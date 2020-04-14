package com.dinoicy.armourcraft.init;

import com.dinoicy.armourcraft.ArmourCraft;
import com.dinoicy.armourcraft.tileentity.RedCTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RedCTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, ArmourCraft.MOD_ID);

    public static final RegistryObject<TileEntityType<RedCTileEntity>> red_miner = TILE_ENTITY_TYPES.register("red_miner", () -> TileEntityType.Builder.create(RedCTileEntity::new, BlockInit.red_miner.get()).build(null));
}
