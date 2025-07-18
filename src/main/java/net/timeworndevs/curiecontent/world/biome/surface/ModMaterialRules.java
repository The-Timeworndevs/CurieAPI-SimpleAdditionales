package net.timeworndevs.curiecontent.world.biome.surface;

import net.timeworndevs.curiecontent.registries.CurieContentBlocks;
import net.timeworndevs.curiecontent.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule RAW_X = makeStateRule(CurieContentBlocks.WASTELAND_SOIL);
    private static final MaterialRules.MaterialRule METEORITE = makeStateRule(CurieContentBlocks.METEORITE_ROCK); // - X is a placeholder dw im not implementing twitter ore

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.RADIATION_TEST),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, RAW_X)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, METEORITE)),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}