package com.qtech.forgemods.materials.data.recipes;

import com.qsoftware.modlib.silentlib.data.ExtendedShapedRecipeBuilder;
import com.qsoftware.modlib.silentlib.data.ExtendedShapelessRecipeBuilder;
import com.qtech.forgemods.core.data.recipes.AlloySmeltingRecipeBuilder;
import com.qtech.forgemods.core.data.recipes.CompressingRecipeBuilder;
import com.qtech.forgemods.core.data.recipes.CrushingRecipeBuilder;
import com.qtech.forgemods.materials.*;
import com.qtech.forgemods.materials.items.tools.Tools;
import net.minecraft.block.Blocks;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import javax.annotation.Nullable;
import java.util.function.Consumer;

@SuppressWarnings("CommentedOutCode")
public class MaterialsRecipesProvider extends RecipeProvider {
    private static final int CRUSHING_CHUNKS_TIME = 300;
    private static final int CRUSHING_INGOT_TIME = 200;
    private static final int CRUSHING_ORE_TIME = 400;
    private static final float CRUSHING_CHUNKS_EXTRA_CHANCE = 0.1f;
    private static final float CRUSHING_ORE_STONE_CHANCE = 0.1f;

    public MaterialsRecipesProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    private static void registerAlloySmelting(Consumer<IFinishedRecipe> consumer) {
        AlloySmeltingRecipeBuilder.builder(OreMaterial.ALUMINUM_STEEL.getIngot().get(), 4, 600)
                .ingredient(OreMaterial.IRON.getSmeltables(), 2)
                .ingredient(ModTags.Items.DUSTS_COAL, 3)
                .ingredient(OreMaterial.ALUMINUM.getSmeltables(), 1)
                .build(consumer);
        AlloySmeltingRecipeBuilder.builder(OreMaterial.BISMUTH_BRASS.getIngot().get(), 4, 400)
                .ingredient(OreMaterial.COPPER.getSmeltables(), 2)
                .ingredient(OreMaterial.ZINC.getSmeltables(), 1)
                .ingredient(OreMaterial.BISMUTH.getSmeltables(), 1)
                .build(consumer);
        AlloySmeltingRecipeBuilder.builder(OreMaterial.BISMUTH_STEEL.getIngot().get(), 4, 600)
                .ingredient(OreMaterial.IRON.getSmeltables(), 2)
                .ingredient(ModTags.Items.DUSTS_COAL, 3)
                .ingredient(OreMaterial.BISMUTH.getSmeltables(), 1)
                .build(consumer);
        AlloySmeltingRecipeBuilder.builder(OreMaterial.BRASS.getIngot().get(), 4, 400)
                .ingredient(OreMaterial.COPPER.getSmeltables(), 3)
                .ingredient(OreMaterial.ZINC.getSmeltables(), 1)
                .build(consumer);
        AlloySmeltingRecipeBuilder.builder(OreMaterial.BRONZE.getIngot().get(), 4, 400)
                .ingredient(OreMaterial.COPPER.getSmeltables(), 3)
                .ingredient(OreMaterial.TIN.getSmeltables(), 1)
                .build(consumer);
        AlloySmeltingRecipeBuilder.builder(OreMaterial.ELECTRUM.getIngot().get(), 2, 400)
                .ingredient(OreMaterial.GOLD.getSmeltables(), 1)
                .ingredient(OreMaterial.SILVER.getSmeltables(), 1)
                .build(consumer);
        AlloySmeltingRecipeBuilder.builder(OreMaterial.ENDERIUM.getIngot().get(), 4, 500)
                .ingredient(OreMaterial.LEAD.getSmeltables(), 3)
                .ingredient(OreMaterial.PLATINUM.getSmeltables(), 1)
                .ingredient(Tags.Items.ENDER_PEARLS, 4)
                .build(consumer);
        AlloySmeltingRecipeBuilder.builder(OreMaterial.INVAR.getIngot().get(), 3, 400)
                .ingredient(OreMaterial.IRON.getSmeltables(), 2)
                .ingredient(OreMaterial.NICKEL.getSmeltables(), 1)
                .build(consumer);
        AlloySmeltingRecipeBuilder.builder(OreMaterial.LUMIUM.getIngot().get(), 4, 500)
                .ingredient(OreMaterial.TIN.getSmeltables(), 3)
                .ingredient(OreMaterial.SILVER.getSmeltables(), 1)
                .ingredient(Tags.Items.DUSTS_GLOWSTONE, 4)
                .build(consumer);
        AlloySmeltingRecipeBuilder.builder(OreMaterial.REDSTONE_ALLOY.getIngot().get(), 2, 200)
                .ingredient(OreMaterial.IRON.getSmeltables(), 1)
                .ingredient(Tags.Items.DUSTS_REDSTONE, 4)
                .build(consumer);
        AlloySmeltingRecipeBuilder.builder(OreMaterial.SIGNALUM.getIngot().get(), 4, 500)
                .ingredient(OreMaterial.COPPER.getSmeltables(), 3)
                .ingredient(OreMaterial.SILVER.getSmeltables(), 1)
                .ingredient(Tags.Items.DUSTS_REDSTONE, 10)
                .build(consumer);
        AlloySmeltingRecipeBuilder.builder(OreMaterial.STEEL.getIngot().get(), 2, 600)
                .ingredient(OreMaterial.IRON.getSmeltables(), 2)
                .ingredient(ModTags.Items.DUSTS_COAL, 2)
                .build(consumer);
    }

    private static void registerCompressingRecipes(Consumer<IFinishedRecipe> consumer) {
        CompressingRecipeBuilder.builder(Items.BLAZE_POWDER, 4, Items.BLAZE_ROD, 1, 400)
                .build(consumer);

        assert (OreMaterial.COMPRESSED_IRON.getIngot().isPresent());
        CompressingRecipeBuilder.builder(Tags.Items.INGOTS_IRON, 1, OreMaterial.COMPRESSED_IRON.getIngot().get(), 1, 400)
                .build(consumer);
        CompressingRecipeBuilder.builder(Tags.Items.STORAGE_BLOCKS_COAL, 16, Items.DIAMOND, 1, 800)
                .build(consumer);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    private static void registerCrushingRecipes(Consumer<IFinishedRecipe> consumer) {
        for (OreMaterial metal : OreMaterial.values()) {
            if (metal.getOreItemTag().isPresent() && metal.getChunks().isPresent()) {
                crushingOre(metal.getOreItemTag().get(), metal.getChunks().get(), Blocks.COBBLESTONE)
                        .build(consumer);
            }
            if (metal.getChunksTag().isPresent() && metal.getDust().isPresent()) {
                crushingChunks(metal.getChunksTag().get(), metal.getDust().get())
                        .build(consumer);
            }
            if (metal.getIngotTag().isPresent() && metal.getDust().isPresent()) {
                crushingIngot(metal.getIngotTag().get(), metal.getDust().get())
                        .build(consumer, QFMMaterials.rl("crushing/" + metal.getName() + "_dust_from_ingot"));
            }
        }
        crushingOre(Tags.Items.ORES_GOLD, OreMaterial.GOLD.getChunks().get(), Blocks.COBBLESTONE).build(consumer);
        crushingOre(Blocks.NETHER_GOLD_ORE, OreMaterial.GOLD.getChunks().get(), Blocks.NETHERRACK)
                .build(consumer, QFMMaterials.rl("crushing/gold_chunks_nether"));
        crushingOre(Tags.Items.ORES_IRON, OreMaterial.IRON.getChunks().get(), Blocks.COBBLESTONE).build(consumer);
    }

    public static CrushingRecipeBuilder crushingChunks(ITag<Item> chunks, IItemProvider dust) {
        return CrushingRecipeBuilder.crushingChunks(chunks, dust, CRUSHING_CHUNKS_TIME, CRUSHING_CHUNKS_EXTRA_CHANCE);
    }

    public static CrushingRecipeBuilder crushingIngot(ITag<Item> ingot, IItemProvider dust) {
        return CrushingRecipeBuilder.crushingIngot(ingot, dust, CRUSHING_INGOT_TIME);
    }

    public static CrushingRecipeBuilder crushingOre(ITag<Item> ore, IItemProvider chunks, @Nullable IItemProvider extra) {
        return CrushingRecipeBuilder.crushingOre(ore, chunks, CRUSHING_ORE_TIME, extra, CRUSHING_ORE_STONE_CHANCE);
    }

    public static CrushingRecipeBuilder crushingOre(IItemProvider ore, IItemProvider chunks, @Nullable IItemProvider extra) {
        return CrushingRecipeBuilder.crushingOre(ore, chunks, CRUSHING_ORE_TIME, extra, CRUSHING_ORE_STONE_CHANCE);
    }

    @Deprecated
    public static CrushingRecipeBuilder crushingOreBonus(ITag<Item> ore, IItemProvider item) {
        return CrushingRecipeBuilder.builder(ore, CRUSHING_ORE_TIME)
                .result(item, 2)
                .result(item, 1, 0.1f)
                .result(Blocks.COBBLESTONE, 1, 0.1f);
    }

    @Override
    public String getName() {
        return "QFM: Materials - Recipes";
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        registerCrafting(consumer);
        registerSmelting(consumer);
        registerAlloySmelting(consumer);
        registerCompressingRecipes(consumer);
        registerCrushingRecipes(consumer);
    }

    private void registerCrafting(Consumer<IFinishedRecipe> consumer) {
        registerMetalCrafting(consumer);
        registerBlockCrafting(consumer);
        registerItemCrafting(consumer);
    }

    private void registerMetalCrafting(Consumer<IFinishedRecipe> consumer) {
        for (OreMaterial metal : OreMaterial.values()) {
            if (metal.getIngot().isPresent() && metal.getNuggetTag().isPresent()) {
                ExtendedShapedRecipeBuilder.vanillaBuilder(metal.getIngot().get())
                        .patternLine("###")
                        .patternLine("###")
                        .patternLine("###")
                        .key('#', metal.getNuggetTag().get())
                        .build(consumer, QFMMaterials.rl("metals/" + metal.getName() + "_ingot_from_nugget"));
            }
            if (metal.getNugget().isPresent() && metal.getIngotTag().isPresent()) {
                ExtendedShapelessRecipeBuilder.vanillaBuilder(metal.getNugget().get(), 9)
                        .addIngredient(metal.getIngotTag().get())
                        .build(consumer, QFMMaterials.rl("metals/" + metal.getName() + "_nugget"));
            }
            if (metal.getStorageBlock().isPresent() && metal.getIngotTag().isPresent()) {
                ExtendedShapedRecipeBuilder.vanillaBuilder(metal.getStorageBlock().get())
                        .patternLine("###")
                        .patternLine("###")
                        .patternLine("###")
                        .key('#', metal.getIngotTag().get())
                        .build(consumer, QFMMaterials.rl("metals/" + metal.getName() + "_block"));
            }
            if (metal.getIngot().isPresent() && metal.getStorageBlockItemTag().isPresent()) {
                ExtendedShapelessRecipeBuilder.vanillaBuilder(metal.getIngot().get(), 9)
                        .addIngredient(metal.getStorageBlockItemTag().get())
                        .build(consumer, QFMMaterials.rl("metals/" + metal.getName() + "_ingot_from_block"));
            }
        }
    }

    private void registerBlockCrafting(Consumer<IFinishedRecipe> consumer) {
        ExtendedShapedRecipeBuilder.vanillaBuilder(MaterialsBlocks.EUCALYPTUS_DRYING_RACK)
                .patternLine("###")
                .key('#', MaterialsBlocks.EUCALYPTUS_SLAB)
                .build(consumer);
        ExtendedShapedRecipeBuilder.vanillaBuilder(MaterialsBlocks.CHERRY_DRYING_RACK)
                .patternLine("###")
                .key('#', MaterialsBlocks.CHERRY_SLAB)
                .build(consumer);
    }

    private void registerItemCrafting(Consumer<IFinishedRecipe> consumer) {
        // Todo: Move crafting recipe providers for all machines to 'com.qtech.forgemods:machines'
//        ShapedRecipeBuilder.shapedRecipe(CraftingItems.CIRCUIT_BOARD, 3)
//                .patternLine("/G/")
//                .patternLine("###")
//                .key('/', OreMaterial.REDSTONE_ALLOY.getIngotTag().get())
//                .key('G', Tags.Items.INGOTS_GOLD)
//                .key('#', OreMaterial.COPPER.getIngotTag().get())
//                .addCriterion("has_item", hasItem(OreMaterial.REDSTONE_ALLOY.getIngotTag().get()))
//                .build(consumer);
//
//        ShapedRecipeBuilder.shapedRecipe(CraftingItems.HEATING_ELEMENT, 2)
//                .patternLine("##")
//                .patternLine("##")
//                .patternLine("/ ")
//                .key('#', OreMaterial.COPPER.getIngotTag().get())
//                .key('/', OreMaterial.REDSTONE_ALLOY.getIngotTag().get())
//                .addCriterion("has_item", hasItem(OreMaterial.REDSTONE_ALLOY.getIngotTag().get()))
//                .build(consumer);
//
//        ShapedRecipeBuilder.shapedRecipe(CraftingItems.PLASTIC_SHEET)
//                .patternLine("##")
//                .patternLine("##")
//                .key('#', CraftingItems.PLASTIC_PELLETS)
//                .addCriterion("has_item", hasItem(CraftingItems.PLASTIC_PELLETS))
//                .build(consumer);
//
//        ShapedRecipeBuilder.shapedRecipe(CraftingItems.UPGRADE_CASE, 2)
//                .patternLine("###")
//                .patternLine("###")
//                .patternLine("///")
//                .key('#', ModTags.Items.PLASTIC)
//                .key('/', Tags.Items.NUGGETS_GOLD)
//                .addCriterion("has_item", hasItem(ModTags.Items.PLASTIC))
//                .build(consumer);
//
//        ShapelessRecipeBuilder.shapelessRecipe(MachineUpgrades.PROCESSING_SPEED)
//                .addIngredient(CraftingItems.UPGRADE_CASE)
//                .addIngredient(Tags.Items.STORAGE_BLOCKS_REDSTONE)
//                .addIngredient(OreMaterial.SILVER.getIngotTag().get())
//                .addIngredient(OreMaterial.SILVER.getIngotTag().get())
//                .addCriterion("has_item", hasItem(CraftingItems.UPGRADE_CASE))
//                .build(consumer);
//
//        ShapelessRecipeBuilder.shapelessRecipe(MachineUpgrades.OUTPUT_CHANCE)
//                .addIngredient(CraftingItems.UPGRADE_CASE)
//                .addIngredient(Tags.Items.STORAGE_BLOCKS_LAPIS)
//                .addIngredient(OreMaterial.PLATINUM.getIngotTag().get())
//                .addIngredient(OreMaterial.PLATINUM.getIngotTag().get())
//                .addCriterion("has_item", hasItem(CraftingItems.UPGRADE_CASE))
//                .build(consumer);
//
//        ShapelessRecipeBuilder.shapelessRecipe(MachineUpgrades.ENERGY_EFFICIENCY)
//                .addIngredient(CraftingItems.UPGRADE_CASE)
//                .addIngredient(Items.GLOWSTONE)
//                .addIngredient(OreMaterial.ELECTRUM.getIngotTag().get())
//                .addIngredient(OreMaterial.ELECTRUM.getIngotTag().get())
//                .addCriterion("has_item", hasItem(CraftingItems.UPGRADE_CASE))
//                .build(consumer);
//
//        ShapelessRecipeBuilder.shapelessRecipe(MachineUpgrades.RANGE)
//                .addIngredient(CraftingItems.UPGRADE_CASE)
//                .addIngredient(Tags.Items.ENDER_PEARLS)
//                .addIngredient(OreMaterial.INVAR.getIngotTag().get())
//                .addIngredient(OreMaterial.INVAR.getIngotTag().get())
//                .addCriterion("has_item", hasItem(CraftingItems.UPGRADE_CASE))
//                .build(consumer);
//
//        ShapedRecipeBuilder.shapedRecipe(MaterialsItems.WRENCH)
//                .patternLine("/ /")
//                .patternLine(" # ")
//                .patternLine(" / ")
//                .key('/', Tags.Items.INGOTS_IRON)
//                .key('#', OreMaterial.REFINED_IRON.getIngotTag().get())
//                .addCriterion("has_item", hasItem(OreMaterial.REFINED_IRON.getIngotTag().get()))
//                .build(consumer);
//
//        ShapedRecipeBuilder.shapedRecipe(MaterialsItems.BATTERY)
//                .patternLine(" / ")
//                .patternLine("#X#")
//                .patternLine("LXL")
//                .key('/', OreMaterial.REDSTONE_ALLOY.getIngotTag().get())
//                .key('#', Tags.Items.INGOTS_IRON)
//                .key('X', Tags.Items.DUSTS_REDSTONE)
//                .key('L', OreMaterial.LEAD.getIngotTag().get())
//                .addCriterion("has_item", hasItem(OreMaterial.REDSTONE_ALLOY.getIngotTag().get()))
//                .build(consumer);
//
//        ExtendedShapedRecipeBuilder.vanillaBuilder(MaterialsItems.HAND_PUMP)
//                .patternLine("/C#")
//                .patternLine(" B#")
//                .key('/', OreMaterial.ALUMINUM.getIngotTag().get())
//                .key('C', MaterialsItems.EMPTY_CANISTER)
//                .key('#', ModTags.Items.PLASTIC)
//                .key('B', MaterialsItems.BATTERY)
//                .build(consumer);

        for (Tools tools : Tools.values()) {
            QFMMaterials.LOGGER.info("Loading recipe for tool: " + tools.getName());
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getSword())
                    .patternLine("X")
                    .patternLine("X")
                    .patternLine("/")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer);
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getAxe())
                    .patternLine("XX")
                    .patternLine("X/")
                    .patternLine(" /")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer);
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getAxe())
                    .patternLine("XX")
                    .patternLine("/X")
                    .patternLine("/ ")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer, new ResourceLocation(QFMMaterials.modId, tools.getAxe().getName() + "_mirror"));
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getShovel())
                    .patternLine("X")
                    .patternLine("/")
                    .patternLine("/")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer);
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getPickaxe())
                    .patternLine("XXX")
                    .patternLine(" / ")
                    .patternLine(" / ")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer);
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getHoe())
                    .patternLine("XX")
                    .patternLine(" /")
                    .patternLine(" /")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer);
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getHoe())
                    .patternLine("XX")
                    .patternLine("/ ")
                    .patternLine("/ ")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer, new ResourceLocation(QFMMaterials.modId, tools.getHoe().getName() + "_mirror"));
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getKatana())
                    .patternLine(" X")
                    .patternLine("X ")
                    .patternLine("X/")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer);
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getKatana())
                    .patternLine("X ")
                    .patternLine(" X")
                    .patternLine("/X")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer, new ResourceLocation(QFMMaterials.modId, tools.getKatana().getName() + "_mirror"));
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getLongsword())
                    .patternLine("X ")
                    .patternLine("X ")
                    .patternLine("X/")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer);
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getLongsword())
                    .patternLine(" X")
                    .patternLine(" X")
                    .patternLine("/X")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer, new ResourceLocation(QFMMaterials.modId, tools.getLongsword().getName() + "_mirror"));
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getBroadsword())
                    .patternLine("XX")
                    .patternLine("XX")
                    .patternLine("/ ")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer);
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getBroadsword())
                    .patternLine("XX")
                    .patternLine("XX")
                    .patternLine(" /")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer, new ResourceLocation(QFMMaterials.modId, tools.getBroadsword().getName() + "_mirror"));
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getHammer())
                    .patternLine("XXX")
                    .patternLine("XXX")
                    .patternLine(" / ")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer);
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getExcavator())
                    .patternLine("XX ")
                    .patternLine("X/ ")
                    .patternLine("  /")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer);
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getExcavator())
                    .patternLine(" XX")
                    .patternLine(" /X")
                    .patternLine("/  ")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer, new ResourceLocation(QFMMaterials.modId, tools.getExcavator().getName() + "_mirror"));
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getBattleaxe())
                    .patternLine("XXX")
                    .patternLine("X/X")
                    .patternLine(" / ")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer);
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getLumberAxe())
                    .patternLine("XXX")
                    .patternLine("X/ ")
                    .patternLine(" / ")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer);
            ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getLumberAxe())
                    .patternLine("XXX")
                    .patternLine(" /X")
                    .patternLine(" / ")
                    .key('/', () -> tools.getHandleMaterial().get())
                    .key('X', () -> tools.getBaseMaterial().get())
                    .build(consumer, new ResourceLocation(QFMMaterials.modId, tools.getLumberAxe().getName() + "_mirror"));
            if (tools.getArmorSubMaterial() != null) {
                ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getHelmet())
                        .patternLine("XXX")
                        .patternLine("XOX")
                        .key('O', () -> tools.getArmorSubMaterial().get())
                        .key('X', () -> tools.getBaseMaterial().get())
                        .build(consumer);
                ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getChestplate())
                        .patternLine("XOX")
                        .patternLine("XXX")
                        .patternLine("XXX")
                        .key('O', () -> tools.getArmorSubMaterial().get())
                        .key('X', () -> tools.getBaseMaterial().get())
                        .build(consumer);
                ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getLeggings())
                        .patternLine("XXX")
                        .patternLine("XOX")
                        .patternLine("X X")
                        .key('O', () -> tools.getArmorSubMaterial().get())
                        .key('X', () -> tools.getBaseMaterial().get())
                        .build(consumer);
                ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getBoots())
                        .patternLine("X X")
                        .patternLine("XOX")
                        .key('O', () -> tools.getArmorSubMaterial().get())
                        .key('X', () -> tools.getBaseMaterial().get())
                        .build(consumer);
            } else {
                ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getHelmet())
                        .patternLine("XXX")
                        .patternLine("X X")
                        .key('X', () -> tools.getBaseMaterial().get())
                        .build(consumer);
                ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getChestplate())
                        .patternLine("X X")
                        .patternLine("XXX")
                        .patternLine("XXX")
                        .key('X', () -> tools.getBaseMaterial().get())
                        .build(consumer);
                ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getLeggings())
                        .patternLine("XXX")
                        .patternLine("X X")
                        .patternLine("X X")
                        .key('X', () -> tools.getBaseMaterial().get())
                        .build(consumer);
                ExtendedShapedRecipeBuilder.vanillaBuilder(tools.getBoots())
                        .patternLine("X X")
                        .patternLine("X X")
                        .key('X', () -> tools.getBaseMaterial().get())
                        .build(consumer);
            }
        }

        // Todo: Move this crafting recipe provider for empty canister to 'com.qtech.forgemods:machines'
//        ExtendedShapedRecipeBuilder.vanillaBuilder(MaterialsItems.EMPTY_CANISTER, 8)
//                .patternLine(" # ")
//                .patternLine("# #")
//                .patternLine(" # ")
//                .key('#', OreMaterial.ALUMINUM.getIngotTag().get())
//                .build(consumer);

//        ExtendedShapelessRecipeBuilder.vanillaBuilder(MaterialsItems.EMPTY_CANISTER)
//                .addIngredient(MaterialsItems.CANISTER)
//                .build(consumer, QFMMaterials.rl("canister_clear"));
//
//        ExtendedShapelessRecipeBuilder.vanillaBuilder(Items.LEATHER)
//                .addIngredient(CraftingItems.ZOMBIE_LEATHER, 4)
//                .build(consumer, QFMMaterials.rl("leather"));
    }

    private void registerSmelting(Consumer<IFinishedRecipe> consumer) {
        for (OreMaterial metal : OreMaterial.values()) {
            if (metal.getIngot().isPresent() && (metal.getChunksTag().isPresent() || metal.getDustTag().isPresent())) {
                smeltingAndBlasting(consumer, metal.getName() + "_ingot",
                        metal.getSmeltables(false), metal.getIngot().get());
            }
            if (metal.getIngot().isPresent() && metal.getOreItemTag().isPresent()) {
                smeltingAndBlasting(consumer, metal.getName() + "_ingot_from_ore",
                        Ingredient.fromTag(metal.getOreItemTag().get()), metal.getIngot().get());
            }
        }

        smeltingAndBlasting(consumer, "iron_ingot", OreMaterial.IRON.getSmeltables(false), Items.IRON_INGOT);
        smeltingAndBlasting(consumer, "gold_ingot", OreMaterial.GOLD.getSmeltables(false), Items.GOLD_INGOT);

        assert (OreMaterial.REFINED_IRON.getIngot().isPresent());
        smeltingAndBlasting(consumer, "refined_iron_ingot", Ingredient.fromTag(Tags.Items.INGOTS_IRON), OreMaterial.REFINED_IRON.getIngot().get());
    }

    private void smeltingAndBlasting(Consumer<IFinishedRecipe> consumer, String name, Ingredient ingredient, IItemProvider result) {
        CookingRecipeBuilder.smeltingRecipe(ingredient, result, 1f, 200)
                .addCriterion("has_item", hasItem(Blocks.FURNACE))
                .build(consumer, QFMMaterials.rl("smelting/" + name));
        CookingRecipeBuilder.blastingRecipe(ingredient, result, 1f, 100)
                .addCriterion("has_item", hasItem(Blocks.FURNACE))
                .build(consumer, QFMMaterials.rl("blasting/" + name));
    }
}
