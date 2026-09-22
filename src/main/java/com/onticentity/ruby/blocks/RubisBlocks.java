package com.onticentity.ruby.blocks;

import com.onticentity.ruby.Rubis;
import com.onticentity.ruby.items.RubisItems;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public class RubisBlocks {
    public static final ResourceKey<Block> RUBY_ORE_KEY =
            keyOfBlock("ruby_ore");

    public static final ResourceKey<Block> DEEPSLATE_RUBY_ORE_KEY =
            keyOfBlock("deepslate_ruby_ore");

    public static final ResourceKey<Block> RUBY_BLOCK_KEY =
            keyOfBlock("ruby_block");


    public static final Block RUBY_ORE = register(
            "ruby_ore",
            RUBY_ORE_KEY,
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(3.5F, 3.5F)
                    .mapColor(MapColor.STONE)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.STONE),
            true
    );

    public static final Block DEEPSLATE_RUBY_ORE = register(
            "deepslate_ruby_ore",
            DEEPSLATE_RUBY_ORE_KEY,
            Block::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(5.0F, 5.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE),
            true
    );

    public static final Block RUBY_BLOCK = register(
            "ruby_block",
            RUBY_BLOCK_KEY,
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(5.5F, 6.5F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL),
            true
    );

    private static Block register(
            String name,
            ResourceKey<Block> blockKey,
            Function<BlockBehaviour.Properties, Block> blockFactory,
            BlockBehaviour.Properties properties,
            boolean registerItem
    ) {
        Block block = blockFactory.apply(
                properties.setId(blockKey)
        );

        if (registerItem) {
            registerBlockItem(name, block);
        }

        return Registry.register(
                BuiltInRegistries.BLOCK,
                blockKey,
                block
        );
    }

    private static void registerBlockItem(String name, Block block) {
        ResourceKey<Item> itemKey = keyOfItem(name);

        BlockItem blockItem = new BlockItem(
                block,
                new Item.Properties()
                        .setId(itemKey)
                        .useBlockDescriptionPrefix()
        );

        Registry.register(
                BuiltInRegistries.ITEM,
                itemKey,
                blockItem
        );
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(
                Registries.BLOCK,
                Identifier.fromNamespaceAndPath(Rubis.MOD_ID, name)
        );
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(Rubis.MOD_ID, name)
        );
    }

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS)
                .register((creativeTab) -> creativeTab.accept(RubisBlocks.RUBY_ORE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS)
                .register((creativeTab) -> creativeTab.accept(RubisBlocks.DEEPSLATE_RUBY_ORE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
                .register((creativeTab) -> creativeTab.accept(RubisBlocks.RUBY_BLOCK));
    }
}