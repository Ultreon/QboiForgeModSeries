package com.qtech.forgemods.materials.data;

import com.qtech.forgemods.materials.data.client.ModBlockStateProvider;
import com.qtech.forgemods.materials.data.client.ModItemModelProvider;
import com.qtech.forgemods.materials.data.loot.MaterialsLootTableProvider;
import com.qtech.forgemods.materials.data.recipes.MaterialsRecipesProvider;
import lombok.experimental.UtilityClass;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@UtilityClass
public final class MaterialsDataGenerators {
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
//
        MaterialsBlockTagsProvider blockTags = new MaterialsBlockTagsProvider(gen, event.getModContainer().getModId(), event.getExistingFileHelper());
        gen.addProvider(blockTags);
        gen.addProvider(new MaterialsItemTagsProvider(gen, blockTags, event.getModContainer().getModId(), event.getExistingFileHelper()));
        gen.addProvider(new MaterialsRecipesProvider(gen));
        gen.addProvider(new MaterialsLootTableProvider(gen));

        gen.addProvider(new ModBlockStateProvider(gen, existingFileHelper));
        gen.addProvider(new ModItemModelProvider(gen, existingFileHelper));
    }
}
