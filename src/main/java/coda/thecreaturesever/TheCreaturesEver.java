package coda.thecreaturesever;

import coda.thecreaturesever.common.entities.SeaBeakEntity;
import coda.thecreaturesever.registry.TCEEntities;
import coda.thecreaturesever.registry.TCEItems;
import com.mojang.logging.LogUtils;
import net.minecraft.SharedConstants;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

@Mod(TheCreaturesEver.ID)
public class TheCreaturesEver {
	public static final String ID = "thecreaturesever";
	private static final Logger LOGGER = LogUtils.getLogger();

	public TheCreaturesEver() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);
		bus.addListener(TCEEntities::registerAttributes);
		bus.addListener(TCEEntities::registerRenderers);
		TCEEntities.ENTITIES.register(bus);
		TCEItems.ITEMS.register(bus);

//		MinecraftForge.EVENT_BUS.register(this);
	}
	
	/**
	 * Set a breakpoint {@link net.minecraft.Util#doPause(String) here} to debug any crash in the IDE
	 */
	private void setup(final FMLCommonSetupEvent event) {
		SpawnPlacements.register(TCEEntities.SEA_BEAK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SeaBeakEntity::checkSeaBeakSpawnRules);

		SharedConstants.IS_RUNNING_IN_IDE = !FMLEnvironment.production;
	}
}