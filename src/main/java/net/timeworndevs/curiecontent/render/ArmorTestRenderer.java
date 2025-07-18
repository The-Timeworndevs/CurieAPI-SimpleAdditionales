package net.timeworndevs.curiecontent.render;

import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.model.*;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.timeworndevs.curiecontent.CurieContentClient;
import net.timeworndevs.curiecontent.compat.FiguraCompat;
import net.timeworndevs.curiecontent.item.HazmatSuitItem;
import net.timeworndevs.curiecontent.registries.CurieContentItems;

public class ArmorTestRenderer {

    static void renderPart(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ItemStack stack, Model model, Identifier texture) {
        VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, RenderLayer.getEntityTranslucent(texture), false, stack.hasGlint());
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
    }

    public static void register() {
        ArmorRenderer renderer = (matrices, vertexConsumers, stack, entity, slot, light, contextModel) -> {

            HazmatSuitItem armor = (HazmatSuitItem) stack.getItem();
            var model = armor.getArmorModel(stack.getItem());
            var texture = armor.getArmorTexture(slot);
            boolean shouldRender = !(entity instanceof PlayerEntity) || !CurieContentClient.isFiguraLoaded || FiguraCompat.renderArmorPart((PlayerEntity) entity, slot);
            if (shouldRender) {
                contextModel.copyBipedStateTo(model);
                renderPart(matrices, vertexConsumers, light, stack, model, texture);
            }
        };
        ArmorRenderer.register(renderer, CurieContentItems.allArmors);
    }
}