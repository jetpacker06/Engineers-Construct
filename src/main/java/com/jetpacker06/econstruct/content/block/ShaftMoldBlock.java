package com.jetpacker06.econstruct.content.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.stream.Stream;

public class ShaftMoldBlock extends Block {
    public ShaftMoldBlock(Properties p_49795_) {
        super(p_49795_);
    }

    private static final VoxelShape shape = Stream.of(
            Block.box(6, 0, 6, 10, 1, 10),
            Block.box(0, 0, 6, 6, 16, 16),
            Block.box(10, 0, 0, 16, 16, 10),
            Block.box(6, 0, 10, 16, 16, 16),
            Block.box(0, 0, 0, 10, 16, 6)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @ParametersAreNonnullByDefault
    @Override
    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return shape;
    }
}
