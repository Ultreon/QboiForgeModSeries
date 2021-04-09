package com.qtech.forgemods.materials;

import com.qtech.filters.Filters;
import com.qtech.forgemods.core.common.ModuleManager;
import com.qtech.forgemods.core.common.interfaces.IHasRenderType;
import com.qtech.forgemods.core.modules.items.objects.advanced.AdvancedBowItem;
import com.qtech.forgemods.materials.items.tools.Tools;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

/**
 * Initialization class for QFM: Materials.
 *
 * @author Qboi123
 * @see QFMMaterials
 */
class MaterialsInit {
    private final Logger logger;
    private final QFMMaterials mod;
    private MinecraftServer server;

    public static MinecraftServer getServer() {
        return Objects.requireNonNull(QFMMaterials.getInit()).server;
    }

    /**
     * Constructor
     *
     * @param mod the mod.
     */
    MaterialsInit(QFMMaterials mod) {
        this.mod = mod;
        this.logger = QFMMaterials.LOGGER;
    }

    /**
     * Setup server side components.
     *
     * @param event a {@link FMLCommonSetupEvent} object.
     */
    @SuppressWarnings("unused")
    public void serverSetup(FMLDedicatedServerSetupEvent event) {
        ModuleManager.getInstance().serverSetup();
    }

    /**
     * Setup server side components.
     *
     * @param event a {@link FMLCommonSetupEvent} object.
     */
    public void commonSetup(FMLCommonSetupEvent event) {
        
    }

    /**
     * Setup client side components.
     *
     * @param event a {@link FMLClientSetupEvent} object.
     */
    public void clientSetup(@SuppressWarnings("unused") FMLClientSetupEvent event) {
        // do something that can only be done on the client

        ModuleManager.getInstance().clientSetup();
//        ((IReloadableResourceManager)Minecraft.getInstance().getResourceManager()).addReloadListener(QFMResouces::new);

        this.logger.info("Setting render layers for blocks.");
        for (Block block : MaterialsRegistration.getBlocks()) {
            if (block instanceof IHasRenderType) {
                IHasRenderType hasRenderType = (IHasRenderType) block;
                RenderTypeLookup.setRenderLayer(block, hasRenderType.getRenderType());
            }
        }

        for (Item item : MaterialsRegistration.getItems((item) -> item instanceof AdvancedBowItem)) {
            ItemModelsProperties.registerProperty(item, new ResourceLocation("pull"), (p_239429_0_, p_239429_1_, p_239429_2_) -> {
                if (p_239429_2_ == null) {
                    return 0.0F;
                } else {
                    return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F : (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
                }
            });

            ItemModelsProperties.registerProperty(item, new ResourceLocation("pulling"), (p_239428_0_, p_239428_1_, p_239428_2_) -> p_239428_2_ != null && p_239428_2_.isHandActive() && p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F);
        }

        Filters.get().register(MaterialsItemGroups.METAL_CRAFTABLES, new ResourceLocation("qfm_materials", "metal_craftables/dusts"), new ItemStack(OreMaterial.IRON.getDust().orElse(Items.AIR)));
        Filters.get().register(MaterialsItemGroups.METAL_CRAFTABLES, new ResourceLocation("qfm_materials", "metal_craftables/nuggets"), new ItemStack(Items.IRON_NUGGET));
        Filters.get().register(MaterialsItemGroups.METAL_CRAFTABLES, new ResourceLocation("qfm_materials", "metal_craftables/ingots"), new ItemStack(Items.IRON_INGOT));
        Filters.get().register(MaterialsItemGroups.METAL_CRAFTABLES, new ResourceLocation("qfm_materials", "metal_craftables/chunks"), new ItemStack(OreMaterial.IRON.getChunks().orElse(Items.AIR)));

        Filters.get().register(MaterialsItemGroups.FLUIDS, new ResourceLocation("qfm_materials", "fluids/liquid"), new ItemStack(MaterialsItems.OIL_BUCKET));
        Filters.get().register(MaterialsItemGroups.FLUIDS, new ResourceLocation("qfm_materials", "fluids/gas"), new ItemStack(MaterialsItems.ETHANE_BUCKET));

        Filters.get().register(MaterialsItemGroups.TOOLS, new ResourceLocation("qfm_materials", "tools/swords"), new ItemStack(Tools.COPPER.getSword()));
        Filters.get().register(MaterialsItemGroups.TOOLS, new ResourceLocation("qfm_materials", "tools/axes"), new ItemStack(Tools.COPPER.getAxe()));
        Filters.get().register(MaterialsItemGroups.TOOLS, new ResourceLocation("qfm_materials", "tools/pickaxes"), new ItemStack(Tools.COPPER.getPickaxe()));
        Filters.get().register(MaterialsItemGroups.TOOLS, new ResourceLocation("qfm_materials", "tools/shovels"), new ItemStack(Tools.COPPER.getShovel()));
        Filters.get().register(MaterialsItemGroups.TOOLS, new ResourceLocation("qfm_materials", "tools/hoes"), new ItemStack(Tools.COPPER.getHoe()));
        Filters.get().register(MaterialsItemGroups.TOOLS, new ResourceLocation("qfm_materials", "tools/longswords"), new ItemStack(Tools.COPPER.getLongsword()));
        Filters.get().register(MaterialsItemGroups.TOOLS, new ResourceLocation("qfm_materials", "tools/broadswords"), new ItemStack(Tools.COPPER.getBroadsword()));
        Filters.get().register(MaterialsItemGroups.TOOLS, new ResourceLocation("qfm_materials", "tools/katanas"), new ItemStack(Tools.COPPER.getKatana()));
        Filters.get().register(MaterialsItemGroups.TOOLS, new ResourceLocation("qfm_materials", "tools/battleaxes"), new ItemStack(Tools.COPPER.getBattleaxe()));
        Filters.get().register(MaterialsItemGroups.TOOLS, new ResourceLocation("qfm_materials", "tools/lumber_axes"), new ItemStack(Tools.COPPER.getLumberAxe()));
        Filters.get().register(MaterialsItemGroups.TOOLS, new ResourceLocation("qfm_materials", "tools/excavators"), new ItemStack(Tools.COPPER.getExcavator()));
        Filters.get().register(MaterialsItemGroups.TOOLS, new ResourceLocation("qfm_materials", "tools/hammers"), new ItemStack(Tools.COPPER.getHammer()));
    }

    /**
     * Do things on server start.
     *
     * @param event a {@link FMLServerStartingEvent} object.
     */
    public void serverStart(@SuppressWarnings("unused") FMLServerStartingEvent event) {
        logger.info("Hello server!");
        ModuleManager.getInstance().serverStart();
        server = event.getServer();
    }

    /**
     * Do things when load is complete.
     *
     * @param event a {@link FMLLoadCompleteEvent} object.
     */
    public void loadComplete(FMLLoadCompleteEvent event) {
        logger.info("LoadCompleteEvent: " + event);
        ModuleManager.getInstance().loadComplete();

        DistExecutor.unsafeRunForDist(() -> () -> {
            loadCompleteClient();
            return null;
        }, () -> () -> {
            loadCompleteServer();
            return null;
        });
    }

    public void loadCompleteServer() {

    }

    public void loadCompleteClient() {

    }

    public QFMMaterials getMod() {
        return mod;
    }
}
