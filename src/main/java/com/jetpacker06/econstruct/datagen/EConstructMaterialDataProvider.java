package com.jetpacker06.econstruct.datagen;

import net.minecraft.data.DataGenerator;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;

public class EConstructMaterialDataProvider extends AbstractMaterialTraitDataProvider {
    public EConstructMaterialDataProvider(DataGenerator gen, AbstractMaterialDataProvider materials) {
        super(gen, materials);
    }

    @Override
    public @NotNull String getName() {
        return "Engineer's Construct Material Traits Provider";
    }

    @Override
    protected void addMaterialTraits() {
    }
}
