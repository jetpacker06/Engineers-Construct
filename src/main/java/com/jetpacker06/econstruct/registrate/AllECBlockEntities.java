package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.block.cogwheel.EncasedMetalCogwheelBlockEntity;
import com.jetpacker06.econstruct.content.block.mechanicalfurnace.MechanicalFurnaceTileEntity;
import com.jetpacker06.econstruct.content.block.cogwheel.MetalCogwheelBlockEntity;
import com.simibubi.create.content.kinetics.base.ShaftInstance;
import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.content.kinetics.base.SingleRotatingInstance;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogInstance;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class AllECBlockEntities {
    private static final CreateRegistrate REGISTRATE = EngineersConstruct.registrate();

    public static BlockEntityEntry<MechanicalFurnaceTileEntity> MECHANICAL_FURNACE;
    public static BlockEntityEntry<MetalCogwheelBlockEntity> METAL_COGWHEEL;
    public static BlockEntityEntry<EncasedMetalCogwheelBlockEntity.Small> ENCASED_METAL_COGWHEEL;
    public static BlockEntityEntry<EncasedMetalCogwheelBlockEntity.Large> ENCASED_LARGE_METAL_COGWHEEL;

    public static void registerBlockEntities() {
        MECHANICAL_FURNACE = REGISTRATE.blockEntity("mechanical_furnace", MechanicalFurnaceTileEntity::new)
                .instance(() -> ShaftInstance::new)
                .validBlocks(AllECBlocks.SEARED_MECHANICAL_FURNACE, AllECBlocks.SCORCHED_MECHANICAL_FURNACE)
                .register();

        METAL_COGWHEEL = REGISTRATE.blockEntity("metal_cogwheel", MetalCogwheelBlockEntity::new)
                .instance(() -> SingleRotatingInstance::new)
                .validBlocks(
                        () -> AllECBlocks.IRON_COGWHEEL.get(),
                        () -> AllECBlocks.LARGE_IRON_COGWHEEL.get(),
                        () -> AllECBlocks.BRASS_COGWHEEL.get(),
                        () -> AllECBlocks.LARGE_BRASS_COGWHEEL.get(),
                        () -> AllECBlocks.SEARED_COGWHEEL.get(),
                        () -> AllECBlocks.LARGE_SEARED_COGWHEEL.get(),
                        () -> AllECBlocks.SCORCHED_COGWHEEL.get(),
                        () -> AllECBlocks.LARGE_SCORCHED_COGWHEEL.get()
                )
                .register();
     //   ENCASED_METAL_COGWHEEL = REGISTRATE.blockEntity("encased_metal_cogwheel", EncasedMetalCogwheelBlockEntity.Small::new)
     //           .instance(() -> EncasedCogInstance::small, false)
     //           .renderer(() -> ShaftRenderer::new)
     //           .validBlocks(
     //                   () -> AllECBlocks.ANDESITE_ENCASED_IRON_COGWHEEL.get(),
     //                   () -> AllECBlocks.BRASS_ENCASED_IRON_COGWHEEL.get(),
     //                   () -> AllECBlocks.ANDESITE_ENCASED_BRASS_COGWHEEL.get(),
     //                   () -> AllECBlocks.BRASS_ENCASED_BRASS_COGWHEEL.get()
     //           )
     //           .register();
     //   ENCASED_LARGE_METAL_COGWHEEL = REGISTRATE.blockEntity("encased_large_metal_cogwheel", EncasedMetalCogwheelBlockEntity.Large::new)
     //           .instance(() -> EncasedCogInstance::large, false)
     //           .renderer(() -> ShaftRenderer::new)
     //           .validBlocks(
     //                   () -> AllECBlocks.ANDESITE_ENCASED_LARGE_IRON_COGWHEEL.get(),
     //                   () -> AllECBlocks.BRASS_ENCASED_LARGE_IRON_COGWHEEL.get(),
     //                   () -> AllECBlocks.ANDESITE_ENCASED_LARGE_BRASS_COGWHEEL.get(),
     //                   () -> AllECBlocks.BRASS_ENCASED_LARGE_BRASS_COGWHEEL.get()
     //           )
     //           .register();
    }
}
