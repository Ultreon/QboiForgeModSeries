package com.qtech.forgemods.tools.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.qtech.forgemods.tools.QFMTools;
import com.qtech.forgemods.tools.items.tools.Tools;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class ToolsItemTagsProvider extends ItemTagsProvider {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();

    @SuppressWarnings("unused")
    public ToolsItemTagsProvider(DataGenerator generatorIn, ToolsBlockTagsProvider blockTags) {
        super(generatorIn, blockTags);
    }

    public ToolsItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, modId, existingFileHelper);
    }

    private static ITag.INamedTag<Item> itemTag(ResourceLocation id) {
        return ItemTags.makeWrapperTag(id.toString());
    }

    @Override
    protected void registerTags() {
        Builder<Item> swords = getOrCreateBuilder(itemTag(new ResourceLocation(modId, "tools/swords")));
        Builder<Item> axes = getOrCreateBuilder(itemTag(new ResourceLocation(modId, "tools/axes")));
        Builder<Item> pickaxes = getOrCreateBuilder(itemTag(new ResourceLocation(modId, "tools/pickaxes")));
        Builder<Item> shovels = getOrCreateBuilder(itemTag(new ResourceLocation(modId, "tools/shovels")));
        Builder<Item> hoes = getOrCreateBuilder(itemTag(new ResourceLocation(modId, "tools/hoes")));
        Builder<Item> longswords = getOrCreateBuilder(itemTag(new ResourceLocation(modId, "tools/longswords")));
        Builder<Item> broadswords = getOrCreateBuilder(itemTag(new ResourceLocation(modId, "tools/broadswords")));
        Builder<Item> katanas = getOrCreateBuilder(itemTag(new ResourceLocation(modId, "tools/katanas")));
        Builder<Item> battleaxes = getOrCreateBuilder(itemTag(new ResourceLocation(modId, "tools/battleaxes")));
        Builder<Item> lumberAxes = getOrCreateBuilder(itemTag(new ResourceLocation(modId, "tools/lumber_axes")));
        Builder<Item> excavators = getOrCreateBuilder(itemTag(new ResourceLocation(modId, "tools/excavators")));
        Builder<Item> hammers = getOrCreateBuilder(itemTag(new ResourceLocation(modId, "tools/hammers")));
        for (Tools tools : Tools.values()) {
            swords.add(tools.getSword().get());
            axes.add(tools.getAxe().get());
            pickaxes.add(tools.getPickaxe().get());
            shovels.add(tools.getShovel().get());
            hoes.add(tools.getHoe().get());
            longswords.add(tools.getLongsword().get());
            broadswords.add(tools.getBroadsword().get());
            katanas.add(tools.getKatana().get());
            battleaxes.add(tools.getBattleaxe().get());
            lumberAxes.add(tools.getLumberAxe().get());
            excavators.add(tools.getExcavator().get());
            hammers.add(tools.getHammer().get());
        }
    }

    @Override
    public @NotNull String getName() {
        return "QFM: Tools - Item Tags";
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void act(@NotNull DirectoryCache cache) {
        // Temp fix that removes the broken safety check
        this.tagToBuilder.clear();
        this.registerTags();
        this.tagToBuilder.forEach((p_240524_4_, p_240524_5_) -> {
            JsonObject jsonobject = p_240524_5_.serialize();
            Path path = this.makePath(p_240524_4_);
            if (path == null)
                return; //Forge: Allow running this data provider without writing it. Recipe provider needs valid tags.

            try {
                String s = GSON.toJson(jsonobject);
                @SuppressWarnings("UnstableApiUsage") String s1 = HASH_FUNCTION.hashUnencodedChars(s).toString();
                if (!Objects.equals(cache.getPreviousHash(path), s1) || !Files.exists(path)) {
                    Files.createDirectories(path.getParent());

                    try (BufferedWriter bufferedwriter = Files.newBufferedWriter(path)) {
                        bufferedwriter.write(s);
                    }
                }

                cache.recordHash(path, s1);
            } catch (IOException ioexception) {
                LOGGER.error("Couldn't save tags to {}", path, ioexception);
            }

        });
    }

    private static ITag.INamedTag<Item> itemTag(String path) {
        return ItemTags.makeWrapperTag(new ResourceLocation(QFMTools.modId, path).toString());
    }
}
