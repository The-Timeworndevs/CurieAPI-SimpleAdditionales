package net.timeworndevs.curiecontent.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class SkinFalloffEffect extends StatusEffect {

    public SkinFalloffEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    private static final Random random = new Random();

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()) {

            if (entity.isUsingItem() && random.nextFloat() < (0.02 * amplifier)) {
                entity.stopUsingItem();
            }

            ItemStack stack = entity.getActiveItem();
            if (!stack.isEmpty() && amplifier > 1 && random.nextFloat() < (0.02 * amplifier)) {
                entity.dropStack(stack);
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}
