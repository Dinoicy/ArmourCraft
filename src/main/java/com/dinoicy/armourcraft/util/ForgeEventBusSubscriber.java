package com.dinoicy.armourcraft.util;

import com.dinoicy.armourcraft.ArmourCraft;
import com.dinoicy.armourcraft.init.DimensionInit;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArmourCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubscriber {

    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event) {
        if(DimensionType.byName(ArmourCraft.RED_DIM_TYPE) == null) {
            DimensionManager.registerDimension(ArmourCraft.RED_DIM_TYPE, DimensionInit.RED_DIM.get(), null, true);
        }
        ArmourCraft.LOGGER.info("Dimensions Registered!");
    }
}
