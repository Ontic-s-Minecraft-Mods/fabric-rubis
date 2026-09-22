package com.onticentity.ruby.datagens;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class RubisEnglishLangProvider extends FabricLanguageProvider {
    public RubisEnglishLangProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("block.rubis.ruby_ore", "Ruby Ore");
        translationBuilder.add("block.rubis.deepslate_ruby_ore", "Deepslate Ruby Ore");
        translationBuilder.add("block.rubis.ruby_block", "Ruby Block");

        translationBuilder.add("item.rubis.ruby", "Ruby");
    }
}
