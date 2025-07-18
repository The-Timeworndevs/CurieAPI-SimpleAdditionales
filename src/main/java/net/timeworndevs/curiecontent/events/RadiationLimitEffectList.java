package net.timeworndevs.curiecontent.events;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.timeworndevs.curieapi.radiation.RadiationEffect;
import net.timeworndevs.curieapi.radiation.RadiationEntry;
import net.timeworndevs.curieapi.radiation.RadiationNBT;
import net.timeworndevs.curieapi.util.IEntityDataSaver;
import net.timeworndevs.curiecontent.effect.QuantumEffects;
import net.timeworndevs.curiecontent.effect.RadiationLimitEffect;
import net.timeworndevs.curiecontent.effect.SingleRadiationLimitEffect;
import net.timeworndevs.curiecontent.registries.CurieContentRadiationTypes;

import java.util.*;

public class RadiationLimitEffectList {
    private static final Random random = new Random();

    public static final List<RadiationEffect> actions = List.of(

            new SingleRadiationLimitEffect(CurieContentRadiationTypes.ALPHA, 0.9f, (player, threshold) -> {
                if (random.nextDouble() <0.15) {
                    addMutation(player);
                } else {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 120, 6));
                }
            }),
            new SingleRadiationLimitEffect(CurieContentRadiationTypes.ALPHA, 0.8f, (player, threshold) -> {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 40, 1));
            }),
            new SingleRadiationLimitEffect(CurieContentRadiationTypes.ALPHA, 0.5f,(player, rad) ->  {
                double num = random.nextDouble();
                if (num >0.5f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 120, 2));   // 50% * 80%
                } else if (num < 0.25f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 120, 2));     // 25% * 80%
                }
            }),
            new SingleRadiationLimitEffect(CurieContentRadiationTypes.ALPHA, 0.1f,(player, rad) ->  {
                if (random.nextDouble() > 0.75f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 60, 1));        // 25%
                }
            }),
            new SingleRadiationLimitEffect(CurieContentRadiationTypes.BETA, 0.9f, (player, threshold) -> {
                double num = random.nextDouble();
                if (num > 0.8f) {
                    addMutation(player);
                } else if (num > 0.5f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20, 6));
                } else {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20, 6));
                }
            }),
            new SingleRadiationLimitEffect(CurieContentRadiationTypes.BETA, 0.8f, (player, threshold) -> {
                double num = random.nextDouble();
                if (num > 0.95f) {
                    player.addStatusEffect(new StatusEffectInstance(QuantumEffects.SKIN_FALLOFF, 40, 1));
                } else if (num > 0.9f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1200, 2));
                }
            }),
            new SingleRadiationLimitEffect(CurieContentRadiationTypes.BETA, 0.5f, (player, threshold) -> {
                double num = random.nextDouble();
                if (num > 0.5f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 120, 2));
                } else if (num < 0.15f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 120, 2));
                }
            }),
            new SingleRadiationLimitEffect(CurieContentRadiationTypes.BETA, 0.1f, (player, threshold) -> {
                if (random.nextDouble() > 0.8f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 60, 1));
                }
            }),
            new SingleRadiationLimitEffect(CurieContentRadiationTypes.GAMMA, 0.9f, (player, threshold) -> {
                if (random.nextDouble() <0.98f) {
                    addMutation(player);
                } else {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 120, 6));
                }
            }),
            new SingleRadiationLimitEffect(CurieContentRadiationTypes.GAMMA, 0.8f, (player, threshold) -> {
                double num = random.nextDouble();
                if (num >0.9f) {
                    player.addStatusEffect(new StatusEffectInstance(QuantumEffects.SKIN_FALLOFF, 40, 1));
                } else if (num >0.8f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1200, 2));
                }
            }),
            new SingleRadiationLimitEffect(CurieContentRadiationTypes.GAMMA, 0.5f, (player, threshold) -> {
                double num = random.nextDouble();
                if (num > 0.5f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 120, 2));
                } else if (num < 0.25f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 120, 2));
                }
            }),
            new SingleRadiationLimitEffect(CurieContentRadiationTypes.GAMMA, 0.1f, (player, threshold) -> {
                if (random.nextDouble() > 0.8f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 60, 1));
                }
            }),
            new RadiationLimitEffect(new RadiationEntry(Map.of(CurieContentRadiationTypes.ALPHA, 0.1f, CurieContentRadiationTypes.BETA,0.1f, CurieContentRadiationTypes.GAMMA, 0.1f, CurieContentRadiationTypes.NEUTRON, 0.1f)),(player, rad) ->  {
                if (random.nextDouble() > 0.65) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 60, 1));
                }
            }),
            new RadiationLimitEffect(new RadiationEntry(Map.of(CurieContentRadiationTypes.ALPHA, 0.9f, CurieContentRadiationTypes.BETA,0.9f, CurieContentRadiationTypes.GAMMA, 0.8f, CurieContentRadiationTypes.NEUTRON, 0.7f)),(player, rad) ->  {
                addMutation(player);
            }),
            new RadiationLimitEffect(new RadiationEntry(Map.of(CurieContentRadiationTypes.ALPHA, 0.8f, CurieContentRadiationTypes.BETA,0.5f, CurieContentRadiationTypes.GAMMA, 0.3f, CurieContentRadiationTypes.NEUTRON, 0.1f)),(player, rad) ->  {
                double num = random.nextDouble();
                if (num > 0.6f) {
                    player.addStatusEffect(new StatusEffectInstance(QuantumEffects.SKIN_FALLOFF, 40, 1));
                } else if (num > 0.2f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1200, 2));
                }
            }),
            new RadiationLimitEffect(new RadiationEntry(Map.of(CurieContentRadiationTypes.ALPHA, 0.5f, CurieContentRadiationTypes.BETA,0.5f, CurieContentRadiationTypes.GAMMA, 0.5f, CurieContentRadiationTypes.NEUTRON, 0.5f)),(player, rad) ->  {
                double num = random.nextDouble();
                if (num > 0.5f) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 120, 2));
                } else if (num < 0.4f) {
//                    EntityAttributeInstance inst = player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
//                    inst.addTemporaryModifier(new EntityAttributeModifier("radiation_speed", 0.2, EntityAttributeModifier.Operation.ADDITION));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 120, 2));
                }
            })
    );

    @FunctionalInterface
    public interface Mutation {
        void mutate(ServerPlayerEntity player);
    }
    private static final List<Mutation> mutations = new ArrayList<>(List.of(
            player -> player.setGlowing(true),
            player -> player.setAbsorptionAmount(3f),
            player -> player.setMainArm(player.getMainArm().getOpposite()),
            player -> player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 1)),
            player -> player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20, 2)),
            player -> player.setInPowderSnow(true),
            player -> RadiationNBT.get((IEntityDataSaver) player).putBoolean("tinted", true)
    ));
    private static void addMutation(ServerPlayerEntity player) {
        mutations.get(random.nextInt(mutations.size())).mutate(player);
    }
}
