package coda.thecreaturesever.client.render.armor;

import coda.thecreaturesever.client.model.armor.AcornCapModel;
import coda.thecreaturesever.common.items.AcornCapArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class AcornCapArmorRenderer extends GeoArmorRenderer<AcornCapArmorItem> {

    public AcornCapArmorRenderer() {
        super(new AcornCapModel());

        //These values are what each bone name is in blockbench. So if your head bone is named "bone545",
        // make sure to do this.headBone = "bone545";

        // The default values are the ones that come with the default armor template in the geckolib blockbench plugin.
        this.headBone = "armorHead";
    }
}