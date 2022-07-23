package coda.thecreaturesever.client;

import coda.thecreaturesever.TheCreaturesEver;
import coda.thecreaturesever.client.model.armor.BearCapeModel;
import coda.thecreaturesever.client.render.SimpleGeoRenderer;
import coda.thecreaturesever.client.render.armor.AcornCapArmorRenderer;
import coda.thecreaturesever.common.items.AcornCapArmorItem;
import coda.thecreaturesever.registry.TCEEntities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = TheCreaturesEver.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(final FMLClientSetupEvent e) {
        EntityRenderers.register(TCEEntities.SEA_BEAK.get(), mgr -> new SimpleGeoRenderer<>(mgr, TheCreaturesEver.MOD_ID, "sea_beak"));
        EntityRenderers.register(TCEEntities.DANDY_DEER.get(), mgr -> new SimpleGeoRenderer<>(mgr, TheCreaturesEver.MOD_ID, "dandy_deer"));
        EntityRenderers.register(TCEEntities.CIVET.get(), mgr -> new SimpleGeoRenderer<>(mgr, TheCreaturesEver.MOD_ID, "civet"));

        ForgeHooksClient.registerLayerDefinition(BearCapeModel.LAYER_LOCATION, BearCapeModel::createBodyLayer);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenders(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(AcornCapArmorItem.class, new AcornCapArmorRenderer());
    }
}