package com.qtech.forgemods.materials;

import com.qsoftware.modlib.api.providers.IItemProvider;
import com.qsoftware.modlib.silentlib.registry.ItemDeferredRegister;
import com.qtech.forgemods.materials.items.tools.ModTraits;
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
public final class MaterialsRegistration {
    public static final DeferredRegister<Block> BLOCKS = create(ForgeRegistries.BLOCKS);
    public static final DeferredRegister<Fluid> FLUIDS = create(ForgeRegistries.FLUIDS);
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(QFMMaterials.modId);
    public static final DeferredRegister<ParticleType<?>> PARTICLES = create(ForgeRegistries.PARTICLE_TYPES);
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = create(ForgeRegistries.RECIPE_SERIALIZERS);

    public static void register() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MaterialsRegistration.BLOCKS.register(modEventBus);
        MaterialsRegistration.ITEMS.register(modEventBus);
        MaterialsRegistration.RECIPE_SERIALIZERS.register(modEventBus);
        ModTraits.REGISTRY.register(modEventBus);

        MaterialStats.register();
        MaterialsBlocks.register();
        MaterialsFluids.register();
        MaterialsItems.register();
        ModTraits.register();
    }

    @SuppressWarnings("unchecked")
    public static <T extends Block> Collection<T> getBlocks(Class<T> clazz) {
        return BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .filter(clazz::isInstance)
                .map(block -> (T) block)
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public static <T extends Block> Collection<T> getBlocks() {
        return BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .map(block -> (T) block)
                .collect(Collectors.toList());
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
