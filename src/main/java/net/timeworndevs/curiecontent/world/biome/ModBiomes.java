package net.timeworndevs.curiecontent.world.biome;

import net.timeworndevs.curiecontent.CurieContent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.timeworndevs.curiecontent.registries.CurieContentEntities;

public class ModBiomes {
    public static RegistryKey<Biome> RADIATION_TEST = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(CurieContent.MOD_ID, "tomb_world"));

    public static void boostrap(Registerable<Biome> context)
    {
        context.register(RADIATION_TEST, testBiome(context));
        //context.register(GAIA_WORLD, gaiaBiome(context));
    }
    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static Biome testBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(CurieContentEntities.MONSTROSITY, 2, 5, 15));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 5, 1, 4));

        //DefaultBiomeFeatures.addFarmAnimals(spawnBuilder); we don't want em here
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x425e44)
                        .waterFogColor(0x528e56)
                        .skyColor(0x7c5f53)
                        .grassColor(0x494949)
                        .foliageColor(0x5e3d43)
                        .fogColor(0x4f6055)
                        .moodSound(BiomeMoodSound.CAVE)
//                        .music(MusicType.createIngameMusic(RegistryEntry.of(ModSounds.ROAR))) //own sounds in the future,,, maybe???
                        .build()).build();
    }

}
