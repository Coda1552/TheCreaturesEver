package coda.thecreaturesever.registry;

import coda.thecreaturesever.TheCreaturesEver;
import coda.thecreaturesever.common.items.AcornCapArmorItem;
import coda.thecreaturesever.common.items.BearCloakArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TCEItems {
    public static final CreativeModeTab TAB = new CreativeModeTab(TheCreaturesEver.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ACORN_CAP.get());
        }
    };

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheCreaturesEver.MOD_ID);

    public static final RegistryObject<Item> SEA_BEAK_SPAWN_EGG =
            ITEMS.register("sea_beak_spawn_egg", () -> new ForgeSpawnEggItem(TCEEntities.SEA_BEAK, 0x354443, 0x57f5a1, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> DANDY_DEER_SPAWN_EGG =
            ITEMS.register("dandy_deer_spawn_egg", () -> new ForgeSpawnEggItem(TCEEntities.DANDY_DEER, 0xa6ef71, 0xcfece1, new Item.Properties().tab(TAB)));

    public static final RegistryObject<Item> ACORN_CAP = ITEMS.register("acorn_cap", () -> new AcornCapArmorItem(EquipmentSlot.HEAD, new Item.Properties().stacksTo(1).tab(TAB)));
    public static final RegistryObject<Item> BEAR_HOOD = ITEMS.register("bear_hood", () -> new BearCloakArmorItem(EquipmentSlot.HEAD, new Item.Properties().stacksTo(1).tab(TAB)));
    public static final RegistryObject<Item> BEAR_CLOAK = ITEMS.register("bear_cloak", () -> new BearCloakArmorItem(EquipmentSlot.CHEST, new Item.Properties().stacksTo(1).tab(TAB)));

}