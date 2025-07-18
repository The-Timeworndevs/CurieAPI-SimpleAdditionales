package net.timeworndevs.curiecontent.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.timeworndevs.curieapi.radiation.RadiationData;
import net.timeworndevs.curieapi.radiation.RadiationType;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import static net.timeworndevs.curieapi.util.CurieAPIConfig.RADIATION_TYPES;

public class ExposedOrgans extends StatusEffect {

    protected ExposedOrgans(StatusEffectCategory category, int color) {
        super(category, color);
    }

    private static final ArrayList<RadiationType> radiations = new ArrayList<>(RADIATION_TYPES.values());
    private static final EntityAttributeModifier armorReduction = new EntityAttributeModifier(UUID.fromString("3999f1d6-6b7e-4c6d-8bc0-46025f73dd84"), "curie-content:armor_reduction", -5, EntityAttributeModifier.Operation.ADDITION);
    private static final Random rand = new Random();
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()) {
            if (entity instanceof PlayerEntity player) {
                RadiationData.addRad(player, radiations.get(rand.nextInt(radiations.size())), (int) (Math.random() * 10 * amplifier));
            }
            EntityAttributeInstance instance = entity.getAttributeInstance(EntityAttributes.GENERIC_ARMOR);
            if (instance != null && !instance.hasModifier(armorReduction)) {
                instance.addTemporaryModifier(armorReduction);
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}
