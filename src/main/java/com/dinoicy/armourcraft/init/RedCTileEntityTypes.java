package com.dinoicy.armourcraft.init;

import com.dinoicy.armourcraft.ArmourCraft;
import com.dinoicy.armourcraft.tileentity.RedCTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;

public class RedCTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, ArmourCraft.MOD_ID);

    public static final RegistryObject<TileEntityType<RedCTileEntity>> red_miner = TILE_ENTITY_TYPES.register("red_miner", () -> TileEntityType.Builder.create(RedCTileEntity::new, BlockInitNew.red_miner.get()).build(null));
}
