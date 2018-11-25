package org.dragonet.protocol.packets;

import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

public class BlockEventPacket extends PEPacket
{

    public int x;
    public int y;
    public int z;
    public int case1;
    public int case2;

    @Override
    public int pid()
    {
        return ProtocolInfo.BLOCK_EVENT_PACKET;
    }

    @Override
    public void decodePayload()
    {

    }

    @Override
    public void encodePayload()
    {
        this.reset();
        this.putBlockPosition(this.x, this.y, this.z);
        this.putVarInt(this.case1);
        this.putVarInt(this.case2);
    }
}
