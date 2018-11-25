/*
 * GNU LESSER GENERAL PUBLIC LICENSE
 *                       Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 *
 * You can view LICENCE file for details.
 *
 * @author The Dragonet Team
 */
package org.dragonet.common.data.itemsblocks;

/**
 * @author vincent
 */
public class ItemEntry
{

    private Integer id;
    private Integer originalDamage;
    private Integer damage;
    private IItemDataTranslator translator;

    public ItemEntry(Integer id)
    {
        this(id, null);
    }

    public ItemEntry(Integer id, Integer damage)
    {
        this.id = id;
        this.damage = damage;
    }

    public ItemEntry(Integer id, Integer damage, IItemDataTranslator translator)
    {
        this.id = id;
        this.originalDamage = this.damage = damage;
        this.translator = translator;
    }

    public Integer getId()
    {
        return this.id;
    }

    public ItemEntry setDamage(int damage)
    {
        this.damage = damage;
        if (this.translator != null)
        {
            this.translator.setOriginalDamage(originalDamage);
        }
        return this;
    }

    public Integer getPEDamage()
    {
        if (this.translator != null && this.damage != null)
        {
            return this.translator.translateToPE(this.damage);
        }
        return damage;
    }

    public Integer getPCDamage()
    {
        if (this.translator != null && this.damage != null)
        {
            return this.translator.translateToPC(this.damage);
        }
        return damage;
    }
}
