package org.dragonet.protocol.packets;

import org.dragonet.common.utilities.BinaryStream;
import org.dragonet.common.utilities.LoginChainDecoder;
import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

/**
 * Created on 2017/10/21.
 */
public class LoginPacket extends PEPacket
{

    public int protocol;
    public LoginChainDecoder decoded;

    public LoginPacket()
    {

    }

    @Override
    public int pid()
    {
        return ProtocolInfo.LOGIN_PACKET;
    }

    @Override
    public void decodePayload()
    {
        protocol = getInt();

        if (protocol == 0)
        {
            setOffset(getOffset() + 2);
            protocol = getInt();
        }

        byte[] payload = getByteArray();
        BinaryStream bin = new BinaryStream(payload);
        byte[] chain = bin.get(bin.getLInt());
        byte[] client = bin.get(bin.getLInt());
        decoded = new LoginChainDecoder(chain, client);
        decoded.decode();
    }

    @Override
    public void encodePayload()
    {
    }
}
