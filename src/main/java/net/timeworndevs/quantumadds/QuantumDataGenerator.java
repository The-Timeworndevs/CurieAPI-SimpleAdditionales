package net.timeworndevs.quantumadds;

import net.timeworndevs.quantumadds.datagen.ModItemTagProvider;
import net.timeworndevs.quantumadds.datagen.ModModelProvider;
import net.timeworndevs.quantumadds.world.ModConfiguredFeatures;
import net.timeworndevs.quantumadds.world.ModPlacedFeatures;
import net.timeworndevs.quantumadds.world.biome.ModBiomes;
import net.timeworndevs.quantumadds.datagen.ModWorldGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
public class QuantumDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(ModWorldGenerator::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModModelProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::boostrap);
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}
