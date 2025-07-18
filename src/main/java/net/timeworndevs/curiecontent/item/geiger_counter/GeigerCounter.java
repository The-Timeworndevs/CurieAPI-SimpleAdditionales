package net.timeworndevs.curiecontent.item.geiger_counter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.timeworndevs.curieapi.util.CurieAPIConfig;
import net.timeworndevs.curieapi.util.PlayerCache;


public class GeigerCounter extends Item {

    public GeigerCounter(Settings settings) {
        super(settings);
    }
    private int tick = 0;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        super.inventoryTick(stack, world, entity, slot, selected);
        if (entity instanceof PlayerEntity player) {
            if (player.isHolding(this)) {
                tick = Math.max(--tick, 0);
                if (tick == 0) {
                    PlayerCache cache = PlayerCache.get(player);

                    float radiation = cache.getPrevBiomeRadiation().addAllTypes() + cache.getPrevBlockRadiation().addAllTypes();

                    updateNBT(world, stack, radiation, RadiationReading.ENVIRONMENT);
                }
            }
        }

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

        ItemStack geigerCounter = player.getStackInHand(hand);
        ItemStack itemStack = hand.equals(Hand.MAIN_HAND) ? player.getOffHandStack() : player.getMainHandStack();
        if (!itemStack.isEmpty()) {
            Item item = itemStack.getItem();
            if (CurieAPIConfig.ITEM_RADIATION_VALUES.containsKey(item)) {
                float radiation = CurieAPIConfig.ITEM_RADIATION_VALUES.get(item).addAllTypes();
                updateNBT(world, player.getStackInHand(hand), radiation, RadiationReading.ITEM);
                tick = 100;
            }
            return TypedActionResult.success(geigerCounter);
        }
        return TypedActionResult.pass(geigerCounter);
    }

    private void updateNBT(World world, ItemStack stack, float radiation, RadiationReading type) {
        if (!world.isClient) {
            NbtCompound nbt = stack.getOrCreateSubNbt("quantum:radiation");
            nbt.putFloat("Detected", radiation);
            nbt.putString("ReadingType", type.name());
        }
    }
}
