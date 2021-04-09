package com.qtech.forgemods.materials;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = QFMMaterials.modId)
public class BiomeLoader {
    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent event) {
        ModGeneration.loadTrees(event);
        ModGeneration.loadLakes(event);
    }
}
