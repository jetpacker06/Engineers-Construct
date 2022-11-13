package com.jetpacker06.econstruct.content.mechanicalfurnace;

import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class MechanicalFurnaceTileEntity extends KineticTileEntity {
    private int ticks = 0;
    public MechanicalFurnaceTileEntity(BlockEntityType<?> pType, BlockPos pWorldPosition, BlockState pBlockState) {
        super(pType, pWorldPosition, pBlockState);
    }

    @Override
    public void tick() {
        super.tick();
        if (new Random().nextBoolean() & new Random().nextBoolean() & new Random().nextBoolean()) {
            System.out.println("Its alive! " + this.ticks);
        }
        this.ticks++;
    }
}
