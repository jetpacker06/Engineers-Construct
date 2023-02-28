package com.jetpacker06.econstruct.content.mechanicalfurnace;

import com.jetpacker06.econstruct.registrate.AllFluids;
import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.util.BlockEntityHelper;
import slimeknights.tconstruct.common.multiblock.IMasterLogic;
import slimeknights.tconstruct.common.multiblock.IServantLogic;

import javax.annotation.Nonnull;
import java.util.Objects;

public class MechanicalFurnaceTileEntity extends KineticTileEntity implements IServantLogic, IFluidHandler {
    public MechanicalFurnaceTileEntity(BlockEntityType<?> pType, BlockPos pWorldPosition, BlockState pBlockState) {
        super(pType, pWorldPosition, pBlockState);
        this.updateFluid();
        holder = LazyOptional.of(() -> this.tank);
    }
    private int ticks = 0;
    @Override
    public void tick() {
        updateFluid();
        super.tick();
        this.ticks++;

        if (this.ticks % 100 != 0) {
            return;
        }
        System.out.println(this.level instanceof ClientLevel ? "Client" : "Server");
        System.out.println("   Speed: " + this.getSpeed());
        System.out.println("   Fluid in tank: " + Objects.requireNonNull(tank.getFluid().getFluid().getRegistryName()).toString().split(":")[1]);
        System.out.println("   " + (this.masterPos == null ? "No master" : "Master: " + this.masterPos));
        if (this.level instanceof ClientLevel) System.out.println("-----------------------------------------------");
        try {
            System.out.println(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(this.getLevel()).getBlockEntity(this.masterPos)).getBlockPos()));
        } catch(Exception ignored) {
        } finally {
            this.ticks = 0;
        }
    }

    @Override
    public void onSpeedChanged(float previousSpeed) {
        super.onSpeedChanged(previousSpeed);
        this.updateFluid();
    }

    private final FluidTank tank = new FluidTank(1000);

    private void updateFluid() {
     //   System.out.println("Speed: " + this.getSpeed());
        int speed = Math.abs(Math.round(this.getSpeed()));
     //   System.out.println("Rounded speed: " + speed);
        FluidStack fluid = FluidStack.EMPTY;
        if (speed >= 64) {
            fluid = new FluidStack(AllFluids.FUEL1.get().getSource(), 1000);
        }
        if (speed >= 128) {
            fluid = new FluidStack(AllFluids.FUEL2.get().getSource(), 1000);
        }
        this.tank.setFluid(fluid);
    }

    //Slimeknights stuff
    @Nullable
    private BlockPos masterPos;
    @Nullable
    private Block masterBlock;
    private final LazyOptional<IFluidHandler> holder;
    @Nullable
    @Override
    public BlockPos getMasterPos() {
        return this.masterPos;
    }

    @Override
    public void notifyMasterOfChange(@NotNull BlockPos pos, @NotNull BlockState state) {
        System.out.println(11);
        if (this.validateMaster()) {
            assert this.masterPos != null;

            BlockEntityHelper.get(IMasterLogic.class, this.level, this.masterPos).ifPresent((te) -> {
                te.notifyChange(this, pos, state);
            });
        }
    }

    @Override
    public boolean isValidMaster(@NotNull IMasterLogic master) {
        System.out.println(11);
        return !this.validateMaster() || master.getMasterPos().equals(this.masterPos);
    }

    @Override
    public void setPotentialMaster(IMasterLogic master) {
        System.out.println(10);
        BlockPos newMaster = master.getMasterPos();
        if (newMaster.equals(this.masterPos)) {
            this.masterBlock = master.getMasterBlock().getBlock();
            this.setChangedFast();
        } else if (!this.validateMaster()) {
            this.setMaster(newMaster, master.getMasterBlock().getBlock());
        }

    }
    @Override
    public void removeMaster(@NotNull IMasterLogic master) {
        System.out.println(9);
        if (this.masterPos != null && this.masterPos.equals(master.getMasterPos())) {
            this.setMaster((BlockPos)null, (Block)null);
        }

    }
    public boolean validateMaster() {
        System.out.println(8);
        if (this.masterPos == null) {
            return false;
        } else {
            assert this.level != null;

            if (this.level.getBlockState(this.masterPos).getBlock() == this.masterBlock) {
                return true;
            } else {
                this.setMaster((BlockPos)null, (Block)null);
                return false;
            }
        }
    }
    public void setMaster(@javax.annotation.Nullable BlockPos master, @javax.annotation.Nullable Block block) {
        System.out.println(7);
        this.masterPos = master;
        this.masterBlock = block;
    }
    @SuppressWarnings("deprecation")
    public void setChangedFast() {
        if (level != null) {
            if (level.hasChunkAt(worldPosition)) {
                level.getChunkAt(worldPosition).setUnsaved(true);
            }
        }
    }

    @Override
    public int getTanks() {
        System.out.println(6);
        return 1;
    }

    @NotNull
    @Override
    public FluidStack getFluidInTank(int tank) {
        System.out.println("getting fluid in tank");
        System.out.println(this.tank.getFluidInTank(0));
        return this.tank.getFluidInTank(0);
    }



    @Override
    public int getTankCapacity(int tank) {
        System.out.println(5);
        return 1000;
    }

    @Override
    public boolean isFluidValid(int tank, @NotNull FluidStack stack) {
        System.out.println(4);
        return stack.getFluid().isSame(AllFluids.FUEL1.get())
                || stack.getFluid().isSame(AllFluids.FUEL2.get());
    }

    @Override
    public int fill(FluidStack resource, FluidAction action) {
        System.out.println(3);
        return 0;
    }

    @NotNull
    @Override
    public FluidStack drain(FluidStack resource, FluidAction action) {
        System.out.println(1);
        return this.getFluidInTank(0);
    }

    @NotNull
    @Override
    public FluidStack drain(int maxDrain, FluidAction action) {
        System.out.println(2);
        return this.tank.getFluidInTank(0);
    }

    @Override
    @Nonnull
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @javax.annotation.Nullable Direction facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return holder.cast();
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        holder.invalidate();
    }
}
