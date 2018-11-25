package org.dragonet.proxy.network.translator.pe;

import com.github.steveice10.mc.protocol.packet.ingame.client.ClientChatPacket;
import com.github.steveice10.packetlib.packet.Packet;
import org.dragonet.protocol.packets.CommandRequestPacket;
import org.dragonet.proxy.network.UpstreamSession;
import org.dragonet.proxy.network.translator.IPEPacketTranslator;

/**
 * Created on 2017/11/15.
 */
public class PECommandRequestPacketTranslator implements IPEPacketTranslator<CommandRequestPacket>
{

    public Packet[] translate(UpstreamSession session, CommandRequestPacket packet)
    {
        return new Packet[]{new ClientChatPacket(packet.command)};
    }
}
