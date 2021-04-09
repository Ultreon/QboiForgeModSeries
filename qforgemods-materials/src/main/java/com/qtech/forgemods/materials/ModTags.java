package com.qtech.forgemods.materials;

import lombok.experimental.UtilityClass;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

@UtilityClass
public class ModTags {
    private static ResourceLocation forgeId(String path) {
        return new ResourceLocation("forge", path);
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(QFMMaterials.modId, path);
    }

    public static final class Blocks {
        private Blocks() {

        }

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.makeWrapperTag(forgeId(path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.makeWrapperTag(modId(path).toString());
        }
    }

    public static final class Items {
        public static final ITag.INamedTag<Item> DUSTS_COAL = forge("dusts/coal");

        public static final ITag.INamedTag<Item> CHUNKS = mod("chunks");

        private Items() {

        }

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.makeWrapperTag(forgeId(path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.makeWrapperTag(modId(path).toString());
        }
    }
}
