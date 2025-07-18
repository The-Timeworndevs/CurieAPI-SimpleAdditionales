package net.timeworndevs.curiecontent.world.biome;

import net.timeworndevs.curiecontent.CurieContent;
import net.minecraft.util.Identifier;
import net.timeworndevs.curiecontent.world.biome.surface.ModMaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(CurieContent.MOD_ID, "overworld"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, CurieContent.MOD_ID, ModMaterialRules.makeRules());
    }
}
