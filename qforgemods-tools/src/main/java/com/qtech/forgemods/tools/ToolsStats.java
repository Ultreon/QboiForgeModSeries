package com.qtech.forgemods.tools;

import com.qtech.forgemods.materials.QFMMaterials;
import lombok.experimental.UtilityClass;
import net.minecraft.stats.IStatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;

@UtilityClass
public class ToolsStats {
    private static final HashMap<String, IStatFormatter> PRE_REGISTER = new HashMap<>();

    public static final ResourceLocation INFINITY_KILL = registerCustomStat("infinity_kill");

    @SuppressWarnings("SameParameterValue")
    private static ResourceLocation registerCustomStat(String name) {
        ResourceLocation resourcelocation = new ResourceLocation(QFMMaterials.modId, name);
        Registry.register(Registry.CUSTOM_STAT, name, resourcelocation);
        Stats.CUSTOM.get(resourcelocation, IStatFormatter.DEFAULT);
        return resourcelocation;
    }

    public static void register() {

    }
}
