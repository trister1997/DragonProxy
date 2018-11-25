package org.dragonet.protocol.packets;

import org.dragonet.common.data.entity.PEEntityAttribute;
import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

import java.util.Collection;

/**
 * Created on 2017/10/23.
 */
public class UpdateAttributesPacket extends PEPacket
{

    public long rtid;
    public Collection<PEEntityAttribute> entries;

    public UpdateAttributesPacket()
    {

    }

    @Override
    public int pid()
    {
        return ProtocolInfo.UPDATE_ATTRIBUTES_PACKET;
    }

    @Override
    public void encodePayload()
    {
        putUnsignedVarLong(rtid);
//        System.out.println("PEEntityAttribute entity " + rtid);
        if (entries != null && entries.size() > 0)
        {
            putUnsignedVarInt(entries.size());
            for (PEEntityAttribute attr : entries)
            {
//                System.out.println("PEEntityAttribute " + attr.name + " : " + attr.currentValue);
                putLFloat(attr.min);
                putLFloat(attr.max);
                putLFloat(attr.currentValue);
                putLFloat(attr.defaultValue);
                putString(attr.name);
            }
        }
        else
        {
            putUnsignedVarInt(0);
        }
    }

    @Override
    public void decodePayload()
    {

    }
}
