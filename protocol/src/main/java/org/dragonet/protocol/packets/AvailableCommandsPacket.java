package org.dragonet.protocol.packets;

import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

// TODO Add CommandDataVersions
public class AvailableCommandsPacket extends PEPacket
{

    public static final int ARG_FLAG_VALID = 0x100000;
    public static final int ARG_TYPE_INT = 0x01;
    public static final int ARG_TYPE_FLOAT = 0x02;
    public static final int ARG_TYPE_VALUE = 0x03;
    public static final int ARG_TYPE_WILDCARD_INT = 0x04;
    public static final int ARG_TYPE_TARGET = 0x05;
    public static final int ARG_TYPE_WILDCARD_TARGET = 0x06;
    public static final int ARG_TYPE_STRING = 0x0f;
    public static final int ARG_TYPE_POSITION = 0x10;
    public static final int ARG_TYPE_MESSAGE = 0x13;
    public static final int ARG_TYPE_RAWTEXT = 0x15;
    public static final int ARG_TYPE_JSON = 0x18;
    public static final int ARG_TYPE_COMMAND = 0x1f;
    public static final int ARG_FLAG_ENUM = 0x200000;
    public static final int ARG_FLAG_POSTFIX = 0x1000000;

    @Override
    public int pid()
    {
        return ProtocolInfo.AVAILABLE_COMMANDS_PACKET;
    }

    @Override
    public void encodePayload()
    {

    }

    @Override
    public void decodePayload()
    {

    }
}
