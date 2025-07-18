package net.timeworndevs.curiecontent.registries;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.timeworndevs.curiecontent.CurieContent;
import net.timeworndevs.curiecontent.item.geiger_counter.GeigerCounter;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.timeworndevs.curiecontent.item.HazmatSuitItem;
import net.timeworndevs.curiecontent.item.ModArmorMaterials;
import net.timeworndevs.curiecontent.item.ModFood;

public class CurieContentItems {

    public static final Item RED_PILL = registerItem("red_pill", new Item(new FabricItemSettings().food(ModFood.SUSPICIOUS_PILL)));
    public static final Item BLUE_PILL = registerItem("blue_pill", new Item(new FabricItemSettings().food(ModFood.MEDICAL_PILL)));

    public static final Item GEIGER_COUNTER = registerItem("geiger_counter", new GeigerCounter(new FabricItemSettings().maxCount(1).maxDamage(64).rarity(Rarity.RARE)));

    public static final Item PLUTONIUM = registerItem("plutonium", new Item(new FabricItemSettings()));

    public static Item RAW_TUNGSTEN = registerItem("raw_tungsten", new Item(new FabricItemSettings()));

    public static Item TUNGSTEN_INGOT = registerItem("tungsten_ingot", new Item(new FabricItemSettings()));

    public static final Item ALPHA_SRC = registerItem("alphasrc", new Item(new FabricItemSettings()));
    public static final Item BETA_SRC = registerItem("betasrc", new Item(new FabricItemSettings()));
    public static final Item GAMMA_SRC = registerItem("gammasrc", new Item(new FabricItemSettings()));

    public static final Item HAZMATD_HELMET = registerItem("hazmatd_helmet", new HazmatSuitItem(ModArmorMaterials.HAZMATD, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.RARE), "hazmatd"));
    public static final Item HAZMATD_CHESTPLATE = registerItem("hazmatd_chestplate", new HazmatSuitItem(ModArmorMaterials.HAZMATD, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.RARE), "hazmatd"));
    public static final Item HAZMATD_LEGGINGS = registerItem("hazmatd_leggings", new HazmatSuitItem(ModArmorMaterials.HAZMATD, ArmorItem.Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.RARE), "hazmatd"));
    public static final Item HAZMATD_BOOTS = registerItem("hazmatd_boots", new HazmatSuitItem(ModArmorMaterials.HAZMATD, ArmorItem.Type.BOOTS, new FabricItemSettings().rarity(Rarity.RARE), "hazmatd"));

    public static final Item HAZMATC_HELMET = registerItem("hazmatc_helmet", new HazmatSuitItem(ModArmorMaterials.HAZMATC, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.RARE), "hazmatc"));
    public static final Item HAZMATC_CHESTPLATE = registerItem("hazmatc_chestplate", new HazmatSuitItem(ModArmorMaterials.HAZMATC, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.RARE), "hazmatc"));
    public static final Item HAZMATC_LEGGINGS = registerItem("hazmatc_leggings", new HazmatSuitItem(ModArmorMaterials.HAZMATC, ArmorItem.Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.RARE), "hazmatc"));
    public static final Item HAZMATC_BOOTS = registerItem("hazmatc_boots", new HazmatSuitItem(ModArmorMaterials.HAZMATC, ArmorItem.Type.BOOTS, new FabricItemSettings().rarity(Rarity.RARE), "hazmatc"));

    public static final Item HAZMATB_HELMET = registerItem("hazmatb_helmet", new HazmatSuitItem(ModArmorMaterials.HAZMATB, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.RARE), "hazmatb"));
    public static final Item HAZMATB_CHESTPLATE = registerItem("hazmatb_chestplate", new HazmatSuitItem(ModArmorMaterials.HAZMATB, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.RARE), "hazmatb"));
    public static final Item HAZMATB_LEGGINGS = registerItem("hazmatb_leggings", new HazmatSuitItem(ModArmorMaterials.HAZMATB, ArmorItem.Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.RARE), "hazmatb"));
    public static final Item HAZMATB_BOOTS = registerItem("hazmatb_boots", new HazmatSuitItem(ModArmorMaterials.HAZMATB, ArmorItem.Type.BOOTS, new FabricItemSettings().rarity(Rarity.RARE), "hazmatb"));

    public static final Item HAZMATA_HELMET = registerItem("hazmata_helmet", new HazmatSuitItem(ModArmorMaterials.HAZMATA, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.RARE), "hazmata"));
    public static final Item HAZMATA_CHESTPLATE = registerItem("hazmata_chestplate", new HazmatSuitItem(ModArmorMaterials.HAZMATA, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.RARE), "hazmata"));
    public static final Item HAZMATA_LEGGINGS = registerItem("hazmata_leggings", new HazmatSuitItem(ModArmorMaterials.HAZMATA, ArmorItem.Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.RARE), "hazmata"));
    public static final Item HAZMATA_BOOTS = registerItem("hazmata_boots", new HazmatSuitItem(ModArmorMaterials.HAZMATA, ArmorItem.Type.BOOTS, new FabricItemSettings().rarity(Rarity.RARE), "hazmata"));

    public static final Item[] allArmors = {HAZMATD_BOOTS, HAZMATD_LEGGINGS, HAZMATD_CHESTPLATE, HAZMATD_HELMET, HAZMATC_BOOTS, HAZMATC_LEGGINGS, HAZMATC_CHESTPLATE, HAZMATC_HELMET,
            HAZMATB_BOOTS, HAZMATB_LEGGINGS, HAZMATB_CHESTPLATE, HAZMATB_HELMET, HAZMATA_BOOTS, HAZMATA_LEGGINGS, HAZMATA_CHESTPLATE, HAZMATA_HELMET};

    public static Item RUBBER = registerItem("rubber", new Item(new FabricItemSettings()));
    public static Item PVC = registerItem("pvc", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CurieContent.MOD_ID, name), item);
    }

    public static void registerItems() {}

    public static final ItemGroup RADIATION = FabricItemGroup.builder()
        .icon(() -> new ItemStack(CurieContentItems.GEIGER_COUNTER))
        .displayName(Text.translatable("itemGroup.curie-content.radiation"))
        .entries((context, entries) -> {
            entries.add(GEIGER_COUNTER);
            entries.add(RUBBER);
            entries.add(PVC);

            entries.add(PLUTONIUM);
            entries.add(RAW_TUNGSTEN);
            entries.add(TUNGSTEN_INGOT);

            for(Item i : allArmors) {
                entries.add(i);
            }

            entries.add(RED_PILL);
            entries.add(BLUE_PILL);
        })
        .build();
}
