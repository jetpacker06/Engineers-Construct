package com.jetpacker06.econstruct.datagen;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.FluidEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import org.jetbrains.annotations.NotNull;

import static com.jetpacker06.econstruct.registrate.AllECBlocks.*;
import static com.jetpacker06.econstruct.registrate.AllECFluids.*;
import static com.jetpacker06.econstruct.registrate.AllECItems.*;

public class EConstructLang extends LanguageProvider {
    public EConstructLang(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.econstruct", "Engineer's Construct");

        this.add(CHOCOLATE_BLOCK, "Chocolate Block");
        this.add(SEARED_MECHANICAL_FURNACE, "Seared Mechanical Furnace");
        this.add(SCORCHED_MECHANICAL_FURNACE, "Scorched Mechanical Furnace");

        this.add(ANDESITE_ALLOY_NUGGET, "Andesite Alloy Nugget");
        this.add(CRUSHED_RAW_COBALT, "Crushed Raw Cobalt");

        this.add(MOLTEN_ANDESITE_BUCKET, "Molten Andesite Bucket");
        this.add(MOLTEN_ANDESITE_ALLOY_BUCKET, "Molten Andesite Alloy Bucket");
        this.add(MOLTEN_REDSTONE_BUCKET, "Molten Redstone Bucket");
        this.add(MOLTEN_ROSE_QUARTZ_BUCKET, "Molten Rose Quartz Bucket");
        this.add(FUEL1_BUCKET, "Fuel 1 Bucket");
        this.add(FUEL2_BUCKET, "Fuel 2 Bucket");

        this.add(MOLTEN_ANDESITE, "Molten Andesite");
        this.add(MOLTEN_ANDESITE_ALLOY, "Molten Andesite Alloy");
        this.add(MOLTEN_REDSTONE, "Molten Redstone");
        this.add(MOLTEN_ROSE_QUARTZ, "Molten Rose Quartz");
        this.add(FUEL1, "Powered by Mechanical Furnace");
        this.add(FUEL2, "Powered by Mechanical Furnace");

        this.addMaterial("modifier.econstruct.creative", "Creative", "Harness your inner wrench",
                "Allows your tool to act like a Wrench.");
        this.addMaterial("modifier.econstruct.engineers_vision", "Engineer's Vision", "8)",
                "Allows your helmet to act like Goggles.");
    }

    public <T extends Block> void add(@NotNull BlockEntry<T> entry, @NotNull String name) {
        this.add(entry.get(), name);
    }

    public <T extends Item> void add(@NotNull ItemEntry<T> entry, @NotNull String name) {
        this.add(entry.get(), name);
    }

    public <T extends ForgeFlowingFluid.Flowing> void add(@NotNull FluidEntry<T> entry, @NotNull String name) {
        this.add("block." + entry.getId().toString().replace(":flowing_", "."), name);
    }

    public <T extends CreativeModeTab> void add(@NotNull T tab, String name) {
        this.add(((TranslatableComponent) tab.getDisplayName()).getKey(), name);
    }

    public void add(@NotNull ForgeFlowingFluid.Flowing fluid, @NotNull String name) {
        assert fluid.getRegistryName() != null;
        String fluidName = fluid.getRegistryName().toString();
        this.add("fluid." + fluidName.replace(":", ".").replace("flowing_", ""), name);
    }

    public void addMaterial(String key, String name, String flavor, String description) {
        this.add(key, name);
        this.add(key + ".flavor", flavor);
        this.add(key + ".description", description);
    }
}