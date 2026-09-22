package com.onticentity.ruby.client.datagens;

import com.onticentity.ruby.Rubis;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.DataProvider;
import com.mojang.serialization.Codec;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class RubisEquipmentAssetProvider implements DataProvider {
    public static final ResourceKey<EquipmentAsset> RUBY = ResourceKey.create(
            EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(Rubis.MOD_ID, "ruby")
    );

    private final PackOutput.PathProvider pathProvider;

    public RubisEquipmentAssetProvider(PackOutput output) {
        this.pathProvider = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    private static void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer) {
        consumer.accept(
                RUBY,
                EquipmentClientInfo.builder()
                        .addHumanoidLayers(Identifier.fromNamespaceAndPath(Rubis.MOD_ID, "ruby"))
                        .build()
        );
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> equipmentAssets = new HashMap<>();
        bootstrap((id, asset) -> {
            if (equipmentAssets.putIfAbsent(id, asset) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + id);
            }
        });
        Codec<EquipmentClientInfo> codec = EquipmentClientInfo.CODEC;
        PackOutput.PathProvider provider = this.pathProvider;
        Objects.requireNonNull(provider);
        return DataProvider.saveAll(cache, codec, provider::json, equipmentAssets);
    }

    @Override
    public String getName() {
        return "RubyEquipmentAssetProvider";
    }

}
