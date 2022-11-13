package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.mechanicalfurnace.MechanicalFurnaceBlock;
import com.jetpacker06.econstruct.register.ItemGroups;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;

public class AllBlocks {

    public static BlockEntry<Block> ANDESITE_ALLOY_BLOCK;
    public static BlockEntry<Block> CHOCOLATE_BLOCK;

    public static void registerBasic(Registrate registrate) {
        registrate.creativeModeTab(() -> ItemGroups.ENGINEERS_CONSTRUCT);
        ANDESITE_ALLOY_BLOCK = registrate.block("andesite_alloy_block", Block::new)
                .simpleItem()
                .lang("Block of Andesite Alloy")
                .register();
        CHOCOLATE_BLOCK = registrate.block("chocolate_block", Block::new)
                .simpleItem()
                .lang("Block of Chocolate")
                .register();
    }
    private static final CreateRegistrate REGISTRATE = EngineersConstruct.registrate().creativeModeTab(() -> ItemGroups.ENGINEERS_CONSTRUCT);

    public static final BlockEntry<MechanicalFurnaceBlock> MECHANICAL_FURNACE = REGISTRATE.block("mechanical_furnace", MechanicalFurnaceBlock::new)
            .initialProperties(SharedProperties::stone)
            .lang("Mechanical Furnace")
            .transform(BlockStressDefaults.setImpact(2))
            .simpleItem()
            .register();
}
