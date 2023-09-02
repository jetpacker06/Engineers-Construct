package com.jetpacker06.econstruct.datagen;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.datagen.material.*;
import com.jetpacker06.econstruct.datagen.recipe.EConstructVanillaRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = EngineersConstruct.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        if (event.includeClient()) {
            client(gen);
        }
        if (event.includeServer()) {
            server(gen);
        }
    }

    public static void server(DataGenerator gen) {
        gen.addProvider(new EConstructVanillaRecipeProvider(gen));

       // ECMaterialGen materialGen = new ECMaterialGen(gen);
       // gen.addProvider(materialGen);
       // gen.addProvider(new ECMaterialTraitsGen(gen, materialGen));
       // gen.addProvider(new ECMaterialTraitsGen(gen, materialGen));
       // gen.addProvider(new ECMaterialStatsGen(gen, materialGen));
    }

    public static void client(DataGenerator gen) {
       // ECMaterialTextures textures = new ECMaterialTextures();
      //  gen.addProvider(new ECMaterialRenderInfo(gen, textures));
    }
}
