package com.onticentity.ruby.datagens;

import com.onticentity.ruby.blocks.RubisBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class RubisBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public RubisBlockTagProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        builder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(RubisBlocks.RUBY_ORE_KEY)
                .add(RubisBlocks.DEEPSLATE_RUBY_ORE_KEY)
                .add(RubisBlocks.RUBY_BLOCK_KEY);

        builder(BlockTags.NEEDS_IRON_TOOL)
                .add(RubisBlocks.RUBY_ORE_KEY)
                .add(RubisBlocks.DEEPSLATE_RUBY_ORE_KEY)
                .add(RubisBlocks.RUBY_BLOCK_KEY);
    }
}
