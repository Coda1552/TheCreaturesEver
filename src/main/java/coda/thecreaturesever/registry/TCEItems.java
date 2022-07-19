package coda.thecreaturesever.registry;

import coda.thecreaturesever.TheCreaturesEver;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TCEItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheCreaturesEver.ID);

    // Spawn Eggs
    public static final RegistryObject<Item> SEA_BEAK_SPAWN_EGG =
            ITEMS.register("sea_beak_spawn_egg", () -> new ForgeSpawnEggItem(TCEEntities.SEA_BEAK, 0x354443, 0x57f5a1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

}