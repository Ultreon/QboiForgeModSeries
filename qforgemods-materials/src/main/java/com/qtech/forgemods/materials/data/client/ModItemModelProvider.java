package com.qtech.forgemods.materials.data.client;

import com.qsoftware.modlib.silentlib.util.NameUtils;
import com.qtech.forgemods.core.modules.items.objects.CraftingItems;
import com.qtech.forgemods.core.modules.items.objects.upgrades.MachineUpgrades;
import com.qtech.forgemods.materials.*;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, QFMMaterials.modId, existingFileHelper);
    }

    @Override
    public @NotNull String getName() {
        return "QFM: Materials - Item Models";
    }

    @Override
    protected void registerModels() {
        MaterialsRegistration.BLOCKS.getEntries().stream().filter((block) -> block.get().getClass().getPackage().getName().startsWith("com.qtech.forgemods.core.modules.tiles.blocks.machines")).forEach(block -> blockBuilder(block.get()));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        ModelFile itemHandheld = getExistingFile(mcLoc("item/handheld"));
        ModelFile itemHandheldDouble = getExistingFile(modLoc("item/handheld_double_size"));

        //noinspection OverlyLongLambda
        Arrays.stream(OreMaterial.values()).forEach(metal -> {
            metal.getOre().ifPresent(this::blockBuilder);
            metal.getStorageBlock().ifPresent(this::blockBuilder);
            metal.getChunks().ifPresent(item -> builder(item, itemGenerated));
            metal.getDust().ifPresent(item -> builder(item, itemGenerated));
            metal.getIngot().ifPresent(item -> builder(item, itemGenerated));
            metal.getNugget().ifPresent(item -> builder(item, itemGenerated));
        });
        Arrays.stream(CraftingItems.values()).forEach(item -> builder(item, itemGenerated));
        Arrays.stream(MachineUpgrades.values()).forEach(item -> builder(item, itemGenerated));
    }

    private void blockBuilder(Block block) {
        try {
            String name = NameUtils.from(block).getPath();
            withExistingParent(name, modLoc("block/" + name));
        } catch (IllegalStateException ignored) {

        }
    }

    private void builder(IItemProvider item, ModelFile parent) {
        String name = NameUtils.fromItem(item).getPath();
        builder(item, parent, "items/" + name);
    }

    private void builder(IItemProvider item, ModelFile parent, String texture) {
        try {
            getBuilder(NameUtils.fromItem(item).getPath())
                    .parent(parent)
                    .texture("layer0", modLoc(texture));
        } catch (IllegalArgumentException e) {
            getBuilder(NameUtils.fromItem(item).getPath())
                    .parent(getExistingFile(mcLoc("item/generated")))
                    .texture("layer0", modLoc("default"));
        }
    }
}
