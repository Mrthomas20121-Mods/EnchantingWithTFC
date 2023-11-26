package mrthomas20121.enchanting_with_tfc;

import mrthomas20121.enchanting_with_tfc.enchantment.HuntingEnchantment;
import mrthomas20121.enchanting_with_tfc.enchantment.SlowAspectEnchantment;
import mrthomas20121.enchanting_with_tfc.enchantment.ResistanceEnchantment;
import net.dries007.tfc.util.PhysicalDamageType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TFCEnchantements {

    public static DeferredRegister<Enchantment> ENCHANTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, EnchantingWithTFC.mod_id);

    public static final RegistryObject<ResistanceEnchantment> PIERCING_PROTECTION = ENCHANTS.register("piercing_protection", () -> new ResistanceEnchantment("piercing", PhysicalDamageType.PIERCING));
    public static final RegistryObject<ResistanceEnchantment> CRUSHING_PROTECTION = ENCHANTS.register("crushing_protection", () -> new ResistanceEnchantment("crushing", PhysicalDamageType.CRUSHING));
    public static final RegistryObject<ResistanceEnchantment> SLASHING_PROTECTION = ENCHANTS.register("slashing_protection", () -> new ResistanceEnchantment("slashing", PhysicalDamageType.SLASHING));
    public static final RegistryObject<SlowAspectEnchantment> SLOW_ASPECT = ENCHANTS.register("slow_aspect", SlowAspectEnchantment::new);
    public static final RegistryObject<HuntingEnchantment> HUNTING = ENCHANTS.register("hunting", HuntingEnchantment::new);

}
