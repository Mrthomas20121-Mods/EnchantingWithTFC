package mrthomas20121.enchanting_with_tfc.enchantment;

import net.dries007.tfc.util.PhysicalDamageType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;

public class ResistanceEnchantment extends Enchantment {

    private final PhysicalDamageType damageType;
    private final String damageTypeName;

    public ResistanceEnchantment(String name, PhysicalDamageType damageType) {
        super(Rarity.COMMON, EnchantmentCategory.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});
        this.damageType = damageType;
        this.damageTypeName = name;
    }

    @Override
    protected boolean checkCompatibility(@NotNull Enchantment enchantment) {
        if(enchantment instanceof ResistanceEnchantment r) {
            if(!this.damageTypeName.equals(r.damageTypeName)) {
                return false;
            }
        }
        return super.checkCompatibility(enchantment);
    }

    @Override
    public int getMaxLevel() {
        if(ModList.get().isLoaded("apotheosis")) {
            return 8;
        }
        return 5;
    }

    @Override
    public int getDamageProtection(int level, @NotNull DamageSource source) {
        PhysicalDamageType dmgType = PhysicalDamageType.getTypeForSource(source);
        if(dmgType == null) {
            return 0;
        }
        else if(dmgType.equals(this.damageType)) {
            return level*3;
        }
        return super.getDamageProtection(level, source);
    }
}
