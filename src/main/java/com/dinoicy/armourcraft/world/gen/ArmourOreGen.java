package com.dinoicy.armourcraft.world.gen;

import com.dinoicy.armourcraft.init.BlockInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ArmourOreGen {
    public static void generateOre() {
        for(Biome biome : ForgeRegistries.BIOMES) {
                ConfiguredPlacement customConfig = Placement.COUNT_RANGE
                        .configure(new CountRangeConfig(10, 5, 5, 17));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.red_diamond_ore.getDefaultState(), 7))
                        .withPlacement(customConfig));
        }
    }
}
