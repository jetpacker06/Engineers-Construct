package com.jetpacker06.econstruct.texture;

import com.jetpacker06.econstruct.EngineersConstruct;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import net.minecraft.resources.ResourceLocation;

public class ECSpriteShifts {
    public static CTSpriteShiftEntry SEARED_CASING = omni("seared_casing");
    public static CTSpriteShiftEntry SCORCHED_CASING = omni("scorched_casing");

    public static CTSpriteShiftEntry omni(String blockTextureName) {
        return CTSpriteShifter.getCT(AllCTTypes.OMNIDIRECTIONAL, new ResourceLocation(EngineersConstruct.MODID, "block/" + blockTextureName),
                new ResourceLocation(EngineersConstruct.MODID, "block/" + blockTextureName + "_connected"));
    }
}
