package net.timeworndevs.quantumadds.render;

import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.model.*;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.timeworndevs.quantumadds.QuantumClient;
import net.timeworndevs.quantumadds.compat.FiguraCompat;
import net.timeworndevs.quantumadds.item.Armors.ArmorTestItems;
import net.timeworndevs.quantumadds.item.HazmatSuitItem;

import java.util.List;


public class ArmorTestRenderer {

    public static final List<Item> HAZMAT_SUIT =
            List.of(
                    ArmorTestItems.HAZMAT_HELMET,
                    ArmorTestItems.HAZMAT_CHESTPLATE,
                    ArmorTestItems.HAZMAT_LEGGINGS,
                    ArmorTestItems.HAZMAT_BOOTS
            );

    static void renderPart(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ItemStack stack, Model model, Identifier texture) {
        VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, RenderLayer.getEntityTranslucent(texture), false, stack.hasGlint());
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
    }

    public static void register() {
        ArmorRenderer renderer = (matrices, vertexConsumers, stack, entity, slot, light, contextModel) -> {

            HazmatSuitItem armor = (HazmatSuitItem) stack.getItem();
            var model = armor.getArmorModel();
            var texture = armor.getArmorTexture(stack, slot);
            boolean shouldRender = !QuantumClient.isFiguraLoaded || FiguraCompat.renderArmorPart((PlayerEntity) entity, slot);

            if (shouldRender) {
                contextModel.copyBipedStateTo(model);
                renderPart(matrices, vertexConsumers, light, stack, model, texture);
            }
        };
        ArmorRenderer.register(renderer, HAZMAT_SUIT.toArray(new Item[0]));
    }
}


