package com.dinoicy.armourcraft;

import com.dinoicy.armourcraft.init.BlockInitNew;
import com.dinoicy.armourcraft.init.ItemInitNew;
import com.dinoicy.armourcraft.init.RedCTileEntityTypes;
import com.dinoicy.armourcraft.objects.blocks.BlockRedMiner;
import com.dinoicy.armourcraft.tileentity.RedCTileEntity;
import com.dinoicy.armourcraft.world.gen.ArmourOreGen;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@Mod("armourcraft")
@Mod.EventBusSubscriber(modid = ArmourCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmourCraft
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "armourcraft";
    public static ArmourCraft instance;

    public ArmourCraft() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        ItemInitNew.ITEMS.register(modEventBus);
        BlockInitNew.BLOCKS.register(modEventBus);
        RedCTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }


    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockInitNew.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(ArmourCraft.TAB);
            final BlockItem blockitem = new BlockItem(block, properties);
            blockitem.setRegistryName(block.getRegistryName());
            registry.register(blockitem);
        });

        LOGGER.debug("Registered Block Items!");
    }

    private void setup(final FMLCommonSetupEvent event) { }

    private void doClientStuff(final FMLClientSetupEvent event) { }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
        ArmourOreGen.generateOre();
    }

    public static final ItemGroup TAB = new ItemGroup("armourCraftTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInitNew.red_diamond.get());
        }
    };

}
