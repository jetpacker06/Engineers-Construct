package com.jetpacker06.econstruct.content;

import com.jetpacker06.econstruct.registrate.AllItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Tab {
    public static final CreativeModeTab ENGINEERS_CONSTRUCT = new CreativeModeTab("Engineer's Construct") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(AllItems.ANDESITE_ALLOY_NUGGET.get());
        }
    };
}
