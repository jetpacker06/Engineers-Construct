package com.jetpacker06.econstruct.datagen;

import com.jetpacker06.econstruct.EngineersConstruct;

public class ECLang {
    private static final String id = EngineersConstruct.MODID;
    private static final String name = EngineersConstruct.NAME;

    public static void add(String key, String value) {
        EngineersConstruct.REGISTRATE.addRawLang(key, value);
    }

    public static void register() {
        add("itemGroup." + id,  name);
        add("info." + id + ".mechanical_furnace", "64 rpm: 1000 degrees\n128 rpm: 1500 degrees");

        addMaterial("Creative", "Harness your inner wrench",
                "Allows your tool to act like a Wrench.");
        addMaterial("Engineer's Vision", "8)",
                "Allows your helmet to act like Goggles.");
    }

    public static void addMaterial(String name, String flavor, String description) {
        String key = name.toLowerCase().replace(" ", "_").replace("'", "");
        add("modifier." + id + "." + key, name);
        add("modifier." + id + "." + key + ".flavor", flavor);
        add("modifier." + id + "." + key + ".description", description);
    }
}