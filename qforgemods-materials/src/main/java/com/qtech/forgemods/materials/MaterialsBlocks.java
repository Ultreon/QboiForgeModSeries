package com.qtech.forgemods.materials;

import com.qsoftware.modlib.silentlib.registry.BlockRegistryObject;
import com.qsoftware.modlib.silentlib.registry.ItemRegistryObject;
import com.qtech.forgemods.core.QFMCore;
import com.qtech.forgemods.core.modules.tiles.blocks.machines.dryingrack.DryingRackBlock;
import com.qtech.forgemods.core.modules.ui.ModItemGroups;
import com.qtech.forgemods.materials.trees.CherryTree;
import com.qtech.forgemods.materials.trees.EucalyptusTree;
import lombok.experimental.UtilityClass;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTableManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@UtilityClass
public final class MaterialsBlocks {
    public static final BlockRegistryObject<DryingRackBlock> EUCALYPTUS_DRYING_RACK = registerMachine("eucalyptus_drying_rack", DryingRackBlock::new);
    public static final BlockRegistryObject<DryingRackBlock> CHERRY_DRYING_RACK = registerMachine("cherry_drying_rack", DryingRackBlock::new);

    ////////////////////
    //     Fluids     //
    ////////////////////
    public static final BlockRegistryObject<FlowingFluidBlock> OIL = registerFluid("oil", () -> MaterialsFluids.OIL);
    public static final BlockRegistryObject<FlowingFluidBlock> DIESEL = registerFluid("diesel", () -> MaterialsFluids.DIESEL);

    //////////////////
    //     Wood     //
    //////////////////
    public static final BlockRegistryObject<Block> EUCALYPTUS_PLANKS = registerWood("eucalyptus_planks", () -> new Block(Block.Properties.create(Material.WOOD).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
    public static final BlockRegistryObject<RotatedPillarBlock> EUCALYPTUS_LOG = registerWood("eucalyptus_log", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.QUARTZ).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final BlockRegistryObject<LeavesBlock> EUCALYPTUS_LEAVES = register("eucalyptus_leaves", MaterialsBlocks::createLeavesBlock);
    public static final BlockRegistryObject<SaplingBlock> EUCALYPTUS_SAPLING = register("eucalyptus_sapling", () -> new SaplingBlock(new EucalyptusTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final BlockRegistryObject<StairsBlock> EUCALYPTUS_STAIRS = registerShaped("eucalyptus_stairs", () -> new StairsBlock(EUCALYPTUS_PLANKS.get()::getDefaultState, Block.Properties.from(EUCALYPTUS_PLANKS.get())));
    public static final BlockRegistryObject<SlabBlock> EUCALYPTUS_SLAB = registerShaped("eucalyptus_slab", () -> new SlabBlock(Block.Properties.from(EUCALYPTUS_PLANKS.get())));
    public static final BlockRegistryObject<FenceBlock> EUCALYPTUS_FENCE = registerShaped("eucalyptus_fence", () -> new FenceBlock(Block.Properties.from(EUCALYPTUS_PLANKS.get())));
    public static final BlockRegistryObject<FenceGateBlock> EUCALYPTUS_FENCE_GATE = registerShaped("eucalyptus_fence_gate", () -> new FenceGateBlock(Block.Properties.from(EUCALYPTUS_PLANKS.get())));

    public static final BlockRegistryObject<Block> CHERRY_PLANKS = registerWood("cherry_planks", () -> new Block(Block.Properties.create(Material.WOOD).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)));
    public static final BlockRegistryObject<Block> CHERRY_LOG = registerWood("cherry_log", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final BlockRegistryObject<LeavesBlock> CHERRY_LEAVES = register("cherry_leaves", MaterialsBlocks::createLeavesBlock);
    public static final BlockRegistryObject<SaplingBlock> CHERRY_SAPLING = register("cherry_sapling", () -> new SaplingBlock(new CherryTree(), AbstractBlock.Properties.create(Material.PLANTS).harvestTool(ToolType.AXE).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final BlockRegistryObject<StairsBlock> CHERRY_STAIRS = registerShaped("cherry_stairs", () -> new StairsBlock(CHERRY_PLANKS.get()::getDefaultState, Block.Properties.from(CHERRY_PLANKS.get())));
    public static final BlockRegistryObject<SlabBlock> CHERRY_SLAB = registerShaped("cherry_slab", () -> new SlabBlock(Block.Properties.from(CHERRY_PLANKS.get())));
    public static final BlockRegistryObject<FenceBlock> CHERRY_FENCE = registerShaped("cherry_fence", () -> new FenceBlock(Block.Properties.from(CHERRY_PLANKS.get())));
    public static final BlockRegistryObject<FenceGateBlock> CHERRY_FENCE_GATE = registerShaped("cherry_fence_gate", () -> new FenceGateBlock(Block.Properties.from(CHERRY_PLANKS.get())));
    
    public static final BlockRegistryObject<OreBlock> GILDED_DIRT = registerOre("gilded_dirt", () -> new OreBlock(Block.Properties.create(Material.EARTH, MaterialColor.DIRT).setRequiresTool().harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).sound(SoundType.GROUND)));
    
    //////////////////////////////
    //     Utility methods     //
    //////////////////////////////
    static {
        OreMaterial.registerBlocks();
    }

    private static <T extends Item> ItemRegistryObject<T> registerItem(String name, Supplier<T> supplier) {
        return MaterialsRegistration.ITEMS.register(name, supplier);
    }

    public static void register() {
    }

    private static <T extends Block> BlockRegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return new BlockRegistryObject<>(MaterialsRegistration.BLOCKS.register(name, block));
    }
    private static <T extends Block> BlockRegistryObject<T> register(String name, Supplier<T> block) {
        return register(name, block, MaterialsBlocks::item);
    }
    @SuppressWarnings("SameParameterValue")
    private static <T extends Block> BlockRegistryObject<T> registerMiscellaneous(String name, Supplier<T> block) {
        return register(name, block, MaterialsBlocks::miscellaneousItem);
    }
    private static <T extends Block> BlockRegistryObject<T> registerMachine(String name, Supplier<T> block) {
        return register(name, block, MaterialsBlocks::machineItem);
    }
    private static <T extends Block> BlockRegistryObject<T> registerOre(String name, Supplier<T> block) {
        return register(name, block, MaterialsBlocks::oreItem);
    }
    private static <T extends Block> BlockRegistryObject<T> registerWood(String name, Supplier<T> block) {
        return register(name, block, MaterialsBlocks::woodItem);
    }
    private static <T extends Block> BlockRegistryObject<T> registerShaped(String name, Supplier<T> block) {
        return register(name, block, MaterialsBlocks::shapedItem);
    }
    private static <T extends Block> BlockRegistryObject<T> registerOverpowered(String name, Supplier<T> block) {
        return register(name, block, MaterialsBlocks::godItem);
    }
    private static <T extends Block> BlockRegistryObject<T> register(String name, Supplier<T> block, Function<BlockRegistryObject<T>, Supplier<? extends BlockItem>> item) {
        BlockRegistryObject<T> ret = registerNoItem(name, block);
        MaterialsRegistration.ITEMS.register(name, item.apply(ret));
        return ret;
    }
    private static BlockRegistryObject<FlowingFluidBlock> registerFluid(String name, Supplier<FlowingFluid> fluid) {
        return registerNoItem(name, () ->
                new FlowingFluidBlock(fluid, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
    }
    private static <T extends Block> Supplier<BlockItem> item(BlockRegistryObject<T> block) {
        return () -> new BlockItem(block.get(), new Item.Properties());
    }
    private static <T extends Block> Supplier<BlockItem> miscellaneousItem(BlockRegistryObject<T> block) {
        return () -> new BlockItem(block.get(), new Item.Properties().group(ModItemGroups.MISC));
    }
    private static <T extends Block> Supplier<BlockItem> machineItem(BlockRegistryObject<T> block) {
        return () -> new BlockItem(block.get(), new Item.Properties().group(ModItemGroups.MACHINES));
    }
    private static <T extends Block> Supplier<BlockItem> oreItem(BlockRegistryObject<T> block) {
        return () -> new BlockItem(block.get(), new Item.Properties().group(MaterialsItemGroups.ORES));
    }
    private static <T extends Block> Supplier<BlockItem> woodItem(BlockRegistryObject<T> block) {
        return () -> new BlockItem(block.get(), new Item.Properties().group(MaterialsItemGroups.WOOD));
    }
    private static <T extends Block> Supplier<BlockItem> shapedItem(BlockRegistryObject<T> block) {
        return () -> new BlockItem(block.get(), new Item.Properties().group(ModItemGroups.SHAPES));
    }
    private static <T extends Block> Supplier<BlockItem> godItem(BlockRegistryObject<T> block) {
        return () -> new BlockItem(block.get(), new Item.Properties().group(ModItemGroups.OVERPOWERED));
    }
    private static LeavesBlock createLeavesBlock() {
        return new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid().setAllowsSpawn(MaterialsBlocks::allowsSpawnOnLeaves).setSuffocates(MaterialsBlocks::isNotSolid).setBlocksVision(MaterialsBlocks::isNotSolid));
    }

    private static Boolean allowsSpawnOnLeaves(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }
    private static boolean isNotSolid(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }

    @Nullable
    public static ITextComponent checkForMissingLootTables(PlayerEntity player) {
        // Checks for missing block loot tables, but only in dev
        if (!(player.world instanceof ServerWorld) || !QFMCore.isModDev()) return null;

        LootTableManager lootTableManager = ((ServerWorld) player.world).getServer().getLootTableManager();
        Collection<String> missing = new ArrayList<>();

        for (Block block : ForgeRegistries.BLOCKS.getValues()) {
            ResourceLocation lootTable = block.getLootTable();
            // The AirBlock check filters out removed blocks
            if (lootTable.getNamespace().equals(QFMMaterials.modId) && !(block instanceof AirBlock) && !lootTableManager.getLootTableKeys().contains(lootTable)) {
                QFMMaterials.LOGGER.error("[QFM:Materials]: Missing block loot table '{}' for {}", lootTable, block.getRegistryName());
                missing.add(lootTable.toString());
            }
        }

        if (!missing.isEmpty()) {
            String list = String.join(", ", missing);
            return new StringTextComponent("The following block loot tables are missing: " + list).mergeStyle(TextFormatting.RED);
        }

        return null;
    }
}
