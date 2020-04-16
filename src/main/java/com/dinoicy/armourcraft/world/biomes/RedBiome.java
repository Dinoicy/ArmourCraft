package com.dinoicy.armourcraft.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class RedBiome extends Biome {

    public RedBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BAT, 10, 2, 6));
        this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.1428571f)));
        this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.02f)));
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addExtraGoldOre(this);
    }

}
