package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.block.mechanicalfurnace.MechanicalFurnaceTileEntity;
import com.jetpacker06.econstruct.content.block.cogwheel.CogwheelBlockEntity;
import com.simibubi.create.content.kinetics.base.ShaftInstance;
import com.simibubi.create.content.kinetics.base.SingleRotatingInstance;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class AllECBlockEntities {
    private static final CreateRegistrate REGISTRATE = EngineersConstruct.registrate();

    public static BlockEntityEntry<MechanicalFurnaceTileEntity> MECHANICAL_FURNACE;
    public static BlockEntityEntry<CogwheelBlockEntity> COGWHEEL;

    /**
     * Necessary because of lazy classloading.
     */
    public static void registerBlockEntities() {
        MECHANICAL_FURNACE = REGISTRATE.blockEntity("mechanical_furnace", MechanicalFurnaceTileEntity::new)
                .instance(() -> ShaftInstance::new)
                .validBlocks(AllECBlocks.SEARED_MECHANICAL_FURNACE, AllECBlocks.SCORCHED_MECHANICAL_FURNACE)
                .register();

        COGWHEEL = REGISTRATE.blockEntity("cogwheel", CogwheelBlockEntity::new)
                .instance(() -> SingleRotatingInstance::new)
                .validBlocks(
                        () -> AllECBlocks.IRON_COGWHEEL.get(),
                        () -> AllECBlocks.BRASS_COGWHEEL.get(),
                        () -> AllECBlocks.LARGE_IRON_COGWHEEL.get(),
                        () -> AllECBlocks.LARGE_BRASS_COGWHEEL.get()
                )
                .register();
    }
}
