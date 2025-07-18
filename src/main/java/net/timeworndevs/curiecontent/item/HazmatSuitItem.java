package net.timeworndevs.curiecontent.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.timeworndevs.curiecontent.CurieContent;
import net.timeworndevs.curiecontent.registries.CurieContentModelLayers;
import net.timeworndevs.curiecontent.item.armors.FullArmorModel;
import org.jetbrains.annotations.NotNull;

public class HazmatSuitItem extends ArmorItem {
    @Environment(EnvType.CLIENT)
    private BipedEntityModel<LivingEntity> model;

    private final String texture_feet, texture_rest;
    public HazmatSuitItem(ArmorMaterial material, Type type, Settings settings, String texture) {
        super(material, type, settings);
        texture_feet = "textures/armor/" + texture + "_suit_feet.png";
        texture_rest = "textures/armor/" + texture + "_suit_main.png";
    }

    @Override
    public ItemStack getDefaultStack() {
        return new ItemStack(this);
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canRepair(ItemStack itemStack_1, ItemStack itemStack_2) {
        return false;
    }

    @Environment(EnvType.CLIENT)
    protected BipedEntityModel<LivingEntity> provideArmorModelForSlot(EquipmentSlot slot, Item item) {

        var models = MinecraftClient.getInstance().getEntityModelLoader();

        var feet = models.getModelPart(CurieContentModelLayers.HAZMAT_A_FEET_LAYER);
        var root = models.getModelPart(CurieContentModelLayers.HAZMAT_A_MAIN_LAYER);
        if (slot == EquipmentSlot.FEET) {
            return new FullArmorModel(feet, slot);
        } else {
            return new FullArmorModel(root, slot);
        }
    }

    @Environment(EnvType.CLIENT)
    public BipedEntityModel<LivingEntity> getArmorModel(Item item) {
        if (model == null) {
            model = provideArmorModelForSlot(getSlotType(), item);
        }
        return model;
    }

    @NotNull
    public Identifier getArmorTexture(EquipmentSlot slot) {
        if (slot == EquipmentSlot.FEET) {
            return new Identifier(CurieContent.MOD_ID, this.texture_feet);
        } else {
            return new Identifier(CurieContent.MOD_ID, this.texture_rest);
        }
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}