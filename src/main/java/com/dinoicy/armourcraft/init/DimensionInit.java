package com.dinoicy.armourcraft.init;

import com.dinoicy.armourcraft.ArmourCraft;
import com.dinoicy.armourcraft.world.dimension.RedModDimension;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {

    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, ArmourCraft.MOD_ID);

    public static final RegistryObject<ModDimension> RED_DIM = MOD_DIMENSIONS.register("red_dim", () -> new RedModDimension());
}
