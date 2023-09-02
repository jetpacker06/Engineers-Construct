package com.jetpacker06.econstruct.datagen.material;

import com.jetpacker06.econstruct.EngineersConstruct;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

public class ECMaterialTextures extends AbstractMaterialSpriteProvider {
    @Override
    public @NotNull String getName() {
        return EngineersConstruct.NAME + " Material Textures";
    }

    @Override
    protected void addAllMaterials() {
         //buildMaterial(ECMaterialGen.CHOCOLATE);
         //buildMaterial(ECMaterialGen.ANDESITE_ALLOY);
    }
}
