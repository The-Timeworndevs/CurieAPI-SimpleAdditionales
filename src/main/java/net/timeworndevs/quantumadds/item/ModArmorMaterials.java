package net.timeworndevs.quantumadds.item;

import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.timeworndevs.quantumadds.Quantum;
import net.timeworndevs.quantumadds.registries.QuantumItems;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    HAZMATD("hazmatd", 5, new int[] {3, 5, 4, 2}, 5, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            2f, 0.1f, () -> Ingredient.ofItems(Items.LEATHER)),
    HAZMATC("hazmatc", 5, new int[] {4, 6, 5, 3}, 6, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
            3f, 0.2f, () -> Ingredient.ofItems(QuantumItems.RUBBER)),
    HAZMATB("hazmatb", 5, new int[] {6, 8, 6, 5}, 8, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
            4f, 0.4f, () -> Ingredient.ofItems(QuantumItems.RUBBER)),
    HAZMATA("hazmata", 5, new int[] {8, 10, 7, 6}, 12, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            6f, 0.8f, () -> Ingredient.ofItems(QuantumItems.PVC));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;

    private final Supplier<Ingredient> repairIngredient;
    private static final int[] BASE_DURABILITY={11, 16, 15, 13}; //HELMET, CHESTPLATE, LEGGINGS, BOOTS

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchability, SoundEvent equipSound,
                      float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchability = enchability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return Quantum.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
