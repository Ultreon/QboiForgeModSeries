package com.qtech.forgemods.materials;

import com.qtech.forgemods.core.util.ExceptionUtil;
import lombok.experimental.UtilityClass;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;

/**
 * Features initialization class.
 *
 * @author Qboi123
 */
@SuppressWarnings("unused")
@UtilityClass
public final class MaterialsFeatures {
    // Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> EUCALYPTUS_TREE = register("eucalyptus_tree", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(MaterialsBlocks.EUCALYPTUS_LOG.asBlockState()), new SimpleBlockStateProvider(MaterialsBlocks.EUCALYPTUS_LEAVES.asBlockState()), new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4), new FancyTrunkPlacer(4, 7, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_TREE = register("cherry_tree", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(MaterialsBlocks.CHERRY_LOG.asBlockState()), new SimpleBlockStateProvider(MaterialsBlocks.CHERRY_LEAVES.asBlockState()), new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));

    // Lakes
    public static final ConfiguredFeature<?, ?> LAKE_OIL = register("lake_oil", Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(MaterialsFluids.OIL.getDefaultState().getBlockState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(60))));

    /**
     * Register a configured feature.
     *
     * @param key registration key to use for registering.
     * @param configuredFeature the configured feature to register.
     * @param <FC> the configured feature class.
     * @return the registered feature.
     */
    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}
