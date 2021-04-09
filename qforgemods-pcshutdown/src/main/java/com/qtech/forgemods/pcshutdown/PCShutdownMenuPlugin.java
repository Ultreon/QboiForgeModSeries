package com.qtech.forgemods.pcshutdown;

import com.qtech.forgemods.actionmenu.AbstractActionMenu;
import com.qtech.forgemods.actionmenu.MainActionMenu;
import com.qtech.forgemods.actionmenu.MenuHandler;
import com.qtech.forgemods.actionmenu.QFMActionMenuPlugin;
import com.qtech.forgemods.core.QFMPlugin;
import com.qtech.forgemods.core.common.ModuleManager;
import com.qtech.forgemods.core.plugins.AbstractPluginManager;
import net.minecraft.util.text.StringTextComponent;
import org.jetbrains.annotations.Nullable;

public class PCShutdownMenuPlugin implements QFMActionMenuPlugin {
    private static PCShutdownMenuPlugin instance;

    @SuppressWarnings("unused")
    public static PCShutdownMenuPlugin get() {
        return instance;
    }

    static void init() {
        instance = new PCShutdownMenuPlugin();
    }

    private static final AbstractActionMenu computerMenu = new ComputerMenu();

    public PCShutdownMenuPlugin() {
        MainActionMenu.registerHandler(new MenuHandler(new StringTextComponent("Computer"), computerMenu, this::enableMenu));
    }

    private boolean enableMenu() {
        return ModuleManager.getInstance().isEnabled(QFMPcShutdown.PC_SHUTDOWN_MODULE) || ModuleManager.getInstance().isEnabled(QFMPcShutdown.PC_SHUTDOWN_MODULE);
    }


    @Override
    public int getActionMenuMinBuild() {
        return 1420;
    }

    @Override
    public int getActionMenuMaxBuild() {
        return 1420;
    }

    @Nullable
    @Override
    public AbstractPluginManager<? extends QFMPlugin<?>> getPluginManager() {
        return null;
    }
}
