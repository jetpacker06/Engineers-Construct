package com.jetpacker06.econstruct.registrate;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;

public class ECItems {

    public static ItemEntry<Item> ANDESITE_ALLOY_NUGGET;
    public static ItemEntry<Item> CRUSHED_RAW_COBALT;

    // Buckets are registered in AllFluids
    public static ItemEntry<BucketItem> FUEL1_BUCKET;
    public static ItemEntry<BucketItem> FUEL2_BUCKET;
    public static ItemEntry<BucketItem> MOLTEN_ANDESITE_BUCKET;
    public static ItemEntry<BucketItem> MOLTEN_ANDESITE_ALLOY_BUCKET;
    public static ItemEntry<BucketItem> MOLTEN_REDSTONE_BUCKET;
    public static ItemEntry<BucketItem> MOLTEN_ROSE_QUARTZ_BUCKET;

    private static ItemEntry<Item> basic(String langName) {
        return basic(langName, langName.replace(" ", "_").replace(".", "").toLowerCase());
    }

    private static ItemEntry<Item> basic(String langName, String registryName) {
        return EngineersConstruct.REGISTRATE.item(registryName, Item::new)
                .lang(langName)
                .register();
    }

    public static void registerItems() {

        ANDESITE_ALLOY_NUGGET = basic("Andesite Alloy Nugget");
        CRUSHED_RAW_COBALT = basic("Crushed Raw Cobalt");
    }
}
