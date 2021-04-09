package com.qtech.forgemods.pcshutdown;

import com.qtech.forgemods.core.Modules;
import com.qtech.forgemods.core.common.ModuleManager;
import com.sun.jna.Platform;
import lombok.experimental.UtilityClass;
import net.minecraft.client.Minecraft;
import org.apache.commons.lang3.SystemUtils;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class PCPowerUtils {
    private static final Runtime runtime = Runtime.getRuntime();

    public static void shutdown() {
        if (ModuleManager.getInstance().isEnabled(QFMPcShutdown.PC_SHUTDOWN_MODULE)) {
            Minecraft mc = Minecraft.getInstance();
            mc.displayGuiScreen(new ConfirmShutdownScreen(mc.currentScreen, PCPowerUtils::shutdown0));
        }
    }

    public static void hibernate() {
        if (ModuleManager.getInstance().isEnabled(QFMPcShutdown.PC_SHUTDOWN_MODULE) && supportsHibernate()) {
            Minecraft mc = Minecraft.getInstance();
            mc.displayGuiScreen(new ConfirmHibernateScreen(mc.currentScreen, PCPowerUtils::hibernate0));
        }
    }

    public static void reboot() {
        if (ModuleManager.getInstance().isEnabled(QFMPcShutdown.PC_SHUTDOWN_MODULE) && supportsHibernate()) {
            Minecraft mc = Minecraft.getInstance();
            mc.displayGuiScreen(new ConfirmHibernateScreen(mc.currentScreen, PCPowerUtils::reboot0));
        }
    }

    private static void shutdown0() {
        if (ModuleManager.getInstance().isDisabled(QFMPcShutdown.PC_SHUTDOWN_MODULE)) {
            return;
        }

        if (Platform.isWindows()) {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("shutdown /s /t 0");
            } catch (IOException e) {
                try {
                    runtime.exec("shutdown -s -t 0");
                } catch (IOException f) {
                    f.printStackTrace();
                }
            }
        } else if (Platform.isLinux()) {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("shutdown 0");
            } catch (IOException e) {
                try {
                    runtime.exec("sudo shutdown 0");
                } catch (IOException f) {
                    f.printStackTrace();
                    e.printStackTrace();
                }
            }
        }
    }

    private static void hibernate0() {
        if (ModuleManager.getInstance().isDisabled(QFMPcShutdown.PC_SHUTDOWN_MODULE)) {
            return;
        }

        if (!supportsHibernate()) {
            return;
        }

        if (Platform.isWindows()) {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("shutdown /h");
            } catch (IOException e) {
                try {
                    runtime.exec("shutdown -h");
                } catch (IOException f) {
                    f.printStackTrace();
                }
            }
        }
    }

    private static void reboot0() {
        if (ModuleManager.getInstance().isDisabled(QFMPcShutdown.PC_SHUTDOWN_MODULE)) {
            return;
        }

        if (!supportsReboot()) {
            return;
        }

        if (Platform.isWindows()) {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("shutdown /r /t 0");
            } catch (IOException e) {
                try {
                    runtime.exec("shutdown -r -t 0");
                } catch (IOException f) {
                    f.printStackTrace();
                }
            }
        } else if (Platform.isLinux()) {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("reboot");
            } catch (IOException e) {
                try {
                    runtime.exec("sudo reboot");
                } catch (IOException f) {
                    f.printStackTrace();
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean supportsHibernate() {
        return SystemUtils.IS_OS_WINDOWS_10 || SystemUtils.IS_OS_WINDOWS_8 || SystemUtils.IS_OS_WINDOWS_7 || SystemUtils.IS_OS_WINDOWS_VISTA;
    }

    public static boolean supportsReboot() {
        return SystemUtils.IS_OS_WINDOWS_10 || SystemUtils.IS_OS_WINDOWS_8 || SystemUtils.IS_OS_WINDOWS_7 || SystemUtils.IS_OS_WINDOWS_VISTA || SystemUtils.IS_OS_LINUX;
    }

    public static boolean supportsCrash() {
        if (SystemUtils.IS_OS_WINDOWS_10) {

            Process process;
            BufferedReader bufferedReader;
            StringBuilder stringBuilder = new StringBuilder();
            String stdOutLine;

            try {
                process = runtime.exec("cmd.exe /c ver");
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while ((stdOutLine = bufferedReader.readLine()) != null) {
                    stringBuilder.append(stdOutLine);
                }
            } catch (IOException ex) {
                throw new RuntimeException("Error while getting Windows version");
            }

            System.out.println(stringBuilder.toString());


            Pattern pattern = Pattern.compile("10\\.0\\.([0-9]*)");
            Matcher matcher = pattern.matcher(stringBuilder.toString());
            if (matcher.find()) {
                String group = matcher.group(1);
                int integer = Integer.parseInt(group);
                return integer > 16299 && integer <= 19042;
            } else {
                throw new IllegalStateException("Invalid windows version!");
            }
        }
        return false;
    }
}
