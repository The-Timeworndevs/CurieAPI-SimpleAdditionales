package net.timeworndevs.curiecontent;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.RenderLayer;
import net.timeworndevs.curieapi.radiation.RadiationType;
import net.timeworndevs.curiecontent.registries.CurieContentModelLayers;
import net.timeworndevs.curiecontent.registries.CurieContentEntities;
import net.timeworndevs.curiecontent.entities.client.MonstrosityRenderer;
import net.timeworndevs.curiecontent.render.GeigerCounterItemRenderer;
import net.timeworndevs.curiecontent.registries.CurieContentBlocks;
import net.timeworndevs.curiecontent.registries.CurieContentItems;
import net.timeworndevs.curiecontent.render.*;

@Environment(EnvType.CLIENT)
public class CurieContentClient implements ClientModInitializer {

    public static boolean isFiguraLoaded = false;
    @Override
    public void onInitializeClient() {
        CurieContentModelLayers.registerModelLayers();
        EntityRendererRegistry.register(CurieContentEntities.MONSTROSITY, MonstrosityRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(CurieContentBlocks.REACTOR_CORE, RenderLayer.getTranslucent());

        ArmorTestRenderer.register();

        BuiltinItemRendererRegistry.INSTANCE.register(CurieContentItems.GEIGER_COUNTER, new GeigerCounterItemRenderer());
        RadiationType.RadiationPacket.registerPackets();

        isFiguraLoaded = (FabricLoader.getInstance().isModLoaded("figura"));
    }
}
