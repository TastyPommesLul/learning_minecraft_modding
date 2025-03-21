package net.tastypommeslul.item.food;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModConsumableComponents {
    public static final ConsumableComponent CAULIFLOWER = ConsumableComponent.builder()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1)
                )
            )
            .build();
}
