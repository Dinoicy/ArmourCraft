package com.dinoicy.armourcraft.init;

import com.dinoicy.armourcraft.ArmourCraft;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = ArmourCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(ArmourCraft.MOD_ID)
public class ItemInit {

    //Items
    public static final Item red_diamond = null;

    //Tools
    public static final Item red_diamond_sword = null;
    public static final Item red_diamond_pickaxe = null;
    public static final Item red_diamond_shovel = null;
    public static final Item red_diamond_axe = null;
    public static final Item red_diamond_hoe = null;

    //Armour
    public static final Item red_diamond_helmet = null;
    public static final Item red_diamond_chestplate = null;
    public static final Item red_diamond_leggings = null;
    public static final Item red_diamond_boots = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {

        //Items
        event.getRegistry().register(new Item(new Item.Properties().group(ArmourCraft.TAB)).setRegistryName("red_diamond"));

        //Tools
        event.getRegistry().register(
                new SwordItem(RedDiamondTier.RED_DIAMOND_TIER, 4, -2.3f, new Item.Properties().group(ArmourCraft.TAB))
                        .setRegistryName("red_diamond_sword"));
        event.getRegistry().register(
                new PickaxeItem(RedDiamondTier.RED_DIAMOND_TIER, 1, -2.7f, new Item.Properties().group(ArmourCraft.TAB))
                        .setRegistryName("red_diamond_pickaxe"));
        event.getRegistry().register(
                new ShovelItem(RedDiamondTier.RED_DIAMOND_TIER, 1.5f, -2.9f, new Item.Properties().group(ArmourCraft.TAB))
                        .setRegistryName("red_diamond_shovel"));
        event.getRegistry().register(
                new AxeItem(RedDiamondTier.RED_DIAMOND_TIER, 5.0f, -2.9f, new Item.Properties().group(ArmourCraft.TAB))
                        .setRegistryName("red_diamond_axe"));
        event.getRegistry().register(
                new HoeItem(RedDiamondTier.RED_DIAMOND_TIER, 0.5f, new Item.Properties().group(ArmourCraft.TAB))
                        .setRegistryName("red_diamond_hoe"));

        //Armour
        event.getRegistry().register(new ArmorItem(RedDiamondArmorMaterial.RED_DIAMOND_ARMOR_MATERIAL, EquipmentSlotType.HEAD,
                new Item.Properties().group(ArmourCraft.TAB)).setRegistryName("red_diamond_helmet"));
        event.getRegistry().register(new ArmorItem(RedDiamondArmorMaterial.RED_DIAMOND_ARMOR_MATERIAL, EquipmentSlotType.CHEST,
                new Item.Properties().group(ArmourCraft.TAB)).setRegistryName("red_diamond_chestplate"));
        event.getRegistry().register(new ArmorItem(RedDiamondArmorMaterial.RED_DIAMOND_ARMOR_MATERIAL, EquipmentSlotType.LEGS,
                new Item.Properties().group(ArmourCraft.TAB)).setRegistryName("red_diamond_leggings"));
        event.getRegistry().register(new ArmorItem(RedDiamondArmorMaterial.RED_DIAMOND_ARMOR_MATERIAL, EquipmentSlotType.FEET,
                new Item.Properties().group(ArmourCraft.TAB)).setRegistryName("red_diamond_boots"));
    }

    public enum RedDiamondTier implements IItemTier {
        RED_DIAMOND_TIER(4, 2061, 8.0f, 3.0f, 12, () -> {
            return Ingredient.fromItems(ItemInit.red_diamond);
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        private RedDiamondTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }

    public enum RedDiamondArmorMaterial implements IArmorMaterial {
        RED_DIAMOND_ARMOR_MATERIAL(ArmourCraft.MOD_ID + ":red_diamond_armor_material",
                35, new int[] { 4, 7, 9, 4 }, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, () -> {
            return Ingredient.fromItems(ItemInit.red_diamond);
        });
        private static final int[] MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        private RedDiamondArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
                                        int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn,
                                        Supplier<Ingredient> repairMaterialIn) {
            this.name = nameIn;
            this.maxDamageFactor = maxDamageFactorIn;
            this.damageReductionAmountArray = damageReductionAmountIn;
            this.enchantability = enchantabilityIn;
            this.soundEvent = soundEventIn;
            this.toughness = toughnessIn;
            this.repairMaterial = new LazyValue<>(repairMaterialIn);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness() {
            return this.toughness;
        }
    }
}
