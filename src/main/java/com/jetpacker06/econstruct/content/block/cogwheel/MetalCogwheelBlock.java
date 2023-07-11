package com.jetpacker06.econstruct.content.block.cogwheel;

import com.jetpacker06.econstruct.registrate.AllECBlockEntities;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.CogWheelBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class MetalCogwheelBlock extends CogWheelBlock {

    private MetalCogwheelBlock(boolean large, Properties properties) {
        super(large, properties);
    }
    public static MetalCogwheelBlock small(Properties properties) {
        return new MetalCogwheelBlock(false, properties);
    }
    public static MetalCogwheelBlock large(Properties properties) {
        return new MetalCogwheelBlock(true, properties);
    }

    @Override
    public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
        return AllECBlockEntities.METAL_COGWHEEL.get();
    }
}