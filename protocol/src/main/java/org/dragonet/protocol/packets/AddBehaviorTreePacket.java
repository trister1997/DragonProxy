package org.dragonet.protocol.packets;

import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

public class AddBehaviorTreePacket extends PEPacket
{

    private String unknown;

    @Override
    public int pid()
    {
        return ProtocolInfo.ADD_BEHAVIOR_TREE_PACKET;
    }

    @Override
    public void encodePayload()
    {
        reset();
        putString(unknown);
    }

    @Override
    public void decodePayload()
    {
    }
}
