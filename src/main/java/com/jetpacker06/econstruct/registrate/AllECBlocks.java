package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.block.ShaftMoldBlock;
import com.jetpacker06.econstruct.content.block.mechanicalfurnace.MechanicalFurnaceBlock;
import com.jetpacker06.econstruct.content.Tab;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.foundation.data.*;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class AllECBlocks {

    public static BlockEntry<Block> CHOCOLATE_BLOCK;
    public static BlockEntry<ShaftMoldBlock> SHAFT_MOLD;

    public static BlockEntry<MechanicalFurnaceBlock> SEARED_MECHANICAL_FURNACE;
    public static BlockEntry<MechanicalFurnaceBlock> SCORCHED_MECHANICAL_FURNACE;

    public static void registerBasicBlocks(Registrate registrate) {
        registrate.creativeModeTab(() -> Tab.ENGINEERS_CONSTRUCT);
        CHOCOLATE_BLOCK = registrate.block("chocolate_block", Block::new)
                .initialProperties(() -> Blocks.SLIME_BLOCK)
                .simpleItem()
                .register();
        SHAFT_MOLD = registrate.block("shaft_mold", ShaftMoldBlock::new)
                .initialProperties(() -> Blocks.GOLD_BLOCK)
                .properties(p -> p.requiresCorrectToolForDrops().noOcclusion())
                .blockstate((c, p) -> p.simpleBlock(c.getEntry(), AssetLookup.partialBaseModel(c, p)))
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
    }
    private static final CreateRegistrate REGISTRATE = EngineersConstruct.registrate().creativeModeTab(() -> Tab.ENGINEERS_CONSTRUCT);
}
