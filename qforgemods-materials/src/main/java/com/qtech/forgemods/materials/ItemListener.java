package com.qtech.forgemods.materials;

import lombok.experimental.UtilityClass;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.eventbus.api.EventPriority;
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
        if (isInfinity(event.getEntityItem()) ||
                event.getEntityItem().getItem().getItem() == OreMaterial.INFINITY.getIngot().get() ||
                event.getEntityItem().getItem().getItem() == OreMaterial.INFINITY.getNugget().get() ||
                event.getEntityItem().getItem().getItem() == OreMaterial.INFINITY.getDust().get() ||
                event.getEntityItem().getItem().getItem() == OreMaterial.INFINITY.getStorageBlock().get().asItem().getItem() ||
                event.getEntityItem().getItem().getItem() == OreMaterial.INFINITY.getOre().get().asItem().getItem()) {
            event.getEntityItem().setInvulnerable(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = true)
    public static void onItemExpire(ItemExpireEvent event) {
        if (isInfinity(event.getEntityItem())) {
            event.setCanceled(true);
        }
    }

    private static boolean isInfinity(ItemEntity entityItem) {
        return isInfinity(entityItem.getItem());
    }

    public static boolean isInfinity(Item item) {
        ResourceLocation registryName = item.getRegistryName();
        return registryName != null && (registryName.toString().equals("qfm_tools:infinity_shovel") ||
                registryName.toString().equals("qfm_tools:infinity_pickaxe") ||
                registryName.toString().equals("qfm_tools:infinity_hoe") ||
                registryName.toString().equals("qfm_tools:infinity_sword") ||
                registryName.toString().equals("qfm_tools:infinity_axe") ||
                registryName.toString().equals("qfm_tools:infinity_helmet") ||
                registryName.toString().equals("qfm_tools:infinity_chestplate") ||
                registryName.toString().equals("qfm_tools:infinity_leggings") ||
                registryName.toString().equals("qfm_tools:infinity_boots") ||
                item.equals(OreMaterial.INFINITY.getChunks().orElse(null)) ||
                item.equals(OreMaterial.INFINITY.getDust().orElse(null)) ||
                item.equals(OreMaterial.INFINITY.getIngot().orElse(null)) ||
                item.equals(OreMaterial.INFINITY.getNugget().orElse(null)) ||
                item.equals(OreMaterial.INFINITY.getOre().orElseThrow(() -> new IllegalArgumentException("Infinity ore not found")).asItem()) ||
                item.equals(OreMaterial.INFINITY.getStorageBlock().orElseThrow(() -> new IllegalArgumentException("Infinity block not found")).asItem()));
    }

    public static boolean isInfinity(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        }

        return isInfinity(stack.getItem());
    }

    public static boolean isInfinity(IItemProvider itemProvider) {
        return isInfinity(itemProvider.asItem());
    }

    public static boolean isInfinity(com.qsoftware.modlib.api.providers.IItemProvider itemProvider) {
        return isInfinity(itemProvider.asItemStack());
    }
}
