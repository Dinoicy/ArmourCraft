package com.dinoicy.armourcraft.util;

import com.dinoicy.armourcraft.ArmourCraft;
import com.dinoicy.armourcraft.client.gui.RedChestScreen;
import com.dinoicy.armourcraft.init.ArmourContainerTypes;
import com.dinoicy.armourcraft.init.BlockInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ArmourCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ArmourContainerTypes.RED_CHEST.get(), RedChestScreen::new);
        RenderTypeLookup.setRenderLayer(BlockInit.RED_SAPLING.get(), RenderType.getCutout());
    }
}
