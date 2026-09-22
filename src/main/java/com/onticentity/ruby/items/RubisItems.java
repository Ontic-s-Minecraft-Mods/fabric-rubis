package com.onticentity.ruby.items;

import com.onticentity.ruby.Rubis;
import com.onticentity.ruby.materials.RubisMaterials;
import com.onticentity.ruby.materials.RubisTrimMaterials;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class RubisItems {

    public static final ResourceKey<Item> RUBY_KEY =
            keyOfItem("ruby");

    public static final ResourceKey<Item> RUBY_CHESTPLATE_KEY =
            keyOfItem("ruby_chestplate");

    public static final Item RUBY = register(
            RUBY_KEY,
            Item::new,
            new Item.Properties()
                    .trimMaterial(RubisTrimMaterials.RUBY)
    );

    public static final Item RUBY_CHESTPLATE = register(
            RUBY_CHESTPLATE_KEY,
            Item::new,
            new Item.Properties()
                    .humanoidArmor(
                            RubisMaterials.INSTANCE,
                            ArmorType.CHESTPLATE
                    )
                    .durability(
                            ArmorType.CHESTPLATE.getDurability(
                                    RubisMaterials.BASE_DURABILITY
                            )
                    )
    );

    public static <T extends Item> T register(
            ResourceKey<Item> itemKey,
            Function<Item.Properties, T> itemFactory,
            Item.Properties properties
    ) {
        T item = itemFactory.apply(
                properties.setId(itemKey)
        );

        return Registry.register(
                BuiltInRegistries.ITEM,
                itemKey,
                item
        );
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(
                        Rubis.MOD_ID,
                        name
                )
        );
    }

    public static void initialize() {
        CreativeModeTabEvents
                .modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register(entries -> entries.accept(RUBY));

        CreativeModeTabEvents
                .modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register(entries -> entries.accept(RUBY_CHESTPLATE));
    }
}