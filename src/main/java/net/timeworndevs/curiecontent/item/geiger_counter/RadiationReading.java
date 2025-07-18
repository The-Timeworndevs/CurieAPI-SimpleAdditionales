package net.timeworndevs.curiecontent.item.geiger_counter;

import net.minecraft.util.Identifier;
import net.timeworndevs.curiecontent.CurieContent;
import org.jetbrains.annotations.NotNull;

public enum RadiationReading {
    BLOCK("block"),
    ITEM("item"),
    ENVIRONMENT("environment"),;

    public final Identifier identifier;
    RadiationReading(String name) {
        this.identifier = new Identifier(CurieContent.MOD_ID, "textures/item/geiger_counter/" + name + ".png");
    }

    @Override
    public String toString() {
        return "RadiationReading{" +
                "identifier=" + identifier +
                '}';
    }

    public static RadiationReading fromString(@NotNull String name) {
        return RadiationReading.valueOf(name.toUpperCase());
    }
}
