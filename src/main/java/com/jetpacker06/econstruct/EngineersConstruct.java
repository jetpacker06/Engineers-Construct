package com.jetpacker06.econstruct;

import com.jetpacker06.econstruct.register.AllBlocks;
import com.jetpacker06.econstruct.register.AllFluids;
import com.jetpacker06.econstruct.register.AllItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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
        eventBus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }
    public void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(AllFluids.MOLTEN_ANDESITE_LIQUID_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AllFluids.MOLTEN_ANDESITE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AllFluids.MOLTEN_ANDESITE_FLOWING.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(AllFluids.MOLTEN_ANDESITE_ALLOY_LIQUID_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AllFluids.MOLTEN_ANDESITE_ALLOY.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AllFluids.MOLTEN_ANDESITE_ALLOY_FLOWING.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(AllFluids.MOLTEN_REDSTONE_LIQUID_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AllFluids.MOLTEN_REDSTONE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AllFluids.MOLTEN_REDSTONE_FLOWING.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(AllFluids.MOLTEN_ROSE_QUARTZ_LIQUID_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AllFluids.MOLTEN_ROSE_QUARTZ.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AllFluids.MOLTEN_ROSE_QUARTZ_FLOWING.get(), RenderType.translucent());
    }
}
