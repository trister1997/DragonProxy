package org.dragonet.protocol.packets;

import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

public class EventPacket extends PEPacket
{

    public long eid;
    public int unknown1;
    public byte unknown2;

    @Override
    public int pid()
    {
        return ProtocolInfo.EVENT_PACKET;
    }

    @Override
    public void encodePayload()
    {
        reset();
        putVarLong(eid);
        putVarInt(unknown1);
        putByte(unknown2);
    }

    @Override
    public void decodePayload()
    {
    }
}
