package com.jetpacker06.econstruct;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//Mod ID can have ONLY LOWERCASE LETTERS. No numbers, no underscores, no characters, no capitals, no spaces.
@Mod("yourmodidhere")
public class EngineersConstruct {
    public static final String MOD_ID = "yourmodidhere";
    public static final Logger LOGGER = LogManager.getLogger();

    public EngineersConstruct() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.register(eventBus);
        ModItems.register(eventBus);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }
}
