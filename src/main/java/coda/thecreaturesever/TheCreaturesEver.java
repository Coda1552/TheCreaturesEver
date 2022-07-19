package coda.thecreaturesever;

import coda.thecreaturesever.client.render.armor.AcornCapArmorRenderer;
import coda.thecreaturesever.client.render.armor.BearCloakArmorRenderer;
import coda.thecreaturesever.common.entities.SeaBeakEntity;
import coda.thecreaturesever.common.items.AcornCapArmorItem;
import coda.thecreaturesever.common.items.BearCloakArmorItem;
import coda.thecreaturesever.registry.TCEEntities;
import coda.thecreaturesever.registry.TCEItems;
import com.mojang.logging.LogUtils;
import net.minecraft.SharedConstants;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod(TheCreaturesEver.MOD_ID)
public class TheCreaturesEver {
	public static final String MOD_ID = "thecreaturesever";
	private static final Logger LOGGER = LogUtils.getLogger();

	public TheCreaturesEver() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		bus.addListener(this::setup);
		bus.addListener(this::registerRenders);
		bus.addListener(TCEEntities::registerAttributes);
		bus.addListener(TCEEntities::registerRenderers);

		TCEEntities.ENTITIES.register(bus);
		TCEItems.ITEMS.register(bus);

	}
	
	/**
	 * Set a breakpoint {@link net.minecraft.Util#doPause(String) here} to debug any crash in the IDE
	 */
	private void setup(final FMLCommonSetupEvent event) {
		SpawnPlacements.register(TCEEntities.SEA_BEAK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SeaBeakEntity::checkSeaBeakSpawnRules);

		SharedConstants.IS_RUNNING_IN_IDE = !FMLEnvironment.production;
	}

	private void registerRenders(final EntityRenderersEvent.AddLayers event) {
		GeoArmorRenderer.registerArmorRenderer(AcornCapArmorItem.class, new AcornCapArmorRenderer());
		GeoArmorRenderer.registerArmorRenderer(BearCloakArmorItem.class, new BearCloakArmorRenderer());
	}
}