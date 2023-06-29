package com.jetpacker06.econstruct.content.mechanicalfurnace;

import com.jetpacker06.econstruct.registrate.AllTileEntities;
import com.simibubi.create.content.kinetics.base.HorizontalKineticBlock;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.util.BlockEntityHelper;


public class MechanicalFurnaceBlock extends HorizontalKineticBlock implements IBE<MechanicalFurnaceTileEntity> {
    public static final BooleanProperty IN_STRUCTURE = BooleanProperty.create("in_structure");

    public MechanicalFurnaceBlock(Properties properties) {
        super(properties);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return state.getValue(HORIZONTAL_FACING).getAxis();
    }

    @Override
    public Class<MechanicalFurnaceTileEntity> getBlockEntityClass() {
        return MechanicalFurnaceTileEntity.class;
    }

    @Override
    public BlockEntityType<? extends MechanicalFurnaceTileEntity> getBlockEntityType() {
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
            return defaultBlockState().setValue(HORIZONTAL_FACING, preferred.getOpposite());
        }
        return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection());
    }

    // from SlimeKnights
    @Override
    @SuppressWarnings("deprecation")
    public void onRemove(@NotNull BlockState state, @NotNull Level worldIn, @NotNull BlockPos pos, BlockState newState, boolean isMoving) {
        if (!newState.is(this)) {
            BlockEntityHelper.get(MechanicalFurnaceTileEntity.class, worldIn, pos).ifPresent(te -> te.notifyMasterOfChange(pos, newState));
        }
        super.onRemove(state, worldIn, pos, newState, isMoving);
    }
}
