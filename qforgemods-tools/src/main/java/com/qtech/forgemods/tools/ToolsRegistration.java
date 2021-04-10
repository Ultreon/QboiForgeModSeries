package com.qtech.forgemods.tools;

import com.qsoftware.modlib.api.providers.IItemProvider;
import com.qsoftware.modlib.silentlib.registry.ItemDeferredRegister;
import com.qtech.forgemods.materials.*;
import com.qtech.forgemods.tools.items.tools.ModTraits;
import lombok.experimental.UtilityClass;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@UtilityClass
public final class ToolsRegistration {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(QFMMaterials.modId);

    public static void register() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModTraits.REGISTRY.register(modEventBus);
        ToolsRegistration.ITEMS.register(modEventBus);
        ToolsItems.register();
        ToolsStats.register();
        ModTraits.register();
    }

    @SuppressWarnings("unchecked")
    public static <T extends Item> Collection<T> getItems(Class<T> clazz) {
        return ITEMS.getAllItems().stream()
                .map(IItemProvider::asItem)
                .filter(clazz::isInstance)
                .map(item -> (T) item)
                .collect(Collectors.toList());
    }

    public static Collection<Item> getItems(Predicate<Item> predicate) {
        return ITEMS.getAllItems().stream()
                .map(IItemProvider::asItem)
                .filter(predicate)
                .collect(Collectors.toList());
    }

    private static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
        return DeferredRegister.create(registry, QFMMaterials.modId);
    }
}
