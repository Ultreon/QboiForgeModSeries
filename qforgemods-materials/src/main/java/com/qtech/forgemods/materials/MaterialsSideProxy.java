package com.qtech.forgemods.materials;

import com.qsoftware.modlib.silentlib.event.Greetings;
import com.qtech.forgemods.core.IProxy;
import com.qtech.forgemods.materials.data.MaterialsDataGenerators;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

class MaterialsSideProxy implements IProxy {
    private MinecraftServer server = null;

    MaterialsSideProxy() {
        MaterialsRegistration.register();

        // Add listeners for common events
        FMLJavaModLoadingContext.get().getModEventBus().addListener(MaterialsDataGenerators::gatherData);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::imcEnqueue);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::imcProcess);

        // Add listeners for registry events
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Fluid.class, MaterialsFluids::registerFluids);

        // Other events
        MinecraftForge.EVENT_BUS.addListener(this::serverAboutToStart);

        Greetings.addMessage(MaterialsBlocks::checkForMissingLootTables);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
//        if (ModList.get().isLoaded("computercraft")) {
//            SMechComputerCraftCompat.init();
//        }
    }

    private void imcEnqueue(InterModEnqueueEvent event) {
    }

    private void imcProcess(InterModProcessEvent event) {
    }

    private void serverAboutToStart(FMLServerAboutToStartEvent event) {
        server = event.getServer();
    }

    @Override
    public MinecraftServer getServer() {
        return server;
    }

    static class Client extends MaterialsSideProxy {
        Client() {
            super();
            FMLJavaModLoadingContext.get().getModEventBus().register(this);
            MinecraftForge.EVENT_BUS.register(this);
        }

        @SubscribeEvent
        public void setFog(EntityViewRenderEvent.FogColors fog) {
            World w = fog.getInfo().getRenderViewEntity().getEntityWorld();
            BlockPos pos = fog.getInfo().getBlockPos();
            BlockState bs = w.getBlockState(pos);
            Block b = bs.getBlock();

            if (b.equals(MaterialsBlocks.OIL.get())) {
                float red = 0.02F;
                float green = 0.02F;
                float blue = 0.02F;
                fog.setRed(red);
                fog.setGreen(green);
                fog.setBlue(blue);
            }

            if (b.equals(MaterialsBlocks.DIESEL.get())) {
                float red = 0.9F;
                float green = 0.9F;
                float blue = 0.02F;
                fog.setRed(red);
                fog.setGreen(green);
                fog.setBlue(blue);
            }
        }
    }

    static class Server extends MaterialsSideProxy {
        Server() {
            super();
            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        }

        private void serverSetup(FMLDedicatedServerSetupEvent event) {

        }
    }
}
