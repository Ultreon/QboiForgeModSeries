package com.qtech.forgemods.materials.groups;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Ore item group.
 *
 * @author Qboi123
 */
public class OresItemGroup extends ItemGroup {
    public static final OresItemGroup instance = new OresItemGroup(ItemGroup.GROUPS.length, "qfm_materialss_ores");

    public OresItemGroup(int index, String label) {
        super(index, label);
    }

    @Override
    public @NotNull ItemStack createIcon() {
        return new ItemStack(Blocks.DIAMOND_ORE);
    }
}
