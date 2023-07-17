package com.jetpacker06.econstruct.content;

import com.jetpacker06.econstruct.registrate.ECItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Tab {
    public static final CreativeModeTab ENGINEERS_CONSTRUCT = new CreativeModeTab("econstruct") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ECItems.ANDESITE_ALLOY_NUGGET.get());
        }
    };
}
