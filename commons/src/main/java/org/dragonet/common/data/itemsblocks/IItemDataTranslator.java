package org.dragonet.common.data.itemsblocks;

/**
 * @author Epic
 */
public class IItemDataTranslator extends AItemDataTranslator
{

    private Integer originalDamage;

    public Integer getOriginalDamage()
    {
        return this.originalDamage;
    }

    public void setOriginalDamage(Integer originalDamage)
    {
        this.originalDamage = originalDamage;
    }

    public Integer translateToPE(Integer damage)
    {
        return damage;
    }

    public Integer translateToPC(Integer damage)
    {
        return damage;
    }
}
