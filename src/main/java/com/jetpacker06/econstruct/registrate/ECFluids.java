package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.Tab;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class ECFluids {
    public static FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_ANDESITE;
    public static FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_ANDESITE_ALLOY;
    public static FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_REDSTONE;
    public static FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_ROSE_QUARTZ;

    public static FluidEntry<ForgeFlowingFluid.Flowing> FUEL1;
    public static FluidEntry<ForgeFlowingFluid.Flowing> FUEL2;

    public static void applyDefaultAttributes(FluidAttributes.Builder builder, int color, int temperature) {
        builder.viscosity(5);
        builder.density(2);
        builder.color(color);
        builder.temperature(temperature);
        builder.sound(SoundEvents.BUCKET_FILL_LAVA);
    }
    public static void applyDefaultAttributes(FluidAttributes.Builder builder, int color) {
        applyDefaultAttributes(builder, color, 300);
    }
    public static void applyDefaultProperties(ForgeFlowingFluid.Properties builder) {
        builder.slopeFindDistance(2).levelDecreasePerBlock(2);
    }
    public static void registerFluids(Registrate REGISTRATE) {
        REGISTRATE.creativeModeTab(() -> Tab.ENGINEERS_CONSTRUCT);
        ResourceLocation still = new ResourceLocation("block/water_still");
        ResourceLocation flow = new ResourceLocation("block/water_flow");
        var molten_andesite = REGISTRATE.fluid("molten_andesite", still, flow)
                .attributes(builder -> applyDefaultAttributes(builder, 0xff7d7a7a))
                .properties(ECFluids::applyDefaultProperties)
                .source(ForgeFlowingFluid.Source::new);
        var molten_andesite_alloy = REGISTRATE.fluid("molten_andesite_alloy", still, flow)
                .attributes(builder -> applyDefaultAttributes(builder, 0xff69818c))
                .properties(ECFluids::applyDefaultProperties)
                .source(ForgeFlowingFluid.Source::new);
        var molten_redstone = REGISTRATE.fluid("molten_redstone", still, flow)
                .attributes(builder -> applyDefaultAttributes(builder, 0xff870000))
                .properties(ECFluids::applyDefaultProperties)
                .source(ForgeFlowingFluid.Source::new);
        var molten_rose_quartz = REGISTRATE.fluid("molten_rose_quartz", still, flow)
                .attributes(builder -> applyDefaultAttributes(builder, 0xffeb23c6))
                .properties(ECFluids::applyDefaultProperties)
                .source(ForgeFlowingFluid.Source::new);

        ResourceLocation fuelRL = new ResourceLocation(EngineersConstruct.MOD_ID, "block/fuel");
        var fuel1 = REGISTRATE.fluid("fuel1", fuelRL, fuelRL)
                .attributes(builder -> applyDefaultAttributes(builder, 0xffffffff))
                .attributes(builder -> builder.temperature(1000))
                .properties(ECFluids::applyDefaultProperties)
                .source(ForgeFlowingFluid.Source::new);
        var fuel2 = REGISTRATE.fluid("fuel2", fuelRL, fuelRL)
                .attributes(builder -> applyDefaultAttributes(builder, 0xffffffff))
                .attributes(builder -> builder.temperature(1500))
                .properties(ECFluids::applyDefaultProperties)
                .source(ForgeFlowingFluid.Source::new);

        ECItems.FUEL1_BUCKET = fuel1.bucket()
                .properties(p -> p.stacksTo(1))
                .register();
        FUEL1 = fuel1.register();

        ECItems.FUEL2_BUCKET = fuel2.bucket()
                .properties(p -> p.stacksTo(1))
                .register();
        FUEL2 = fuel2.register();

        ECItems.MOLTEN_ANDESITE_BUCKET = molten_andesite.bucket()
                .properties(p -> p.stacksTo(1))
                .register();
        MOLTEN_ANDESITE = molten_andesite.register();

        ECItems.MOLTEN_ANDESITE_ALLOY_BUCKET = molten_andesite_alloy.bucket()
                .properties(p -> p.stacksTo(1))
                .register();
        MOLTEN_ANDESITE_ALLOY = molten_andesite_alloy.register();

        ECItems.MOLTEN_REDSTONE_BUCKET = molten_redstone.bucket()
                .properties(p -> p.stacksTo(1))
                .register();
        MOLTEN_REDSTONE = molten_redstone.register();

        ECItems.MOLTEN_ROSE_QUARTZ_BUCKET = molten_rose_quartz.bucket()
                .properties(p -> p.stacksTo(1))
                .register();
        MOLTEN_ROSE_QUARTZ = molten_rose_quartz.register();
    }
}
