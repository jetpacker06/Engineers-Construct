package com.jetpacker06.econstruct.datagen;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.datagen.recipeproviders.EConstructVanillaRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = EngineersConstruct.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        ExistingFileHelper helper = event.getExistingFileHelper();
        DataGenerator gen = event.getGenerator();
        gen.addProvider(new EConstructLang(gen, EngineersConstruct.MOD_ID, "en_us"));
        gen.addProvider(new EConstructVanillaRecipeProvider(gen));
    }
}
