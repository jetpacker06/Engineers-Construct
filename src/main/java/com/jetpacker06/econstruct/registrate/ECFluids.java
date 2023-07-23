package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.Tab;
import com.tterrag.registrate.Registrate;
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
    public static Registrate REGISTRATE;

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
    public static FluidBuilder<ForgeFlowingFluid.Flowing, Registrate> basicFluid(String name, int color) {
        return basicFluid(name, color, waterStill, waterFlow);
    }
    public static FluidBuilder<ForgeFlowingFluid.Flowing, Registrate> basicFluid(String name, int color, ResourceLocation still, ResourceLocation flow) {
        return REGISTRATE.fluid(name, still, flow, (b, f) -> new ColoredFluidAttributes(b, f, color))
                .attributes(b -> b.viscosity(500).density(500))
                .properties(p -> p.tickRate(5).slopeFindDistance(6).explosionResistance(100f))
                .source(ForgeFlowingFluid.Source::new);
    }
    public static ItemEntry<BucketItem> getBucket(FluidBuilder<ForgeFlowingFluid.Flowing, Registrate> fluid) {
        return fluid.bucket().properties(p -> p.stacksTo(1)).register();
    }
    public static void registerFluids(Registrate registrate) {
        registrate.creativeModeTab(() -> Tab.ENGINEERS_CONSTRUCT);
        ECFluids.REGISTRATE = registrate;

        var molten_andesite = basicFluid("molten_andesite", 0x007d7a7a);
        var molten_andesite_alloy = basicFluid("molten_andesite_alloy", 0x0069818c);
        var molten_redstone = basicFluid("molten_redstone", 0x00870000);
        var molten_rose_quartz = basicFluid("molten_rose_quartz", 0x00eb23c6);
        ECItems.MOLTEN_ANDESITE_BUCKET = getBucket(molten_andesite);
        MOLTEN_ANDESITE = molten_andesite.register();
        ECItems.MOLTEN_ANDESITE_ALLOY_BUCKET = getBucket(molten_andesite_alloy);
        MOLTEN_ANDESITE_ALLOY = molten_andesite_alloy.register();
        ECItems.MOLTEN_REDSTONE_BUCKET = getBucket(molten_redstone);
        MOLTEN_REDSTONE = molten_redstone.register();
        ECItems.MOLTEN_ROSE_QUARTZ_BUCKET = getBucket(molten_rose_quartz);
        MOLTEN_ROSE_QUARTZ = molten_rose_quartz.register();

        ResourceLocation fuelRL = new ResourceLocation(EngineersConstruct.MOD_ID, "block/fuel");
        var fuel1 = basicFluid("fuel1", 0x00ffffff, fuelRL, fuelRL)
                .attributes(b -> b.temperature(1000));
        var fuel2 = basicFluid("fuel2", 0x00ffffff, fuelRL, fuelRL)
                .attributes(b -> b.temperature(1500));
        ECItems.FUEL1_BUCKET = getBucket(fuel1);
        FUEL1 = fuel1.register();
        ECItems.FUEL2_BUCKET = getBucket(fuel2);
        FUEL2 = fuel2.register();
    }

    private static class ColoredFluidAttributes extends FluidAttributes {
        private final int color;

        protected ColoredFluidAttributes(Builder builder, Fluid fluid, int color) {
            super(builder, fluid);
            this.color = color;
        }

        @Override
        public int getColor(BlockAndTintGetter world, BlockPos pos) {
            return color;
        }

        @Override
        public int getColor(FluidStack stack) {
            return color;
        }
    }
}
