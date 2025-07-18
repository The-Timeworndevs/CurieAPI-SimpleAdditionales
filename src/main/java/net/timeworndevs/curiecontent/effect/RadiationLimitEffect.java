package net.timeworndevs.curiecontent.effect;

import net.minecraft.server.network.ServerPlayerEntity;
import net.timeworndevs.curieapi.radiation.RadiationEntry;
import net.timeworndevs.curieapi.radiation.RadiationType;
import net.timeworndevs.curieapi.radiation.RadiationEffect;

import java.util.function.BiConsumer;

public class RadiationLimitEffect implements RadiationEffect {
    private final RadiationEntry radiations;
    private final BiConsumer<ServerPlayerEntity, RadiationEntry> consumer;
    public RadiationLimitEffect(RadiationEntry radiations, BiConsumer<ServerPlayerEntity, RadiationEntry> consumer) {
        this.radiations = radiations;
        this.consumer = consumer;
    }

    @Override
    public void applyEffect(ServerPlayerEntity serverPlayerEntity, RadiationEntry hashMap) {
        boolean state = true;
        for (RadiationType type : radiations.entries().keySet()) {
            if (!hashMap.containsKey(type) || hashMap.get(type) < radiations.get(type)) {
                state = false;
                break;
            }
        }
        if (state) {
            consumer.accept(serverPlayerEntity, hashMap);
        }
    }
}
