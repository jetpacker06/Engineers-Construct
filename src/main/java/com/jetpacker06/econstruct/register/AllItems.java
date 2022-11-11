package com.jetpacker06.econstruct.register;

import com.jetpacker06.econstruct.EngineersConstruct;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EngineersConstruct.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    public static RegistryObject<Item> registerBasic(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().tab(ItemGroups.ENGINEERS_CONSTRUCT)));
    }

    public static final RegistryObject<Item> ANDESITE_ALLOY_NUGGET = registerBasic("andesite_alloy_nugget");
}