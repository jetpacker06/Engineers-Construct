package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.block.mechanicalfurnace.MechanicalFurnaceTileEntity;
import com.simibubi.create.content.kinetics.base.ShaftInstance;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class AllECBlockEntities {
    private static final CreateRegistrate REGISTRATE = EngineersConstruct.registrate();

    public static final BlockEntityEntry<MechanicalFurnaceTileEntity> MECHANICAL_FURNACE = REGISTRATE
            .blockEntity("mechanical_furnace_tile_entity", MechanicalFurnaceTileEntity::new)
            .instance(() -> ShaftInstance::new)
            .validBlocks(AllECBlocks.SEARED_MECHANICAL_FURNACE, AllECBlocks.SCORCHED_MECHANICAL_FURNACE)
            .register();

    /**
     * Necessary because of lazy classloading.
     */
    public static void register() {}
}
