/*
 * GNU LESSER GENERAL PUBLIC LICENSE
 *                       Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 *
 * You can view LICENCE file for details.
 *
 * @author The Dragonet Team
 */
package org.dragonet.proxy.network.translator.pc;

import com.github.steveice10.mc.protocol.data.game.entity.player.GameMode;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerRespawnPacket;
import org.dragonet.common.data.entity.PEEntityAttribute;
import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.packets.*;
import org.dragonet.proxy.DragonProxy;
import org.dragonet.proxy.network.UpstreamSession;
import org.dragonet.proxy.network.cache.CachedEntity;
import org.dragonet.proxy.network.translator.IPCPacketTranslator;

import java.util.ArrayList;

public class PCRespawnPacketTranslator implements IPCPacketTranslator<ServerRespawnPacket>
{

    public PEPacket[] translate(UpstreamSession session, ServerRespawnPacket packet)
    {

        CachedEntity entity = session.getEntityCache().getClientEntity();
        if (entity.dimention != packet.getDimension())
        {
            // the player have changed dimention
            DragonProxy.getInstance().getLogger().info(session.getUsername() + " change dim " + entity.dimention + " to " + packet.getDimension());
//            entity.dimention = packet.getDimension();

            // purge and despawn
            session.getEntityCache().reset(true);
            session.getChunkCache().purge();

            // send new world gamemode
            SetPlayerGameTypePacket pkgm = new SetPlayerGameTypePacket();
            pkgm.gamemode = packet.getGameMode() == GameMode.CREATIVE ? 1 : 0;
            session.sendPacket(pkgm);

            // send new adventure settings
            AdventureSettingsPacket adv = new AdventureSettingsPacket();
            adv.setFlag(AdventureSettingsPacket.WORLD_IMMUTABLE, packet.getGameMode().equals(GameMode.ADVENTURE));
            adv.setFlag(AdventureSettingsPacket.ALLOW_FLIGHT, packet.getGameMode().equals(GameMode.CREATIVE) || packet.getGameMode().equals(GameMode.SPECTATOR));
            adv.setFlag(AdventureSettingsPacket.NO_CLIP, packet.getGameMode().equals(GameMode.SPECTATOR));
            adv.setFlag(AdventureSettingsPacket.WORLD_BUILDER, !packet.getGameMode().equals(GameMode.SPECTATOR) || !packet.getGameMode().equals(GameMode.ADVENTURE));
            adv.setFlag(AdventureSettingsPacket.FLYING, packet.getGameMode().equals(GameMode.SPECTATOR));
            adv.setFlag(AdventureSettingsPacket.MUTED, false);
            adv.eid = entity.proxyEid;
            adv.commandsPermission = AdventureSettingsPacket.PERMISSION_NORMAL;
            adv.playerPermission = AdventureSettingsPacket.LEVEL_PERMISSION_MEMBER;
            session.sendPacket(adv);

            // send entity attributes
            UpdateAttributesPacket attr = new UpdateAttributesPacket();
            attr.rtid = entity.proxyEid;
            if (entity.attributes.isEmpty())
            {
                attr.entries = new ArrayList();
                attr.entries.addAll(PEEntityAttribute.getDefault());
            }
            else
                attr.entries = entity.attributes.values();
            session.sendPacket(attr);

            //set world difficulty
            session.sendPacket(new SetDifficultyPacket(packet.getDifficulty()));

            if (packet.getGameMode().equals(GameMode.CREATIVE))
                session.sendCreativeInventory();

            // change dim packet
//            ChangeDimensionPacket changeDimPacket = new ChangeDimensionPacket();
//            changeDimPacket.dimension = packet.getDimension();
//            changeDimPacket.position = entity.spawnPosition.toVector3F();
//            changeDimPacket.respawn = false;
//            session.sendPacket(new ChangeDimensionPacket());

            return null;
        }
        else
            return new PEPacket[]{new PlayStatusPacket(PlayStatusPacket.PLAYER_SPAWN)};
    }
}
