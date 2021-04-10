package com.qtech.forgemods.tools.data.recipes;

import com.qsoftware.modlib.silentlib.data.ExtendedShapedRecipeBuilder;
import com.qtech.forgemods.core.data.recipes.CrushingRecipeBuilder;
import com.qtech.forgemods.materials.OreMaterial;
import com.qtech.forgemods.tools.QFMTools;
import com.qtech.forgemods.tools.items.tools.Tools;
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
public class ToolsRecipesProvider extends RecipeProvider {
    private static final int CRUSHING_CHUNKS_TIME = 300;
    private static final int CRUSHING_INGOT_TIME = 200;
    private static final int CRUSHING_ORE_TIME = 400;
    private static final float CRUSHING_CHUNKS_EXTRA_CHANCE = 0.1f;
    private static final float CRUSHING_ORE_STONE_CHANCE = 0.1f;

    public ToolsRecipesProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    private static void registerCrushingRecipes(Consumer<IFinishedRecipe> consumer) {
        
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
        return "QFM: Tools - Recipes";
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        registerCrafting(consumer);
        registerSmelting(consumer);
        registerCrushingRecipes(consumer);
    }

    private void registerCrafting(Consumer<IFinishedRecipe> consumer) {
        registerMetalCrafting(consumer);
        registerBlockCrafting(consumer);
        registerItemCrafting(consumer);
    }

    private void registerMetalCrafting(Consumer<IFinishedRecipe> consumer) {
        
    }

    private void registerBlockCrafting(Consumer<IFinishedRecipe> consumer) {
        
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
            QFMTools.LOGGER.info("Loading recipe for tool: " + tools.getName());
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
                    .build(consumer, new ResourceLocation(QFMTools.modId, tools.getAxe().getName() + "_mirror"));
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
                    .build(consumer, new ResourceLocation(QFMTools.modId, tools.getHoe().getName() + "_mirror"));
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
                    .build(consumer, new ResourceLocation(QFMTools.modId, tools.getKatana().getName() + "_mirror"));
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
                    .build(consumer, new ResourceLocation(QFMTools.modId, tools.getLongsword().getName() + "_mirror"));
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
                    .build(consumer, new ResourceLocation(QFMTools.modId, tools.getBroadsword().getName() + "_mirror"));
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
                    .build(consumer, new ResourceLocation(QFMTools.modId, tools.getExcavator().getName() + "_mirror"));
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
                    .build(consumer, new ResourceLocation(QFMTools.modId, tools.getLumberAxe().getName() + "_mirror"));
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
//                .build(consumer, QFMTools.rl("canister_clear"));
//
//        ExtendedShapelessRecipeBuilder.vanillaBuilder(Items.LEATHER)
//                .addIngredient(CraftingItems.ZOMBIE_LEATHER, 4)
//                .build(consumer, QFMTools.rl("leather"));
    }

    private void registerSmelting(Consumer<IFinishedRecipe> consumer) {
        for (Tools tools : Tools.values()) {
            if (tools.getSword().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_sword",
                        Ingredient.fromItems(tools.getSword().get()), tools.getBaseMaterial().get());
            }
            if (tools.getAxe().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_axe",
                        Ingredient.fromItems(tools.getAxe().get()), tools.getBaseMaterial().get());
            }
            if (tools.getPickaxe().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_pickaxe",
                        Ingredient.fromItems(tools.getPickaxe().get()), tools.getBaseMaterial().get());
            }
            if (tools.getShovel().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_shovel",
                        Ingredient.fromItems(tools.getShovel().get()), tools.getBaseMaterial().get());
            }
            if (tools.getHoe().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_hoe",
                        Ingredient.fromItems(tools.getHoe().get()), tools.getBaseMaterial().get());
            }
            if (tools.getHelmet().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_helmet",
                        Ingredient.fromItems(tools.getHelmet().get()), tools.getBaseMaterial().get());
            }
            if (tools.getChestplate().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_chestplate",
                        Ingredient.fromItems(tools.getChestplate().get()), tools.getBaseMaterial().get());
            }
            if (tools.getLeggings().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_leggings",
                        Ingredient.fromItems(tools.getLeggings().get()), tools.getBaseMaterial().get());
            }
            if (tools.getBoots().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_boots",
                        Ingredient.fromItems(tools.getBoots().get()), tools.getBaseMaterial().get());
            }
            if (tools.getLongsword().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_longsword",
                        Ingredient.fromItems(tools.getLongsword().get()), tools.getBaseMaterial().get());
            }
            if (tools.getBroadsword().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_broadsword",
                        Ingredient.fromItems(tools.getBroadsword().get()), tools.getBaseMaterial().get());
            }
            if (tools.getKatana().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_katana",
                        Ingredient.fromItems(tools.getKatana().get()), tools.getBaseMaterial().get());
            }
            if (tools.getHammer().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_hammer",
                        Ingredient.fromItems(tools.getHammer().get()), tools.getBaseMaterial().get());
            }
            if (tools.getExcavator().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_excavator",
                        Ingredient.fromItems(tools.getExcavator().get()), tools.getBaseMaterial().get());
            }
            if (tools.getLumberAxe().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_lumber_axe",
                        Ingredient.fromItems(tools.getLumberAxe().get()), tools.getBaseMaterial().get());
            }
            if (tools.getBattleaxe().isPresent()) {
                smeltingAndBlasting(consumer, tools.getName() + "_nugget_from_battleaxe",
                        Ingredient.fromItems(tools.getBattleaxe().get()), tools.getBaseMaterial().get());
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
                .build(consumer, QFMTools.rl("smelting/" + name));
        CookingRecipeBuilder.blastingRecipe(ingredient, result, 1f, 100)
                .addCriterion("has_item", hasItem(Blocks.FURNACE))
                .build(consumer, QFMTools.rl("blasting/" + name));
    }
}
