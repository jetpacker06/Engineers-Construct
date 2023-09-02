package com.jetpacker06.econstruct.datagen.material;

import com.jetpacker06.econstruct.EngineersConstruct;
import net.minecraft.data.DataGenerator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

public class ECMaterialRenderInfo extends AbstractMaterialRenderInfoProvider {
    public ECMaterialRenderInfo(DataGenerator gen, @Nullable AbstractMaterialSpriteProvider materialSprites) {
        super(gen, materialSprites);
    }

    @Override
    protected void addMaterialRenderInfo() {
        buildRenderInfo(ECMaterialGen.CHOCOLATE)
          //      .generator()
                .color(0x4a2e0c).fallbacks("bone", "rock");
        buildRenderInfo(ECMaterialGen.ANDESITE_ALLOY)
                .color(0x6D7D73).fallbacks("bone", "rock");
    }

    @Override
    public @NotNull String getName() {
        return EngineersConstruct.MODID + " Material Render Info";
    }
}
