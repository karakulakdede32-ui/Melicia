package com.melicia.performance.handler;

import com.melicia.performance.config.MeliciaConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "melicia", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PerformanceHandler {

    private static final MeliciaConfig CFG = MeliciaConfig.CONFIG;

    // ======================== SOUND ========================

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onPlaySound(PlaySoundEvent event) {
        if (CFG.sound.disableAllSounds.get()) {
            event.setSound(null);
            return;
        }
        if (!(event.getSound() instanceof SimpleSoundInstance sound)) return;

        SoundSource src = sound.getSource();
        if (CFG.sound.disableWeatherSounds.get() && src == SoundSource.WEATHER) {
            event.setSound(null);
        } else if (CFG.sound.disableBlockSounds.get() && src == SoundSource.BLOCKS) {
            event.setSound(null);
        } else if (CFG.sound.disableEntitySounds.get() &&
                (src == SoundSource.HOSTILE || src == SoundSource.NEUTRAL || src == SoundSource.PLAYERS)) {
            event.setSound(null);
        } else if (CFG.sound.disableAmbientSounds.get() &&
                (src == SoundSource.AMBIENT || src == SoundSource.MUSIC)) {
            event.setSound(null);
        }
    }

    // ======================== ENTITY SPAWN (server) ========================

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
        if (event.getLevel().isClientSide()) return;
    }

    // ======================== LIVING ENTITY RENDER ========================

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> event) {
        if (event.getEntity() instanceof ArmorStand && CFG.graphics.disableArmorStandRender.get()) {
            event.setCanceled(true);
        }
    }

    // ======================== TOASTS ========================

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onToastAdd(ToastAddEvent event) {
        if (CFG.general.disableAdvancementToasts.get()) {
            event.setCanceled(true);
        }
    }

    // ======================== GUI OVERLAYS ========================

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onRenderGuiOverlayPre(RenderGuiOverlayEvent.Pre event) {
        String path = event.getOverlay().id().getPath();

        if (CFG.graphics.disableScoreboard.get() && path.contains("scoreboard")) {
            event.setCanceled(true);
        }
        if (CFG.graphics.disableBossBar.get() && path.contains("boss")) {
            event.setCanceled(true);
        }
    }

    // ======================== FIRE OVERLAYS ========================

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onRenderBlockScreenEffect(RenderBlockScreenEffectEvent event) {
        if (CFG.graphics.disableOverlays.get()) {
            event.setCanceled(true);
        }
    }

    // ======================== FOG ========================

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onRenderFog(ViewportEvent.RenderFog event) {
        if (CFG.graphics.disableFog.get()) {
            event.setFarPlaneDistance(10000.0F);
            event.setNearPlaneDistance(0.0F);
        }
    }

    // ======================== ENTITY AI ========================

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        if (!CFG.entity.disableAllEntityAI.get()) return;
        LivingEntity entity = event.getEntity();
        if (entity.level().isClientSide()) return;
        if (entity instanceof Mob mob) {
            mob.setNoAi(true);
        }
    }

    // ======================== CLIENT TICK (weather) ========================

    private static int tickCounter = 0;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.START) return;
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null) return;

        tickCounter++;
        if (tickCounter % 20 != 0) return;

        boolean disableRain = CFG.graphics.disableRain.get();
        boolean disableSnow = CFG.graphics.disableSnow.get();
        if (disableRain || disableSnow) {
            mc.level.setRainLevel(0.0F);
            mc.level.setThunderLevel(0.0F);
        }
    }
}
