package com.jetpacker06.econstruct.datagen.recipeproviders;

import com.jetpacker06.econstruct.registrate.AllECBlocks;
import com.jetpacker06.econstruct.registrate.AllECItems;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.shared.TinkerMaterials;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import java.util.function.Consumer;

public class EConstructVanillaRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public EConstructVanillaRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> c) {
        // CRAFTING
        ShapedRecipeBuilder.shaped(AllItems.ANDESITE_ALLOY.get(), 1)
                .define('N', AllECItems.ANDESITE_ALLOY_NUGGET.get())
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .unlockedBy("has_andesite_alloy", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(AllItems.ANDESITE_ALLOY.get()).build()))
                .save(c);
        ShapelessRecipeBuilder.shapeless(AllECItems.ANDESITE_ALLOY_NUGGET.get(), 9)
                .requires(AllItems.ANDESITE_ALLOY.get())
                .unlockedBy("has_andesite_alloy", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(AllItems.ANDESITE_ALLOY.get()).build()))
                .save(c);
        ShapelessRecipeBuilder.shapeless(AllItems.BAR_OF_CHOCOLATE.get(), 4)
                .requires(AllECBlocks.CHOCOLATE_BLOCK.get())
                .unlockedBy("has_bar_of_chocolate", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(AllItems.BAR_OF_CHOCOLATE.get()).build()))
                .save(c);
        ShapedRecipeBuilder.shaped(AllECBlocks.CHOCOLATE_BLOCK.get(), 1)
                .define('C', AllItems.BAR_OF_CHOCOLATE.get())
                .pattern("CC")
                .pattern("CC")
                .unlockedBy("has_bar_of_chocolate", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(AllItems.BAR_OF_CHOCOLATE.get()).build()))
                .save(c);
        ShapedRecipeBuilder.shaped(AllECBlocks.SEARED_MECHANICAL_FURNACE.get(), 1)
                .define('#', TinkerSmeltery.searedBricks)
                .define('S', AllBlocks.SHAFT.get())
                .define('B', AllBlocks.BLAZE_BURNER.get())
                .pattern("###")
                .pattern("SBS")
                .pattern("###")
                .unlockedBy("has_shaft", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(AllBlocks.SHAFT.get()).build()))
                .save(c);
        ShapedRecipeBuilder.shaped(AllECBlocks.SCORCHED_MECHANICAL_FURNACE.get(), 1)
                .define('#', TinkerSmeltery.scorchedBricks)
                .define('S', AllBlocks.SHAFT.get())
                .define('B', AllBlocks.BLAZE_BURNER.get())
                .pattern("###")
                .pattern("SBS")
                .pattern("###")
                .unlockedBy("has_shaft", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(AllBlocks.SHAFT.get()).build()))
                .save(c);

        // SMELTING
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(AllECItems.CRUSHED_RAW_COBALT.get()), TinkerMaterials.cobalt, 1.0f, 200);
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(AllECItems.CRUSHED_RAW_COBALT.get()), TinkerMaterials.cobalt, 1.0f, 100);
    }
}
