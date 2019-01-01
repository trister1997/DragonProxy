package org.dragonet.protocol.packets;

import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

public class NetworkStackLatencyPacket extends PEPacket
{

    public long timestamp;

    @Override
    public int pid()
    {
        return ProtocolInfo.NETWORK_STACK_LATENCY_PACKET;
    }

    @Override
    public void encodePayload()
    {
        reset();
        putLLong(timestamp);
    }

    @Override
    public void decodePayload()
    {
        timestamp = getLLong();
    }
}
