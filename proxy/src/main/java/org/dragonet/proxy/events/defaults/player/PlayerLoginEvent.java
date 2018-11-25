package org.dragonet.proxy.events.defaults.player;

import org.dragonet.proxy.events.HandlerList;
import org.dragonet.proxy.network.UpstreamSession;

public class PlayerLoginEvent extends PlayerEvent
{

    private static final HandlerList handlerList = new HandlerList();

    public PlayerLoginEvent(UpstreamSession session)
    {
        super(session);
    }

    @Override
    public HandlerList getHandlers​()
    {
        return handlerList;
    }

}
