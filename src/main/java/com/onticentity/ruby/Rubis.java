package com.onticentity.ruby;

import com.onticentity.ruby.blocks.RubisBlocks;
import com.onticentity.ruby.items.RubisItems;
import com.onticentity.ruby.worldgen.gen.RubisWorldgen;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rubis implements ModInitializer {
	public static final String MOD_ID = "rubis";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		RubisItems.initialize();
		RubisBlocks.initialize();
		RubisWorldgen.initialize();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
