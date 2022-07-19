package coda.thecreaturesever.client.model.armor;

import coda.thecreaturesever.TheCreaturesEver;
import coda.thecreaturesever.common.items.AcornCapArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AcornCapModel extends AnimatedGeoModel<AcornCapArmorItem> {

	@Override
	public ResourceLocation getModelLocation(AcornCapArmorItem object) {
		return new ResourceLocation(TheCreaturesEver.MOD_ID, "geo/acorn_cap.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(AcornCapArmorItem object) {
		return new ResourceLocation(TheCreaturesEver.MOD_ID, "textures/armor/acorn_cap.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(AcornCapArmorItem object) {
		return null;
	}
}
