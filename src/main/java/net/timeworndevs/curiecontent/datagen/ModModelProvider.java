package net.timeworndevs.curiecontent.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.timeworndevs.curiecontent.registries.CurieContentBlocks;
import net.timeworndevs.curiecontent.registries.CurieContentItems;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(CurieContentBlocks.TUNGSTEN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(CurieContentBlocks.DEEPSLATE_TUNGSTEN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(CurieContentBlocks.TUNGSTEN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(CurieContentBlocks.PLUTONIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(CurieContentBlocks.DEEPSLATE_PLUTONIUM_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (Item item : CurieContentItems.allArmors) {
            itemModelGenerator.registerArmor((ArmorItem) item);
        }
    }
}
