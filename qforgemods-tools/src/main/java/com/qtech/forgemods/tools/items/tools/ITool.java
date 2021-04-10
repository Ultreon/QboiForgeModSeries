package com.qtech.forgemods.tools.items.tools;

import com.qtech.forgemods.tools.QFMTools;
import com.qtech.forgemods.tools.items.tools.trait.AbstractTrait;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;

@Mod.EventBusSubscriber(modid = QFMTools.modId)
public interface ITool {
    AbstractTrait[] getTraits();
    Set<ToolType> getQfmToolTypes();

    @SubscribeEvent
    static void onLivingDamage(LivingDamageEvent e) {
        LivingEntity entityLiving = e.getEntityLiving();
        if (entityLiving.getHeldItem(Hand.MAIN_HAND).getItem() instanceof ArmorTool) {
            ArmorTool item = (ArmorTool) entityLiving.getHeldItem(Hand.MAIN_HAND).getItem();
            item.onLivingDamage(e);
        }
    }
}
