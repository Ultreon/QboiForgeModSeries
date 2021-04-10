package com.qtech.forgemods.core.common;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public enum ModuleSecurity {
    SAFE(new TranslationTextComponent("misc.qfm_core.module.security.safe")),
    RISC(new TranslationTextComponent("misc.qfm_core.module.security.risc")),
    EXPERIMENTAL(new TranslationTextComponent("misc.qfm_core.module.security.experimental")),
    ;

    private final ITextComponent confirmMessage;

    ModuleSecurity(ITextComponent confirmMessage) {
        this.confirmMessage = confirmMessage;
    }

    public ITextComponent getConfirmMessage() {
        return confirmMessage;
    }
}
