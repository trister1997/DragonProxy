package org.dragonet.protocol.packets;

import com.github.steveice10.mc.protocol.data.game.setting.Difficulty;
import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

public class SetDifficultyPacket extends PEPacket
{

    public Difficulty difficulty;

    public SetDifficultyPacket()
    {
    }

    public SetDifficultyPacket(Difficulty difficulty)
    {
        this.difficulty = difficulty;
    }

    @Override
    public int pid()
    {
        return ProtocolInfo.SET_DIFFICULTY_PACKET;
    }

    @Override
    public void encodePayload()
    {
        putUnsignedVarInt(this.difficulty.ordinal());
    }

    @Override
    public void decodePayload()
    {
        this.difficulty = Difficulty.values()[(int) getUnsignedVarInt()];
    }
}
