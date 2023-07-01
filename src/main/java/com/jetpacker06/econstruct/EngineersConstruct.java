package com.jetpacker06.econstruct;

import com.jetpacker06.econstruct.content.modifier.EConstructModifiers;
import com.jetpacker06.econstruct.registrate.AllBlocks;
import com.jetpacker06.econstruct.registrate.AllFluids;
import com.jetpacker06.econstruct.registrate.AllItems;
import com.jetpacker06.econstruct.registrate.AllTileEntities;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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

        AllItems.registerItems(REGISTRATE);
        AllFluids.registerFluids(REGISTRATE);
        AllBlocks.registerBasicBlocks(REGISTRATE);
        EConstructModifiers.register(eventBus);
        AllTileEntities.register();
        MinecraftForge.EVENT_BUS.register(this);
    }
}
