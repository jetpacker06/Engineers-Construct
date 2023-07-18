package com.jetpacker06.econstruct.datagen;

import com.jetpacker06.econstruct.EngineersConstruct;
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
        return EngineersConstruct.NAME + " Materials";
    }

    @Override
    protected void addMaterialTraits() {
    }
}
