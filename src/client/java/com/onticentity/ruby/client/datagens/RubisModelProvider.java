package com.onticentity.ruby.client.datagens;

import com.onticentity.ruby.blocks.RubisBlocks;
import com.onticentity.ruby.items.RubisItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;

public class RubisModelProvider extends FabricModelProvider {
    public RubisModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialBlock(
                RubisBlocks.RUBY_ORE,
                TexturedModel.CUBE
        );
        blockModelGenerators.createTrivialBlock(
                RubisBlocks.DEEPSLATE_RUBY_ORE,
                TexturedModel.CUBE
        );
        blockModelGenerators.createTrivialBlock(
                RubisBlocks.RUBY_BLOCK,
                TexturedModel.CUBE
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(RubisItems.RUBY, ModelTemplates.FLAT_ITEM);
    }

    @Override
    public String getName() {
        return "";
    }

}
