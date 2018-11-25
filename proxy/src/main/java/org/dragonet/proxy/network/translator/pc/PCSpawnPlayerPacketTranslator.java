package org.dragonet.proxy.network.translator.pc;

import com.github.steveice10.mc.protocol.packet.ingame.server.entity.spawn.ServerSpawnPlayerPacket;
import org.dragonet.protocol.PEPacket;
import org.dragonet.proxy.network.UpstreamSession;
import org.dragonet.proxy.network.translator.IPCPacketTranslator;

public class PCSpawnPlayerPacketTranslator implements IPCPacketTranslator<ServerSpawnPlayerPacket>
{

    public PEPacket[] translate(UpstreamSession session, ServerSpawnPlayerPacket packet)
    {
        try
        {
            session.getEntityCache().newPlayer(packet).spawn(session);
            return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
