package net.timeworndevs.curiecontent.registries;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.timeworndevs.curiecontent.CurieContent;
import net.timeworndevs.curiecontent.block.HeavyTungstenBlock;
import net.timeworndevs.curiecontent.block.ReactorCore;

import java.util.ArrayList;

public class CurieContentBlocks {

    private static final ArrayList<Block> BLOCKS = new ArrayList<>();
    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        BLOCKS.add(block);
        return Registry.register(Registries.BLOCK, new Identifier(CurieContent.MOD_ID, name), block);
    }

    public static final Block TUNGSTEN_ORE = registerBlock("tungsten_ore", new Block(FabricBlockSettings.create().strength(4.5f)));
    public static final Block DEEPSLATE_TUNGSTEN_ORE = registerBlock("deepslate_tungsten_ore", new Block(FabricBlockSettings.create().strength(5.5f)));
    public static final Block TUNGSTEN_BLOCK = registerBlock("tungsten_block", new Block(FabricBlockSettings.create().strength(7.0f)));
    public static final Block HEAVY_TUNGSTEN_BLOCK = registerBlock("heavy_tungsten_block", new HeavyTungstenBlock(FabricBlockSettings.create().strength(7.0f)));

    public static final Block PLUTONIUM_ORE = registerBlock("plutonium_ore", new Block(FabricBlockSettings.create().strength(4.0f)));
    public static final Block DEEPSLATE_PLUTONIUM_ORE = registerBlock("deepslate_plutonium_ore", new Block(FabricBlockSettings.create().strength(5.0f)));
    //public static final Block PLUTONIUM_CORE = registerBlock("plutonium_core", new PlutoniumBlock(FabricBlockSettings.create().strength(4.0f))); GONNA UPDATE THIS SOME DAY IN THE FUTUREEEEEEEEEEEEEEEEEEEEEE

    public static final Block METEORITE_ROCK = registerBlock("meteorite_rock", new Block(FabricBlockSettings.create().strength(4.0f)));

    public static final Block WASTELAND_SOIL = registerBlock("wasteland_soil", new Block(FabricBlockSettings.create().strength(4.0f)));

    public static final Block REACTOR_CORE = registerBlock("reactor_core", new ReactorCore(FabricBlockSettings.create().strength(8f).nonOpaque().luminance(4)));

    public static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(CurieContent.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static final ItemGroup BUILDING_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(WASTELAND_SOIL))
            .displayName(Text.translatable("itemGroup.curie-api.building_blocks"))
            .entries((context, entries) -> {
                for (Block block : BLOCKS) {
                    entries.add(block);
                }
            })
            .build();

    public static void registerBlocks() {}
}
