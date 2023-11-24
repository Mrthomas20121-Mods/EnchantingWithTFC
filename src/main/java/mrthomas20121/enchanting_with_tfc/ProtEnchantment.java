package mrthomas20121.enchanting_with_tfc;

import net.dries007.tfc.common.TFCDamageSources;
import net.dries007.tfc.util.PhysicalDamageType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class ProtEnchantment extends Enchantment {

    protected ProtEnchantment() {
        super(Rarity.COMMON, EnchantmentCategory.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});
    }

    @Override
    public int getDamageProtection(int level, @NotNull DamageSource source) {
        if(source.is(PhysicalDamageType.IS_CRUSHING)) {
            return level;
        }
        else if(source.is(PhysicalDamageType.IS_PIERCING)) {
            return level;
        }
        else if(source.is(PhysicalDamageType.IS_SLASHING)) {
            return level;
        }
        return super.getDamageProtection(level, source);
    }
}
