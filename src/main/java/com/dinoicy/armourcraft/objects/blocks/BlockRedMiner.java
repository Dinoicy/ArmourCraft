package com.dinoicy.armourcraft.objects.blocks;

import com.dinoicy.armourcraft.init.RedCTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockRedMiner extends Block {

    public BlockRedMiner(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return RedCTileEntityTypes.red_miner.get().create();
    }
}
