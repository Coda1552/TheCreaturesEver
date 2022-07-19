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
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.AnimalTameEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
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
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;

		bus.addListener(this::setup);
		bus.addListener(this::registerRenders);
		bus.addListener(TCEEntities::registerAttributes);
		bus.addListener(TCEEntities::registerRenderers);

		forgeBus.addListener(this::addSpawns);

		TCEEntities.ENTITIES.register(bus);
		TCEItems.ITEMS.register(bus);
	}

	private void setup(final FMLCommonSetupEvent event) {
		SpawnPlacements.register(TCEEntities.SEA_BEAK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SeaBeakEntity::checkSeaBeakSpawnRules);
		SpawnPlacements.register(TCEEntities.DANDY_DEER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
	}

	private void addSpawns(final BiomeLoadingEvent event) {
		if (event.getName().getPath().equals("flower_forest")) {
			event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TCEEntities.DANDY_DEER.get(), 1, 2, 4));
		}
	}

	private void registerRenders(final EntityRenderersEvent.AddLayers event) {
		GeoArmorRenderer.registerArmorRenderer(AcornCapArmorItem.class, new AcornCapArmorRenderer());
		GeoArmorRenderer.registerArmorRenderer(BearCloakArmorItem.class, new BearCloakArmorRenderer());
	}
}