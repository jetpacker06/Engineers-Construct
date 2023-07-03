package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.content.Tab;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;

public class AllItems {
    public static ItemEntry<Item> ANDESITE_ALLOY_NUGGET;

    // Buckets are registered in AllFluids
    public static ItemEntry<BucketItem> FUEL1_BUCKET;
    public static ItemEntry<BucketItem> FUEL2_BUCKET;
    public static ItemEntry<BucketItem> MOLTEN_ANDESITE_BUCKET;
    public static ItemEntry<BucketItem> MOLTEN_ANDESITE_ALLOY_BUCKET;
    public static ItemEntry<BucketItem> MOLTEN_REDSTONE_BUCKET;
    public static ItemEntry<BucketItem> MOLTEN_ROSE_QUARTZ_BUCKET;

    public static void registerItems(Registrate REGISTRATE) {
        REGISTRATE.creativeModeTab(() -> Tab.ENGINEERS_CONSTRUCT);

        ANDESITE_ALLOY_NUGGET = REGISTRATE.item("andesite_alloy_nugget", Item::new)
                .lang("Andesite Alloy Nugget")
                .register();
    }
}
