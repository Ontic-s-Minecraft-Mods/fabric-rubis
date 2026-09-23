package com.onticentity.ruby.worldgen;

import com.onticentity.ruby.Rubis;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class RubisPlacedFeatures {
    public static void configure(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        List<PlacementModifier> rubyOreVeinModifiers = List.of(
                CountPlacement.of(6),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(8))
        );
        context.register(
                RUBY_ORE_VEIN_SIZE_ONE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(RubisConfiguredFeatures.RUBY_ORE_VEIN_SIZE_ONE_CONFIGURED_KEY),
                        rubyOreVeinModifiers
                )
        );
        context.register(
                RUBY_ORE_VEIN_SIZE_TWO_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(RubisConfiguredFeatures.RUBY_ORE_VEIN_SIZE_TWO_CONFIGURED_KEY),
                        rubyOreVeinModifiers
                )
        );
        context.register(
                RUBY_ORE_VEIN_SIZE_THREE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(RubisConfiguredFeatures.RUBY_ORE_VEIN_SIZE_THREE_CONFIGURED_KEY),
                        rubyOreVeinModifiers
                )
        );
        context.register(
                RUBY_ORE_VEIN_SIZE_FOUR_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(RubisConfiguredFeatures.RUBY_ORE_VEIN_SIZE_FOUR_CONFIGURED_KEY    ),
                        rubyOreVeinModifiers
                )
        );
    }
    public static final ResourceKey<PlacedFeature> RUBY_ORE_VEIN_SIZE_ONE_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE,
            Rubis.id("ruby_ore_vein_size_one_placed_key")
    );
    public static final ResourceKey<PlacedFeature> RUBY_ORE_VEIN_SIZE_TWO_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE,
            Rubis.id("ruby_ore_vein_size_two_placed_key")
    );
    public static final ResourceKey<PlacedFeature> RUBY_ORE_VEIN_SIZE_THREE_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE,
            Rubis.id("ruby_ore_vein_size_three_placed_key")
    );
    public static final ResourceKey<PlacedFeature> RUBY_ORE_VEIN_SIZE_FOUR_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE,
            Rubis.id("ruby_ore_vein_size_four_placed_key")
    );
}
