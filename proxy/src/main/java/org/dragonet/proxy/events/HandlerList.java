package org.dragonet.proxy.events;

import org.pf4j.Plugin;

import java.util.ArrayList;

public class HandlerList
{

    private ArrayList<WrapedListener> handlerList = new ArrayList<>();

    public void registerListener(WrapedListener listener)
    {
        handlerList.add(listener);
    }

    public void unregisterListener(Listener listener)
    {
        handlerList.removeIf(l -> l.getListener().equals(listener));
    }

    public void unregisterListener(Plugin plugin)
    {
        handlerList.removeIf(l -> l.getPlugin().equals(plugin));
    }

    public ArrayList<WrapedListener> getHandlerList()
    {
        return handlerList;
    }

}
