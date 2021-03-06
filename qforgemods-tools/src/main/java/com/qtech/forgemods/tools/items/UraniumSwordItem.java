package com.qtech.forgemods.tools.items;

import com.qtech.forgemods.tools.QFMTools;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Infinity sword item class.
 *
 * @author Qboi123
 */
public class UraniumSwordItem extends SwordItem {
    public UraniumSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Properties().group(QFMTools.ITEM_GROUP));
    }

    @Override
    public boolean hitEntity(@NotNull ItemStack stack, @NotNull LivingEntity victim, @NotNull LivingEntity player) {
        victim.addPotionEffect(new EffectInstance(Effects.WITHER, ThreadLocalRandom.current().nextInt(50, 120), 2, true, false));
        return true;
    }
}
