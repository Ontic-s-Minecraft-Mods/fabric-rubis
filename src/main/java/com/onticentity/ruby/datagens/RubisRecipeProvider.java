package com.onticentity.ruby.datagens;

import com.onticentity.ruby.blocks.RubisBlocks;
import com.onticentity.ruby.items.RubisItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class RubisRecipeProvider extends FabricRecipeProvider {
    public RubisRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                shaped(RecipeCategory.COMBAT, RubisItems.RUBY_CHESTPLATE)
                        .pattern("R R")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', RubisItems.RUBY)
                        .unlockedBy(
                                "has_ruby",
                                has(RubisItems.RUBY)
                        )
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, RubisBlocks.RUBY_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', RubisItems.RUBY)
                        .unlockedBy(
                                "has_ruby",
                                has(RubisItems.RUBY)
                        )
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "RubisRecipeProvider";
    }
}
