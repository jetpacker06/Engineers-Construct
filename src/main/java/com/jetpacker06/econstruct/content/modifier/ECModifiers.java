package com.jetpacker06.econstruct.content.modifier;

import com.jetpacker06.econstruct.EngineersConstruct;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class ECModifiers {
    private static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(EngineersConstruct.MODID);

    public static StaticModifier<CreativeModifier> CREATIVE = MODIFIERS.register(
            "creative",
            CreativeModifier::new
    );
    public static StaticModifier<EngineersVisionModifier> ENGINEERS_VISION= MODIFIERS.register(
            "engineers_vision",
            EngineersVisionModifier::new
    );

    public static void register(IEventBus eventBus) {
        MODIFIERS.register(eventBus);
    }
}
