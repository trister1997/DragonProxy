package org.dragonet.protocol.packets;

import org.dragonet.common.utilities.Colors;
import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ClientboundMapItemDataPacket extends PEPacket
{

    public static final int TEXTURE_UPDATE = 2;
    public static final int DECORATIONS_UPDATE = 4;
    public static final int ENTITIES_UPDATE = 8;
    public int[] eids = new int[0];
    public long mapId;
    public int update;
    public byte scale;
    public int width;
    public int height;
    public int offsetX;
    public int offsetZ;
    public byte dimensionId;
    public MapDecorator[] decorators = new MapDecorator[0];
    public int[] colors = new int[0];
    public BufferedImage image = null;

    @Override
    public int pid()
    {
        return ProtocolInfo.CLIENTBOUND_MAP_ITEM_DATA_PACKET;
    }

    @Override
    public void encodePayload()
    {
        reset();
        putEntityUniqueId(mapId);

        int update = 0;
        if (eids.length > 0)
        {
            update |= 0x08;
        }

        if (decorators.length > 0)
        {
            update |= DECORATIONS_UPDATE;
        }

        if (image != null || colors.length > 0)
        {
            update |= TEXTURE_UPDATE;
        }

        putUnsignedVarInt(update);
        putByte(dimensionId);

        if ((update & 0x08) != 0)
        {
            putUnsignedVarInt(eids.length);
            for (int eid : eids)
            {
                putEntityUniqueId(eid);
            }
        }

        if ((update & (TEXTURE_UPDATE | DECORATIONS_UPDATE)) != 0)
        {
            putByte(scale);
        }

        if ((update & DECORATIONS_UPDATE) != 0)
        {
            putUnsignedVarInt(decorators.length);
            for (MapDecorator decorator : decorators)
            {
                putByte(decorator.rotation);
                putByte(decorator.icon);
                putByte(decorator.offsetX);
                putByte(decorator.offsetZ);
                putString(decorator.label);
                putVarInt(decorator.color.getRGB());
            }
        }

        if ((update & TEXTURE_UPDATE) != 0)
        {
            putVarInt(width);
            putVarInt(height);
            putVarInt(offsetX);
            putVarInt(offsetZ);

            putUnsignedVarInt(width * height);

            if (image != null)
            {
                for (int x = 0; x < width; x++)
                {
                    for (int y = 0; y < height; y++)
                    {
                        Color color = new Color(image.getRGB(x, y), true);
                        byte red = (byte) color.getRed();
                        byte green = (byte) color.getGreen();
                        byte blue = (byte) color.getBlue();

                        putUnsignedVarInt(Colors.toRGB(red, green, blue, (byte) 0xff));
                    }
                }

                image.flush();
            }
            else if (colors.length > 0)
            {
                for (int color : colors)
                {
                    putUnsignedVarInt(color);
                }
            }
        }
    }

    @Override
    public void decodePayload()
    {

    }

    public class MapDecorator
    {
        public byte rotation;
        public byte icon;
        public byte offsetX;
        public byte offsetZ;
        public String label;
        public Color color;
    }
}
