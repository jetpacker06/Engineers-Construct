package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.datagen.ECLang;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.entry.FluidEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class ECFluids {

    public static ResourceLocation waterStill = new ResourceLocation("block/water_still");
    public static ResourceLocation waterFlow = new ResourceLocation("block/water_flow");

    public static FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_ANDESITE;
    public static FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_ANDESITE_ALLOY;
    public static FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_REDSTONE;
    public static FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_ROSE_QUARTZ;

    public static FluidEntry<ForgeFlowingFluid.Flowing> FUEL1;
    public static FluidEntry<ForgeFlowingFluid.Flowing> FUEL2;

    /**
     * Creates a fluid with a given color. Use the format 0xAA(hex)
     */
    public static FluidBuilder<ForgeFlowingFluid.Flowing, CreateRegistrate> basicFluid(String langName, int color) {
        return basicFluid(langName.toLowerCase().replace(" ", "_").replace(".", "_"), langName, color, waterStill, waterFlow);
    }
    public static FluidBuilder<ForgeFlowingFluid.Flowing, CreateRegistrate> basicFluid(String registryName, String langName, int color, ResourceLocation still, ResourceLocation flow) {
        ECLang.add("fluid." + EngineersConstruct.MODID + "." + registryName, langName);
        return EngineersConstruct.REGISTRATE.fluid(registryName, still, flow, (b, f) -> FluidAttributes.builder(still, flow).color(color).build(f))
             //   .lang(langName)
                .attributes(b -> b.viscosity(500).density(500))
                .properties(p -> p.tickRate(5).slopeFindDistance(6).explosionResistance(100f))
                .source(ForgeFlowingFluid.Source::new);
    }
    public static ItemEntry<BucketItem> getBucket(FluidBuilder<ForgeFlowingFluid.Flowing, CreateRegistrate> fluid) {
        return fluid.bucket().properties(p -> p.stacksTo(1)).register();
    }
    public static void registerFluids() {
        var molten_andesite = basicFluid("Molten Andesite", 0xff7d7a7a);
        var molten_andesite_alloy = basicFluid("Molten Andesite Alloy", 0xff69818c);
        var molten_redstone = basicFluid("Molten Redstone", 0xff870000);
        var molten_rose_quartz = basicFluid("molten_rose_quartz", 0xffeb23c6);
        ECItems.MOLTEN_ANDESITE_BUCKET = getBucket(molten_andesite);
        MOLTEN_ANDESITE = molten_andesite.register();
        ECItems.MOLTEN_ANDESITE_ALLOY_BUCKET = getBucket(molten_andesite_alloy);
        MOLTEN_ANDESITE_ALLOY = molten_andesite_alloy.register();
        ECItems.MOLTEN_REDSTONE_BUCKET = getBucket(molten_redstone);
        MOLTEN_REDSTONE = molten_redstone.register();
        ECItems.MOLTEN_ROSE_QUARTZ_BUCKET = getBucket(molten_rose_quartz);
        MOLTEN_ROSE_QUARTZ = molten_rose_quartz.register();

        ResourceLocation fuelRL = new ResourceLocation(EngineersConstruct.MODID, "block/fuel");
        var fuel1 = basicFluid("fuel1", "Powered by Mechanical Furnace", 0xffffffff, fuelRL, fuelRL)
                .attributes(b -> b.temperature(1000));
        var fuel2 = basicFluid("fuel2", "Powered by Mechanical Furnace", 0xffffffff, fuelRL, fuelRL)
                .attributes(b -> b.temperature(1500));
        ECItems.FUEL1_BUCKET = getBucket(fuel1);
        FUEL1 = fuel1.register();
        ECItems.FUEL2_BUCKET = getBucket(fuel2);
        FUEL2 = fuel2.register();
    }
}
