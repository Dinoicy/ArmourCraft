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
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ArmourCraft.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    //Blocks
    public static final RegistryObject<Item> red_diamond_block = ITEMS.register("red_diamond_block", () -> new Item(new Item.Properties().group(ArmourCraft.TAB)));
    public static final RegistryObject<Item> red_diamond_ore = ITEMS.register("red_diamond_ore", () -> new Item(new Item.Properties().group(ArmourCraft.TAB)));
    public static final RegistryObject<Item> red_crafter = ITEMS.register("red_crafter", () -> new Item(new Item.Properties().group(ArmourCraft.TAB)));
    public static final RegistryObject<Item> red_miner = ITEMS.register("red_diamond", () -> new Item(new Item.Properties().group(ArmourCraft.TAB)));

    //Items
    public static final RegistryObject<Item> red_item = ITEMS.register("red_item", () -> new Item(new Item.Properties().group(ArmourCraft.TAB)));

    public static final RegistryObject<Item> red_diamond = ITEMS.register("red_diamond", () -> new Item(new Item.Properties().group(ArmourCraft.TAB)));

    //Tools
    public static final RegistryObject<Item> red_diamond_sword = ITEMS.register("red_diamond_sword", () ->
            new SwordItem(RedDiamondTier.RED_DIAMOND_TIER, 4, -2.3f, new Item.Properties().group(ArmourCraft.TAB)));

    public static final RegistryObject<Item> red_diamond_pickaxe = ITEMS.register("red_diamond_pickaxe", () ->
            new PickaxeItem(RedDiamondTier.RED_DIAMOND_TIER, 1, -2.7f, new Item.Properties().group(ArmourCraft.TAB)));

    public static final RegistryObject<Item> red_diamond_axe = ITEMS.register("red_diamond_axe", () ->
            new AxeItem(RedDiamondTier.RED_DIAMOND_TIER, 5.0f, -2.9f, new Item.Properties().group(ArmourCraft.TAB)));

    public static final RegistryObject<Item> red_diamond_shovel = ITEMS.register("red_diamond_shovel", () ->
            new ShovelItem(RedDiamondTier.RED_DIAMOND_TIER, 1.5f, -2.9f, new Item.Properties().group(ArmourCraft.TAB)));

    public static final RegistryObject<Item> red_diamond_hoe = ITEMS.register("red_diamond_hoe", () ->
            new HoeItem(RedDiamondTier.RED_DIAMOND_TIER, 0.5f, new Item.Properties().group(ArmourCraft.TAB)));

    //Armour
    public static final RegistryObject<Item> red_diamond_helmet = ITEMS.register("red_diamond_helmet", () ->
            new ArmorItem(RedDiamondArmorMaterial.RED_DIAMOND_ARMOR_MATERIAL, EquipmentSlotType.HEAD, new Item.Properties().group(ArmourCraft.TAB)));

    public static final RegistryObject<Item> red_diamond_chestplate = ITEMS.register("red_diamond_chestplate", () ->
            new ArmorItem(RedDiamondArmorMaterial.RED_DIAMOND_ARMOR_MATERIAL, EquipmentSlotType.CHEST, new Item.Properties().group(ArmourCraft.TAB)));

    public static final RegistryObject<Item> red_diamond_leggings = ITEMS.register("red_diamond_leggings", () ->
            new ArmorItem(RedDiamondArmorMaterial.RED_DIAMOND_ARMOR_MATERIAL, EquipmentSlotType.LEGS, new Item.Properties().group(ArmourCraft.TAB)));

    public static final RegistryObject<Item> red_diamond_boots = ITEMS.register("red_diamond_boots", () ->
            new ArmorItem(RedDiamondArmorMaterial.RED_DIAMOND_ARMOR_MATERIAL, EquipmentSlotType.FEET, new Item.Properties().group(ArmourCraft.TAB)));


    public enum RedDiamondTier implements IItemTier {
        RED_DIAMOND_TIER(4, 2061, 8.0f, 3.0f, 12, () -> {
            return Ingredient.fromItems(ItemInit.red_diamond.get());
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
            return Ingredient.fromItems(ItemInit.red_diamond.get());
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
