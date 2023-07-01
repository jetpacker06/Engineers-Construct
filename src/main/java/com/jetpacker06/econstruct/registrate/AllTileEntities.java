package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.block.mechanicalfurnace.MechanicalFurnaceTileEntity;
import com.simibubi.create.content.kinetics.base.ShaftInstance;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class AllTileEntities {
    private static final CreateRegistrate REGISTRATE = EngineersConstruct.registrate();

    public static final BlockEntityEntry<MechanicalFurnaceTileEntity> MECHANICAL_FURNACE = REGISTRATE
            .blockEntity("mechanical_furnace_tile_entity", MechanicalFurnaceTileEntity::new)
            .instance(() -> ShaftInstance::new)
            .validBlocks(AllBlocks.SEARED_MECHANICAL_FURNACE, AllBlocks.SCORCHED_MECHANICAL_FURNACE)
            .register();

    /**
     * Necessary because of lazy classloading.
     */
    public static void register() {}
}
