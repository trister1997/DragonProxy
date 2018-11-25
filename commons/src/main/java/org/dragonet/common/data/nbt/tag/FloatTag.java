package org.dragonet.common.data.nbt.tag;

import org.dragonet.common.data.nbt.stream.NBTInputStream;
import org.dragonet.common.data.nbt.stream.NBTOutputStream;

import java.io.IOException;

public class FloatTag extends NumberTag<Float>
{

    public float data;

    public FloatTag(String name)
    {
        super(name);
    }

    public FloatTag(String name, float data)
    {
        super(name);
        this.data = data;
    }

    @Override
    public Float getData()
    {
        return data;
    }

    @Override
    public void setData(Float data)
    {
        this.data = data == null ? 0 : data;
    }

    @Override
    void write(NBTOutputStream dos) throws IOException
    {
        dos.writeFloat(data);
    }

    @Override
    void load(NBTInputStream dis) throws IOException
    {
        data = dis.readFloat();
    }

    @Override
    public byte getId()
    {
        return TAG_Float;
    }

    @Override
    public Object getValue()
    {
        return this.data;
    }

    @Override
    public Tag copy()
    {
        return new FloatTag(getName(), data);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            FloatTag o = (FloatTag) obj;
            return data == o.data;
        }
        return false;
    }

}
