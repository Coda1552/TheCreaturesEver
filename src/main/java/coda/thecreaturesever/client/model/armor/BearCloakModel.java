package coda.thecreaturesever.client.model.armor;

import coda.thecreaturesever.TheCreaturesEver;
import coda.thecreaturesever.common.items.BearCloakArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BearCloakModel extends AnimatedGeoModel<BearCloakArmorItem> {

	@Override
	public ResourceLocation getModelLocation(BearCloakArmorItem object) {
		return new ResourceLocation(TheCreaturesEver.MOD_ID, "geo/bear_cloak.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(BearCloakArmorItem object) {
		return new ResourceLocation(TheCreaturesEver.MOD_ID, "textures/armor/bear_cloak.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(BearCloakArmorItem object) {
		return null;
	}
}
