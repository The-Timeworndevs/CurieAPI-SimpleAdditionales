package net.timeworndevs.curiecontent.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class AlphaRadiationBuildUpEffect extends StatusEffect {

    protected AlphaRadiationBuildUpEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()) {

            entity.kill();
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}
