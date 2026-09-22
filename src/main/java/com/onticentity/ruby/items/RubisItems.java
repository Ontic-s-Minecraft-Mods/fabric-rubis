package com.onticentity.ruby.items;

import com.onticentity.ruby.Rubis;
import com.onticentity.ruby.materials.RubisMaterials;
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
    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Rubis.MOD_ID, name));

        T item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static final Item RUBY = register("ruby", Item::new, new Item.Properties());

    public static final Item RUBY_CHESTPLATE = register("ruby_chestplate", Item::new, new Item.Properties().humanoidArmor(RubisMaterials.INSTANCE, ArmorType.CHESTPLATE)
            .durability(ArmorType.CHESTPLATE.getDurability(RubisMaterials.BASE_DURABILITY))
    );

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(RubisItems.RUBY));

    }
}
