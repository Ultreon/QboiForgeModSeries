package com.qtech.forgemods.tools.data;

import com.qtech.forgemods.tools.data.client.ToolsItemModelProvider;
import com.qtech.forgemods.tools.data.loot.MaterialsLootTableProvider;
import com.qtech.forgemods.tools.data.recipes.ToolsRecipesProvider;
import lombok.experimental.UtilityClass;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@UtilityClass
public final class ToolsDataGenerators {
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
//
        ToolsBlockTagsProvider blockTags = new ToolsBlockTagsProvider(gen, event.getModContainer().getModId(), event.getExistingFileHelper());
        gen.addProvider(blockTags);
        gen.addProvider(new ToolsItemTagsProvider(gen, blockTags, event.getModContainer().getModId(), event.getExistingFileHelper()));
        gen.addProvider(new ToolsRecipesProvider(gen));
        gen.addProvider(new MaterialsLootTableProvider(gen));

//        gen.addProvider(new ModBlockStateProvider(gen, existingFileHelper));
        gen.addProvider(new ToolsItemModelProvider(gen, existingFileHelper));
    }
}
