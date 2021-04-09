package com.qtech.forgemods.materials.data.loot;

import com.qtech.forgemods.materials.MaterialsRegistration;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;

import java.util.stream.Collectors;

public class MaterialsBlockLootTables extends BlockLootTables {
    @Override
    protected void addTables() {
        MaterialsRegistration.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .filter(block -> block.asItem() != Items.AIR)
                .forEach(this::registerDropSelfLootTable);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return MaterialsRegistration.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
    }
}
