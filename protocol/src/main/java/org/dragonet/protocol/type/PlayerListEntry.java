package org.dragonet.protocol.type;

import org.dragonet.common.data.entity.Skin;

import java.util.UUID;

/**
 * Created on 2017/10/22.
 */
public class PlayerListEntry
{

    public UUID uuid;
    public long eid;
    public String username;
    public String unk1 = ""; // TODO
    public Skin skin;
    public byte[] capeData = new byte[0]; //TODO
    public String geometryModel = "";
    public byte[] geometryData = new byte[0]; //TODO
    public String xboxUserId;
}
