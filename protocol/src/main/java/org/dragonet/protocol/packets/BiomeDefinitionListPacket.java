package org.dragonet.protocol.packets;

import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

public class BiomeDefinitionListPacket extends PEPacket
{

    public byte[] tag;

    @Override
    public int pid()
    {
        return ProtocolInfo.BIOME_DEFINITION_LIST_PACKET;
    }

    @Override
    public void encodePayload()
    {
        reset();
        put(tag);
    }

    @Override
    public void decodePayload()
    {
    }
}
