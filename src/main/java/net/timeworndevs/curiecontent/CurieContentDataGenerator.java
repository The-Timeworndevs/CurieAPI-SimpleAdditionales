package net.timeworndevs.curiecontent;

import net.timeworndevs.curiecontent.datagen.ModItemTagProvider;
import net.timeworndevs.curiecontent.datagen.ModModelProvider;
import net.timeworndevs.curiecontent.world.CurieContentConfiguredFeatures;
import net.timeworndevs.curiecontent.world.CurieContentPlacedFeatures;
import net.timeworndevs.curiecontent.world.biome.ModBiomes;
import net.timeworndevs.curiecontent.datagen.ModWorldGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class CurieContentDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {

        CurieContent.LOGGER.info("Initializing CurieContentDataGenerator");
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(ModWorldGenerator::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModModelProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::boostrap);
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, CurieContentConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, CurieContentPlacedFeatures::bootstrap);
    }
}
