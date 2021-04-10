package com.qtech.forgemods.materials;

import com.qtech.forgemods.materials.groups.*;
import lombok.experimental.UtilityClass;

/**
 * ModItemGroups collection.
 *
 * @author Qboi123
 */
@UtilityClass
public class MaterialsItemGroups {
    public static final WoodItemGroup WOOD = WoodItemGroup.instance;
    public static final OresItemGroup ORES = OresItemGroup.instance;
    public static final MetalCraftablesItemGroup METAL_CRAFTABLES = MetalCraftablesItemGroup.instance;
    public static final GemsItemGroup GEMS = GemsItemGroup.instance;
    public static final FluidItemGroup FLUIDS = FluidItemGroup.instance;
}
