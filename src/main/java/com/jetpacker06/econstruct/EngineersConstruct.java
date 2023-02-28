package com.jetpacker06.econstruct;

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

@Mod("econstruct")
public class EngineersConstruct {
    public static final String MOD_ID = "econstruct";
    private static final NonNullSupplier<CreateRegistrate> createRegistrate = CreateRegistrate.lazy(MOD_ID);
    public static CreateRegistrate registrate() {
        return createRegistrate.get();
    }

    public EngineersConstruct() {
        Registrate REGISTRATE = Registrate.create(EngineersConstruct.MOD_ID);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        AllItems.registerItems(REGISTRATE);
        AllFluids.registerFluids(REGISTRATE);
        AllBlocks.registerBasicBlocks(REGISTRATE);
        AllTileEntities.register();
        eventBus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }
    public void clientSetup(FMLClientSetupEvent event) {
        return;//   ItemBlockRenderTypes.setRenderLayer(AllBlocks.MECHANICAL_FURNACE.get(), RenderType.cutout());
    }
}
