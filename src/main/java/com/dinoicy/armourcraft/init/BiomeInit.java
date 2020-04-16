package com.dinoicy.armourcraft.init;

import com.dinoicy.armourcraft.ArmourCraft;
import com.dinoicy.armourcraft.world.biomes.RedBiome;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, ArmourCraft.MOD_ID);

    public static final RegistryObject<Biome> RED_BIOME = BIOMES.register("red_biome", () ->
            new RedBiome(new Biome.Builder().precipitation(Biome.RainType.RAIN).scale(1.2f).temperature(0.0f)
                    .waterColor(10092544).waterFogColor(10193032)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(BlockInit.red_diamond_block.get().getDefaultState(),
                            BlockInit.red_diamond_ore.get().getDefaultState(),
                                    Blocks.COAL_BLOCK.getDefaultState())).category(Biome.Category.FOREST)
                    .downfall(0.1f).depth(0.125f).parent(null)));

    public static void registerBiomes() {
        registerBiome(RED_BIOME.get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
    }

    private static void registerBiome(Biome biome, BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));
    }
}
