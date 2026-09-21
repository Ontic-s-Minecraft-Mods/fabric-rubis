package com.onticentity.ruby.blocks;

import com.onticentity.ruby.Rubis;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class RubisBlocks {
    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);

        Block block = blockFactory.apply(properties.setId(blockKey));

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Rubis.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Rubis.MOD_ID, name));
    }

    public static void initialize() {
    }

    public static final Block RUBY_ORE = register("ruby_ore", Block::new,
            BlockBehaviour.Properties.of()
                    .strength(50.0F, 1400.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE), true);

    public static final Block DEEPSLATE_RUBY_ORE = register("deepslate_ruby_ore", Block::new,
            BlockBehaviour.Properties.of()
                    .strength(50.0F, 1400.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE), true);

    public static final Block RUBY_BLOCK = register("ruby_block", Block::new,
            BlockBehaviour.Properties.of()
                    .strength(50.0F, 1400.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL), true);
}
