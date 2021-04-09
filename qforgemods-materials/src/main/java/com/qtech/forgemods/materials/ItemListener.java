package com.qtech.forgemods.materials;

import com.qtech.forgemods.materials.items.tools.Tools;
import lombok.experimental.UtilityClass;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Item listener.
 *
 * @author Qboi123
 */
@Mod.EventBusSubscriber(modid = QFMMaterials.modId, bus = Mod.EventBusSubscriber.Bus.FORGE)
@UtilityClass
public class ItemListener {
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @SubscribeEvent
    public static void onItem(ItemEvent event) {
        if (event.getEntityItem().getItem().getItem() == Tools.INFINITY.getSword().get() ||
                event.getEntityItem().getItem().getItem() == Tools.INFINITY.getAxe().get() ||
                event.getEntityItem().getItem().getItem() == Tools.INFINITY.getPickaxe().get() ||
                event.getEntityItem().getItem().getItem() == Tools.INFINITY.getHoe().get() ||
                event.getEntityItem().getItem().getItem() == Tools.INFINITY.getShovel().get() ||
                event.getEntityItem().getItem().getItem() == Tools.INFINITY.getHelmet().get() ||
                event.getEntityItem().getItem().getItem() == Tools.INFINITY.getChestplate().get() ||
                event.getEntityItem().getItem().getItem() == Tools.INFINITY.getLeggings().get() ||
                event.getEntityItem().getItem().getItem() == Tools.INFINITY.getBoots().get() ||
                event.getEntityItem().getItem().getItem() == OreMaterial.INFINITY.getIngot().get() ||
                event.getEntityItem().getItem().getItem() == OreMaterial.INFINITY.getNugget().get() ||
                event.getEntityItem().getItem().getItem() == OreMaterial.INFINITY.getDust().get() ||
                event.getEntityItem().getItem().getItem() == OreMaterial.INFINITY.getStorageBlock().get().asItem().getItem() ||
                event.getEntityItem().getItem().getItem() == OreMaterial.INFINITY.getOre().get().asItem().getItem()) {
            event.getEntityItem().setInvulnerable(true);
        }
    }
}