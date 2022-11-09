package com.jetpacker06.econstruct.register;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
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
    public static final RegistryObject<FlowingFluid> MOLTEN_ANDESITE_ALLOY;
    public static final RegistryObject<FlowingFluid> MOLTEN_ANDESITE_ALLOY_FLOWING;
    public static final RegistryObject<LiquidBlock> MOLTEN_ANDESITE_ALLOY_LIQUID_BLOCK;
    public static final RegistryObject<FlowingFluid> MOLTEN_ANDESITE;
    public static final RegistryObject<FlowingFluid> MOLTEN_ANDESITE_FLOWING;
    public static final RegistryObject<LiquidBlock> MOLTEN_ANDESITE_LIQUID_BLOCK;
    static {
        MOLTEN_ANDESITE_ALLOY = FLUIDS.register("molten_andesite_alloy", () -> new ForgeFlowingFluid.Source(AllFluids.PROPERTIES));
        MOLTEN_ANDESITE_ALLOY_FLOWING = FLUIDS.register("molten_andesite_alloy_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.PROPERTIES));
        MOLTEN_ANDESITE_ALLOY_LIQUID_BLOCK = AllBlocks.BLOCKS.register("molten_andesite_alloy", () -> new LiquidBlock(AllFluids.MOLTEN_ANDESITE_ALLOY, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));

        MOLTEN_ANDESITE = FLUIDS.register("molten_andesite", () -> new ForgeFlowingFluid.Source(AllFluids.PROPERTIES));
        MOLTEN_ANDESITE_FLOWING = FLUIDS.register("molten_andesite_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.PROPERTIES));
        MOLTEN_ANDESITE_LIQUID_BLOCK = AllBlocks.BLOCKS.register("molten_andesite", () -> new LiquidBlock(AllFluids.MOLTEN_ANDESITE_ALLOY, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));
    }
    public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(MOLTEN_ANDESITE_ALLOY, MOLTEN_ANDESITE_ALLOY_FLOWING, FluidAttributes.Water.builder(STILL, FLOWING)
            .temperature(300).sound(SoundEvents.BOTTLE_FILL).overlay(OVERLAY).density(2).color(0xffffffff).luminosity(2).viscosity(5))
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(AllFluids.MOLTEN_ANDESITE_ALLOY_LIQUID_BLOCK);
}
