package com.draxxmaxx24.genomecraft.item.custom;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent ORGANIC_WASTE = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 500), 1.0f)
            .build();
}
