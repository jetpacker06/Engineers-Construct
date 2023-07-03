package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.block.mechanicalfurnace.MechanicalFurnaceBlock;
import com.jetpacker06.econstruct.content.Tab;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.foundation.data.*;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.Tags;

public class AllBlocks {

    public static BlockEntry<Block> CHOCOLATE_BLOCK;

    public static void registerBasicBlocks(Registrate registrate) {
        registrate.creativeModeTab(() -> Tab.ENGINEERS_CONSTRUCT);
        CHOCOLATE_BLOCK = registrate.block("chocolate_block", Block::new)
                .lang("Block of Chocolate")
                .initialProperties(() -> Blocks.SLIME_BLOCK)
                .properties(p -> p.destroyTime(1f))
                .simpleItem()
                .register();
    }
    private static final CreateRegistrate REGISTRATE = EngineersConstruct.registrate().creativeModeTab(() -> Tab.ENGINEERS_CONSTRUCT);

    public static final BlockEntry<MechanicalFurnaceBlock> SEARED_MECHANICAL_FURNACE = REGISTRATE.block("seared_mechanical_furnace", MechanicalFurnaceBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.destroyTime(1f).requiresCorrectToolForDrops().noOcclusion())
            .lang("Seared Mechanical Furnace")
            .transform(BlockStressDefaults.setImpact(64))
            .blockstate(BlockStateGen.horizontalBlockProvider(false))
            .simpleItem()
            .register();
    public static final BlockEntry<MechanicalFurnaceBlock> SCORCHED_MECHANICAL_FURNACE = REGISTRATE.block("scorched_mechanical_furnace", MechanicalFurnaceBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.destroyTime(3f).requiresCorrectToolForDrops().noOcclusion())
            .lang("Scorched Mechanical Furnace")
            .transform(BlockStressDefaults.setImpact(64))
            .blockstate(BlockStateGen.horizontalBlockProvider(false))
            .simpleItem()
            .register();
}
