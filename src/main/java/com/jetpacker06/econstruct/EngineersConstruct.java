package com.jetpacker06.econstruct;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Mod("econstruct")
public class EngineersConstruct {
    public static final String MOD_ID = "econstruct";
    public static final Logger LOGGER = LogManager.getLogger();

    public EngineersConstruct() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.register(eventBus);
        ModItems.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
