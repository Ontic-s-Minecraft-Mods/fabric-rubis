package com.onticentity.ruby.materials;


import com.onticentity.ruby.Rubis;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

public class RubisTrimMaterials {

    public static final ResourceKey<TrimMaterial> RUBY =
            ResourceKey.create(
                    Registries.TRIM_MATERIAL,
                    Identifier.fromNamespaceAndPath(
                            Rubis.MOD_ID,
                            "ruby"
                    )
            );
}