package com.dinoicy.armourcraft.init;

import com.dinoicy.armourcraft.ArmourCraft;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(ArmourCraft.MOD_ID)
@Mod.EventBusSubscriber(modid = ArmourCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    public static final Block red_diamond_block = null;
    public static final Block red_diamond_ore = null;
    public static final Block red_crafter = null;
    public static final Block red_miner = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("red_diamond_block"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("red_diamond_ore"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("red_crafter"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("red_miner"));
    }
    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItem(red_diamond_block, new Item.Properties().group(ArmourCraft.TAB)).setRegistryName("red_diamond_block"));
        event.getRegistry().register(new BlockItem(red_diamond_ore, new Item.Properties().group(ArmourCraft.TAB)).setRegistryName("red_diamond_ore"));
        event.getRegistry().register(new BlockItem(red_crafter, new Item.Properties().group(ArmourCraft.TAB)).setRegistryName("red_crafter"));
        event.getRegistry().register(new BlockItem(red_miner, new Item.Properties().group(ArmourCraft.TAB)).setRegistryName("red_miner"));
    }
}
