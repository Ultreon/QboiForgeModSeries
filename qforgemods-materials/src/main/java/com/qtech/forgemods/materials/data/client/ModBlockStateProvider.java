package com.qtech.forgemods.materials.data.client;

import com.qsoftware.modlib.silentlib.util.NameUtils;
import com.qtech.forgemods.core.modules.tiles.blocks.machines.dryingrack.DryingRackBlock;
import com.qtech.forgemods.materials.MaterialsBlocks;
import com.qtech.forgemods.materials.OreMaterial;
import com.qtech.forgemods.materials.QFMMaterials;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Objects;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, QFMMaterials.modId, exFileHelper);
    }

    @Nonnull
    @Override
    public String getName() {
        return "QFM: Materials - Block States and Models";
    }

    @Override
    protected void registerStatesAndModels() {
        Arrays.stream(OreMaterial.values()).forEach(metal -> {
            metal.getOre().ifPresent(this::simpleBlock);
            metal.getStorageBlock().ifPresent(this::simpleBlock);
        });

        models().withExistingParent("drying_rack", mcLoc("block/block"))
                .texture("0", "#wood")
                .texture("particle", "#wood")
                .element()
                .from(0, 12, 0)
                .to(16, 16, 4)
                .face(Direction.DOWN).uvs(0, 0, 16, 4).texture("#0").end()
                .face(Direction.UP).uvs(0, 0, 16, 4).texture("#0").end()
                .face(Direction.NORTH).uvs(0, 0, 16, 4).texture("#0").end()
                .face(Direction.SOUTH).uvs(0, 0, 16, 4).texture("#0").end()
                .face(Direction.WEST).uvs(0, 0, 4, 4).texture("#0").end()
                .face(Direction.EAST).uvs(0, 0, 4, 4).texture("#0").end()
                .end();

        dryingRack(MaterialsBlocks.EUCALYPTUS_DRYING_RACK.get(), "qfm_materials:blocks/eucalyptus_planks");
        dryingRack(MaterialsBlocks.CHERRY_DRYING_RACK.get(), "qfm_materials:blocks/cherry_planks");
    }

    private void dryingRack(DryingRackBlock block, String texture) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            String name = NameUtils.from(block).getPath();
            return ConfiguredModel.builder()
                    .modelFile(models()
                            .withExistingParent(name, modLoc("block/drying_rack"))
                            .texture("wood", mcLoc(texture)))
                    .rotationY((int) state.get(DryingRackBlock.FACING).getHorizontalAngle())
                    .build();
        }, DryingRackBlock.WATERLOGGED);
    }

    public ResourceLocation blockTexture(Block block) {
        ResourceLocation name = block.getRegistryName();
        return new ResourceLocation(Objects.requireNonNull(name).getNamespace(), "blocks/" + name.getPath());
    }
}
