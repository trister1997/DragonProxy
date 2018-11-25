package org.dragonet.common.data.nbt.tag;

import org.dragonet.common.data.nbt.stream.NBTInputStream;
import org.dragonet.common.data.nbt.stream.NBTOutputStream;

import java.io.IOException;

public class ByteTag extends NumberTag<Integer>
{

    public int data;

    public ByteTag(String name)
    {
        super(name);
    }

    public ByteTag(String name, int data)
    {
        super(name);
        this.data = data;
    }

    @Override
    public Integer getData()
    {
        return data;
    }

    @Override
    public void setData(Integer data)
    {
        this.data = data == null ? 0 : data;
    }

    @Override
    void write(NBTOutputStream dos) throws IOException
    {
        dos.writeByte(data);
    }

    @Override
    void load(NBTInputStream dis) throws IOException
    {
        data = dis.readByte();
    }

    @Override
    public byte getId()
    {
        return TAG_Byte;
    }

    @Override
    public Object getValue()
    {
        return this.data;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            ByteTag byteTag = (ByteTag) obj;
            return data == byteTag.data;
        }
        return false;
    }

    @Override
    public Tag copy()
    {
        return new ByteTag(getName(), data);
    }
}
