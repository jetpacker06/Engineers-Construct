package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.Tab;
import com.jetpacker06.econstruct.content.block.cogwheel.EncasedMetalCogwheelBlock;
import com.jetpacker06.econstruct.content.block.cogwheel.MetalCogwheelBlock;
import com.jetpacker06.econstruct.content.block.mechanicalfurnace.MechanicalFurnaceBlock;
import com.jetpacker06.econstruct.content.block.mold.ShaftMoldBlock;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockModel;
import com.simibubi.create.content.kinetics.simpleRelays.CogwheelBlockItem;
import com.simibubi.create.foundation.data.*;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class AllECBlocks {

    private static final CreateRegistrate REGISTRATE = EngineersConstruct.registrate().creativeModeTab(() -> Tab.ENGINEERS_CONSTRUCT);

    public static BlockEntry<Block> CHOCOLATE_BLOCK;
    public static BlockEntry<ShaftMoldBlock> SHAFT_MOLD;

    //Encased cogwheels are not enabled because they dont work yet
    public static BlockEntry<MetalCogwheelBlock> IRON_COGWHEEL;
    public static BlockEntry<EncasedMetalCogwheelBlock> ANDESITE_ENCASED_IRON_COGWHEEL;
    public static BlockEntry<EncasedMetalCogwheelBlock> BRASS_ENCASED_IRON_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> LARGE_IRON_COGWHEEL;
    public static BlockEntry<EncasedMetalCogwheelBlock> ANDESITE_ENCASED_LARGE_IRON_COGWHEEL;
    public static BlockEntry<EncasedMetalCogwheelBlock> BRASS_ENCASED_LARGE_IRON_COGWHEEL;

    public static BlockEntry<MetalCogwheelBlock> BRASS_COGWHEEL;
    public static BlockEntry<EncasedMetalCogwheelBlock> ANDESITE_ENCASED_BRASS_COGWHEEL;
    public static BlockEntry<EncasedMetalCogwheelBlock> BRASS_ENCASED_BRASS_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> LARGE_BRASS_COGWHEEL;
    public static BlockEntry<EncasedMetalCogwheelBlock> ANDESITE_ENCASED_LARGE_BRASS_COGWHEEL;
    public static BlockEntry<EncasedMetalCogwheelBlock> BRASS_ENCASED_LARGE_BRASS_COGWHEEL;

    public static BlockEntry<MetalCogwheelBlock> SEARED_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> LARGE_SEARED_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> SCORCHED_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> LARGE_SCORCHED_COGWHEEL;


    public static BlockEntry<MechanicalFurnaceBlock> SEARED_MECHANICAL_FURNACE;
    public static BlockEntry<MechanicalFurnaceBlock> SCORCHED_MECHANICAL_FURNACE;

    public static void registerBlocks() {
        CHOCOLATE_BLOCK = REGISTRATE.block("chocolate_block", Block::new)
                .initialProperties(() -> Blocks.SLIME_BLOCK)
                .transform(block -> block.tag(BlockTags.MINEABLE_WITH_PICKAXE).tag(BlockTags.MINEABLE_WITH_SHOVEL))
                .simpleItem()
                .register();
        SHAFT_MOLD = REGISTRATE.block("shaft_mold", ShaftMoldBlock::new)
                .initialProperties(() -> Blocks.GOLD_BLOCK)
                .properties(p -> p.requiresCorrectToolForDrops().noOcclusion())
                .blockstate((context, provider) -> provider.simpleBlock(context.getEntry(), AssetLookup.standardModel(context, provider)))
                .transform(pickaxeOnly())
                .simpleItem()
                .register();

        SEARED_MECHANICAL_FURNACE = REGISTRATE.block("seared_mechanical_furnace", MechanicalFurnaceBlock::new)
                .initialProperties(SharedProperties::stone)
                .properties(p -> p.requiresCorrectToolForDrops().noOcclusion())
                .transform(BlockStressDefaults.setImpact(64))
                .blockstate(BlockStateGen.horizontalBlockProvider(false))
                .transform(pickaxeOnly())
                .simpleItem()
                .register();
        SCORCHED_MECHANICAL_FURNACE = REGISTRATE.block("scorched_mechanical_furnace", MechanicalFurnaceBlock::new)
                .initialProperties(SharedProperties::stone)
                .properties(p -> p.requiresCorrectToolForDrops().noOcclusion())
                .transform(BlockStressDefaults.setImpact(64))
                .blockstate(BlockStateGen.horizontalBlockProvider(false))
                .transform(pickaxeOnly())
                .simpleItem()
                .register();

        IRON_COGWHEEL = REGISTRATE.block("iron_cogwheel", MetalCogwheelBlock::small)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();
   //     ANDESITE_ENCASED_IRON_COGWHEEL = REGISTRATE.block("andesite_encased_iron_cogwheel",
   //                     p -> new EncasedMetalCogwheelBlock(p, false, AllBlocks.ANDESITE_CASING::get))
   //             .properties(p -> p.color(MaterialColor.PODZOL))
   //             .transform(BuilderTransformers.encasedCogwheel("andesite", () -> AllSpriteShifts.ANDESITE_CASING))
   //             .transform(EncasingRegistry.addVariantTo(AllECBlocks.IRON_COGWHEEL))
   //             .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.ANDESITE_CASING,
   //                     Couple.create(AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_SIDE,
   //                             AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_OTHERSIDE))))
   //             .register();
   //     BRASS_ENCASED_IRON_COGWHEEL = REGISTRATE.block("brass_encased_iron_cogwheel",
   //                     p -> new EncasedMetalCogwheelBlock(p, false, AllBlocks.BRASS_CASING::get))
   //             .properties(p -> p.color(MaterialColor.TERRACOTTA_BROWN))
   //             .transform(BuilderTransformers.encasedCogwheel("brass", () -> AllSpriteShifts.BRASS_CASING))
   //             .transform(EncasingRegistry.addVariantTo(AllECBlocks.IRON_COGWHEEL))
   //             .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.BRASS_CASING,
   //                     Couple.create(AllSpriteShifts.BRASS_ENCASED_COGWHEEL_SIDE,
   //                             AllSpriteShifts.BRASS_ENCASED_COGWHEEL_OTHERSIDE))))
   //             .register();
        LARGE_IRON_COGWHEEL = REGISTRATE.block("large_iron_cogwheel", MetalCogwheelBlock::large)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();
    //    ANDESITE_ENCASED_LARGE_IRON_COGWHEEL = REGISTRATE.block("andesite_encased_large_iron_cogwheel",
    //                    p -> new EncasedMetalCogwheelBlock(p, true, AllBlocks.ANDESITE_CASING::get))
    //            .properties(p -> p.color(MaterialColor.PODZOL))
    //            .transform(BuilderTransformers.encasedLargeCogwheel("andesite", () -> AllSpriteShifts.ANDESITE_CASING))
    //            .transform(EncasingRegistry.addVariantTo(AllECBlocks.LARGE_IRON_COGWHEEL))
    //            .register();
    //    BRASS_ENCASED_LARGE_IRON_COGWHEEL = REGISTRATE.block("brass_encased_large_iron_cogwheel",
    //                    p -> new EncasedMetalCogwheelBlock(p, true, AllBlocks.BRASS_CASING::get))
    //            .properties(p -> p.color(MaterialColor.TERRACOTTA_BROWN))
    //            .transform(BuilderTransformers.encasedLargeCogwheel("brass", () -> AllSpriteShifts.BRASS_CASING))
    //            .transform(EncasingRegistry.addVariantTo(AllECBlocks.LARGE_IRON_COGWHEEL))
    //            .register();


        BRASS_COGWHEEL = REGISTRATE.block("brass_cogwheel", MetalCogwheelBlock::small)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();
   //     ANDESITE_ENCASED_BRASS_COGWHEEL = REGISTRATE.block("andesite_encased_brass_cogwheel",
   //                     p -> new EncasedMetalCogwheelBlock(p, false, AllBlocks.ANDESITE_CASING::get))
   //             .properties(p -> p.color(MaterialColor.PODZOL))
   //             .transform(BuilderTransformers.encasedCogwheel("andesite", () -> AllSpriteShifts.ANDESITE_CASING))
   //             .transform(EncasingRegistry.addVariantTo(AllECBlocks.BRASS_COGWHEEL))
   //             .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.ANDESITE_CASING,
   //                     Couple.create(AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_SIDE,
   //                             AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_OTHERSIDE))))
   //             .register();
   //     BRASS_ENCASED_BRASS_COGWHEEL = REGISTRATE.block("brass_encased_brass_cogwheel",
   //                     p -> new EncasedMetalCogwheelBlock(p, false, AllBlocks.BRASS_CASING::get))
   //             .properties(p -> p.color(MaterialColor.TERRACOTTA_BROWN))
   //             .transform(BuilderTransformers.encasedCogwheel("brass", () -> AllSpriteShifts.BRASS_CASING))
   //             .transform(EncasingRegistry.addVariantTo(AllECBlocks.BRASS_COGWHEEL))
   //             .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.BRASS_CASING,
   //                     Couple.create(AllSpriteShifts.BRASS_ENCASED_COGWHEEL_SIDE,
   //                             AllSpriteShifts.BRASS_ENCASED_COGWHEEL_OTHERSIDE))))
   //             .register();
        LARGE_BRASS_COGWHEEL = REGISTRATE.block("large_brass_cogwheel", MetalCogwheelBlock::large)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();
    //    ANDESITE_ENCASED_LARGE_BRASS_COGWHEEL = REGISTRATE.block("andesite_encased_large_brass_cogwheel",
    //                    p -> new EncasedMetalCogwheelBlock(p, true, AllBlocks.ANDESITE_CASING::get))
    //            .properties(p -> p.color(MaterialColor.PODZOL))
    //            .transform(BuilderTransformers.encasedLargeCogwheel("andesite", () -> AllSpriteShifts.ANDESITE_CASING))
    //            .transform(EncasingRegistry.addVariantTo(AllECBlocks.LARGE_BRASS_COGWHEEL))
    //            .register();
    //    BRASS_ENCASED_LARGE_BRASS_COGWHEEL = REGISTRATE.block("brass_encased_large_brass_cogwheel",
    //                    p -> new EncasedMetalCogwheelBlock(p, true, AllBlocks.BRASS_CASING::get))
    //            .properties(p -> p.color(MaterialColor.TERRACOTTA_BROWN))
    //            .transform(BuilderTransformers.encasedLargeCogwheel("brass", () -> AllSpriteShifts.BRASS_CASING))
    //            .transform(EncasingRegistry.addVariantTo(AllECBlocks.LARGE_BRASS_COGWHEEL))
    //            .register();


        SEARED_COGWHEEL = REGISTRATE.block("seared_cogwheel", MetalCogwheelBlock::small)
                .initialProperties(SharedProperties::stone)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();
        LARGE_SEARED_COGWHEEL = REGISTRATE.block("large_seared_cogwheel", MetalCogwheelBlock::large)
                .initialProperties(SharedProperties::stone)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();
        SCORCHED_COGWHEEL = REGISTRATE.block("scorched_cogwheel", MetalCogwheelBlock::small)
                .initialProperties(SharedProperties::stone)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();
        LARGE_SCORCHED_COGWHEEL = REGISTRATE.block("large_scorched_cogwheel", MetalCogwheelBlock::large)
                .initialProperties(SharedProperties::stone)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();
    }
}
