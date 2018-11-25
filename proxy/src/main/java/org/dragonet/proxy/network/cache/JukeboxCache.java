package org.dragonet.proxy.network.cache;

import com.github.steveice10.mc.protocol.data.game.world.sound.BuiltinSound;
import org.dragonet.common.maths.BlockPosition;

import java.util.HashMap;

public class JukeboxCache
{

    private HashMap<BlockPosition, BuiltinSound> jukebox = new HashMap<BlockPosition, BuiltinSound>();

    public JukeboxCache()
    {
    }

    public void registerJukebox(BlockPosition position, BuiltinSound record)
    {
        jukebox.put(position, record);
    }

    public BuiltinSound unregisterJukebox(BlockPosition position)
    {
        if (jukebox.containsKey(position))
        {
            BuiltinSound sound = jukebox.get(position);
            jukebox.remove(position);
            return sound;
        }
        return null;
    }
}
