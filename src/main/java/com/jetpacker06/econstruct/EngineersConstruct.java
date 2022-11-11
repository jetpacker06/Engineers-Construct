package com.jetpacker06.econstruct;

import com.jetpacker06.econstruct.register.AllBlocks;
import com.jetpacker06.econstruct.register.AllFluids;
import com.jetpacker06.econstruct.register.AllItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Mod("econstruct")
public class EngineersConstruct {
    public static final String MOD_ID = "econstruct";
    public static final Logger LOGGER = LogManager.getLogger();

    public EngineersConstruct() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        AllBlocks.register(eventBus);
        AllItems.register(eventBus);
        AllFluids.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
