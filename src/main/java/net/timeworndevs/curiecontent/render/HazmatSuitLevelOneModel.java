package net.timeworndevs.curiecontent.render;

import net.minecraft.client.model.*;

public class HazmatSuitLevelOneModel {
    public final ModelPart head;
    public final ModelPart body;
    public final ModelPart right_arm;
    public final ModelPart left_arm;
    public final ModelPart right_leg;
    public final ModelPart left_leg;
    public final ModelPart Mask;
    public final ModelPart Left;
    public final ModelPart Right;

    public HazmatSuitLevelOneModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.right_arm = root.getChild("right_arm");
        this.left_arm = root.getChild("left_arm");
        this.right_leg = root.getChild("right_leg");
        this.left_leg = root.getChild("left_leg");
        this.Mask = root.getChild("Mask");
        this.Left = root.getChild("Left");
        this.Right = root.getChild("Right");
    }
    public static ModelData getModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.26F))
                .uv(0, 16).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData.addChild("hat", ModelPartBuilder.create(), ModelTransform.NONE);
        ModelPartData Mask = head.addChild("Mask", ModelPartBuilder.create().uv(56, 36).cuboid(-1.5F, -3.2F, -6.0F, 3.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(56, 32).cuboid(-3.5F, -2.7F, -5.0F, 7.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Left = Mask.addChild("Left", ModelPartBuilder.create().uv(56, 42).cuboid(-1.5389F, -1.0231F, -2.7452F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F))
                .uv(42, 58).mirrored().cuboid(-1.0389F, -0.5231F, -0.7452F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.0F, -1.2F, -5.0F, 0.2618F, -0.3927F, 0.0F));

        ModelPartData Right = Mask.addChild("Right", ModelPartBuilder.create().uv(32, 58).cuboid(-1.4611F, -1.0231F, -2.7452F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F))
                .uv(42, 58).cuboid(-0.9611F, -0.5231F, -0.7452F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -1.2F, -5.0F, 0.3439F, 0.5537F, 0.0916F));

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 32).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.26F))
                .uv(32, 48).cuboid(-3.0F, 1.0F, 2.0F, 6.0F, 8.0F, 2.0F, new Dilation(0.0F))
                .uv(48, 48).cuboid(-3.0F, 1.0F, 2.0F, 6.0F, 8.0F, 2.0F, new Dilation(0.375F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(32, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.26F))
                .uv(24, 32).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.5F)), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(40, 32).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.26F))
                .uv(32, 0).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.5F)), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.26F))
                .uv(48, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.5F)), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));

        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(16, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.26F))
                .uv(48, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.5F)), ModelTransform.pivot(1.9F, 12.0F, 0.0F));
        return modelData;
    }
}