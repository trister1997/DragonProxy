package org.dragonet.protocol.packets;

import org.dragonet.common.maths.Vector3F;
import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

public class SpawnParticleEffectPacket extends PEPacket
{

    public int dimensionId;
    public Vector3F position;
    public String identifier;

    @Override
    public int pid()
    {
        return ProtocolInfo.SPAWN_PARTICLE_EFFECT_PACKET;
    }

    @Override
    public void encodePayload()
    {
    }

    @Override
    public void decodePayload()
    {
        reset();
        putByte((byte) dimensionId);
        putVector3F(position);
        putString(identifier);
    }
}
