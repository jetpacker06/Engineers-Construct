package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.register.ItemGroup;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class AllItems {
    public static ItemEntry<Item> ANDESITE_ALLOY_NUGGET;

    public static void registerItems(Registrate REGISTRATE) {
        REGISTRATE.creativeModeTab(() -> ItemGroup.ENGINEERS_CONSTRUCT);

        ANDESITE_ALLOY_NUGGET = REGISTRATE.item("andesite_alloy_nugget", Item::new)
                .lang("Andesite Alloy Nugget")
                .register();
    }
}
