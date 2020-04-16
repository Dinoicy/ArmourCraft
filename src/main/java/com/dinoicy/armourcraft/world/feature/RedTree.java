package com.dinoicy.armourcraft.world.feature;

import com.dinoicy.armourcraft.init.BlockInit;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class RedTree extends Tree {

    public static final TreeFeatureConfig RED_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockInit.RED_LOGS.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInit.RED_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(3).foliageHeight(4).ignoreVines()
            .setSapling((IPlantable) BlockInit.RED_SAPLING.get()).build();

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(RED_TREE_CONFIG);
    }
}
