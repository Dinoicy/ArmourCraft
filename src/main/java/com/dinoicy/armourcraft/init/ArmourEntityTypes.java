package com.dinoicy.armourcraft.init;

import com.dinoicy.armourcraft.ArmourCraft;
import com.dinoicy.armourcraft.entities.RedAnimalEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ArmourEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, ArmourCraft.MOD_ID);

    public static final RegistryObject<EntityType<RedAnimalEntity>> RED_ANIMAL_ENTITY = ENTITY_TYPES
            .register("red_animal_entity",
                    () -> EntityType.Builder.<RedAnimalEntity>create(RedAnimalEntity::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(ArmourCraft.MOD_ID, "red_animal_entity").toString()));
}
