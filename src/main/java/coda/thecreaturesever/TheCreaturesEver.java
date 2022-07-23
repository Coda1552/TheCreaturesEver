package coda.thecreaturesever;

import coda.thecreaturesever.common.entities.SeaBeakEntity;
import coda.thecreaturesever.registry.TCEEntities;
import coda.thecreaturesever.registry.TCEItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(TheCreaturesEver.MOD_ID)
public class TheCreaturesEver {
	public static final String MOD_ID = "thecreaturesever";
	private static final Logger LOGGER = LogUtils.getLogger();

	public TheCreaturesEver() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;

		bus.addListener(this::setup);
		bus.addListener(TCEEntities::registerAttributes);

		forgeBus.addListener(this::addSpawns);

		TCEEntities.ENTITIES.register(bus);
		TCEItems.ITEMS.register(bus);
	}

	private void setup(final FMLCommonSetupEvent event) {
		SpawnPlacements.register(TCEEntities.SEA_BEAK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SeaBeakEntity::checkSeaBeakSpawnRules);
		SpawnPlacements.register(TCEEntities.DANDY_DEER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(TCEEntities.CIVET.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
	}

	private void addSpawns(final BiomeLoadingEvent event) {
		if (event.getName().getPath().equals("flower_forest")) {
			event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TCEEntities.DANDY_DEER.get(), 1, 2, 4));
		}
		if (event.getCategory().equals(Biome.BiomeCategory.SAVANNA)) {
			event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TCEEntities.CIVET.get(), 1, 1, 1));
		}
	}
}