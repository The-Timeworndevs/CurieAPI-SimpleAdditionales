package net.timeworndevs.curiecontent.registries;

import net.timeworndevs.curieapi.radiation.RadiationType;

import java.util.List;

public class CurieContentRadiationTypes {

    public static final RadiationType GAMMA = RadiationType.register("gamma", List.of(0.0f, 0.2f, 0.33f, 1.0f));
    public static final RadiationType BETA = RadiationType.register("beta", List.of(0.24f, 0.33f, 0.2f, 1.0f));
    public static final RadiationType ALPHA = RadiationType.register("alpha", List.of(0.35f, 0.0f, 0.0f, 1.0f));
    public static final RadiationType NEUTRON = RadiationType.register("neutron", List.of(0.5f, 1.0f, 0.5f, 1.0f));

    public static void registerRadiationTypes() {}
}
