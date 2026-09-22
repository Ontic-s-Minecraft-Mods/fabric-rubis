package com.onticentity.ruby.worldgen.gen;

import com.onticentity.ruby.worldgen.RubisPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

public class RubisWorldgen {
    public static void initialize() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                RubisPlacedFeatures.RUBY_ORE_VEIN_SIZE_ONE_PLACED_KEY
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                RubisPlacedFeatures.RUBY_ORE_VEIN_SIZE_TWO_PLACED_KEY
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                RubisPlacedFeatures.RUBY_ORE_VEIN_SIZE_THREE_PLACED_KEY
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                RubisPlacedFeatures.RUBY_ORE_VEIN_SIZE_FOUR_PLACED_KEY
        );
    }
}
