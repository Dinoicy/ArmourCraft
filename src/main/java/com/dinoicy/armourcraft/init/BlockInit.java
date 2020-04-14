package com.dinoicy.armourcraft.init;

import com.dinoicy.armourcraft.ArmourCraft;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.EventBus;
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

    public static final RegistryObject<Block> red_diamond_ore = BLOCKS.register("red_diamond_ore", () -> new Block(Block.Properties.create(Material.IRON)
            .hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)));

    public static final RegistryObject<Block> red_crafter = BLOCKS.register("red_crafter", () -> new Block(Block.Properties.create(Material.IRON)
            .hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3)));

    public static final RegistryObject<Block> red_miner = BLOCKS.register("red_miner", () -> new Block(Block.Properties.create(Material.IRON)
            .hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3)));

}
