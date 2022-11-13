package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.mechanicalfurnace.MechanicalFurnaceRenderer;
import com.jetpacker06.econstruct.content.mechanicalfurnace.MechanicalFurnaceTileEntity;
import com.simibubi.create.content.contraptions.base.HorizontalHalfShaftInstance;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class AllTileEntities {
    private static final CreateRegistrate REGISTRATE = EngineersConstruct.registrate();

    public static final BlockEntityEntry<MechanicalFurnaceTileEntity> MECHANICAL_FURNACE = REGISTRATE
            .tileEntity("mechanical_furnace_tile_entity", MechanicalFurnaceTileEntity::new)
          //  .renderer(() -> MechanicalFurnaceRenderer::new)
            .instance(() -> HorizontalHalfShaftInstance::new)
            .validBlocks(AllBlocks.MECHANICAL_FURNACE)
            .register();

    public static void register() {}
}
