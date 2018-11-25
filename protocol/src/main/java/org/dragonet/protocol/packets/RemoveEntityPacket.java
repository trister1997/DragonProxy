package org.dragonet.protocol.packets;

import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

/**
 * Created on 2017/10/21.
 */
public class RemoveEntityPacket extends PEPacket
{

    public long eid;

    public RemoveEntityPacket()
    {

    }

    public RemoveEntityPacket(long eid)
    {
        this.eid = eid;
    }

    @Override
    public int pid()
    {
        return ProtocolInfo.REMOVE_ENTITY_PACKET;
    }

    @Override
    public void encodePayload()
    {
        putVarLong(eid);
    }

    @Override
    public void decodePayload()
    {
        eid = getVarLong();
    }
}
