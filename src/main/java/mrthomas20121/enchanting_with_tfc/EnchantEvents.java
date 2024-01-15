package mrthomas20121.enchanting_with_tfc;

import net.dries007.tfc.common.entities.predator.Predator;
import net.dries007.tfc.util.PhysicalDamageType;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnchantingWithTFC.mod_id)
public class EnchantEvents {

    @SubscribeEvent
    public static void damageEvent(LivingDamageEvent event) {
        LivingEntity target = event.getEntity();
        Entity directEntity = event.getSource().getDirectEntity();

        if(directEntity instanceof Player player) {
            ItemStack itemStack = player.getMainHandItem();
            if(!itemStack.isEmpty()) {
                int level = itemStack.getEnchantmentLevel(TFCEnchantements.SLOW_ASPECT.get());
                int levelHunting = itemStack.getEnchantmentLevel(TFCEnchantements.HUNTING.get());
                if(level > 0) {
                    if(!target.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, level == 2 ? 200 : 100));
                    }
                }
                if(levelHunting > 0 && target instanceof Predator) {
                    event.setAmount(event.getAmount()+levelHunting-0.5f*1.15f);
                }
            }
        }
    }

    @SubscribeEvent
    public static void afterEntityHit(LivingAttackEvent event) {
        LivingEntity target = event.getEntity();
        Entity directEntity = event.getSource().getDirectEntity();

        if(directEntity instanceof Arrow arrow) {
            boolean isPierce = event.getSource().is(PhysicalDamageType.IS_PIERCING);

            if(isPierce) {
                target.hurt(arrow.level().damageSources().mobAttack(target), 5);
            }
        }
    }
}
