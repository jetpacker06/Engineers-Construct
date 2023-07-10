package com.jetpacker06.econstruct;

import com.jetpacker06.econstruct.content.modifier.EConstructModifiers;
import com.jetpacker06.econstruct.registrate.AllECBlocks;
import com.jetpacker06.econstruct.registrate.AllECFluids;
import com.jetpacker06.econstruct.registrate.AllECItems;
import com.jetpacker06.econstruct.registrate.AllECBlockEntities;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EngineersConstruct.MOD_ID)
public class EngineersConstruct {
    public static final String MOD_ID = "econstruct";
    private static final NonNullSupplier<CreateRegistrate> createRegistrate = NonNullSupplier
            .lazy(() -> CreateRegistrate.create(MOD_ID).registerEventListeners(FMLJavaModLoadingContext.get()
                    .getModEventBus()));
    public static CreateRegistrate registrate() {
        return createRegistrate.get();
    }

    public EngineersConstruct() {
        Registrate REGISTRATE = Registrate.create(EngineersConstruct.MOD_ID);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        AllECItems.registerItems(REGISTRATE);
        AllECFluids.registerFluids(REGISTRATE);
        AllECBlocks.registerBlocks();
        AllECBlockEntities.registerBlockEntities();

        EConstructModifiers.register(eventBus);
        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void clientSetup(FMLClientSetupEvent event) {
   //     ItemBlockRenderTypes.setRenderLayer(AllECBlocks.SHAFT_MOLD.get(), RenderType.CUT);
    }
}
