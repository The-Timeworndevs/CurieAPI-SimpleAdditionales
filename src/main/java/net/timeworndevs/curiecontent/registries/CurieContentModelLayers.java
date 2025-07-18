package net.timeworndevs.curiecontent.registries;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.timeworndevs.curiecontent.CurieContent;

import net.timeworndevs.curiecontent.entities.client.MonstrosityModel;
import net.timeworndevs.curiecontent.render.*;

public class CurieContentModelLayers {

    // -- Hazmat Suits -- //
    public static final EntityModelLayer HAZMAT_A_FEET_LAYER = new EntityModelLayer(new Identifier(CurieContent.MOD_ID, "hazmat_suit_a"), "feet");
    public static final EntityModelLayer HAZMAT_A_MAIN_LAYER = new EntityModelLayer(new Identifier(CurieContent.MOD_ID,"hazmat_suit_a"), "main");
    public static final EntityModelLayer HAZMAT_B_FEET_LAYER = new EntityModelLayer(new Identifier(CurieContent.MOD_ID, "hazmat_suit_b"), "feet");
    public static final EntityModelLayer HAZMAT_B_MAIN_LAYER = new EntityModelLayer(new Identifier(CurieContent.MOD_ID,"hazmat_suit_b"), "main");
    public static final EntityModelLayer HAZMAT_C_FEET_LAYER = new EntityModelLayer(new Identifier(CurieContent.MOD_ID, "hazmat_suit_c"), "feet");
    public static final EntityModelLayer HAZMAT_C_MAIN_LAYER = new EntityModelLayer(new Identifier(CurieContent.MOD_ID,"hazmat_suit_c"), "main");
    public static final EntityModelLayer HAZMAT_D_FEET_LAYER = new EntityModelLayer(new Identifier(CurieContent.MOD_ID, "hazmat_suit_d"), "feet");
    public static final EntityModelLayer HAZMAT_D_MAIN_LAYER = new EntityModelLayer(new Identifier(CurieContent.MOD_ID,"hazmat_suit_d"), "main");

    public static final EntityModelLayer GEIGER_COUNTER = new EntityModelLayer(new Identifier(CurieContent.MOD_ID,"geiger_counter"), "main");
    public static final EntityModelLayer MONSTROSITY = new EntityModelLayer(new Identifier(CurieContent.MOD_ID, "monstrosity"), "main");

    public static void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(HAZMAT_A_FEET_LAYER, () -> TexturedModelData.of(HazmatSuitLevelOneModel.getModelData(), 128, 128));
        EntityModelLayerRegistry.registerModelLayer(HAZMAT_A_MAIN_LAYER, () -> TexturedModelData.of(HazmatSuitLevelOneModel.getModelData(), 128, 128));
        EntityModelLayerRegistry.registerModelLayer(HAZMAT_B_FEET_LAYER, () -> TexturedModelData.of(HazmatSuitLevelTwoModel.getModelData(), 128, 128));
        EntityModelLayerRegistry.registerModelLayer(HAZMAT_B_MAIN_LAYER, () -> TexturedModelData.of(HazmatSuitLevelTwoModel.getModelData(), 128, 128));
        EntityModelLayerRegistry.registerModelLayer(HAZMAT_C_FEET_LAYER, () -> TexturedModelData.of(HazmatSuitLevelThreeModel.getModelData(), 128, 128));
        EntityModelLayerRegistry.registerModelLayer(HAZMAT_C_MAIN_LAYER, () -> TexturedModelData.of(HazmatSuitLevelThreeModel.getModelData(), 128, 128));
        EntityModelLayerRegistry.registerModelLayer(HAZMAT_D_FEET_LAYER, () -> TexturedModelData.of(HazmatSuitLevelFourModel.getModelData(), 128, 128));
        EntityModelLayerRegistry.registerModelLayer(HAZMAT_D_MAIN_LAYER, () -> TexturedModelData.of(HazmatSuitLevelFourModel.getModelData(), 128, 128));
        EntityModelLayerRegistry.registerModelLayer(MONSTROSITY, MonstrosityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(GEIGER_COUNTER, GeigerCounterItemRenderer::getGeigerCounterModel);
    }
}
