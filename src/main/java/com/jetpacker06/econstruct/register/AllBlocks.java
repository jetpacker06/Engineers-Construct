package com.jetpacker06.econstruct.register;

import com.jetpacker06.econstruct.EngineersConstruct;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class AllBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EngineersConstruct.MOD_ID);
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        AllItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    public static final RegistryObject<Block> ANDESITE_ALLOY_BLOCK = registerBlock("andesite_alloy_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), ItemGroups.ENGINEERS_CONSTRUCT);
    public static final RegistryObject<Block> CHOCOLATE_BLOCK = registerBlock("chocolate_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.SLIME_BLOCK)), ItemGroups.ENGINEERS_CONSTRUCT);
}
