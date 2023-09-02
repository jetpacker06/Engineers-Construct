package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.Tab;
import com.jetpacker06.econstruct.content.block.cogwheel.MetalCogwheelBlock;
import com.jetpacker06.econstruct.content.block.mechanicalfurnace.MechanicalFurnaceBlock;
import com.jetpacker06.econstruct.content.block.mold.ShaftMoldBlock;
import com.jetpacker06.econstruct.texture.ECSpriteShifts;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockModel;
import com.simibubi.create.content.kinetics.simpleRelays.CogwheelBlockItem;
import com.simibubi.create.foundation.data.*;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

public class ECBlocks {
    public static BlockEntry<Block> CHOCOLATE_BLOCK;
    public static BlockEntry<ShaftMoldBlock> SHAFT_MOLD;
    public static BlockEntry<CasingBlock> SEARED_CASING;
    public static BlockEntry<CasingBlock> SCORCHED_CASING;

    public static BlockEntry<MetalCogwheelBlock> IRON_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> LARGE_IRON_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> BRASS_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> LARGE_BRASS_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> SEARED_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> LARGE_SEARED_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> SCORCHED_COGWHEEL;
    public static BlockEntry<MetalCogwheelBlock> LARGE_SCORCHED_COGWHEEL;

    public static BlockEntry<MechanicalFurnaceBlock> SEARED_MECHANICAL_FURNACE;
    public static BlockEntry<MechanicalFurnaceBlock> SCORCHED_MECHANICAL_FURNACE;

    public static void registerBlocks(CreateRegistrate REGISTRATE) {
        CHOCOLATE_BLOCK = REGISTRATE.block("chocolate_block", Block::new)
                .lang("Chocolate Block")
                .initialProperties(() -> Blocks.SLIME_BLOCK)
                .transform(block -> block.tag(BlockTags.MINEABLE_WITH_PICKAXE).tag(BlockTags.MINEABLE_WITH_SHOVEL))
                .simpleItem()
                .register();
        SHAFT_MOLD = REGISTRATE.block("shaft_mold", ShaftMoldBlock::new)
                .lang("Shaft Mold")
                .initialProperties(() -> Blocks.GOLD_BLOCK)
                .properties(p -> p.requiresCorrectToolForDrops().noOcclusion())
                .blockstate((context, provider) -> provider.simpleBlock(context.getEntry(), AssetLookup.standardModel(context, provider)))
                .transform(TagGen.pickaxeOnly())
                .simpleItem()
                .register();
        SEARED_CASING = REGISTRATE.block("seared_casing", CasingBlock::new)
                .lang("Seared Casing")
                .properties(p -> p.sound(SoundType.STONE))
                .transform(BuilderTransformers.casing(() -> ECSpriteShifts.SEARED_CASING))
                .register();
        SCORCHED_CASING = REGISTRATE.block("scorched_casing", CasingBlock::new)
                .lang("Scorched Casing")
                .properties(p -> p.sound(SoundType.STONE))
                .transform(BuilderTransformers.casing(() -> ECSpriteShifts.SCORCHED_CASING))
                .register();

        SEARED_MECHANICAL_FURNACE = REGISTRATE.block("seared_mechanical_furnace", MechanicalFurnaceBlock::new)
                .lang("Seared Mechanical Furnace")
                .initialProperties(SharedProperties::stone)
                .properties(p -> p.requiresCorrectToolForDrops().noOcclusion())
                .transform(BlockStressDefaults.setImpact(64))
                .blockstate(BlockStateGen.horizontalBlockProvider(false))
                .transform(TagGen.pickaxeOnly())
                .simpleItem()
                .register();
        SCORCHED_MECHANICAL_FURNACE = REGISTRATE.block("scorched_mechanical_furnace", MechanicalFurnaceBlock::new)
                .lang("Scorched Mechanical Furnace")
                .initialProperties(SharedProperties::stone)
                .properties(p -> p.requiresCorrectToolForDrops().noOcclusion())
                .transform(BlockStressDefaults.setImpact(64))
                .blockstate(BlockStateGen.horizontalBlockProvider(false))
                .transform(TagGen.pickaxeOnly())
                .simpleItem()
                .register();

        IRON_COGWHEEL = REGISTRATE.block("iron_cogwheel", MetalCogwheelBlock::small)
                .lang("Iron Cogwheel")
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(TagGen.pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();
        LARGE_IRON_COGWHEEL = REGISTRATE.block("large_iron_cogwheel", MetalCogwheelBlock::large)
                .lang("Large Iron Cogwheel")
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(TagGen.pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();

        BRASS_COGWHEEL = REGISTRATE.block("brass_cogwheel", MetalCogwheelBlock::small)
                .lang("Brass Cogwheel")
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(TagGen.pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();
        LARGE_BRASS_COGWHEEL = REGISTRATE.block("large_brass_cogwheel", MetalCogwheelBlock::large)
                .lang("Large Brass Cogwheel")
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(TagGen.pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();

        SEARED_COGWHEEL = REGISTRATE.block("seared_cogwheel", MetalCogwheelBlock::small)
                .lang("Seared Cogwheel")
                .initialProperties(SharedProperties::stone)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(TagGen.pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();
        LARGE_SEARED_COGWHEEL = REGISTRATE.block("large_seared_cogwheel", MetalCogwheelBlock::large)
                .lang("Large Seared Cogwheel")
                .initialProperties(SharedProperties::stone)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(TagGen.pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();

        SCORCHED_COGWHEEL = REGISTRATE.block("scorched_cogwheel", MetalCogwheelBlock::small)
                .lang("Large Seared Cogwheel")
                .initialProperties(SharedProperties::stone)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(TagGen.pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();
        LARGE_SCORCHED_COGWHEEL = REGISTRATE.block("large_scorched_cogwheel", MetalCogwheelBlock::large)
                .lang("Large Scorched Cogwheel")
                .initialProperties(SharedProperties::stone)
                .transform(BlockStressDefaults.setNoImpact())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .transform(TagGen.pickaxeOnly())
                .item(CogwheelBlockItem::new).build()
                .register();
    }
}
