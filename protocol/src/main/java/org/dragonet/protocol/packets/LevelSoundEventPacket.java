package org.dragonet.protocol.packets;

import org.dragonet.common.maths.Vector3F;
import org.dragonet.protocol.PEPacket;
import org.dragonet.protocol.ProtocolInfo;

import java.util.Arrays;

public class LevelSoundEventPacket extends PEPacket
{

    public Sound sound;
    public Vector3F position;
    public int extraData = -1;
    public String entityIdentifier;
    public boolean isBabyMob;
    public boolean isGlobal;

    @Override
    public int pid()
    {
        return ProtocolInfo.LEVEL_SOUND_EVENT_PACKET;
    }

    @Override
    public void encodePayload()
    {
        reset();
        putByte((byte) sound.soundID);
        putVector3F(position);
        putVarInt(extraData);
        putString(entityIdentifier);
        putBoolean(isBabyMob);
        putBoolean(isGlobal);
    }

    @Override
    public void decodePayload()
    {
        this.sound = Sound.fromID(getByte());
        this.position = getVector3F();
        this.extraData = getVarInt();
        this.entityIdentifier = getString();
        this.isBabyMob = getBoolean();
        this.isGlobal = getBoolean();
    }

    public enum Sound
    {
        ITEM_USE_ON,
        HIT,
        STEP,
        FLY,
        JUMP,
        BREAK,
        PLACE,
        HEAVY_STEP,
        GALLOP,
        FALL,
        AMBIENT,
        AMBIENT_BABY,
        AMBIENT_IN_WATER,
        BREATHE,
        DEATH,
        DEATH_IN_WATER,
        DEATH_TO_ZOMBIE,
        HURT,
        HURT_IN_WATER,
        MAD,
        BOOST,
        BOW,
        SQUISH_BIG,
        SQUISH_SMALL,
        FALL_BIG,
        FALL_SMALL,
        SPLASH,
        FIZZ,
        FLAP,
        SWIM,
        DRINK,
        EAT,
        TAKEOFF,
        SHAKE,
        PLOP,
        LAND,
        SADDLE,
        ARMOR,
        MOB_ARMOR_STAND_PLACE,
        ADD_CHEST,
        THROW,
        ATTACK,
        ATTACK_NO_DAMAGE,
        ATTACK_STRONG,
        WARN,
        SHEAR,
        MILK,
        THUNDER,
        EXPLODE,
        FIRE,
        IGNITE,
        FUSE,
        STARE,
        SPAWN,
        SHOOT,
        BREAK_BLOCK,
        LAUNCH,
        BLAST,
        LARGE_BLAST,
        TWINKLE,
        REMEDY,
        UNFECT,
        LEVEL_UP,
        BOW_HIT,
        BULLET_HIT,
        EXTINGUISH_FIRE,
        ITEM_FIZZ,
        CHEST_OPEN,
        CHEST_CLOSED,
        SHULKER_BOX_OPEN,
        SHULKER_BOX_CLOSE,
        ENDERCHEST_OPEN,
        ENDERCHEST_CLOSED,
        POWER_ON,
        POWER_OFF,
        ATTACH,
        DETACH,
        DENY,
        TRIPOD,
        POP,
        DROP_SLOT,
        NOTE,
        THORNS,
        PISTON_IN,
        PISTON_OUT,
        PORTAL,
        WATER,
        LAVA_POP,
        LAVA,
        BURP,
        BUCKET_FILL_WATER,
        BUCKET_FILL_LAVA,
        BUCKET_EMPTY_WATER,
        BUCKET_EMPTY_LAVA,
        ARMOR_EQUIP_CHAIN,
        ARMOR_EQUIP_DIAMOND,
        ARMOR_EQUIP_GENERIC,
        ARMOR_EQUIP_GOLD,
        ARMOR_EQUIP_IRON,
        ARMOR_EQUIP_LEATHER,
        ARMOR_EQUIP_ELYTRA,
        RECORD_13,
        RECORD_CAT,
        RECORD_BLOCKS,
        RECORD_CHIRP,
        RECORD_FAR,
        RECORD_MALL,
        RECORD_MELLOHI,
        RECORD_STAL,
        RECORD_STRAD,
        RECORD_WARD,
        RECORD_11,
        RECORD_WAIT,
        PLACEHOLDER_1,// Not a real sound, just a place holder. This ID is skipped for some reason
        GUARDIAN_FLOP,
        ELDER_GUARDIAN_CURSE,
        MOB_WARNING,
        MOB_WARNING_BABY,
        TELEPORT,
        SHULKER_OPEN,
        SHULKER_CLOSE,
        HAGGLE,
        HAGGLE_YES,
        HAGGLE_NO,
        HAGGLE_IDLE,
        CHORUS_GROW,
        CHORUS_DEATH,
        GLASS,
        POTION_BREWED,
        CAST_SPELL,
        PREPARE_ATTACK,
        PREPARE_SUMMON,
        PREPARE_WOLOLO,
        FANG,
        CHARGE,
        CAMERA_TAKE_PICTURE,
        LEASHKNOT_PLACE,
        LEASHKNOT_BREAK,
        GROWL,
        WHINE,
        PANT,
        PURR,
        PURREOW,
        DEATH_MIN_VOLUME,
        DEATH_MID_VOLUME,
        INITIATE_BLAZE,
        INITIATE_CAVE_SPIDER,
        INITIATE_CREEPER,
        INITIATE_ELDER_GUARDIAN,
        INITIATE_ENDER_DRAGON,
        INITIATE_ENDERMAN,
        INITIATE_EVOCATION_VILLAGER,
        INITIATE_MAGMA_CUBE,
        INITIATE_POLAR_BEAR,
        INITIATE_SHULKER,
        INITIATE_SILVERFISH,
        INITIATE_SKELETON,
        INITIATE_SLIME,
        INITIATE_SPIDER,
        INITIATE_STRAY,
        INITIATE_VEX,
        INITIATE_VINDICATION_VILLAGER,
        INITIATE_WITCH,
        INITIATE_WITHER,
        INITIATE_WITHER_SKELETON,
        INITIATE_WOLF,
        INITIATE_ZOMBIE,
        INITIATE_ZOMBIE_PIGMAN,
        INITIATE_ZOMBIE_VILLAGER,
        BLOCK_END_PORTAL_FRAME_FILL,
        BLOCK_END_PORTAL_SPAWN,
        RANDOM_ANVIL_USE,
        BOTTLE_DRAGON_BREATH,
        PORTAL_TRAVEL,
        ITEM_TRIDENT_HIT,
        ITEM_TRIDENT_RETURN,
        ITEM_TRIDENT_RIPTIDE_1,
        ITEM_TRIDENT_RIPTIDE_2,
        ITEM_TRIDENT_RIPTIDE_3,
        ITEM_TRIDENT_THROW,
        ITEM_TRIDENT_THUNDER,
        ITEM_TRIDENT_HIT_GROUND,
        DEFAULT,
        ELEMCONSTRUCT_OPEN,
        ICEBOMB_HIT,
        BALLOONPOP,
        LT_REACTION_ICEBOMB,
        LT_REACTION_BLEACH,
        LT_REACTION_EPASTE,
        LT_REACTION_EPASTE2,
        LT_REACTION_FERTILIZER,
        LT_REACTION_FIREBALL,
        LT_REACTION_MGSALT,
        LT_REACTION_MISCFIRE,
        LT_REACTION_FIRE,
        LT_REACTION_MISCEXPLOSION,
        LT_REACTION_MISCMYSTICAL,
        LT_REACTION_MISCMYSTICAL2,
        LT_REACTION_PRODUCT,
        SPARKLER_USE,
        GLOWSTICK_USE,
        SPARKLER_ACTIVE,
        CONVERT_TO_DROWNED,
        BUCKET_FILL_FISH,
        BUCKET_EMPTY_FISH,
        BUBBLE_UP,
        BUBBLE_DOWN,
        BUBBLE_POP,
        BUBBLE_UPINSIDE,
        BUBBLE_DOWNINSIDE,
        HURT_BABY,
        DEATH_BABY,
        STEP_BABY,
        BORN,
        BLOCK_TURTLE_EGG_BREAK,
        BLOCK_TURTLE_EGG_CRACK,
        BLOCK_TURTLE_EGG_HATCH,
        BLOCK_TURTLE_EGG_ATTACK,
        BEACON_ACTIVATE,
        BEACON_AMBIENT,
        BEACON_DEACTIVATE,
        BEACON_POWER,
        CONDUIT_ACTIVATE,
        CONDUIT_AMBIENT,
        CONDUIT_ATTACK,
        CONDUIT_DEACTIVATE,
        CONDUIT_SHORT,
        SWOOP,
        BLOCK_BAMBOO_SAPLING_PLACE,
        PRESNEEZE,
        SNEEZE,
        AMBIENT_TAME,
        SCARED,
        BLOCK_SCAFFOLDING_CLIMB,
        CROSSBOW_LOADING_START,
        CROSSBOW_LOADING_MIDDLE,
        CROSSBOW_LOADING_END,
        CROSSBOW_SHOOT,
        CROSSBOW_QUICK_CHARGE_START,
        CROSSBOW_QUICK_CHARGE_MIDDLE,
        CROSSBOW_QUICK_CHARGE_END,
        AMBIENT_AGGRESSIVE,
        AMBIENT_WORRIED,
        CANT_BREED,
        UNDEFINED,
        EVENT_SOUND_TNT(1005);

        public final int soundID;

        Sound()
        {
            this.soundID = this.ordinal();
        }

        Sound(int id)
        {
            this.soundID = id;
        }

        public static Sound fromID(int soundID)
        {
            return Arrays.stream(values()).filter(sound -> sound.soundID == soundID).findFirst().orElse(null);
        }
    }
}
