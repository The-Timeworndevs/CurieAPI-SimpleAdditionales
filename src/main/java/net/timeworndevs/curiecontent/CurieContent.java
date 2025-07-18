package net.timeworndevs.curiecontent;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.timeworndevs.curiecontent.registries.*;
import net.timeworndevs.curiecontent.effect.QuantumEffects;
import net.timeworndevs.curiecontent.registries.CurieContentEntities;
import net.timeworndevs.curiecontent.entities.custom.MonstrosityEntity;
import net.timeworndevs.curiecontent.events.PlayerTickHandler;
import net.timeworndevs.curiecontent.registries.CurieContentItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.timeworndevs.curiecontent.registries.CurieContentItems.RADIATION;
import static net.timeworndevs.curiecontent.registries.CurieContentBlocks.BUILDING_BLOCKS;

public class CurieContent implements ModInitializer {

    public static final String MOD_ID = "curie-content";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Computing wave-functions...");
        CurieContentRadiationTypes.registerRadiationTypes();
        CurieContentBlocks.registerBlocks();
        QuantumEffects.registerEffects();

        //ModWorldGeneration.generateModWorldGen();

        CurieContentEntities.registerEntities();

        CurieContentItems.registerItems();


        LOGGER.info("Analyzing external dimensions...");

        ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());

        LOGGER.info("Testing radiation...");

        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "radiation"), RADIATION);
        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "building_blocks"), BUILDING_BLOCKS);
        FabricDefaultAttributeRegistry.register(CurieContentEntities.MONSTROSITY, MonstrosityEntity.createMonstrosityAttributes());

        LOGGER.info("Wormhole established!");
    }
}