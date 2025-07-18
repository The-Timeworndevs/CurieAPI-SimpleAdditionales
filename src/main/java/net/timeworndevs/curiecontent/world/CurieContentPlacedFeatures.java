package net.timeworndevs.curiecontent.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.timeworndevs.curiecontent.CurieContent;

import java.util.List;

public class CurieContentPlacedFeatures {
    public static final RegistryKey<PlacedFeature> PLUTONIUM_ORE_PLACED_KEY = registerKey("plutonium_ore_placed");
    public static final RegistryKey<PlacedFeature> TUNGSTEN_ORE_PLACED_KEY = registerKey("tungsten_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {

        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        /*register(context, PLUTONIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PLUTONIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(4,
                HeightRangePlacementModifier.trapezoid(new YOffset.Fixed(-20), new YOffset.Fixed(20))));
        register(context, TUNGSTEN_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TUNGSTEN_ORE_KEY), ModOrePlacement.modifiersWithCount(4,
                HeightRangePlacementModifier.trapezoid(new YOffset.Fixed(-30), new YOffset.Fixed(30))));*/    }
    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(CurieContent.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
