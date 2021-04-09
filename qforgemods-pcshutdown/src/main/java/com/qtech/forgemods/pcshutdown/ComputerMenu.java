package com.qtech.forgemods.pcshutdown;

import com.qtech.forgemods.actionmenu.AbstractActionMenu;
import com.qtech.forgemods.actionmenu.IActionMenuItem;
import com.qtech.forgemods.core.common.ModuleManager;
import com.qtech.forgemods.debugmenu.DebugMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class ComputerMenu extends AbstractActionMenu {
    public ComputerMenu() {
        addItem(new IActionMenuItem() {
            @Override
            public void onActivate() {
                PCPowerUtils.shutdown();
            }

            @Override
            public ITextComponent getText() {
                return new StringTextComponent("Shutdown");
            }

            @Override
            public boolean isEnabled() {
                return ModuleManager.getInstance().isEnabled(QFMPcShutdown.PC_SHUTDOWN_MODULE);
            }
        });
        addItem(new IActionMenuItem() {
            @Override
            public void onActivate() {
                PCPowerUtils.hibernate();
            }

            @Override
            public ITextComponent getText() {
                return new StringTextComponent("Hibernate");
            }

            @Override
            public boolean isEnabled() {
                return ModuleManager.getInstance().isEnabled(QFMPcShutdown.PC_SHUTDOWN_MODULE) && PCPowerUtils.supportsHibernate();
            }
        });
        addItem(new IActionMenuItem() {
            @Override
            public void onActivate() {
                PCPowerUtils.reboot();
            }

            @Override
            public ITextComponent getText() {
                return new StringTextComponent("Reboot");
            }

            @Override
            public boolean isEnabled() {
                return ModuleManager.getInstance().isEnabled(QFMPcShutdown.PC_SHUTDOWN_MODULE) && PCPowerUtils.supportsReboot();
            }
        });
//        addItem(new IActionMenuItem() {
//            @Override
//            public void onActivate() {
//                PCPowerUtils.crash();
//            }
//
//            @Override
//            public ITextComponent getText() {
//                return new StringTextComponent("Crash");
//            }
//
//            @Override
//            public boolean isEnabled() {
//                return ModuleManager.getInstance().isEnabled(QFMPcShutdown.PC_SHUTDOWN_MODULE) && PCPowerUtils.supportsCrash();
//            }
//        });
        addItem(new IActionMenuItem() {
            @Override
            public void onActivate() {
                DebugMenu.DEBUG_PAGE = DebugMenu.PAGE.COMPUTER;
            }

            @Override
            public ITextComponent getText() {
                return new StringTextComponent("Set Debug Page");
            }

            @Override
            public boolean isEnabled() {
                Minecraft mc = Minecraft.getInstance();
                return mc.player != null && mc.world != null && mc.playerController != null;
            }
        });
    }
}
