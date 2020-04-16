package com.dinoicy.armourcraft.world.dimension;

import com.dinoicy.armourcraft.init.BiomeInit;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.Random;
import java.util.Set;

public class RedBiomeProvider extends BiomeProvider {

    private Random rand;

    public RedBiomeProvider() {
        super(biomeList);
        rand = new Random();
    }

    private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.RED_BIOME.get());

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return BiomeInit.RED_BIOME.get();
    }
}
