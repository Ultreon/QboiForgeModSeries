package com.qtech.forgemods.tools;

import com.qsoftware.modlib.silentlib.registry.ItemRegistryObject;
import com.qtech.forgemods.core.modules.items.objects.advanced.AdvancedBowItem;
import com.qtech.forgemods.core.modules.ui.ModItemGroups;
import com.qtech.forgemods.core.util.builder.ArmorMaterial;
import com.qtech.forgemods.core.util.builder.ItemTier;
import com.qtech.forgemods.materials.MaterialsItems;
import com.qtech.forgemods.materials.items.EnderSwordItem;
import com.qtech.forgemods.materials.items.FireSwordItem;
import com.qtech.forgemods.tools.items.tools.Tools;
import lombok.experimental.UtilityClass;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvents;

import java.util.function.Supplier;

@UtilityClass
@SuppressWarnings("unused")
public final class ToolsItems {
    static {
        Tools.registerItems();
    }

    // Bows
    public static final ItemRegistryObject<AdvancedBowItem> BLAZE_BOW = register("blaze_bow", () -> new AdvancedBowItem(new Item.Properties().group(ModItemGroups.FLETCHING), 6.25f, 1.0f, 6, 1, true));
    public static final ItemRegistryObject<AdvancedBowItem> ICE_BOW =   register("ice_bow", () -> new AdvancedBowItem(new Item.Properties().group(ModItemGroups.FLETCHING), 2f, 1.0f, 8, 2));

    public static final ItemRegistryObject<FireSwordItem> FIRE_SWORD = register("fire_sword", () -> new FireSwordItem(net.minecraft.item.ItemTier.IRON, 3, -3.5f, new Item.Properties().group(ModItemGroups.SPECIALS).rarity(Rarity.EPIC)));
    public static final ItemRegistryObject<EnderSwordItem> ENDER_SWORD = register("ender_sword", () -> new EnderSwordItem(net.minecraft.item.ItemTier.IRON, 3, -1.9f, new Item.Properties().group(ModItemGroups.SPECIALS).rarity(Rarity.EPIC)));

    // Armor materials
    public static final IArmorMaterial rubyArmorMaterial = ArmorMaterial.builder()
            .name(QFMTools.modId + ":ruby")
            .maxDamageFactor(24)
            .damageReduction(new int[]{3, 6, 8, 4})
            .enchantability(14)
            .knockbackResistance(1f)
            .sound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND)
            .toughness(2.0F)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.RUBY.get()))
            .build();
    public static final IArmorMaterial amethystArmorMaterial = ArmorMaterial.builder()
            .name(QFMTools.modId + ":amethyst")
            .maxDamageFactor(21)
            .damageReduction(new int[]{2, 5, 7, 3})
            .enchantability(31)
            .knockbackResistance(1f)
            .sound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND)
            .toughness(2.0F)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.AMETHYST.get()))
            .build();
    public static final IArmorMaterial aquamarineArmorMaterial = ArmorMaterial.builder()
            .name(QFMTools.modId + ":aquamarine")
            .maxDamageFactor(21)
            .damageReduction(new int[]{2, 4, 6, 2})
            .enchantability(31)
            .knockbackResistance(1f)
            .sound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND)
            .toughness(2.0F)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.AQUAMARINE.get()))
            .build();
    public static final IArmorMaterial saphireArmorMaterial = ArmorMaterial.builder()
            .name(QFMTools.modId + ":saphire")
            .maxDamageFactor(21)
            .damageReduction(new int[]{2, 4, 6, 2})
            .enchantability(31)
            .knockbackResistance(1f)
            .sound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND)
            .toughness(2.0F)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.SAPHIRE.get()))
            .build();
    public static final IArmorMaterial malachiteArmorMaterial = ArmorMaterial.builder()
            .name(QFMTools.modId + ":malachite")
            .maxDamageFactor(21)
            .damageReduction(new int[]{2, 4, 6, 2})
            .enchantability(31)
            .knockbackResistance(1f)
            .sound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND)
            .toughness(2.0F)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.MALACHITE.get()))
            .build();
    public static final IArmorMaterial topazArmorMaterial = ArmorMaterial.builder()
            .name(QFMTools.modId + ":topaz")
            .maxDamageFactor(21)
            .damageReduction(new int[]{2, 4, 6, 2})
            .enchantability(31)
            .knockbackResistance(1f)
            .sound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND)
            .toughness(2.0F)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.TOPAZ.get()))
            .build();
    public static final IArmorMaterial amberArmorMaterial = ArmorMaterial.builder()
            .name(QFMTools.modId + ":amber")
            .maxDamageFactor(21)
            .damageReduction(new int[]{2, 4, 6, 2})
            .enchantability(31)
            .knockbackResistance(1f)
            .sound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND)
            .toughness(2.0F)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.AMBER.get()))
            .build();
    public static final IArmorMaterial berylArmorMaterial = ArmorMaterial.builder()
            .name(QFMTools.modId + ":beryl")
            .maxDamageFactor(21)
            .damageReduction(new int[]{2, 4, 6, 2})
            .enchantability(31)
            .knockbackResistance(1f)
            .sound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND)
            .toughness(2.0F)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.BERYL.get()))
            .build();
    public static final IArmorMaterial tanzaniteArmorMaterial = ArmorMaterial.builder()
            .name(QFMTools.modId + ":tanzanite")
            .maxDamageFactor(19)
            .damageReduction(new int[]{3, 6, 8, 3})
            .enchantability(48)
            .knockbackResistance(1f)
            .sound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND)
            .toughness(2.0F)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.TANZANITE.get()))
            .build();

    // Item tiers
    public static final IItemTier RUBY_ITEM_TIER = ItemTier.builder()
            .tier(3).maxUses(970).efficiency(7.6f).attackDamage(3.6f).enchantability(13)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.RUBY)).build();
    public static final IItemTier AMETHYST_ITEM_TIER = ItemTier.builder()
            .tier(2).maxUses(650).efficiency(7.3f).attackDamage(3.1f).enchantability(31)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.AMETHYST)).build();
    public static final IItemTier AQUAMARINE_ITEM_TIER = ItemTier.builder()
            .tier(2).maxUses(740).efficiency(5.3f).attackDamage(2.6f).enchantability(23)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.AQUAMARINE)).build();
    public static final IItemTier SAPHIRE_ITEM_TIER = ItemTier.builder()
            .tier(2).maxUses(810).efficiency(5.2f).attackDamage(2.5f).enchantability(29)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.SAPHIRE)).build();
    public static final IItemTier MALACHITE_ITEM_TIER = ItemTier.builder()
            .tier(2).maxUses(670).efficiency(4.3f).attackDamage(3.2f).enchantability(12)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.MALACHITE)).build();
    public static final IItemTier TOPAZ_ITEM_TIER = ItemTier.builder()
            .tier(1).maxUses(665).efficiency(4.4f).attackDamage(3.9f).enchantability(17)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.TOPAZ)).build();
    public static final IItemTier AMBER_ITEM_TIER = ItemTier.builder()
            .tier(2).maxUses(670).efficiency(3.9f).attackDamage(3.1f).enchantability(16)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.AMBER)).build();
    public static final IItemTier BERYL_ITEM_TIER = ItemTier.builder()
            .tier(2).maxUses(730).efficiency(4.8f).attackDamage(3.5f).enchantability(11)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.BERYL)).build();
    public static final IItemTier TANZANITE_ITEM_TIER = ItemTier.builder()
            .tier(3).maxUses(1090).efficiency(7.7f).attackDamage(3.5f).enchantability(48)
            .repairMaterial(() -> Ingredient.fromItems(MaterialsItems.TANZANITE)).build();

    // Tools - Vanilla
    public static final ItemRegistryObject<AxeItem> WOODEN_BATTLEAXE = register("wooden_battleaxe", () -> new AxeItem(net.minecraft.item.ItemTier.WOOD, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> STONE_BATTLEAXE = register("stone_battleaxe", () -> new AxeItem(net.minecraft.item.ItemTier.STONE, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> GOLDEN_BATTLEAXE = register("golden_battleaxe", () -> new AxeItem(net.minecraft.item.ItemTier.GOLD, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> IRON_BATTLEAXE = register("iron_battleaxe", () -> new AxeItem(net.minecraft.item.ItemTier.IRON, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> DIAMOND_BATTLEAXE = register("diamond_battleaxe", () -> new AxeItem(net.minecraft.item.ItemTier.DIAMOND, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> NETHERITE_BATTLEAXE = register("netherite_battleaxe", () -> new AxeItem(net.minecraft.item.ItemTier.NETHERITE, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));

    // Armors - Ruby
    public static final ItemRegistryObject<ArmorItem> RUBY_HELMET = register("ruby_helmet", () -> new ArmorItem(rubyArmorMaterial, EquipmentSlotType.HEAD, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> RUBY_CHESTPLATE = register("ruby_chestplate", () -> new ArmorItem(rubyArmorMaterial, EquipmentSlotType.CHEST, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> RUBY_LEGGINGS = register("ruby_leggings", () -> new ArmorItem(rubyArmorMaterial, EquipmentSlotType.LEGS, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> RUBY_BOOTS = register("ruby_boots", () -> new ArmorItem(rubyArmorMaterial, EquipmentSlotType.FEET, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<SwordItem> RUBY_SWORD = register("ruby_sword", () -> new SwordItem(RUBY_ITEM_TIER, 3, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<PickaxeItem> RUBY_PICKAXE = register("ruby_pickaxe", () -> new PickaxeItem(RUBY_ITEM_TIER, 1, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ShovelItem> RUBY_SHOVEL = register("ruby_shovel", () -> new ShovelItem(RUBY_ITEM_TIER, 1.5F, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> RUBY_AXE = register("ruby_axe", () -> new AxeItem(RUBY_ITEM_TIER, 6.0F, -2.4f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> RUBY_BATTLEAXE = register("ruby_battleaxe", () -> new AxeItem(RUBY_ITEM_TIER, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<HoeItem> RUBY_HOE = register("ruby_hoe", () -> new HoeItem(RUBY_ITEM_TIER, 2, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));

    // Armors - Amethyst
    public static final ItemRegistryObject<ArmorItem> AMETHYST_HELMET = register("amethyst_helmet", () -> new ArmorItem(amethystArmorMaterial, EquipmentSlotType.HEAD, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> AMETHYST_CHESTPLATE = register("amethyst_chestplate", () -> new ArmorItem(amethystArmorMaterial, EquipmentSlotType.CHEST, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> AMETHYST_LEGGINGS = register("amethyst_leggings", () -> new ArmorItem(amethystArmorMaterial, EquipmentSlotType.LEGS, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> AMETHYST_BOOTS = register("amethyst_boots", () -> new ArmorItem(amethystArmorMaterial, EquipmentSlotType.FEET, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<SwordItem> AMETHYST_SWORD = register("amethyst_sword", () -> new SwordItem(AMETHYST_ITEM_TIER, 3, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<PickaxeItem> AMETHYST_PICKAXE = register("amethyst_pickaxe", () -> new PickaxeItem(AMETHYST_ITEM_TIER, 1, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ShovelItem> AMETHYST_SHOVEL = register("amethyst_shovel", () -> new ShovelItem(AMETHYST_ITEM_TIER, 1.5F, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> AMETHYST_AXE = register("amethyst_axe", () -> new AxeItem(AMETHYST_ITEM_TIER, 6.0F, -2.4f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> AMETHYST_BATTLEAXE = register("amethyst_battleaxe", () -> new AxeItem(AMETHYST_ITEM_TIER, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<HoeItem> AMETHYST_HOE = register("amethyst_hoe", () -> new HoeItem(AMETHYST_ITEM_TIER, 1, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));

    // Armors - Aquamarine
    public static final ItemRegistryObject<ArmorItem> AQUAMARINE_HELMET = register("aquamarine_helmet", () -> new ArmorItem(aquamarineArmorMaterial, EquipmentSlotType.HEAD, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> AQUAMARINE_CHESTPLATE = register("aquamarine_chestplate", () -> new ArmorItem(aquamarineArmorMaterial, EquipmentSlotType.CHEST, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> AQUAMARINE_LEGGINGS = register("aquamarine_leggings", () -> new ArmorItem(aquamarineArmorMaterial, EquipmentSlotType.LEGS, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> AQUAMARINE_BOOTS = register("aquamarine_boots", () -> new ArmorItem(aquamarineArmorMaterial, EquipmentSlotType.FEET, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<SwordItem> AQUAMARINE_SWORD = register("aquamarine_sword", () -> new SwordItem(AQUAMARINE_ITEM_TIER, 3, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<PickaxeItem> AQUAMARINE_PICKAXE = register("aquamarine_pickaxe", () -> new PickaxeItem(AQUAMARINE_ITEM_TIER, 1, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ShovelItem> AQUAMARINE_SHOVEL = register("aquamarine_shovel", () -> new ShovelItem(AQUAMARINE_ITEM_TIER, 1.5F, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> AQUAMARINE_AXE = register("aquamarine_axe", () -> new AxeItem(AQUAMARINE_ITEM_TIER, 6.0F, -2.4f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> AQUAMARINE_BATTLEAXE = register("aquamarine_battleaxe", () -> new AxeItem(AQUAMARINE_ITEM_TIER, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<HoeItem> AQUAMARINE_HOE = register("aquamarine_hoe", () -> new HoeItem(AQUAMARINE_ITEM_TIER, 1, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));

    // Armors - Saphire
    public static final ItemRegistryObject<ArmorItem> SAPHIRE_HELMET = register("saphire_helmet", () -> new ArmorItem(saphireArmorMaterial, EquipmentSlotType.HEAD, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> SAPHIRE_CHESTPLATE = register("saphire_chestplate", () -> new ArmorItem(saphireArmorMaterial, EquipmentSlotType.CHEST, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> SAPHIRE_LEGGINGS = register("saphire_leggings", () -> new ArmorItem(saphireArmorMaterial, EquipmentSlotType.LEGS, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> SAPHIRE_BOOTS = register("saphire_boots", () -> new ArmorItem(saphireArmorMaterial, EquipmentSlotType.FEET, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<SwordItem> SAPHIRE_SWORD = register("saphire_sword", () -> new SwordItem(SAPHIRE_ITEM_TIER, 3, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<PickaxeItem> SAPHIRE_PICKAXE = register("saphire_pickaxe", () -> new PickaxeItem(SAPHIRE_ITEM_TIER, 1, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ShovelItem> SAPHIRE_SHOVEL = register("saphire_shovel", () -> new ShovelItem(SAPHIRE_ITEM_TIER, 1.5F, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> SAPHIRE_AXE = register("saphire_axe", () -> new AxeItem(SAPHIRE_ITEM_TIER, 6.0F, -2.4f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> SAPHIRE_BATTLEAXE = register("saphire_battleaxe", () -> new AxeItem(SAPHIRE_ITEM_TIER, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<HoeItem> SAPHIRE_HOE = register("saphire_hoe", () -> new HoeItem(SAPHIRE_ITEM_TIER, 1, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));

    // Armors - Malachite
    public static final ItemRegistryObject<ArmorItem> MALACHITE_HELMET = register("malachite_helmet", () -> new ArmorItem(malachiteArmorMaterial, EquipmentSlotType.HEAD, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> MALACHITE_CHESTPLATE = register("malachite_chestplate", () -> new ArmorItem(malachiteArmorMaterial, EquipmentSlotType.CHEST, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> MALACHITE_LEGGINGS = register("malachite_leggings", () -> new ArmorItem(malachiteArmorMaterial, EquipmentSlotType.LEGS, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> MALACHITE_BOOTS = register("malachite_boots", () -> new ArmorItem(malachiteArmorMaterial, EquipmentSlotType.FEET, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<SwordItem> MALACHITE_SWORD = register("malachite_sword", () -> new SwordItem(MALACHITE_ITEM_TIER, 3, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<PickaxeItem> MALACHITE_PICKAXE = register("malachite_pickaxe", () -> new PickaxeItem(MALACHITE_ITEM_TIER, 1, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ShovelItem> MALACHITE_SHOVEL = register("malachite_shovel", () -> new ShovelItem(MALACHITE_ITEM_TIER, 1.5F, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> MALACHITE_AXE = register("malachite_axe", () -> new AxeItem(MALACHITE_ITEM_TIER, 6.0F, -2.4f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> MALACHITE_BATTLEAXE = register("malachite_battleaxe", () -> new AxeItem(MALACHITE_ITEM_TIER, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<HoeItem> MALACHITE_HOE = register("malachite_hoe", () -> new HoeItem(MALACHITE_ITEM_TIER, 1, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));

    // Armors - Topaz
    public static final ItemRegistryObject<ArmorItem> TOPAZ_HELMET = register("topaz_helmet", () -> new ArmorItem(topazArmorMaterial, EquipmentSlotType.HEAD, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> TOPAZ_CHESTPLATE = register("topaz_chestplate", () -> new ArmorItem(topazArmorMaterial, EquipmentSlotType.CHEST, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> TOPAZ_LEGGINGS = register("topaz_leggings", () -> new ArmorItem(topazArmorMaterial, EquipmentSlotType.LEGS, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> TOPAZ_BOOTS = register("topaz_boots", () -> new ArmorItem(topazArmorMaterial, EquipmentSlotType.FEET, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<SwordItem> TOPAZ_SWORD = register("topaz_sword", () -> new SwordItem(TOPAZ_ITEM_TIER, 3, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<PickaxeItem> TOPAZ_PICKAXE = register("topaz_pickaxe", () -> new PickaxeItem(TOPAZ_ITEM_TIER, 1, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ShovelItem> TOPAZ_SHOVEL = register("topaz_shovel", () -> new ShovelItem(TOPAZ_ITEM_TIER, 1.5F, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> TOPAZ_AXE = register("topaz_axe", () -> new AxeItem(TOPAZ_ITEM_TIER, 6.0F, -2.4f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> TOPAZ_BATTLEAXE = register("topaz_battleaxe", () -> new AxeItem(TOPAZ_ITEM_TIER, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<HoeItem> TOPAZ_HOE = register("topaz_hoe", () -> new HoeItem(TOPAZ_ITEM_TIER, 1, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));

    // Armors - Amber
    public static final ItemRegistryObject<ArmorItem> AMBER_HELMET = register("amber_helmet", () -> new ArmorItem(amberArmorMaterial, EquipmentSlotType.HEAD, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> AMBER_CHESTPLATE = register("amber_chestplate", () -> new ArmorItem(amberArmorMaterial, EquipmentSlotType.CHEST, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> AMBER_LEGGINGS = register("amber_leggings", () -> new ArmorItem(amberArmorMaterial, EquipmentSlotType.LEGS, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> AMBER_BOOTS = register("amber_boots", () -> new ArmorItem(amberArmorMaterial, EquipmentSlotType.FEET, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<SwordItem> AMBER_SWORD = register("amber_sword", () -> new SwordItem(AMBER_ITEM_TIER, 3, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<PickaxeItem> AMBER_PICKAXE = register("amber_pickaxe", () -> new PickaxeItem(AMBER_ITEM_TIER, 1, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ShovelItem> AMBER_SHOVEL = register("amber_shovel", () -> new ShovelItem(AMBER_ITEM_TIER, 1.5F, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> AMBER_AXE = register("amber_axe", () -> new AxeItem(AMBER_ITEM_TIER, 6.0F, -2.4f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> AMBER_BATTLEAXE = register("amber_battleaxe", () -> new AxeItem(AMBER_ITEM_TIER, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<HoeItem> AMBER_HOE = register("amber_hoe", () -> new HoeItem(AMBER_ITEM_TIER, 1, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));

    // Armors - Beryl
    public static final ItemRegistryObject<ArmorItem> BERYL_HELMET = register("beryl_helmet", () -> new ArmorItem(berylArmorMaterial, EquipmentSlotType.HEAD, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> BERYL_CHESTPLATE = register("beryl_chestplate", () -> new ArmorItem(berylArmorMaterial, EquipmentSlotType.CHEST, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> BERYL_LEGGINGS = register("beryl_leggings", () -> new ArmorItem(berylArmorMaterial, EquipmentSlotType.LEGS, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> BERYL_BOOTS = register("beryl_boots", () -> new ArmorItem(berylArmorMaterial, EquipmentSlotType.FEET, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<SwordItem> BERYL_SWORD = register("beryl_sword", () -> new SwordItem(BERYL_ITEM_TIER, 3, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<PickaxeItem> BERYL_PICKAXE = register("beryl_pickaxe", () -> new PickaxeItem(BERYL_ITEM_TIER, 1, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ShovelItem> BERYL_SHOVEL = register("beryl_shovel", () -> new ShovelItem(BERYL_ITEM_TIER, 1.5F, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> BERYL_AXE = register("beryl_axe", () -> new AxeItem(BERYL_ITEM_TIER, 6.0F, -2.4f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> BERYL_BATTLEAXE = register("beryl_battleaxe", () -> new AxeItem(BERYL_ITEM_TIER, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<HoeItem> BERYL_HOE = register("beryl_hoe", () -> new HoeItem(BERYL_ITEM_TIER, 1, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));

    // Armors - Tanzanite
    public static final ItemRegistryObject<ArmorItem> TANZANITE_HELMET = register("tanzanite_helmet", () -> new ArmorItem(tanzaniteArmorMaterial, EquipmentSlotType.HEAD, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> TANZANITE_CHESTPLATE = register("tanzanite_chestplate", () -> new ArmorItem(tanzaniteArmorMaterial, EquipmentSlotType.CHEST, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> TANZANITE_LEGGINGS = register("tanzanite_leggings", () -> new ArmorItem(tanzaniteArmorMaterial, EquipmentSlotType.LEGS, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ArmorItem> TANZANITE_BOOTS = register("tanzanite_boots", () -> new ArmorItem(tanzaniteArmorMaterial, EquipmentSlotType.FEET, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<SwordItem> TANZANITE_SWORD = register("tanzanite_sword", () -> new SwordItem(TANZANITE_ITEM_TIER, 3, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<PickaxeItem> TANZANITE_PICKAXE = register("tanzanite_pickaxe", () -> new PickaxeItem(TANZANITE_ITEM_TIER, 1, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<ShovelItem> TANZANITE_SHOVEL = register("tanzanite_shovel", () -> new ShovelItem(TANZANITE_ITEM_TIER, 1.5F, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> TANZANITE_AXE = register("tanzanite_axe", () -> new AxeItem(TANZANITE_ITEM_TIER, 6.0F, -2.4f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<AxeItem> TANZANITE_BATTLEAXE = register("tanzanite_battleaxe", () -> new AxeItem(TANZANITE_ITEM_TIER, 7.0F, -2.2f, new Item.Properties().group(QFMTools.ITEM_GROUP)));
    public static final ItemRegistryObject<HoeItem> TANZANITE_HOE = register("tanzanite_hoe", () -> new HoeItem(TANZANITE_ITEM_TIER, 1, -2.0f, new Item.Properties().group(QFMTools.ITEM_GROUP)));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //     Utility Methods     //
    /////////////////////////////

    public static void register() {

    }

    private static <T extends Item> ItemRegistryObject<T> register(String name, Supplier<T> item) {
        return ToolsRegistration.ITEMS.register(name, item);
    }
}
