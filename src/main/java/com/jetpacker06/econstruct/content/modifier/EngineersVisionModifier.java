package com.jetpacker06.econstruct.content.modifier;

import com.simibubi.create.content.equipment.goggles.GogglesItem;
import net.minecraft.world.entity.EquipmentSlot;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;

public class EngineersVisionModifier extends NoLevelsModifier {
    public EngineersVisionModifier () {
        GogglesItem.addIsWearingPredicate((p) -> ModifierUtil.getModifierLevel(p.getItemBySlot(EquipmentSlot.HEAD), this.getId()) == 1);
    }
}
