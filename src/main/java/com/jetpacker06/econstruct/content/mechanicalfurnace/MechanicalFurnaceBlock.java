package com.jetpacker06.econstruct.content.mechanicalfurnace;

import com.jetpacker06.econstruct.registrate.AllTileEntities;
import com.simibubi.create.content.contraptions.base.HorizontalKineticBlock;
import com.simibubi.create.foundation.block.ITE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;

public class MechanicalFurnaceBlock extends HorizontalKineticBlock implements ITE<MechanicalFurnaceTileEntity> {
    public MechanicalFurnaceBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull PushReaction getPistonPushReaction(@NotNull BlockState pState) {
        return PushReaction.NORMAL;
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return state.getValue(HORIZONTAL_FACING).getAxis();
    }

    @Override
    public Class<MechanicalFurnaceTileEntity> getTileEntityClass() {
        return MechanicalFurnaceTileEntity.class;
    }

    @Override
    public BlockEntityType<? extends MechanicalFurnaceTileEntity> getTileEntityType() {
       return AllTileEntities.MECHANICAL_FURNACE.get();
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        if (state.getValue(HORIZONTAL_FACING) == Direction.EAST || state.getValue(HORIZONTAL_FACING) == Direction.WEST) {
            return face == Direction.EAST || face == Direction.WEST;
        }

        return face == Direction.NORTH || face == Direction.SOUTH;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction preferred = getPreferredHorizontalFacing(context);
        if (preferred != null) {
            return defaultBlockState().setValue(HORIZONTAL_FACING, preferred.getOpposite().getClockWise());
        }
        return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection());
    }
}
