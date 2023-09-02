package com.jetpacker06.econstruct.datagen.material;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.content.modifier.ECModifiers;
import net.minecraft.data.DataGenerator;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.data.ModifierIds;

public class ECMaterialTraitsGen extends AbstractMaterialTraitDataProvider {
    public ECMaterialTraitsGen(DataGenerator gen, AbstractMaterialDataProvider materials) {
        super(gen, materials);
    }

    @Override
    protected void addMaterialTraits() {
        addDefaultTraits(ECMaterialGen.CHOCOLATE, TinkerModifiers.tasty);
        addDefaultTraits(ECMaterialGen.ANDESITE_ALLOY, ECModifiers.CREATIVE.getId(), ModifierIds.ductile);
    }

    @Override
    public @NotNull String getName() {
        return EngineersConstruct.NAME + " Material Traits";
    }
}
