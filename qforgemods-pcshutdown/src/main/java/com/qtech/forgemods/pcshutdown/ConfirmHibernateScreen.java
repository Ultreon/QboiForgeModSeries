package com.qtech.forgemods.pcshutdown;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.text2speech.Narrator;
import com.qtech.forgemods.core.QFMCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.IBidiRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.settings.NarratorStatus;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = QFMCore.modId, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ConfirmHibernateScreen extends Screen {
    private final IBidiRenderer bidiRenderer = IBidiRenderer.field_243257_a;
    private final ITextComponent yesButtonText;
    private final ITextComponent noButtonText;
    private final Screen backScreen;
    private final Runnable hibernate;
    private int ticksUntilEnable;

    public ConfirmHibernateScreen(Screen backScreen, Runnable hibernate) {
        super(new TranslationTextComponent("msg.qfm_shutdown.confirm_hibernate.title"));
        this.backScreen = backScreen;
        this.hibernate = hibernate;
        this.yesButtonText = DialogTexts.GUI_YES;
        this.noButtonText = DialogTexts.GUI_NO;
    }

    public static void show(Runnable hibernate) {
        Minecraft mc = Minecraft.getInstance();
        mc.displayGuiScreen(new ConfirmHibernateScreen(mc.currentScreen, hibernate));
    }

    protected void init() {
        super.init();

        NarratorStatus narratorStatus = Objects.requireNonNull(this.minecraft).gameSettings.narrator;

        if (narratorStatus == NarratorStatus.SYSTEM || narratorStatus == NarratorStatus.ALL) {
            Narrator.getNarrator().say("Are you sure you want to hibernate your computer?", true);
        }

        this.buttons.clear();
        this.children.clear();

        this.addButton(new Button(this.width / 2 - 105, this.height / 6 + 126, 100, 20, this.yesButtonText, (p_213006_1_) -> {
            hibernate.run();
            goBack();
        }));
        this.addButton(new Button(this.width / 2 + 5, this.height / 6 + 126, 100, 20, this.noButtonText, (p_213006_1_) -> {
            goBack();
        }));

        setButtonDelay(10);
    }

    public void render(@NotNull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);

        drawCenteredString(matrixStack, this.font, this.title, this.width / 2, 70, 0xffffff);
        drawCenteredString(matrixStack, this.font, new TranslationTextComponent("msg.qfm_shutdown.confirm_hibernate.description"), this.width / 2, 90, 0xbfbfbf);

        this.bidiRenderer.func_241863_a(matrixStack, this.width / 2, 90);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    /**
     * Sets the number of ticks to wait before enabling the buttons.
     */
    public void setButtonDelay(int ticksUntilEnableIn) {
        this.ticksUntilEnable = ticksUntilEnableIn;

        for (Widget widget : this.buttons) {
            widget.active = false;
        }

    }

    public void tick() {
        super.tick();

        if (--this.ticksUntilEnable == 0) {
            for (Widget widget : this.buttons) {
                widget.active = true;
            }
        }
    }

    public void goBack() {
        Minecraft.getInstance().displayGuiScreen(backScreen);
    }

    @Override
    public void closeScreen() {
        goBack();
    }

    public boolean shouldCloseOnEsc() {
        return true;
    }
}
