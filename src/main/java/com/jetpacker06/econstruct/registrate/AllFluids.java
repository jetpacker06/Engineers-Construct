package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.register.ItemGroup;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.FluidEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BucketItem;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class AllFluids {
    public static FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_ANDESITE;
    public static FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_ANDESITE_ALLOY;
    public static FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_REDSTONE;
    public static FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_ROSE_QUARTZ;

    public static ItemEntry<BucketItem> MOLTEN_ANDESITE_BUCKET;
    public static ItemEntry<BucketItem> MOLTEN_ANDESITE_ALLOY_BUCKET;
    public static ItemEntry<BucketItem> MOLTEN_REDSTONE_BUCKET;
    public static ItemEntry<BucketItem> MOLTEN_ROSE_QUARTZ_BUCKET;

    public static void applyDefaultAttributes(FluidAttributes.Builder builder, int color) {
        builder.viscosity(5);
        builder.density(2);
        builder.color(color);
        builder.temperature(300);
        builder.sound(SoundEvents.BUCKET_FILL_LAVA);
    }
    public static void applyDefaultProperties(ForgeFlowingFluid.Properties builder) {
        builder.slopeFindDistance(2).levelDecreasePerBlock(2);
    }
    public static void registerFluids(Registrate REGISTRATE) {
        REGISTRATE.creativeModeTab(() -> ItemGroup.ENGINEERS_CONSTRUCT);
        ResourceLocation still = new ResourceLocation("block/water_still");
        ResourceLocation flow = new ResourceLocation("block/water_flow");
        var molten_andesite = REGISTRATE.fluid("molten_andesite", still, flow)
                .lang("Molten Andesite")
                .attributes(builder -> applyDefaultAttributes(builder, 0xff7d7a7a))
                .properties(AllFluids::applyDefaultProperties)
                .source(ForgeFlowingFluid.Source::new);
        var molten_andesite_alloy = REGISTRATE.fluid("molten_andesite_alloy", still, flow)
                .lang("Molten Andesite Alloy")
                .attributes(builder -> applyDefaultAttributes(builder, 0xff69818c))
                .properties(AllFluids::applyDefaultProperties)
                .source(ForgeFlowingFluid.Source::new);
        var molten_redstone = REGISTRATE.fluid("molten_redstone", still, flow)
                .lang("Molten Redstone")
                .attributes(builder -> applyDefaultAttributes(builder, 0xff870000))
                .properties(AllFluids::applyDefaultProperties)
                .source(ForgeFlowingFluid.Source::new);
        var molten_rose_quartz = REGISTRATE.fluid("molten_rose_quartz", still, flow)
                .lang("Molten Rose Quartz")
                .attributes(builder -> applyDefaultAttributes(builder, 0xffeb23c6))
                .properties(AllFluids::applyDefaultProperties)
                .source(ForgeFlowingFluid.Source::new);

        MOLTEN_ANDESITE_BUCKET = molten_andesite.bucket()
                .properties(p -> p.stacksTo(1))
                .lang("Molten Andesite Bucket")
                .register();
        MOLTEN_ANDESITE = molten_andesite.register();

        MOLTEN_ANDESITE_ALLOY_BUCKET = molten_andesite_alloy.bucket()
                .lang("Molten Andesite Alloy Bucket")
                .properties(p -> p.stacksTo(1))
                .register();
        MOLTEN_ANDESITE_ALLOY = molten_andesite_alloy.register();

        MOLTEN_REDSTONE_BUCKET = molten_redstone.bucket()
                .properties(p -> p.stacksTo(1))
                .lang("Molten Redstone Bucket")
                .register();
        MOLTEN_REDSTONE = molten_redstone.register();

        MOLTEN_ROSE_QUARTZ_BUCKET = molten_rose_quartz.bucket()
                .properties(p -> p.stacksTo(1))
                .lang("Molten Rose Quartz Bucket")
                .register();
        MOLTEN_ROSE_QUARTZ = molten_rose_quartz.register();
    }
}
