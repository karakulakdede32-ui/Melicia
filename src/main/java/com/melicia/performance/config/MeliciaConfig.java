package com.melicia.performance.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public final class MeliciaConfig {

    public static class General {
        public final ForgeConfigSpec.BooleanValue disableTutorial;
        public final ForgeConfigSpec.BooleanValue disableAdvancementToasts;
        public final ForgeConfigSpec.BooleanValue disableStatistics;
        public final ForgeConfigSpec.BooleanValue disableRecipeBook;
        public final ForgeConfigSpec.BooleanValue disableDeathScreen;

        General(ForgeConfigSpec.Builder builder) {
            builder.comment("General tweaks that affect gameplay mechanics.")
                   .push("general");

            disableTutorial = builder
                    .comment("Disable the tutorial hints that appear for new players.")
                    .define("disableTutorial", true);

            disableAdvancementToasts = builder
                    .comment("Suppress advancement popup toasts.")
                    .define("disableAdvancementToasts", true);

            disableStatistics = builder
                    .comment("Stop tracking statistics to reduce write operations.")
                    .define("disableStatistics", true);

            disableRecipeBook = builder
                    .comment("Remove the recipe book from the crafting GUI.")
                    .define("disableRecipeBook", true);

            disableDeathScreen = builder
                    .comment("Skip the death screen overlay entirely.")
                    .define("disableDeathScreen", false);

            builder.pop();
        }
    }

    public static class Graphics {
        public final ForgeConfigSpec.BooleanValue disableParticles;
        public final ForgeConfigSpec.BooleanValue disableBlockBreakParticles;
        public final ForgeConfigSpec.BooleanValue disableEnchantmentGlint;
        public final ForgeConfigSpec.BooleanValue disableBlockAnimations;
        public final ForgeConfigSpec.BooleanValue disableItemAnimations;
        public final ForgeConfigSpec.BooleanValue disableRain;
        public final ForgeConfigSpec.BooleanValue disableSnow;
        public final ForgeConfigSpec.BooleanValue disableFog;
        public final ForgeConfigSpec.BooleanValue disableBossBar;
        public final ForgeConfigSpec.BooleanValue disableScoreboard;
        public final ForgeConfigSpec.BooleanValue disableOverlays;
        public final ForgeConfigSpec.BooleanValue disableArmorStandRender;
        public final ForgeConfigSpec.BooleanValue disableItemFrameRender;
        public final ForgeConfigSpec.BooleanValue disablePaintingRender;
        public final ForgeConfigSpec.BooleanValue disableItemEntityRender;
        public final ForgeConfigSpec.BooleanValue disableXpOrbRender;

        Graphics(ForgeConfigSpec.Builder builder) {
            builder.comment("Graphics and rendering optimizations. These have the biggest impact on FPS.")
                   .push("graphics");

            disableParticles = builder
                    .comment("Disable ALL particle effects (block break, potion, portal, etc.).")
                    .define("disableParticles", true);

            disableBlockBreakParticles = builder
                    .comment("Disable particles when breaking blocks.")
                    .define("disableBlockBreakParticles", true);

            disableEnchantmentGlint = builder
                    .comment("Remove the enchantment glint effect from items and armor.")
                    .define("disableEnchantmentGlint", true);

            disableBlockAnimations = builder
                    .comment("Disable animated block textures (lava, fire, water, etc.).")
                    .define("disableBlockAnimations", false);

            disableItemAnimations = builder
                    .comment("Disable item bob/swing animations.")
                    .define("disableItemAnimations", false);

            disableRain = builder
                    .comment("Disable rain rendering (weather still ticks).")
                    .define("disableRain", false);

            disableSnow = builder
                    .comment("Disable snow rendering.")
                    .define("disableSnow", false);

            disableFog = builder
                    .comment("Disable all fog effects (nether, water, distance).")
                    .define("disableFog", false);

            disableBossBar = builder
                    .comment("Remove the boss health bar overlay.")
                    .define("disableBossBar", true);

            disableScoreboard = builder
                    .comment("Remove the scoreboard sidebar overlay.")
                    .define("disableScoreboard", true);

            disableOverlays = builder
                    .comment("Remove screen overlays (pumpkin, fire, portal vignette).")
                    .define("disableOverlays", true);

            disableArmorStandRender = builder
                    .comment("Stop rendering armor stands entirely.")
                    .define("disableArmorStandRender", false);

            disableItemFrameRender = builder
                    .comment("Stop rendering item frames.")
                    .define("disableItemFrameRender", false);

            disablePaintingRender = builder
                    .comment("Stop rendering paintings.")
                    .define("disablePaintingRender", false);

            disableItemEntityRender = builder
                    .comment("Stop rendering dropped item entities on the ground.")
                    .define("disableItemEntityRender", false);

            disableXpOrbRender = builder
                    .comment("Stop rendering experience orbs.")
                    .define("disableXpOrbRender", false);

            builder.pop();
        }
    }

    public static class Sound {
        public final ForgeConfigSpec.BooleanValue disableAllSounds;
        public final ForgeConfigSpec.BooleanValue disableWeatherSounds;
        public final ForgeConfigSpec.BooleanValue disableBlockSounds;
        public final ForgeConfigSpec.BooleanValue disableEntitySounds;
        public final ForgeConfigSpec.BooleanValue disableAmbientSounds;

        Sound(ForgeConfigSpec.Builder builder) {
            builder.comment("Sound optimizations. Disable audio to reduce resource usage.")
                   .push("sound");

            disableAllSounds = builder
                    .comment("Completely mute all game sounds.")
                    .define("disableAllSounds", false);

            disableWeatherSounds = builder
                    .comment("Mute weather-related sounds (rain, thunder).")
                    .define("disableWeatherSounds", false);

            disableBlockSounds = builder
                    .comment("Mute block interaction sounds (placing, breaking, stepping).")
                    .define("disableBlockSounds", false);

            disableEntitySounds = builder
                    .comment("Mute entity sounds (mobs, players, etc.).")
                    .define("disableEntitySounds", false);

            disableAmbientSounds = builder
                    .comment("Mute ambient biome sounds and cave noises.")
                    .define("disableAmbientSounds", false);

            builder.pop();
        }
    }

    public static class Entity {
        public final ForgeConfigSpec.BooleanValue disableAllEntityAI;
        public final ForgeConfigSpec.BooleanValue disableVillagerActivities;
        public final ForgeConfigSpec.BooleanValue disableBeaconEffects;

        Entity(ForgeConfigSpec.Builder builder) {
            builder.comment("Entity-related performance options.")
                   .push("entity");

            disableAllEntityAI = builder
                    .comment("Disable AI tick for all living entities, making them stationary.")
                    .define("disableAllEntityAI", false);

            disableVillagerActivities = builder
                    .comment("Disable villager work activities and gossip particles.")
                    .define("disableVillagerActivities", false);

            disableBeaconEffects = builder
                    .comment("Disable beacon beam rendering and status effects.")
                    .define("disableBeaconEffects", false);

            builder.pop();
        }
    }

    public static class World {
        public final ForgeConfigSpec.BooleanValue fastLeafDecay;
        public final ForgeConfigSpec.BooleanValue fastFurnace;
        public final ForgeConfigSpec.BooleanValue disableRandomTicks;

        World(ForgeConfigSpec.Builder builder) {
            builder.comment("World processing optimizations.")
                   .push("world");

            fastLeafDecay = builder
                    .comment("Accelerate leaf decay when trees are chopped (no waiting).")
                    .define("fastLeafDecay", true);

            fastFurnace = builder
                    .comment("Speed up furnace smelting (cook times halved).")
                    .define("fastFurnace", false);

            disableRandomTicks = builder
                    .comment("Disable random block ticks (crop growth, grass spread, ice melting, etc.).\n" +
                             "Warning: This stops natural growth and decay processes.")
                    .define("disableRandomTicks", false);

            builder.pop();
        }
    }

    public static final MeliciaConfig CONFIG;
    public static final ForgeConfigSpec SPEC;

    public final General general;
    public final Graphics graphics;
    public final Sound sound;
    public final Entity entity;
    public final World world;

    MeliciaConfig(ForgeConfigSpec.Builder builder) {
        general = new General(builder);
        graphics = new Graphics(builder);
        sound = new Sound(builder);
        entity = new Entity(builder);
        world = new World(builder);
    }

    static {
        Pair<MeliciaConfig, ForgeConfigSpec> pair =
                new ForgeConfigSpec.Builder().configure(MeliciaConfig::new);
        CONFIG = pair.getLeft();
        SPEC = pair.getRight();
    }
}
