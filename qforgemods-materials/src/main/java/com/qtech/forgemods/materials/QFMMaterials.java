package com.qtech.forgemods.materials;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.qsoftware.modlib.api.annotations.FieldsAreNonnullByDefault;
import com.qtech.forgemods.core.*;
import com.qtech.forgemods.core.common.ModuleManager;
import com.qtech.forgemods.core.internal.QfmArgs;
import com.qtech.forgemods.core.plugins.AbstractPluginManager;
import lombok.Getter;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.FolderName;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Random;
import java.util.function.Supplier;

/**
 * The main mod class.
 * Here's everything started.
 *
 * @author Qboi123
 * @see #QFMMaterials()
 * @see Mod
 * @see Mod.EventBusSubscriber
 */
@SuppressWarnings("unused")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@FieldsAreNonnullByDefault
@Mod(QFMMaterials.modId)
@Mod.EventBusSubscriber(modid = QFMMaterials.modId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class QFMMaterials implements QFMCorePlugin {
    /**
     * QFM: Materials's Logger
     */
    public static final Logger LOGGER = LogManager.getLogger("QFM:Materials");

    /**
     * Unused.
     */
    @SuppressWarnings("unused")
    @Deprecated
    public static final Random RANDOM = new Random();
    private static final boolean MOD_TEST_PHASE = false;

    // Class static fields.
    @Getter @Nullable private static QFMMaterials instance;
    @Getter @Nullable private static IProxy proxy;
    @Getter @Nullable private static MaterialsInit init;

    @Getter private static final boolean clientSide;
    @Getter private static final boolean serverSide;

    // Mod Data
    @Getter public static final String modId = "qfm_materials";
    @Getter public static final String modNameLong = "Qboi's Forge Mods: Materials";
    @Getter public static final String modName = "QFM: Materials";
    @Getter public static final String nbtName = "QFMMaterials";
    @Getter public static final String modVersion;
    @Getter public static final QFMVersion version;
    @Getter private static final QfmArgs modArgs;

    @Getter private final ModuleManager moduleManager = QFMCore.getInstance().getModuleManager();

    @SuppressWarnings("ConstantConditions")
    private static final Supplier<Boolean> getClientSide = () -> {
        try {
            return Minecraft.getInstance() != null; // This is null when running runData.
        } catch (Throwable t) {
            return false;
        }
    };

    static {
        if (new File("/mnt/chromeos").exists()) {
            throw new UnsupportedOperationException("Tried to run QFM: Materials on Chrome OS (Linux subsystem), this is unsupported.");
        }

        clientSide = getClientSide.get();

        boolean s;
        try {
            Class.forName("net.minecraft.server.MinecraftServer");
            s = true;
        } catch (ClassNotFoundException e) {
            s = false;
        }
        serverSide = s;

        // Create gson instance.
        Gson gson = new Gson();

        // Get stream.
        InputStream qfmArgsStream = QFMMaterials.class.getResourceAsStream("/META-INF/qfm_args.json");
        Objects.requireNonNull(qfmArgsStream, "Couldn't get QFM: Materials Args file.");

        // Get data.
        InputStreamReader isr = new InputStreamReader(qfmArgsStream);
        JsonObject o = gson.fromJson(isr, JsonObject.class);

        modArgs = new QfmArgs(o);
        modVersion = modArgs.getVersion().getName();
        version = modArgs.getVersion().toVersionObject();
    }

    // Getters
    @Getter private final IEventBus modEventBus;

    /**
     * The QForgeUtils constructor for mod-loading.
     *
     * @since 1.0-alpha1
     * @see Mod
     * @see QFMMaterials
     */
    public QFMMaterials() {

        // Constants.
        QFMMaterials.instance = this;
        QFMMaterials.proxy = DistExecutor.safeRunForDist(() -> MaterialsSideProxy.Client::new, () -> MaterialsSideProxy.Server::new);
        QFMMaterials.init = new MaterialsInit(this);

        // Final fields.
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        this.modEventBus = modEventBus;

        // Register forge event bus listener(s).
        MinecraftForge.EVENT_BUS.register(this);

        // Register mod event bus listeners.
        modEventBus.addListener(QFMMaterials.init::clientSetup);
        modEventBus.addListener(QFMMaterials.init::serverSetup);
        modEventBus.addListener(QFMMaterials.init::commonSetup);
        modEventBus.addListener(QFMMaterials.init::loadComplete);
    }

    public static File getDataFile() {
        return MaterialsInit.getServer().func_240776_a_(new FolderName("qfm-data")).toFile();
    }

    public static Path getDataPath() {
        return MaterialsInit.getServer().func_240776_a_(new FolderName("qfm-data"));
    }

    /**
     * Get the resource location based on QFM: Materials's id.
     *
     * @param path the resource path.
     * @return a resource location.
     */
    public static ResourceLocation rl(String path) {
        return new ResourceLocation(modId, path);
    }

    /**
     * Internal method.
     *
     * @return boolean.
     */
    @OnlyIn(Dist.CLIENT)
    private static boolean isDevState0() {
        return Minecraft.getInstance().getVersion().equals("MOD_DEV");
    }

    /**
     * Check if QFM: Materials is currently a development build.
     *
     * @return the QFM dev-state..
     */
    public static boolean isModDev() {
        try {
            return isDevState0();
        } catch (NoSuchMethodError error) {
            return false;
        }
    }

    /**
     * Check if QFM: Materials is currently a development build.
     *
     * @param def the default value if failed to detect development mode.
     * @return the QFM dev-state..
     */
    public static boolean isModDev(boolean def) {
        try {
            return isDevState0();
        } catch (NoSuchMethodError error) {
            return def;
        }
    }

    /**
     * Check test phase.
     *
     * @return true if QFM: Materials is in test phase, false otherwise.
     */
    public static boolean isTestPhase() {
        return isModDev() || MOD_TEST_PHASE;
    }

    /**
     * @return true if QFM: Materials is a dev test version, false otherwise.
     */
    public static boolean isDevtest() {
        return modArgs.getFlags().isDevTest();
    }

    /**
     * Event handler for server starting.
     *
     * @param event a {@link FMLServerStartingEvent} object.
     */
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        Objects.requireNonNull(init).serverStart(event);
    }

    @Override
    public int getCoreMinBuild() {
        return 1353;
    }

    @Override
    public int getCoreMaxBuild() {
        return 1353;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public AbstractPluginManager<? extends QFMPlugin<?>> getPluginManager() {
        return null;
    }
}
