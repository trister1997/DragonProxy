package org.dragonet.proxy.network.translator.pc;

import com.github.steveice10.mc.protocol.packet.ingame.server.ServerBossBarPacket;
import org.dragonet.protocol.PEPacket;
import org.dragonet.proxy.network.UpstreamSession;
import org.dragonet.proxy.network.translator.IPCPacketTranslator;

public class PCBossBarPacketTranslator implements IPCPacketTranslator<ServerBossBarPacket>
{

    @Override
    public PEPacket[] translate(UpstreamSession session, ServerBossBarPacket packet)
    {

        return new PEPacket[]{};
    }

}
