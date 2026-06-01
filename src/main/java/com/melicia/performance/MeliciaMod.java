package com.melicia.performance;

import com.melicia.performance.config.MeliciaConfig;
import com.melicia.performance.handler.PerformanceHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MeliciaMod.MODID)
public class MeliciaMod {

    public static final String MODID = "melicia";

    public MeliciaMod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MeliciaConfig.SPEC, "melicia-performance.toml");

        MinecraftForge.EVENT_BUS.register(new PerformanceHandler());
    }
}
