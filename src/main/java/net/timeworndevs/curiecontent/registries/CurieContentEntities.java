package net.timeworndevs.curiecontent.registries;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.timeworndevs.curiecontent.CurieContent;
import net.timeworndevs.curiecontent.entities.custom.MonstrosityEntity;

public class CurieContentEntities {
    public static EntityType<MonstrosityEntity> MONSTROSITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CurieContent.MOD_ID, "monstrosity"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MonstrosityEntity::new).dimensions(EntityDimensions.fixed(1f, 1f)).build());
    
    public static void registerEntities() {
    }

}
