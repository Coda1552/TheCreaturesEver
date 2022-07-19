package coda.thecreaturesever.client.render.armor;

import coda.thecreaturesever.client.model.armor.BearCloakModel;
import coda.thecreaturesever.common.items.BearCloakArmorItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BearCloakArmorRenderer extends GeoArmorRenderer<BearCloakArmorItem> {

    public BearCloakArmorRenderer() {
        super(new BearCloakModel());

        //These values are what each bone name is in blockbench. So if your head bone is named "bone545",
        // make sure to do this.headBone = "bone545";

        // The default values are the ones that come with the default armor template in the geckolib blockbench plugin.
        this.headBone = "armorHead";
    }

    @Override
    public void render(float partialTicks, PoseStack stack, VertexConsumer bufferIn, int packedLightIn) {
        super.render(partialTicks, stack, bufferIn, packedLightIn);
    }

}