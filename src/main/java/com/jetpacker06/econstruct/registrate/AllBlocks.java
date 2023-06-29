package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.mechanicalfurnace.MechanicalFurnaceBlock;
import com.jetpacker06.econstruct.content.Tab;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class AllBlocks {

    public static BlockEntry<Block> CHOCOLATE_BLOCK;

    public static void registerBasicBlocks(Registrate registrate) {
        registrate.creativeModeTab(() -> Tab.ENGINEERS_CONSTRUCT);
        CHOCOLATE_BLOCK = registrate.block("chocolate_block", Block::new)
                .simpleItem()
                .lang("Block of Chocolate")
                .register();
    }
    private static final CreateRegistrate REGISTRATE = EngineersConstruct.registrate().creativeModeTab(() -> Tab.ENGINEERS_CONSTRUCT);

    public static final BlockEntry<MechanicalFurnaceBlock> SEARED_MECHANICAL_FURNACE = REGISTRATE.block("seared_mechanical_furnace", MechanicalFurnaceBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .lang("Seared Mechanical Furnace")
            .transform(BlockStressDefaults.setImpact(64))
            .simpleItem()
            .register();
    public static final BlockEntry<MechanicalFurnaceBlock> SCORCHED_MECHANICAL_FURNACE = REGISTRATE.block("scorched_mechanical_furnace", MechanicalFurnaceBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .lang("Scorched Mechanical Furnace")
            .transform(BlockStressDefaults.setImpact(64))
            .simpleItem()
            .register();
}
