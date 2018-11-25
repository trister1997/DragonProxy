package org.dragonet.common.utilities;

public class Colors
{

    public static long toRGB(byte r, byte g, byte b, byte a)
    {
        long result = (int) r & 0xff;
        result |= ((int) g & 0xff) << 8;
        result |= ((int) b & 0xff) << 16;
        result |= ((int) a & 0xff) << 24;
        return result & 0xFFFFFFFFL;
    }
}
