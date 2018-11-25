package org.dragonet.protocol;

import org.dragonet.common.utilities.BinaryStream;

/**
 * Created on 2017/10/21.
 */
public abstract class PEPacket extends BinaryStream
{

    private boolean encoded;
    private boolean decoded;

    public PEPacket()
    {
        super();
    }

    public boolean isEncoded()
    {
        return encoded;
    }

    public boolean isDecoded()
    {
        return decoded;
    }

    public void encode()
    {
        reset();
        encodeHeader();
        encodePayload();
        encoded = true;
    }

    public void decode()
    {
        decodeHeader();
        decodePayload();
        decoded = true;
    }

    public void encodeHeader()
    {
        putUnsignedVarInt((pid() & 0xFF));
    }

    public void decodeHeader()
    {
        getUnsignedVarInt();
    }

    public abstract int pid();

    public abstract void encodePayload();

    public abstract void decodePayload();

}
