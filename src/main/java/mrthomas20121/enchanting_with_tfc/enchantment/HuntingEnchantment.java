package mrthomas20121.enchanting_with_tfc.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.fml.ModList;

public class HuntingEnchantment extends Enchantment {

    public HuntingEnchantment() {
        super(Rarity.COMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        if(ModList.get().isLoaded("apotheosis")) {
            return 8;
        }
        return 5;
    }
}
