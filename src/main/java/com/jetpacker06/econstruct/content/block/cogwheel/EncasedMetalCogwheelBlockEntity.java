package com.jetpacker06.econstruct.content.block.cogwheel;

import com.jetpacker06.econstruct.registrate.AllECBlockEntities;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public abstract class EncasedMetalCogwheelBlockEntity extends SimpleKineticBlockEntity {
    public EncasedMetalCogwheelBlockEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
        super(typeIn, pos, state);
    }
    public static class Small extends EncasedMetalCogwheelBlockEntity {
        public Small(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
            super(typeIn, pos, state);
        }

        @Override
        public @NotNull BlockEntityType<?> getType() {
            return AllECBlockEntities.ENCASED_METAL_COGWHEEL.get();
        }
    }
    public static class Large extends EncasedMetalCogwheelBlockEntity{
        public Large(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
            super(typeIn, pos, state);
        }

        @Override
        public @NotNull BlockEntityType<?> getType() {
            return AllECBlockEntities.ENCASED_LARGE_METAL_COGWHEEL.get();
        }
    }
}
