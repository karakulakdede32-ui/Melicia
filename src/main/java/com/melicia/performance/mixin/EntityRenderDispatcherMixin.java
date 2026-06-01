package com.melicia.performance.mixin;

import com.melicia.performance.config.MeliciaConfig;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public class EntityRenderDispatcherMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private <E extends Entity> void melicia$onRender(
            E entity,
            double x,
            double y,
            double z,
            float yaw,
            float partialTick,
            PoseStack poseStack,
            MultiBufferSource buffer,
            int packedLight,
            CallbackInfo ci
    ) {
        var cfg = MeliciaConfig.CONFIG.graphics;
        if (cfg.disableItemFrameRender.get() && entity instanceof ItemFrame) {
            ci.cancel();
        } else if (cfg.disablePaintingRender.get() && entity instanceof Painting) {
            ci.cancel();
        } else if (cfg.disableItemEntityRender.get() && entity instanceof ItemEntity) {
            ci.cancel();
        } else if (cfg.disableXpOrbRender.get() && entity instanceof ExperienceOrb) {
            ci.cancel();
        }
    }
}
