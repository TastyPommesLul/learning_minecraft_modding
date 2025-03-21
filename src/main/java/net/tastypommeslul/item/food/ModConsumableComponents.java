package net.tastypommeslul.item.food;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import java.util.List;

public class ModConsumableComponents {
    public static final ConsumableComponent CAULIFLOWER = ConsumableComponent.builder()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    List.of(
                            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 100, 1),
                            new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1)
                    )
                )
            )
            .build();
}
