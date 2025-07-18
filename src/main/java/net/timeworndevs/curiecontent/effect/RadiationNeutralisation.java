package net.timeworndevs.curiecontent.effect;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.timeworndevs.curieapi.radiation.RadiationData;
import net.timeworndevs.curieapi.radiation.RadiationType;

import java.util.Random;

import static net.timeworndevs.curieapi.util.CurieAPIConfig.RADIATION_TYPES;

public class RadiationNeutralisation extends StatusEffect {
    private static final Random random = new Random();
    protected RadiationNeutralisation(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()) {
            if (entity instanceof PlayerEntity player) {
                for (RadiationType type : RADIATION_TYPES.values()) {
                    RadiationData.delRad(player, type, random.nextInt(25) * amplifier);
                }
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}
