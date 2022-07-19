package coda.thecreaturesever.registry;

import coda.thecreaturesever.TheCreaturesEver;
import coda.thecreaturesever.client.render.SimpleGeoRenderer;
import coda.thecreaturesever.common.entities.CivetEntity;
import coda.thecreaturesever.common.entities.DandyDeerEntity;
import coda.thecreaturesever.common.entities.SeaBeakEntity;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TCEEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, TheCreaturesEver.MOD_ID);

    public static final RegistryObject<EntityType<SeaBeakEntity>> SEA_BEAK =
            ENTITIES.register("sea_beak", () -> EntityType.Builder.of(SeaBeakEntity::new, MobCategory.WATER_CREATURE)
                    .sized(0.65F, 0.4F)
                    .setTrackingRange(16)
                    .updateInterval(1)
                    .build("sea_beak"));

    public static final RegistryObject<EntityType<DandyDeerEntity>> DANDY_DEER =
            ENTITIES.register("dandy_deer", () -> EntityType.Builder.of(DandyDeerEntity::new, MobCategory.CREATURE)
                    .sized(0.55F, 1.5F)
                    .setTrackingRange(16)
                    .updateInterval(1)
                    .build("dandy_deer"));

    public static final RegistryObject<EntityType<CivetEntity>> CIVET =
            ENTITIES.register("civet", () -> EntityType.Builder.of(CivetEntity::new, MobCategory.CREATURE)
                    .sized(0.85F, 0.6F)
                    .setTrackingRange(16)
                    .updateInterval(1)
                    .build("civet"));

    public static void registerAttributes(final EntityAttributeCreationEvent e) {
        e.put(TCEEntities.SEA_BEAK.get(), SeaBeakEntity.createAttributes().build());
        e.put(TCEEntities.DANDY_DEER.get(), DandyDeerEntity.createAttributes().build());
        e.put(TCEEntities.CIVET.get(), CivetEntity.createAttributes().build());
    }
    
    public static void registerRenderers(final FMLClientSetupEvent e) {
        EntityRenderers.register(TCEEntities.SEA_BEAK.get(), mgr -> new SimpleGeoRenderer<>(mgr, TheCreaturesEver.MOD_ID, "sea_beak"));
        EntityRenderers.register(TCEEntities.DANDY_DEER.get(), mgr -> new SimpleGeoRenderer<>(mgr, TheCreaturesEver.MOD_ID, "dandy_deer"));
        EntityRenderers.register(TCEEntities.CIVET.get(), mgr -> new SimpleGeoRenderer<>(mgr, TheCreaturesEver.MOD_ID, "civet"));
    }
    
}