package com.qtech.forgemods.core.common.interfaces;

import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.*;

public interface IModInitializer {
    void serverSetup(FMLDedicatedServerSetupEvent event);
    void clientSetup(FMLClientSetupEvent event);
    void commonSetup(FMLCommonSetupEvent event);

    void serverAboutToStart(FMLServerAboutToStartEvent event);
    void serverStarting(FMLServerStartingEvent event);
    void serverStarted(FMLServerStartedEvent event);
    void serverStopping(FMLServerStoppingEvent event);
    void serverStopped(FMLServerStoppedEvent event);

    void constructMod(FMLConstructModEvent event);
    void modIdMapping(FMLModIdMappingEvent event);
    void loadComplete(FMLLoadCompleteEvent event);
}
