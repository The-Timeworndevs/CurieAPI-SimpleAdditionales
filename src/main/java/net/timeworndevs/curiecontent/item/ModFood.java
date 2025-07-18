package net.timeworndevs.curiecontent.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.timeworndevs.curiecontent.effect.QuantumEffects;

public class ModFood {
    public static final FoodComponent SUSPICIOUS_PILL = new FoodComponent.Builder()
            .alwaysEdible()
            .snack()
            .hunger(3)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(QuantumEffects.EXPOSED_ORGANS, 120*20, 1), 1.0f)
            .build();
    public static final FoodComponent MEDICAL_PILL = new FoodComponent.Builder()
            .alwaysEdible()
            .snack()
            .saturationModifier(0.5f)
            .hunger(4)
            .statusEffect(new StatusEffectInstance(QuantumEffects.RADIATION_NEUTRALISATION, 240*20, 0), 0.8f)
            .build();
}
