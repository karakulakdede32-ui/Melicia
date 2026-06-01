package com.melicia.performance.mixin;

import com.melicia.performance.config.MeliciaConfig;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderType.class)
public class RenderTypeMixin {

    @Inject(method = "glint", at = @At("HEAD"), cancellable = true)
    private static void melicia$onGlint(CallbackInfoReturnable<RenderType> cir) {
        if (MeliciaConfig.CONFIG.graphics.disableEnchantmentGlint.get()) {
            cir.setReturnValue(RenderType.translucent());
        }
    }

    @Inject(method = "glintDirect", at = @At("HEAD"), cancellable = true)
    private static void melicia$onGlintDirect(CallbackInfoReturnable<RenderType> cir) {
        if (MeliciaConfig.CONFIG.graphics.disableEnchantmentGlint.get()) {
            cir.setReturnValue(RenderType.translucent());
        }
    }

    @Inject(method = "glintTranslucent", at = @At("HEAD"), cancellable = true)
    private static void melicia$onGlintTranslucent(CallbackInfoReturnable<RenderType> cir) {
        if (MeliciaConfig.CONFIG.graphics.disableEnchantmentGlint.get()) {
            cir.setReturnValue(RenderType.translucent());
        }
    }
}
