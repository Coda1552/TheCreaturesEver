package coda.thecreaturesever.common.items;

import coda.thecreaturesever.TheCreaturesEver;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;

public class AcornCapArmorItem extends GeoArmorItem implements IAnimatable {
    public static final ArmorMaterial MATERIAL = new TCEArmorMaterial(TheCreaturesEver.MOD_ID + ":acorn_cap", 1, new int[]{1, 1, 1, 1}, 1, SoundEvents.ARMOR_EQUIP_TURTLE, 0.0F, null);
    private final AnimationFactory factory = new AnimationFactory(this);

    public AcornCapArmorItem(EquipmentSlot slot, Item.Properties builder) {
        super(MATERIAL, slot, builder);
    }

    @Override
    public void registerControllers(AnimationData animationData) {}

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
