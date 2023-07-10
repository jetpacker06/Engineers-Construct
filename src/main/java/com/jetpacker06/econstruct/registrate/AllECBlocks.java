package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.Tab;
import com.jetpacker06.econstruct.content.block.cogwheel.MetalCogwheelBlock;
import com.jetpacker06.econstruct.content.block.mechanicalfurnace.MechanicalFurnaceBlock;
import com.jetpacker06.econstruct.content.block.mold.ShaftMoldBlock;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockModel;
import com.simibubi.create.content.kinetics.simpleRelays.CogwheelBlockItem;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class AllECBlocks {
    private static final CreateRegistrate REGISTRATE = EngineersConstruct.registrate().creativeModeTab(() -> Tab.ENGINEERS_CONSTRUCT);

    public static BlockEntry<Block> CHOCOLATE_BLOCK;
    public static BlockEntry<ShaftMoldBlock> SHAFT_MOLD;

    public static BlockEntry<MetalCogwheelBlock> IRON_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> BRASS_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> LARGE_IRON_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> LARGE_BRASS_COGWHEEL;

    public static BlockEntry<MechanicalFurnaceBlock> SEARED_MECHANICAL_FURNACE;
    public static BlockEntry<MechanicalFurnaceBlock> SCORCHED_MECHANICAL_FURNACE;

    public static void registerBlocks() {
        CHOCOLATE_BLOCK = REGISTRATE.block("chocolate_block", Block::new)
                .initialProperties(() -> Blocks.SLIME_BLOCK)
                .simpleItem()
                .register();
        SHAFT_MOLD = REGISTRATE.block("shaft_mold", ShaftMoldBlock::new)
                .initialProperties(() -> Blocks.GOLD_BLOCK)
                .properties(p -> p.requiresCorrectToolForDrops().noOcclusion())
                .blockstate((context, provider) -> provider.simpleBlock(context.getEntry(), AssetLookup.standardModel(context, provider)))
                .simpleItem()
                .register();

        SEARED_MECHANICAL_FURNACE = REGISTRATE.block("seared_mechanical_furnace", MechanicalFurnaceBlock::new)
                .initialProperties(SharedProperties::stone)
                .properties(p -> p.requiresCorrectToolForDrops().noOcclusion())
                .transform(BlockStressDefaults.setImpact(64))
                .blockstate(BlockStateGen.horizontalBlockProvider(false))
                .simpleItem()
                .register();
        SCORCHED_MECHANICAL_FURNACE = REGISTRATE.block("scorched_mechanical_furnace", MechanicalFurnaceBlock::new)
                .initialProperties(SharedProperties::stone)
                .properties(p -> p.requiresCorrectToolForDrops().noOcclusion())
                .transform(BlockStressDefaults.setImpact(64))
                .blockstate(BlockStateGen.horizontalBlockProvider(false))
                .simpleItem()
                .register();

        IRON_COGWHEEL = REGISTRATE.block("iron_cogwheel", MetalCogwheelBlock::small)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .item(CogwheelBlockItem::new).build()
                .register();

        BRASS_COGWHEEL = REGISTRATE.block("brass_cogwheel", MetalCogwheelBlock::small)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .item(CogwheelBlockItem::new).build()
                .register();

        LARGE_IRON_COGWHEEL = REGISTRATE.block("large_iron_cogwheel", MetalCogwheelBlock::large)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .item(CogwheelBlockItem::new).build()
                .register();

        LARGE_BRASS_COGWHEEL = REGISTRATE.block("large_brass_cogwheel", MetalCogwheelBlock::large)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .item(CogwheelBlockItem::new).build()
                .register();

    }
}
