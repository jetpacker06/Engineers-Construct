package com.jetpacker06.econstruct.datagen.material;

import com.jetpacker06.econstruct.EngineersConstruct;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Tiers;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

import javax.annotation.CheckReturnValue;

public class ECMaterialStatsGen extends AbstractMaterialStatsDataProvider {
    public ECMaterialStatsGen(DataGenerator gen, AbstractMaterialDataProvider materials) {
        super(gen, materials);
    }

    @Override
    protected void addMaterialStats() {
        addMaterialStats(ECMaterialGen.ANDESITE_ALLOY, new HeadMaterialStats(975, 8.0f, Tiers.WOOD, 2.5f),
                new HandleMaterialStats(1.1f, 1.2f, 1.0f, 0.9f));
        addMaterialStats(ECMaterialGen.CHOCOLATE, new HeadMaterialStats(975, 8.0f, Tiers.WOOD, 2.5f),
                new HandleMaterialStats(1.1f, 1.2f, 1.0f, 0.9f));
    }

    @Override
    public @NotNull String getName() {
        return EngineersConstruct.NAME + " Material Stats";
    }
}
