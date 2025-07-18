// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.timeworndevs.curiecontent.entities.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.timeworndevs.curiecontent.entities.custom.MonstrosityEntity;

public class MonstrosityModel<T extends MonstrosityEntity> extends SinglePartEntityModel<T> {
	private final ModelPart Root;
	private final ModelPart Body;
    private final ModelPart LeftFrontLeg1;
	private final ModelPart LeftFrontLeg2;
	private final ModelPart RightFrontLeg;
	private final ModelPart RightFrontLeg1;
	private final ModelPart RightFrontLeg2;
	private final ModelPart Back;
	private final ModelPart cube_r1;
	private final ModelPart cube_r2;
	private final ModelPart LeftBackLeg;
	private final ModelPart LeftBackLeg1;
	private final ModelPart LeftBackLeg2;
	private final ModelPart RightBackLeg;
	private final ModelPart RightBackLeg1;
	private final ModelPart RightBackLeg2;
	private final ModelPart Tail;
	private final ModelPart Tail2;
	private final ModelPart Tail3;
	private final ModelPart Tail4;
	private final ModelPart Tail5;
	private final ModelPart Tail6;
	private final ModelPart Tail7;
	public MonstrosityModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
        ModelPart leftFrontLeg = this.Body.getChild("LeftFrontLeg");
		this.LeftFrontLeg1 = leftFrontLeg.getChild("LeftFrontLeg1");
		this.LeftFrontLeg2 = this.LeftFrontLeg1.getChild("LeftFrontLeg2");
		this.RightFrontLeg = this.Body.getChild("RightFrontLeg");
		this.RightFrontLeg1 = this.RightFrontLeg.getChild("RightFrontLeg1");
		this.RightFrontLeg2 = this.RightFrontLeg1.getChild("RightFrontLeg2");

		this.Back = this.Body.getChild("Back");
		this.LeftBackLeg = this.Back.getChild("LeftBackLeg");
		this.LeftBackLeg1 = this.LeftBackLeg.getChild("LeftBackLeg1");
		this.LeftBackLeg2 = this.LeftBackLeg1.getChild("LeftBackLeg2");
		this.RightBackLeg = this.Back.getChild("RightBackLeg");
		this.RightBackLeg1 = this.RightBackLeg.getChild("RightBackLeg1");
		this.RightBackLeg2 = this.RightBackLeg1.getChild("RightBackLeg2");

		this.Tail = this.Back.getChild("Tail");
		this.Tail2 = this.Tail.getChild("Tail2");
		this.Tail3 = this.Tail2.getChild("Tail3");
		this.Tail4 = this.Tail3.getChild("Tail4");
		this.Tail5 = this.Tail4.getChild("Tail5");
		this.Tail6 = this.Tail5.getChild("Tail6");
		this.Tail7 = this.Tail6.getChild("Tail7");
		this.cube_r1 = this.Back.getChild("cube_r1");
		this.cube_r2 = this.Back.getChild("cube_r2");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Root = modelPartData.addChild("Root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Body = Root.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.25F, 0.0F));

		ModelPartData LeftFrontLeg = Body.addChild("LeftFrontLeg", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, 0.75F, -2.0F));

		ModelPartData LeftFrontLeg1 = LeftFrontLeg.addChild("LeftFrontLeg1", ModelPartBuilder.create().uv(26, 26).cuboid(-0.25F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData LeftFrontLeg2 = LeftFrontLeg1.addChild("LeftFrontLeg2", ModelPartBuilder.create().uv(0, 12).cuboid(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.5F))
		.uv(26, 0).cuboid(0.25F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new Dilation(0.25F)), ModelTransform.pivot(4.75F, 0.0F, 0.0F));

		ModelPartData RightFrontLeg = Body.addChild("RightFrontLeg", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, 0.75F, -2.0F));

		ModelPartData RightFrontLeg1 = RightFrontLeg.addChild("RightFrontLeg1", ModelPartBuilder.create().uv(26, 14).cuboid(-4.75F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData RightFrontLeg2 = RightFrontLeg1.addChild("RightFrontLeg2", ModelPartBuilder.create().uv(0, 4).cuboid(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.5F))
		.uv(24, 18).cuboid(-6.25F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new Dilation(0.25F)), ModelTransform.pivot(-4.75F, 0.0F, 0.0F));

		ModelPartData Back = Body.addChild("Back", ModelPartBuilder.create().uv(0, 12).cuboid(-3.0F, -5.25F, -1.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-3.0F, -5.25F, -1.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, 0.75F, -2.0F));

		ModelPartData cube_r1 = Back.addChild("cube_r1", ModelPartBuilder.create().uv(8, 24).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -5.0F, -1.0F, -0.1745F, 0.3927F, 0.0F));

		ModelPartData cube_r2 = Back.addChild("cube_r2", ModelPartBuilder.create().uv(8, 24).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -5.0F, -1.0F, -0.1745F, -0.3927F, 0.0F));

		ModelPartData LeftBackLeg = Back.addChild("LeftBackLeg", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, 0.0F, 4.0F));

		ModelPartData LeftBackLeg1 = LeftBackLeg.addChild("LeftBackLeg1", ModelPartBuilder.create().uv(28, 22).cuboid(-0.25F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData LeftBackLeg2 = LeftBackLeg1.addChild("LeftBackLeg2", ModelPartBuilder.create().uv(0, 2).cuboid(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.25F))
		.uv(26, 12).cuboid(0.25F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(3.75F, 0.0F, 0.0F));

		ModelPartData RightBackLeg = Back.addChild("RightBackLeg", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, 0.0F, 4.0F));

		ModelPartData RightBackLeg1 = RightBackLeg.addChild("RightBackLeg1", ModelPartBuilder.create().uv(28, 20).cuboid(-3.75F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData RightBackLeg2 = RightBackLeg1.addChild("RightBackLeg2", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.25F))
		.uv(26, 2).cuboid(-5.25F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.75F, 0.0F, 0.0F));

		ModelPartData Tail = Back.addChild("Tail", ModelPartBuilder.create().uv(12, 24).cuboid(-1.0F, -1.55F, -0.5F, 2.0F, 2.0F, 4.0F, new Dilation(-0.25F)), ModelTransform.pivot(0.0F, -1.0F, 5.0F));

		ModelPartData Tail2 = Tail.addChild("Tail2", ModelPartBuilder.create().uv(24, 6).cuboid(-1.0F, -1.55F, -0.5F, 2.0F, 2.0F, 4.0F, new Dilation(-0.3F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

		ModelPartData Tail3 = Tail2.addChild("Tail3", ModelPartBuilder.create().uv(0, 24).cuboid(-1.0F, -1.55F, -0.5F, 2.0F, 2.0F, 4.0F, new Dilation(-0.35F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

		ModelPartData Tail4 = Tail3.addChild("Tail4", ModelPartBuilder.create().uv(20, 20).cuboid(-1.0F, -1.55F, -0.5F, 2.0F, 2.0F, 4.0F, new Dilation(-0.4F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

		ModelPartData Tail5 = Tail4.addChild("Tail5", ModelPartBuilder.create().uv(18, 12).cuboid(-1.0F, -1.55F, -0.5F, 2.0F, 2.0F, 4.0F, new Dilation(-0.45F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

		ModelPartData Tail6 = Tail5.addChild("Tail6", ModelPartBuilder.create().uv(18, 0).cuboid(-1.0F, -1.55F, -0.5F, 2.0F, 2.0F, 4.0F, new Dilation(-0.5F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

		ModelPartData Tail7 = Tail6.addChild("Tail7", ModelPartBuilder.create().uv(20, 26).cuboid(-0.5F, -1.05F, -0.5F, 1.0F, 1.0F, 4.0F, new Dilation(-0.25F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return Root;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		//AnimationHelper.animate(this, ModAnimations.WALK, (long)(limbAngle), Math.min(limbDistance, 1f), new Vector3f());
		float speedScale = (float) entity.getVelocity().horizontalLength() / 0.026375f;
		speedScale = MathHelper.clamp(speedScale, 0.0f, 2.0f);
		this.updateAnimation(entity.idleAnimationState, MonstrosityAnimations.IDLE, animationProgress, 1f);
		this.updateAnimation(entity.walkAnimationState, MonstrosityAnimations.WALK, animationProgress, speedScale);
	}
	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);
		this.Back.yaw = headYaw * 0.017453292F;
		this.Back.pitch = headPitch * 0.017453292F;
	}
}