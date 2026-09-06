package net.cacaique.TutorialMod;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(ModTutorial.MOD_ID);

    public static final DeferredItem<BucketItem> SCORCHMELT_BUCKET = ITEMS.registerItem(
            "scorchmelt_bucket",
            properties -> new BucketItem(ModFluids.SCORCHMELT_SOURCE,
                    properties.craftRemainder(Items.BUCKET).stacksTo(1)));
}