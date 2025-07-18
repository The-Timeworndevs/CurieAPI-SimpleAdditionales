package net.timeworndevs.curiecontent.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.timeworndevs.curiecontent.CurieContent;
import net.timeworndevs.curiecontent.registries.CurieContentBlocks;

import java.util.List;

public class CurieContentConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PLUTONIUM_ORE_KEY = registerKey("plutonium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TUNGSTEN_ORE_KEY = registerKey("tungsten_ore");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplecables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplecables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldPlutoniumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplecables, CurieContentBlocks.PLUTONIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplecables, CurieContentBlocks.DEEPSLATE_PLUTONIUM_ORE.getDefaultState()));

        register(context, PLUTONIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPlutoniumOres, 4));

        List<OreFeatureConfig.Target> overworldTungstenOres =
                List.of(OreFeatureConfig.createTarget(stoneReplecables, CurieContentBlocks.TUNGSTEN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplecables, CurieContentBlocks.DEEPSLATE_TUNGSTEN_ORE.getDefaultState()));

        register(context, TUNGSTEN_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPlutoniumOres, 6));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(CurieContent.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
