package coda.thecreaturesever.registry;

import coda.thecreaturesever.TheCreaturesEver;
import coda.thecreaturesever.common.items.AcornCapArmorItem;
import coda.thecreaturesever.common.items.BearCloakArmorItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> SEA_BEAK_SPAWN_EGG = ITEMS.register("sea_beak_spawn_egg", () -> new ForgeSpawnEggItem(TCEEntities.SEA_BEAK, 0x354443, 0x57f5a1, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> DANDY_DEER_SPAWN_EGG = ITEMS.register("dandy_deer_spawn_egg", () -> new ForgeSpawnEggItem(TCEEntities.DANDY_DEER, 0xa6ef71, 0xcfece1, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> CIVET_SPAWN_EGG = ITEMS.register("civet_spawn_egg", () -> new ForgeSpawnEggItem(TCEEntities.CIVET, 0xb2aa61, 0x322c1f, new Item.Properties().tab(TAB)));

    public static final RegistryObject<Item> ACORN_CAP = ITEMS.register("acorn_cap", () -> new AcornCapArmorItem(EquipmentSlot.HEAD, new Item.Properties().stacksTo(1).tab(TAB)));
    public static final RegistryObject<Item> BEAR_HOOD = ITEMS.register("bear_hood", () -> new BearCloakArmorItem(EquipmentSlot.HEAD, new Item.Properties().stacksTo(1).tab(TAB)));
    public static final RegistryObject<Item> BEAR_CLOAK = ITEMS.register("bear_cloak", () -> new BearCloakArmorItem(EquipmentSlot.CHEST, new Item.Properties().stacksTo(1).tab(TAB)));

    public static final RegistryObject<Item> COFFEE_BEAN = ITEMS.register("coffee_bean", () -> new Item(new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> COFFEE = ITEMS.register("coffee", () -> new HoneyBottleItem(new Item.Properties().tab(TAB).stacksTo(1).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.2F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0), 1.0F).build())));
}