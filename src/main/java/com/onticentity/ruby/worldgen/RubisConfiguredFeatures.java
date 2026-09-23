package com.onticentity.ruby.worldgen;

import com.onticentity.ruby.Rubis;
import com.onticentity.ruby.blocks.RubisBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class RubisConfiguredFeatures {
    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceableRule = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceableRule = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> sapphireOreConfiguration = List.of(
                OreConfiguration.target(stoneReplaceableRule, RubisBlocks.RUBY_ORE.defaultBlockState()),
                OreConfiguration.target(deepslateReplaceableRule, RubisBlocks.DEEPSLATE_RUBY_ORE.defaultBlockState())
        );
        context.register(
                RUBY_ORE_VEIN_SIZE_ONE_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(sapphireOreConfiguration, 1, 0.25F)
                )
        );
        context.register(
                RUBY_ORE_VEIN_SIZE_TWO_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(sapphireOreConfiguration, 2, 0.25F)
                )
        );
        context.register(
                RUBY_ORE_VEIN_SIZE_THREE_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(sapphireOreConfiguration, 3, 0.75F)
                )
        );
        context.register(
                RUBY_ORE_VEIN_SIZE_FOUR_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(sapphireOreConfiguration, 4, 0.95F)
                )
        );
    }

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_VEIN_SIZE_ONE_CONFIGURED_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Rubis.id("ruby_ore_vein_size_one_configured_key")
            );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_VEIN_SIZE_TWO_CONFIGURED_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Rubis.id("ruby_ore_vein_size_two_configured_key")
            );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_VEIN_SIZE_THREE_CONFIGURED_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Rubis.id("ruby_ore_vein_size_three_configured_key")
            );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_VEIN_SIZE_FOUR_CONFIGURED_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Rubis.id("ruby_ore_vein_size_four_configured_key")
            );
}
