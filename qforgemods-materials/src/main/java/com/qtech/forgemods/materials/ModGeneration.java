package com.qtech.forgemods.materials;

import lombok.experimental.UtilityClass;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Biome generation class.
 *
 * @author Qboi123
 */
@UtilityClass
public class ModGeneration {
    public static void loadTrees(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.Category.FOREST) {
            event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MaterialsFeatures.EUCALYPTUS_TREE);
        }
    }

    public static void loadLakes(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.Category.PLAINS) {
            event.getGeneration().withFeature(GenerationStage.Decoration.LAKES, MaterialsFeatures.LAKE_OIL);
        }
        if (event.getCategory() == Biome.Category.DESERT) {
            event.getGeneration().withFeature(GenerationStage.Decoration.LAKES, MaterialsFeatures.LAKE_OIL);
        }
    }
}
