package com.dinoicy.armourcraft.init;

import com.dinoicy.armourcraft.ArmourCraft;
import com.dinoicy.armourcraft.container.RedChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ArmourContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, ArmourCraft.MOD_ID);

    public static final RegistryObject<ContainerType<RedChestContainer>> RED_CHEST = CONTAINER_TYPES
            .register("red_chest", () -> IForgeContainerType.create(RedChestContainer::new));
}
