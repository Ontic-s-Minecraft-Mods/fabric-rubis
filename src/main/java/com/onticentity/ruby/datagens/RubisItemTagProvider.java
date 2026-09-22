package com.onticentity.ruby.datagens;

import com.onticentity.ruby.blocks.RubisBlocks;
import com.onticentity.ruby.items.RubisItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class RubisItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public RubisItemTagProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        builder(ItemTags.CHEST_ARMOR).add(RubisItems.RUBY_CHESTPLATE_KEY);
        builder(ItemTags.TRIMMABLE_ARMOR).add(RubisItems.RUBY_CHESTPLATE_KEY);
        builder(ItemTags.ARMOR_ENCHANTABLE).add(RubisItems.RUBY_CHESTPLATE_KEY);
        builder(ItemTags.TRIM_MATERIALS).add(RubisItems.RUBY_KEY);
    }
}


