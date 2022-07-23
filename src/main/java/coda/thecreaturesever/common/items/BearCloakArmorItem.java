package coda.thecreaturesever.common.items;

import coda.thecreaturesever.TheCreaturesEver;
import coda.thecreaturesever.client.model.armor.BearCapeModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.client.IItemRenderProperties;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class BearCloakArmorItem extends ArmorItem {
    public static final ArmorMaterial MATERIAL = new TCEArmorMaterial(TheCreaturesEver.MOD_ID + ":bear_cape", 1, new int[]{1, 1, 1, 1}, 1, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, null);

    public BearCloakArmorItem(EquipmentSlot slot, Properties builder) {
        super(MATERIAL, slot, builder);
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            @Nonnull
            @Override
            public Model getBaseArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> defaultModel) {
                if (BearCapeModel.INSTANCE == null) {
                    BearCapeModel.INSTANCE = new BearCapeModel<>(new EntityRendererProvider.Context(Minecraft.getInstance().getEntityRenderDispatcher(), Minecraft.getInstance().getItemRenderer(), Minecraft.getInstance().getResourceManager(), Minecraft.getInstance().getEntityModels(), Minecraft.getInstance().font).bakeLayer(new ModelLayerLocation(new ResourceLocation(TheCreaturesEver.MOD_ID, "bear_cape"), "main")));
                }
                return BearCapeModel.INSTANCE;
            }
        });
    }
}
