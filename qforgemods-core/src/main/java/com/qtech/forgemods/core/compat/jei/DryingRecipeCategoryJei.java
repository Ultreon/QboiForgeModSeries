package com.qtech.forgemods.core.compat.jei;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.qtech.forgemods.core.crafting.recipe.DryingRecipe;
import com.qtech.forgemods.core.modules.tiles.ModBlocks;
import com.qtech.forgemods.core.modules.tiles.blocks.machines.compressor.CompressorScreen;
import com.qtech.forgemods.core.util.Constants;
import com.qtech.forgemods.core.util.TextUtils;
import com.qsoftware.modlib.silentlib.util.TextRenderUtils;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DryingRecipeCategoryJei implements IRecipeCategory<DryingRecipe> {
    private static final int GUI_START_X = 55;
    private static final int GUI_START_Y = 30;
    private static final int GUI_WIDTH = 137 - GUI_START_X;
    private static final int GUI_HEIGHT = 56 - GUI_START_Y;

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableAnimated arrow;
    private final String localizedName;

    public DryingRecipeCategoryJei(IGuiHelper guiHelper) {
        background = guiHelper.createDrawable(CompressorScreen.TEXTURE, GUI_START_X, GUI_START_Y, GUI_WIDTH, GUI_HEIGHT);
        icon = guiHelper.createDrawableIngredient(new ItemStack(ModBlocks.OAK_DRYING_RACK));
        arrow = guiHelper.drawableBuilder(CompressorScreen.TEXTURE, 176, 14, 24, 17)
                .buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);
        localizedName = TextUtils.translate("jei", "category.drying").getString();
    }

    @Override
    public ResourceLocation getUid() {
        return Constants.DRYING;
    }

    @Override
    public Class<? extends DryingRecipe> getRecipeClass() {
        return DryingRecipe.class;
    }

    @Override
    public String getTitle() {
        return localizedName;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setIngredients(DryingRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(Collections.singletonList(recipe.getIngredient()));
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, DryingRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
        itemStacks.init(0, true, 55 - GUI_START_X, 34 - GUI_START_Y);
        itemStacks.init(1, false, 115 - GUI_START_X, 34 - GUI_START_Y);

        itemStacks.set(0, new ArrayList<>(Arrays.asList(recipe.getIngredient().getMatchingStacks())));
        itemStacks.set(1, recipe.getRecipeOutput());
    }

    @Override
    public void draw(DryingRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
        arrow.draw(matrixStack, 79 - GUI_START_X, 35 - GUI_START_Y);
        FontRenderer font = Minecraft.getInstance().fontRenderer;
        ITextComponent text = TextUtils.translate("misc", "timeInSeconds", recipe.getProcessTime() / 20);
        TextRenderUtils.renderScaled(matrixStack, font, text.func_241878_f(), 24, 20, 0.67f, 0xFFFFFF, true);
    }
}
