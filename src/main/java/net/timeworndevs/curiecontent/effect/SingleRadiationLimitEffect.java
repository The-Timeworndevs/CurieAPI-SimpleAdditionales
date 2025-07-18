package net.timeworndevs.curiecontent.effect;

import net.minecraft.server.network.ServerPlayerEntity;
import net.timeworndevs.curieapi.radiation.RadiationEffect;
import net.timeworndevs.curieapi.radiation.RadiationEntry;
import net.timeworndevs.curieapi.radiation.RadiationType;

import java.util.Map;
import java.util.function.BiConsumer;

public class SingleRadiationLimitEffect implements RadiationEffect {
    private final RadiationType type;
    private final float threshold;
    private final BiConsumer<ServerPlayerEntity, RadiationEntry> consumer;
    public SingleRadiationLimitEffect(RadiationType type, float threshold , BiConsumer<ServerPlayerEntity, RadiationEntry> consumer) {
        this.type = type;
        this.threshold = threshold;
        this.consumer = consumer;
    }

    @Override
    public void applyEffect(ServerPlayerEntity serverPlayerEntity, RadiationEntry hashMap) {
        if (hashMap.containsKey(this.type) && hashMap.get(this.type) >= this.threshold) {
            consumer.accept(serverPlayerEntity, hashMap);
        }
    }
}
