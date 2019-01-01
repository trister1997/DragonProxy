package org.dragonet.protocol.packets;

import org.dragonet.common.maths.BlockPosition;
import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

public class NetworkChunkPublisherUpdatePacket extends PEPacket
{

    public BlockPosition position;
    public int radius;

    @Override
    public int pid()
    {
        return ProtocolInfo.NETWORK_CHUNK_PUBLISHER_UPDATE_PACKET;
    }

    @Override
    public void encodePayload()
    {
        reset();
        putSignedBlockPosition(position);
        putUnsignedVarInt(radius);
    }

    @Override
    public void decodePayload()
    {
        position = getSignedBlockPosition();
        radius = (int) getUnsignedVarInt();
    }
}
