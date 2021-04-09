package com.qtech.forgemods.core;

import com.qtech.forgemods.core.common.Module;
import com.qtech.forgemods.core.common.ModuleManager;
import com.qtech.forgemods.core.modules.MainModule;
import com.qtech.forgemods.core.modules.client.ClientTweaksModule;
import com.qtech.forgemods.core.modules.confirmExit.ConfirmExitModule;
import com.qtech.forgemods.core.modules.debug.DebuggingModule;
import com.qtech.forgemods.core.modules.environment.EntitiesModule;
//import com.qtech.forgemods.core.modules.environment.WorldGenerationModule;
import com.qtech.forgemods.core.modules.environment.WorldGenerationModule;
import com.qtech.forgemods.core.modules.items.ItemsModule;
import com.qtech.forgemods.core.modules.tiles.BlocksModule;
import com.qtech.forgemods.core.modules.tiles.TileEntitiesModule;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@UtilityClass
public class Modules {
    public static final List<Module> MODULES = new ArrayList<>();
    public static final MainModule MAIN = new MainModule();
    public static final ClientTweaksModule CLIENT = new ClientTweaksModule();
    public static final BlocksModule BLOCKS = new BlocksModule();
    public static final ItemsModule ITEMS = new ItemsModule();
    public static final EntitiesModule ENTITIES = new EntitiesModule();
    public static final TileEntitiesModule TILE_ENTITIES = new TileEntitiesModule();
    public static final WorldGenerationModule BIOMES = new WorldGenerationModule();
    public static final ConfirmExitModule CONFIRM_EXIT = new ConfirmExitModule();
    public static final DebuggingModule DEBUGGING = new DebuggingModule();

    public static void init(ModuleManager manager) {
        manager.register(MAIN);
        manager.register(BLOCKS);
        manager.register(ITEMS);
        manager.register(ENTITIES);
        manager.register(TILE_ENTITIES);
        manager.register(BIOMES);
        manager.register(CONFIRM_EXIT);
        if (QFMCore.isClientSide()) {
            manager.register(CLIENT);
        }
        if (QFMCore.isModDev(false)) {
            manager.register(DEBUGGING);
        }
    }
}
