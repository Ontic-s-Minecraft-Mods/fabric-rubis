package com.onticentity.ruby.datagens;


import com.onticentity.ruby.blocks.RubisBlocks;
import com.onticentity.ruby.items.RubisItems;
import net.minecraft.core.HolderLookup;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;

import java.util.concurrent.CompletableFuture;


public class RubisBlockLootTableProvider extends FabricBlockLootSubProvider {
    public RubisBlockLootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(RubisBlocks.RUBY_BLOCK);
        this.add(RubisBlocks.RUBY_ORE,
                block -> createSingleItemTable(RubisItems.RUBY));
        this.add(RubisBlocks.DEEPSLATE_RUBY_ORE,
                block -> createSingleItemTable(RubisItems.RUBY));
    }
}