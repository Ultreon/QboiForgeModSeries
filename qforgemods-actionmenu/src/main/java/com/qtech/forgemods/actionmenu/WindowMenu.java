package com.qtech.forgemods.actionmenu;

import com.qtech.forgemods.core.Modules;
import com.qtech.forgemods.core.common.ModuleManager;
import com.qtech.forgemods.core.modules.confirmExit.ConfirmExitScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class WindowMenu extends AbstractActionMenu {
    public WindowMenu() {
        addItem(new IActionMenuItem() {
            @Override
            public void onActivate() {
                Minecraft mc = Minecraft.getInstance();
                if (ModuleManager.getInstance().isEnabled(Modules.CONFIRM_EXIT)) {
                    mc.displayGuiScreen(new ConfirmExitScreen(mc.currentScreen));
                } else {
                    mc.shutdown();
                }
            }

            @Override
            public ITextComponent getText() {
                return new TranslationTextComponent("action.qforgemod.window.close");
            }
        });
        addItem(new IActionMenuItem() {
            @Override
            public void onActivate() {
                Minecraft mc = Minecraft.getInstance();
                mc.getMainWindow().toggleFullscreen();
            }

            @Override
            public ITextComponent getText() {
                return new TranslationTextComponent("action.qforgemod.window.fullscreen");
            }
        });
    }
}
