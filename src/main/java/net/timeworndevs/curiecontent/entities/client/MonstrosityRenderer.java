package net.timeworndevs.curiecontent.entities.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.timeworndevs.curiecontent.CurieContent;
import net.timeworndevs.curiecontent.entities.custom.MonstrosityEntity;
import net.timeworndevs.curiecontent.registries.CurieContentModelLayers;

@Environment(EnvType.CLIENT)
public class MonstrosityRenderer extends MobEntityRenderer<MonstrosityEntity, MonstrosityModel<MonstrosityEntity>> {
    private static final Identifier TEXTURE = new Identifier(CurieContent.MOD_ID, "textures/entity/monstrosity.png");

    public MonstrosityRenderer(EntityRendererFactory.Context context) {
        super(context, new MonstrosityModel<>(context.getPart(CurieContentModelLayers.MONSTROSITY)), 0.6f);
    }

    @Override
    public Identifier getTexture(MonstrosityEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(MonstrosityEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby()) {
            matrixStack.scale(0.6f, 0.6f, 0.6f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
