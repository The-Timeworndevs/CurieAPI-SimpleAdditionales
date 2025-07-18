package net.timeworndevs.curiecontent.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.player.PlayerEntity;
import net.timeworndevs.curieapi.radiation.RadiationNBT;
import net.timeworndevs.curieapi.util.IEntityDataSaver;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin<T extends LivingEntity, M extends EntityModel<T>> {

    // This will modify the arguments before passing them to the original method
    @ModifyArgs(method = "render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"))
    public void modifyRenderArgs(Args args, @Local(ordinal = 0, argsOnly = true) LivingEntity livingEntity) {
        if (livingEntity instanceof PlayerEntity player) {
            if(RadiationNBT.get((IEntityDataSaver) player).getBoolean("tinted")) {
                args.set(4, 0.2f);
                args.set(5, 0.4f);
                args.set(6, 0.2f);
            }
        }
    }
}