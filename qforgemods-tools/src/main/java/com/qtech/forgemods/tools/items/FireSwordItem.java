package com.qtech.forgemods.tools.items;

import com.qtech.forgemods.tools.items.tools.ModTraits;
import com.qtech.forgemods.tools.items.tools.SwordTool;
import com.qtech.forgemods.tools.items.tools.trait.AbstractTrait;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;

/**
 * Fire sword item class.
 *
 * @author Qboi123
 */
public class FireSwordItem extends SwordTool {
    public FireSwordItem(ItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties, () -> new AbstractTrait[]{ModTraits.BLAZE.get()});
    }
}
