package com.qtech.forgemods.core.client.gui.modules;

import com.qtech.forgemods.core.common.Module;
import com.qtech.forgemods.core.modules.ui.screens.AdvancedScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.Objects;

public abstract class ModuleOptionsScreen<T extends Module> extends AdvancedScreen {
    private final Screen back;
    protected final T module;

    protected ModuleOptionsScreen(Screen back, T module) {
        super(new TranslationTextComponent("screen.qfm_core.module_options." + module.getName()));
        this.back = back;
        this.module = module;
    }

    @Override
    public void closeScreen() {
        Objects.requireNonNull(this.minecraft).displayGuiScreen(back);
    }

    public T getModule() {
        return module;
    }
}
