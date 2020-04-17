package com.dinoicy.armourcraft.init;

import com.dinoicy.armourcraft.ArmourCraft;
import com.dinoicy.armourcraft.objects.blocks.*;
import com.dinoicy.armourcraft.world.feature.RedTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ArmourCraft.MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Block> red_diamond_block = BLOCKS.register("red_diamond_block", () -> new Block(Block.Properties.create(Material.IRON)
            .hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3)));

    public static final RegistryObject<Block> red_diamond_ore = BLOCKS.register("red_diamond_ore", () -> new Block(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)));

    public static final RegistryObject<Block> red_crafter = BLOCKS.register("red_crafter", () -> new Block(Block.Properties.create(Material.IRON)
            .hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3)));

    public static final RegistryObject<Block> red_miner = BLOCKS.register("red_miner", () -> new BlockRedMiner(Block.Properties.create(Material.IRON)
            .hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3)));

    public static final RegistryObject<Block> RED_CHEST = BLOCKS.register("red_chest", () -> new RedChestBlock(Block.Properties.from(BlockInit.red_diamond_block.get())));

    public static final RegistryObject<Block> RED_PLANKS = BLOCKS.register("red_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> RED_LOGS = BLOCKS.register("red_logs", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> RED_LEAVES = BLOCKS.register("red_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> RED_SAPLING = BLOCKS.register("red_sapling", () -> new ArmourSaplingBlock(() -> new RedTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> RED_PLANKS_STAIRS = BLOCKS.register("red_planks_stairs", () -> new StairsBlock(() -> BlockInit.RED_PLANKS
            .get().getDefaultState(), Block.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> RED_PLANKS_FENCE = BLOCKS.register("red_planks_fence", () -> new FenceBlock(Block.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> RED_PLANKS_BUTTON = BLOCKS.register("red_planks_button", () -> new RedWoodButtonBlock(Block.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> RED_PLANKS_PRESSURE_PLATE = BLOCKS.register("red_planks_pressure_plate", () -> new RedPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PLANKS)));
}
