package org.dragonet.proxy.events.defaults.packets;

import org.dragonet.protocol.PEPacket;
import org.dragonet.proxy.events.Cancellable;
import org.dragonet.proxy.events.HandlerList;
import org.dragonet.proxy.network.UpstreamSession;

public class PackettoPlayerEvent extends PEPacketEvent implements Cancellable
{

    private static final HandlerList handlerList = new HandlerList();
    private final UpstreamSession session;
    private boolean cancelled = false;

    public PackettoPlayerEvent(UpstreamSession session, PEPacket packet)
    {
        super(packet);
        this.session = session;
    }

    @Override
    public HandlerList getHandlers​()
    {
        return handlerList;
    }

    public UpstreamSession getSession()
    {
        return session;
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
