package com.jetpacker06.econstruct.content.block.cogwheel;

import com.jetpacker06.econstruct.registrate.AllECBlockEntities;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogwheelBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class EncasedMetalCogwheelBlock extends EncasedCogwheelBlock {
    public EncasedMetalCogwheelBlock(Properties properties, boolean large, Supplier<Block> casing) {
        super(properties, large, casing);
    }

    @Override
    public BlockEntityType<? extends SimpleKineticBlockEntity> getBlockEntityType() {
        return this.isLargeCog() ? AllECBlockEntities.ENCASED_LARGE_METAL_COGWHEEL.get() : AllECBlockEntities.ENCASED_METAL_COGWHEEL.get();
    }
}
