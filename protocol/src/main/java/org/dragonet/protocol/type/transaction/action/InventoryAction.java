package org.dragonet.protocol.type.transaction.action;

import org.dragonet.common.data.inventory.Slot;

/**
 * @author CreeperFace
 */
public abstract class InventoryAction
{

    protected Slot sourceItem;
    protected Slot targetItem;
    private long creationTime;

    public InventoryAction(Slot sourceItem, Slot targetItem)
    {
        this.sourceItem = sourceItem;
        this.targetItem = targetItem;

        this.creationTime = System.currentTimeMillis();
    }

    public long getCreationTime()
    {
        return creationTime;
    }

    /**
     * Returns the item that was present before the action took place.
     *
     * @return Item
     */
    public Slot getSourceItem()
    {
        return sourceItem.clone();
    }

    /**
     * Returns the item that the action attempted to replace the source item with.
     */
    public Slot getTargetItem()
    {
        return targetItem.clone();
    }
}
