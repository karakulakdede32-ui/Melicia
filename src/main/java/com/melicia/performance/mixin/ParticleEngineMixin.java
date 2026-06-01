package com.melicia.performance.mixin;

import com.melicia.performance.config.MeliciaConfig;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.TerrainParticle;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ParticleEngine.class)
public class ParticleEngineMixin {

    @Inject(method = "add", at = @At("HEAD"), cancellable = true)
    private void melicia$onAddParticle(Particle particle, CallbackInfo ci) {
        var cfg = MeliciaConfig.CONFIG.graphics;
        if (cfg.disableParticles.get()) {
            ci.cancel();
        } else if (cfg.disableBlockBreakParticles.get() && particle instanceof TerrainParticle) {
            ci.cancel();
        }
    }
}
