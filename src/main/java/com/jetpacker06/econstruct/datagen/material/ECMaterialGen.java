package com.jetpacker06.econstruct.datagen.material;

import com.jetpacker06.econstruct.EngineersConstruct;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class ECMaterialGen extends AbstractMaterialDataProvider {

    public ECMaterialGen(DataGenerator gen) {
        super(gen);
    }

    public static final MaterialId CHOCOLATE = createMaterial("chocolate");
    public static final MaterialId ANDESITE_ALLOY = createMaterial("andesite_alloy");

    @Override
    public @NotNull String getName() {
        return EngineersConstruct.NAME + " Materials";
    }

    private static MaterialId createMaterial(String name) {
        return new MaterialId(new ResourceLocation(EngineersConstruct.MODID, name));
    }

    @Override
    protected void addMaterials() {
        addMaterial(CHOCOLATE, 1, ORDER_COMPAT, true);
        addMaterial(ANDESITE_ALLOY, 3, ORDER_COMPAT, false);
    }
}
