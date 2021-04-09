package com.qtech.forgemods.materials.items;

import com.qtech.forgemods.materials.MaterialsItemGroups;
import com.qtech.forgemods.materials.groups.MetalCraftablesItemGroup;
import net.minecraft.item.Item;

/**
 * Item or dust item class.
 * Used for metal crafting items. Such as ingots or nuggets.
 * Has a default group: {@link MetalCraftablesItemGroup} from the field {@link MaterialsItemGroups#METAL_CRAFTABLES}
 *
 * @author Qboi123
 */
public class IngotOrDustItem extends Item {
    public IngotOrDustItem() {
        super(new Item.Properties().group(MaterialsItemGroups.METAL_CRAFTABLES));
    }
}
