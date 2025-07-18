package net.timeworndevs.curiecontent.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.timeworndevs.curiecontent.CurieContent;

public class QuantumEffects {
    public static StatusEffect SKIN_FALLOFF;
    public static StatusEffect EXPOSED_ORGANS;
    public static StatusEffect RADIATION_NEUTRALISATION;

    public static StatusEffect registerEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(CurieContent.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        SKIN_FALLOFF = registerEffect("skin_falloff", new SkinFalloffEffect(StatusEffectCategory.HARMFUL, 5245231));
        EXPOSED_ORGANS =  registerEffect("exposed_organs", new ExposedOrgans(StatusEffectCategory.HARMFUL, 7633476));
        RADIATION_NEUTRALISATION = registerEffect("radiation_neutralisation", new RadiationNeutralisation(StatusEffectCategory.BENEFICIAL, 3245231));
    }
}