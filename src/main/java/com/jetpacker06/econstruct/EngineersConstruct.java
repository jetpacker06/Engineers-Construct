package com.jetpacker06.econstruct;

import com.jetpacker06.econstruct.content.Tab;
import com.jetpacker06.econstruct.content.modifier.ECModifiers;
import com.jetpacker06.econstruct.datagen.ECLang;
import com.jetpacker06.econstruct.registrate.ECBlocks;
import com.jetpacker06.econstruct.registrate.ECFluids;
import com.jetpacker06.econstruct.registrate.ECItems;
import com.jetpacker06.econstruct.registrate.ECBlockEntities;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EngineersConstruct.MODID)
public class EngineersConstruct {

    public static final String MODID = "econstruct";
    public static final String NAME = "Engineer's Construct";

    public static CreateRegistrate REGISTRATE;

    public EngineersConstruct() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRATE = CreateRegistrate.create(EngineersConstruct.MODID).registerEventListeners(eventBus);
        REGISTRATE.creativeModeTab(() -> Tab.ENGINEERS_CONSTRUCT);

        ECItems.registerItems();
        ECFluids.registerFluids();
        ECBlocks.registerBlocks(REGISTRATE);
        ECBlockEntities.registerBlockEntities(REGISTRATE);

        ECLang.register();

        ECModifiers.register(eventBus);
        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void clientSetup(FMLClientSetupEvent event) {
   //     ItemBlockRenderTypes.setRenderLayer(AllECBlocks.SHAFT_MOLD.get(), RenderType.CUT);
    }
}
