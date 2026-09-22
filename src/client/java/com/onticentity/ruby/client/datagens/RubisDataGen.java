package com.onticentity.ruby.client.datagens;

import com.onticentity.ruby.datagens.RubisBlockLootTableProvider;
import com.onticentity.ruby.datagens.RubisBlockTagProvider;
import com.onticentity.ruby.datagens.RubisWorldgenProvider;
import com.onticentity.ruby.worldgen.RubisConfiguredFeatures;
import com.onticentity.ruby.worldgen.RubisPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class RubisDataGen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(RubisModelProvider::new);
        pack.addProvider(RubisWorldgenProvider::new);
        pack.addProvider(RubisBlockLootTableProvider::new);
        pack.addProvider(RubisBlockTagProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, RubisConfiguredFeatures::configure);
        registryBuilder.add(Registries.PLACED_FEATURE, RubisPlacedFeatures::configure);
    }
}