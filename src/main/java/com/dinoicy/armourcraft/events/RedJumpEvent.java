package com.dinoicy.armourcraft.events;

import com.dinoicy.armourcraft.ArmourCraft;
import com.dinoicy.armourcraft.init.BlockInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

//@Mod.EventBusSubscriber(modid = ArmourCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
//public class RedJumpEvent {
    //@SubscribeEvent
    //public static void redJumpEvent(LivingEvent.LivingJumpEvent event) {
        //ArmourCraft.LOGGER.info("redJumpEvent fired");
        //LivingEntity livingEntity = event.getEntityLiving();
        //World world = livingEntity.getEntityWorld();
        //world.setBlockState(livingEntity.getPosition().add(0, 5, 0), BlockInit.red_diamond_block.getDefaultState());
        //livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 600, 255));
        //livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5000, 255));
        //livingEntity.setGlowing(true);
    //}
//}
