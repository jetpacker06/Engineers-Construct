package com.jetpacker06.econstruct.register;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class ItemGroups {
    public static final CreativeModeTab ENGINEERS_CONSTRUCT = new CreativeModeTab("Engineer's Construct") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(AllItems.ANDESITE_ALLOY_NUGGET.get());
        }
    };
}
