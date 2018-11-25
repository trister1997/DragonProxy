package org.dragonet.common.data;

public enum ParticleEffects
{

    TYPE_BUBBLE(1),
    TYPE_CRITICAL(2),
    TYPE_BLOCK_FORCE_FIELD(3),
    TYPE_SMOKE(4),
    TYPE_EXPLODE(5),
    TYPE_EVAPORATION(6),
    TYPE_FLAME(7),
    TYPE_LAVA(8),
    TYPE_LARGE_SMOKE(9),
    TYPE_REDSTONE(10),
    TYPE_RISING_RED_DUST(11),
    TYPE_ITEM_BREAK(12),
    TYPE_SNOWBALL_POOF(13),
    TYPE_HUGE_EXPLODE(14),
    TYPE_HUGE_EXPLODE_SEED(15),
    TYPE_MOB_FLAME(16),
    TYPE_HEART(17),
    TYPE_TERRAIN(18),
    TYPE_SUSPENDED_TOWN(19),
    TYPE_PORTAL(20),
    TYPE_SPLASH(21),
    TYPE_WATER_WAKE(22),
    TYPE_DRIP_WATER(23),
    TYPE_DRIP_LAVA(24),
    TYPE_FALLING_DUST(25),
    TYPE_MOB_SPELL(26),
    TYPE_MOB_SPELL_AMBIENT(27),
    TYPE_MOB_SPELL_INSTANTANEOUS(28),
    TYPE_INK(29),
    TYPE_SLIME(30),
    TYPE_RAIN_SPLASH(31),
    TYPE_VILLAGER_ANGRY(32),
    TYPE_VILLAGER_HAPPY(33),
    TYPE_ENCHANTMENT_TABLE(34),
    TYPE_TRACKING_EMITTER(35),
    TYPE_NOTE(36),
    TYPE_WITCH_SPELL(37),
    TYPE_CARROT(38),
    TYPE_END_ROD(40),
    TYPE_DRAGONS_BREATH(41);

    public final int id;

    ParticleEffects(int id)
    {
        this.id = id;
    }
}
