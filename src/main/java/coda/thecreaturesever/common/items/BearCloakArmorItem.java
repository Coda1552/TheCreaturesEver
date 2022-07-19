package coda.thecreaturesever.common.items;

import coda.thecreaturesever.TheCreaturesEver;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;

public class BearCloakArmorItem extends GeoArmorItem implements IAnimatable {
    public static final ArmorMaterial MATERIAL = new TCEArmorMaterial(TheCreaturesEver.MOD_ID + ":bear_cloak", 1, new int[]{1, 1, 1, 1}, 1, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, null);
    private final AnimationFactory factory = new AnimationFactory(this);

    public BearCloakArmorItem(EquipmentSlot slot, Properties builder) {
        super(MATERIAL, slot, builder);
    }

    @Override
    public void registerControllers(AnimationData animationData) {}

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
