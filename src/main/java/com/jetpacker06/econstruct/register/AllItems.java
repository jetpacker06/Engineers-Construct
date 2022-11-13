package com.jetpacker06.econstruct.register;

import com.jetpacker06.econstruct.EngineersConstruct;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllItems {
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EngineersConstruct.MOD_ID);

    public static RegistryObject<Item> ingredient(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().tab(ItemGroups.ENGINEERS_CONSTRUCT)));
    }
    public static RegistryObject<Item> bucket(String name, RegistryObject<FlowingFluid> fluid) {
        return ITEMS.register(name, () -> new BucketItem(fluid, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET).tab(ItemGroups.ENGINEERS_CONSTRUCT)));
    }

    public static final RegistryObject<Item> ANDESITE_ALLOY_NUGGET = ingredient("andesite_alloy_nugget");

    public static final RegistryObject<Item> MOLTEN_ANDESITE_BUCKET = bucket("molten_andesite_bucket", AllFluids.MOLTEN_ANDESITE);
    public static final RegistryObject<Item> MOLTEN_ANDESITE_ALLOY_BUCKET = bucket("molten_andesite_alloy_bucket", AllFluids.MOLTEN_ANDESITE_ALLOY);
    public static final RegistryObject<Item> MOLTEN_REDSTONE_BUCKET = bucket("molten_redstone_bucket", AllFluids.MOLTEN_REDSTONE);
    public static final RegistryObject<Item> MOLTEN_ROSE_QUARTZ_BUCKET = bucket("molten_rose_quartz_bucket", AllFluids.MOLTEN_ROSE_QUARTZ);
}