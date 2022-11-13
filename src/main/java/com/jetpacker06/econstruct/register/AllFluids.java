package com.jetpacker06.econstruct.register;

import com.jetpacker06.econstruct.EngineersConstruct;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.jetpacker06.econstruct.EngineersConstruct.MOD_ID;

public class AllFluids {
    public static final ResourceLocation STILL = new ResourceLocation("block/water_still");
    public static final ResourceLocation FLOWING = new ResourceLocation("block/water_flow");
    public static final ResourceLocation OVERLAY = new ResourceLocation("block/water_overlay");
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MOD_ID);
    public static final DeferredRegister<Block> LIQUID_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EngineersConstruct.MOD_ID);

    public static final RegistryObject<FlowingFluid> MOLTEN_ANDESITE_ALLOY;
    public static final RegistryObject<FlowingFluid> MOLTEN_ANDESITE_ALLOY_FLOWING;
    public static final RegistryObject<LiquidBlock> MOLTEN_ANDESITE_ALLOY_LIQUID_BLOCK;

    public static final RegistryObject<FlowingFluid> MOLTEN_ANDESITE;
    public static final RegistryObject<FlowingFluid> MOLTEN_ANDESITE_FLOWING;
    public static final RegistryObject<LiquidBlock> MOLTEN_ANDESITE_LIQUID_BLOCK;

    public static final RegistryObject<FlowingFluid> MOLTEN_REDSTONE;
    public static final RegistryObject<FlowingFluid> MOLTEN_REDSTONE_FLOWING;
    public static final RegistryObject<LiquidBlock> MOLTEN_REDSTONE_LIQUID_BLOCK;

    public static final RegistryObject<FlowingFluid> MOLTEN_ROSE_QUARTZ;
    public static final RegistryObject<FlowingFluid> MOLTEN_ROSE_QUARTZ_FLOWING;
    public static final RegistryObject<LiquidBlock> MOLTEN_ROSE_QUARTZ_LIQUID_BLOCK;


    static {
        MOLTEN_ANDESITE_ALLOY = FLUIDS.register("molten_andesite_alloy", () -> new ForgeFlowingFluid.Source(AllFluids.MAA_PROPERTIES));
        MOLTEN_ANDESITE_ALLOY_FLOWING = FLUIDS.register("molten_andesite_alloy_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.MAA_PROPERTIES));
        MOLTEN_ANDESITE_ALLOY_LIQUID_BLOCK = LIQUID_BLOCKS.register("molten_andesite_alloy", () -> new LiquidBlock(AllFluids.MOLTEN_ANDESITE_ALLOY, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));

        MOLTEN_ANDESITE = FLUIDS.register("molten_andesite", () -> new ForgeFlowingFluid.Source(AllFluids.MA_PROPERTIES));
        MOLTEN_ANDESITE_FLOWING = FLUIDS.register("molten_andesite_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.MA_PROPERTIES));
        MOLTEN_ANDESITE_LIQUID_BLOCK = LIQUID_BLOCKS.register("molten_andesite", () -> new LiquidBlock(AllFluids.MOLTEN_ANDESITE, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));

        MOLTEN_REDSTONE = FLUIDS.register("molten_redstone", () -> new ForgeFlowingFluid.Source(AllFluids.MR_PROPERTIES));
        MOLTEN_REDSTONE_FLOWING = FLUIDS.register("molten_redstone_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.MR_PROPERTIES));
        MOLTEN_REDSTONE_LIQUID_BLOCK = LIQUID_BLOCKS.register("molten_redstone", () -> new LiquidBlock(AllFluids.MOLTEN_REDSTONE, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));

        MOLTEN_ROSE_QUARTZ = FLUIDS.register("molten_rose_quartz", () -> new ForgeFlowingFluid.Source(AllFluids.MRQ_PROPERTIES));
        MOLTEN_ROSE_QUARTZ_FLOWING = FLUIDS.register("molten_rose_quartz_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.MRQ_PROPERTIES));
        MOLTEN_ROSE_QUARTZ_LIQUID_BLOCK = LIQUID_BLOCKS.register("molten_rose_quartz", () -> new LiquidBlock(AllFluids.MOLTEN_ROSE_QUARTZ, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));
    }
    public static final ForgeFlowingFluid.Properties MAA_PROPERTIES = new ForgeFlowingFluid.Properties(MOLTEN_ANDESITE_ALLOY, MOLTEN_ANDESITE_ALLOY_FLOWING, FluidAttributes.builder(STILL, FLOWING)
            .temperature(300).sound(SoundEvents.BOTTLE_FILL).overlay(OVERLAY).density(2).color(0xff69818c).luminosity(2).viscosity(5))
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(AllFluids.MOLTEN_ANDESITE_ALLOY_LIQUID_BLOCK).bucket(AllItems.MOLTEN_ANDESITE_ALLOY_BUCKET);

    public static final ForgeFlowingFluid.Properties MA_PROPERTIES = new ForgeFlowingFluid.Properties(MOLTEN_ANDESITE, MOLTEN_ANDESITE_FLOWING, FluidAttributes.builder(STILL, FLOWING)
            .temperature(300).sound(SoundEvents.BOTTLE_FILL).overlay(OVERLAY).density(2).color(0xff545454).luminosity(2).viscosity(5))
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(AllFluids.MOLTEN_ANDESITE_LIQUID_BLOCK).bucket(AllItems.MOLTEN_ANDESITE_BUCKET);

    public static final ForgeFlowingFluid.Properties MR_PROPERTIES = new ForgeFlowingFluid.Properties(MOLTEN_REDSTONE, MOLTEN_REDSTONE_FLOWING, FluidAttributes.builder(STILL, FLOWING)
            .temperature(300).sound(SoundEvents.BOTTLE_FILL).overlay(OVERLAY).density(2).color(0xff870000).luminosity(2).viscosity(5))
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(AllFluids.MOLTEN_REDSTONE_LIQUID_BLOCK).bucket(AllItems.MOLTEN_REDSTONE_BUCKET);

    public static final ForgeFlowingFluid.Properties MRQ_PROPERTIES = new ForgeFlowingFluid.Properties(MOLTEN_ROSE_QUARTZ, MOLTEN_ROSE_QUARTZ_FLOWING, FluidAttributes.builder(STILL, FLOWING)
            .temperature(300).sound(SoundEvents.BOTTLE_FILL).overlay(OVERLAY).density(2).color(0xffeb23c6).luminosity(2).viscosity(5))
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(AllFluids.MOLTEN_ROSE_QUARTZ_LIQUID_BLOCK).bucket(AllItems.MOLTEN_ROSE_QUARTZ_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
        LIQUID_BLOCKS.register(eventBus);
    }
}
