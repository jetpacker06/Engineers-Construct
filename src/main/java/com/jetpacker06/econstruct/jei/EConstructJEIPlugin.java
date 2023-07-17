package com.jetpacker06.econstruct.jei;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.jetpacker06.econstruct.registrate.ECFluids;
import com.jetpacker06.econstruct.registrate.ECItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JeiPlugin
@SuppressWarnings("unused")
public class EConstructJEIPlugin implements IModPlugin {

    public static ResourceLocation UID = new ResourceLocation(EngineersConstruct.MOD_ID, "jei_plugin");

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration reg) {
        reg.getIngredientManager().removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, List.of(
                new ItemStack(ECItems.FUEL1_BUCKET.get()),
                new ItemStack(ECItems.FUEL2_BUCKET.get())
        ));

        reg.getIngredientManager().removeIngredientsAtRuntime(ForgeTypes.FLUID_STACK, List.of(
                new FluidStack(ECFluids.FUEL1.get().getSource(), 1),
                new FluidStack(ECFluids.FUEL2.get().getSource(), 1)
        ));
    }
}
