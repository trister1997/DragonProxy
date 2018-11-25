package org.dragonet.proxy.events.defaults.player;

import org.dragonet.proxy.events.Cancellable;
import org.dragonet.proxy.events.HandlerList;
import org.dragonet.proxy.network.UpstreamSession;

public class PlayerKickEvent extends PlayerEvent implements Cancellable
{

    private static final HandlerList handlerList = new HandlerList();
    private boolean cancelled = false;

    public PlayerKickEvent(UpstreamSession session)
    {
        super(session);
    }

    @Override
    public HandlerList getHandlers​()
    {
        return handlerList;
    }

    public boolean isCancelled​()
    {
        return cancelled;
    }

    public void setCancelled​(boolean cancel)
    {
        cancelled = cancel;
    }

}
