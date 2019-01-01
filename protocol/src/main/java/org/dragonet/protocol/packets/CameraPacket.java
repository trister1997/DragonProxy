package org.dragonet.protocol.packets;

import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

public class CameraPacket extends PEPacket
{

    public long cameraUniqueId;
    public long playerUnqiueId;

    @Override
    public int pid()
    {
        return ProtocolInfo.CAMERA_PACKET;
    }

    @Override
    public void encodePayload()
    {
        reset();
        putVarLong(cameraUniqueId);
        putVarLong(playerUnqiueId);
    }

    @Override
    public void decodePayload()
    {
        cameraUniqueId = getVarLong();
        playerUnqiueId = getVarLong();
    }
}
