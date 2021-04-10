package com.qtech.forgemods.materials;

import com.qsoftware.modlib.silentlib.registry.ItemRegistryObject;
import com.qtech.forgemods.core.modules.items.objects.EucalyptusLeafItem;
import com.qtech.forgemods.core.modules.items.objects.advanced.AdvancedBowItem;
import com.qtech.forgemods.core.modules.items.objects.fluid.NoPlaceBucketItem;
import com.qtech.forgemods.core.modules.items.objects.type.IngredientItem;
import com.qtech.forgemods.core.modules.ui.ModItemGroups;
import com.qtech.forgemods.materials.items.IngotOrDustItem;
import com.qtech.forgemods.materials.items.UnstableInfinityIngot;
import lombok.experimental.UtilityClass;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import java.util.function.Supplier;

@UtilityClass
@SuppressWarnings("unused")
public final class MaterialsItems {
    static {
        OreMaterial.registerItems();
    }

    // Buckets
    public static final ItemRegistryObject<BucketItem> OIL_BUCKET =          register("oil_bucket", () -> createBucketItem(() -> MaterialsFluids.OIL));
    public static final ItemRegistryObject<BucketItem> DIESEL_BUCKET =       register("diesel_bucket", () -> createBucketItem(() -> MaterialsFluids.DIESEL));
    public static final ItemRegistryObject<BucketItem> ETHANE_BUCKET =       register("ethane_bucket", () -> createBucketItem(() -> MaterialsFluids.ETHANE));
    public static final ItemRegistryObject<BucketItem> POLYETHYLENE_BUCKET = register("polyethylene_bucket", () -> createBucketItem(() -> MaterialsFluids.POLYETHYLENE));

    // Leaves
    public static final ItemRegistryObject<Item> EUCALYPTUS_LEAF = register("eucalyptus_leaf", () -> new EucalyptusLeafItem(new Item.Properties()
            .group(ModItemGroups.NATURE)
            .maxStackSize(128)
            .food(new Food.Builder()
                    .hunger(1)
                    .saturation(0.2f)
                    .effect(() -> new EffectInstance(Effects.REGENERATION, 60, 1), 0.7f)
                    .build())));

    // Rods
    public static final ItemRegistryObject<IngredientItem> URANIUM_ROD = register("uranium_rod", IngredientItem::new);

    // Metals - Tungsten Steel Level
    public static final ItemRegistryObject<IngotOrDustItem> TUNGSTEN_INGOT =  register("tungsten_ingot", IngotOrDustItem::new);
    public static final ItemRegistryObject<IngotOrDustItem> TUNGSTEN_NUGGET = register("tungsten_nugget", IngotOrDustItem::new);
    public static final ItemRegistryObject<IngotOrDustItem> TUNGSTEN_DUST =   register("tungsten_dust", IngotOrDustItem::new);

    // Metals - Infinity Level
    public static final ItemRegistryObject<UnstableInfinityIngot> UNSTABLE_INFINITY_INGOT = register("unstable_infinity_ingot", UnstableInfinityIngot::new);

    // Dusts
    public static final ItemRegistryObject<IngotOrDustItem> COAL_DUST =       register("coal_dust", IngotOrDustItem::new);
    public static final ItemRegistryObject<IngotOrDustItem> RUBY_DUST =       register("ruby_dust", IngotOrDustItem::new);
    public static final ItemRegistryObject<IngotOrDustItem> AMETHYST_DUST =   register("amethyst_dust", IngotOrDustItem::new);
    public static final ItemRegistryObject<IngotOrDustItem> AQUAMARINE_DUST = register("aquamarine_dust", IngotOrDustItem::new);
    public static final ItemRegistryObject<IngotOrDustItem> SAPHIRE_DUST =    register("saphire_dust", IngotOrDustItem::new);
    public static final ItemRegistryObject<IngotOrDustItem> MALACHITE_DUST =  register("malachite_dust", IngotOrDustItem::new);
    public static final ItemRegistryObject<IngotOrDustItem> TOPAZ_DUST =      register("topaz_dust", IngotOrDustItem::new);
    public static final ItemRegistryObject<IngotOrDustItem> AMBER_DUST =      register("amber_dust", IngotOrDustItem::new);
    public static final ItemRegistryObject<IngotOrDustItem> BERYL_DUST =      register("beryl_dust", IngotOrDustItem::new);
    public static final ItemRegistryObject<IngotOrDustItem> DIAMOND_DUST =    register("diamond_dust", IngotOrDustItem::new);
    public static final ItemRegistryObject<IngotOrDustItem> TANZANITE_DUST =  register("tanzanite_dust", IngotOrDustItem::new);

    // Gems
    public static final ItemRegistryObject<Item> RUBY =       register("ruby", () -> new Item(new Item.Properties().group(MaterialsItemGroups.GEMS)));
    public static final ItemRegistryObject<Item> AMETHYST =   register("amethyst", () -> new Item(new Item.Properties().group(MaterialsItemGroups.GEMS)));
    public static final ItemRegistryObject<Item> AQUAMARINE = register("aquamarine", () -> new Item(new Item.Properties().group(MaterialsItemGroups.GEMS)));
    public static final ItemRegistryObject<Item> SAPHIRE =    register("saphire", () -> new Item(new Item.Properties().group(MaterialsItemGroups.GEMS)));
    public static final ItemRegistryObject<Item> MALACHITE =  register("malachite", () -> new Item(new Item.Properties().group(MaterialsItemGroups.GEMS)));
    public static final ItemRegistryObject<Item> TOPAZ =      register("topaz", () -> new Item(new Item.Properties().group(MaterialsItemGroups.GEMS)));
    public static final ItemRegistryObject<Item> AMBER =      register("amber", () -> new Item(new Item.Properties().group(MaterialsItemGroups.GEMS)));
    public static final ItemRegistryObject<Item> PERIDOT =    register("peridot", () -> new Item(new Item.Properties().group(MaterialsItemGroups.GEMS)));
    public static final ItemRegistryObject<Item> BERYL =      register("beryl", () -> new Item(new Item.Properties().group(MaterialsItemGroups.GEMS)));
    public static final ItemRegistryObject<Item> TANZANITE =  register("tanzanite", () -> new Item(new Item.Properties().group(MaterialsItemGroups.GEMS)));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //     Utility Methods     //
    /////////////////////////////

    public static void register() {

    }

    private static BucketItem createBucketItem(Supplier<? extends Fluid> fluid) {
        return new BucketItem(fluid, new Item.Properties().group(MaterialsItemGroups.FLUIDS).maxStackSize(1).containerItem(Items.BUCKET));
    }

    private static NoPlaceBucketItem createNoPlaceBucketItem(Supplier<? extends Fluid> fluid) {
        return new NoPlaceBucketItem(fluid, new Item.Properties().group(MaterialsItemGroups.FLUIDS).maxStackSize(1).containerItem(Items.BUCKET));
    }

    private static <T extends Item> ItemRegistryObject<T> register(String name, Supplier<T> item) {
        return MaterialsRegistration.ITEMS.register(name, item);
    }
}
