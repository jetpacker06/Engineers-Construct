package com.jetpacker06.econstruct.register;

import com.jetpacker06.econstruct.EngineersConstruct;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AllItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EngineersConstruct.MOD_ID);

    //public static final RegistryObject<Item> ITEM = ITEMS.register("item_name", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}