package com.onticentity.ruby.mixin;

import com.onticentity.ruby.items.RubisItems;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(
            method = "getDamageAfterMagicAbsorb",
            at = @At("RETURN"),
            cancellable = true
    )
    private void rubis$applyRubyResistance(
            DamageSource damageSource,
            float amount,
            CallbackInfoReturnable<Float> cir
    ) {
        LivingEntity entity = (LivingEntity) (Object) this;

        ItemStack chestplate = entity.getItemBySlot(EquipmentSlot.CHEST);

        if (!chestplate.is(RubisItems.RUBY_CHESTPLATE)) {
            return;
        }

        float damage = cir.getReturnValue();

        if (damageSource.is(DamageTypeTags.IS_FIRE)) {
            damage *= 0.75F;
        }

        if (damageSource.is(DamageTypeTags.IS_EXPLOSION)) {
            damage *= 0.75F;
        }

        if (damageSource.is(DamageTypeTags.IS_PROJECTILE)) {
            damage *= 0.75F;
        }

        cir.setReturnValue(damage);
    }
}
