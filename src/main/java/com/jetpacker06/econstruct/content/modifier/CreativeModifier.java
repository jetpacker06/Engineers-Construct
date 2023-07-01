package com.jetpacker06.econstruct.content.modifier;

import com.simibubi.create.AllItems;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.interaction.BlockInteractionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InteractionSource;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class CreativeModifier extends NoLevelsModifier implements BlockInteractionModifierHook {

    @Override
    public void registerHooks(ModifierHookMap.@NotNull Builder bobTheBuilder) {
        bobTheBuilder.addHook(this, TinkerHooks.BLOCK_INTERACT);
    }

    @Override
    public @NotNull InteractionResult beforeBlockUse(@NotNull IToolStackView tool, @NotNull ModifierEntry modifier, @NotNull UseOnContext context, @NotNull InteractionSource source) {
        if (context.getPlayer() == null || tool.isBroken()) {
            return InteractionResult.PASS;
        }
        return AllItems.WRENCH.get().useOn(context);
    }
}
