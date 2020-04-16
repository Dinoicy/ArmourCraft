package com.dinoicy.armourcraft.init;

import com.dinoicy.armourcraft.ArmourCraft;
import com.dinoicy.armourcraft.tileentity.RedChestTileEntity;
import com.dinoicy.armourcraft.tileentity.RedMTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ArmourTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, ArmourCraft.MOD_ID);

    public static final RegistryObject<TileEntityType<RedMTileEntity>> red_miner = TILE_ENTITY_TYPES
            .register("red_miner", () -> TileEntityType.Builder.create(RedMTileEntity::new, BlockInit.red_miner.get()).build(null));

    public static final RegistryObject<TileEntityType<RedChestTileEntity>> RED_CHEST = TILE_ENTITY_TYPES
            .register("red_chest", () -> TileEntityType.Builder.create(RedChestTileEntity::new, BlockInit.RED_CHEST.get()).build(null));
}
