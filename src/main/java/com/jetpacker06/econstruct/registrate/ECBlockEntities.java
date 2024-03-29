package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.content.block.cogwheel.MetalCogwheelBlockEntity;
import com.jetpacker06.econstruct.content.block.mechanicalfurnace.MechanicalFurnaceBlockEntity;
import com.simibubi.create.content.kinetics.base.ShaftInstance;
import com.simibubi.create.content.kinetics.base.SingleRotatingInstance;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class ECBlockEntities {
    public static BlockEntityEntry<MechanicalFurnaceBlockEntity> MECHANICAL_FURNACE;
    public static BlockEntityEntry<MetalCogwheelBlockEntity> METAL_COGWHEEL;

    public static void registerBlockEntities(CreateRegistrate REGISTRATE) {
        MECHANICAL_FURNACE = REGISTRATE.blockEntity("mechanical_furnace", MechanicalFurnaceBlockEntity::new)
                .instance(() -> ShaftInstance::new)
                .validBlocks(ECBlocks.SEARED_MECHANICAL_FURNACE, ECBlocks.SCORCHED_MECHANICAL_FURNACE)
                .register();

        METAL_COGWHEEL = REGISTRATE.blockEntity("metal_cogwheel", MetalCogwheelBlockEntity::new)
                .instance(() -> SingleRotatingInstance::new)
                .validBlocks(
                        () -> ECBlocks.IRON_COGWHEEL.get(),
                        () -> ECBlocks.LARGE_IRON_COGWHEEL.get(),
                        () -> ECBlocks.BRASS_COGWHEEL.get(),
                        () -> ECBlocks.LARGE_BRASS_COGWHEEL.get(),
                        () -> ECBlocks.SEARED_COGWHEEL.get(),
                        () -> ECBlocks.LARGE_SEARED_COGWHEEL.get(),
                        () -> ECBlocks.SCORCHED_COGWHEEL.get(),
                        () -> ECBlocks.LARGE_SCORCHED_COGWHEEL.get()
                )
                .register();
    }
}
