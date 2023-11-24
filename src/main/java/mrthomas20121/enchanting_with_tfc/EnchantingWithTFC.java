package mrthomas20121.enchanting_with_tfc;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EnchantingWithTFC.mod_id)
public class EnchantingWithTFC {

	public static final String mod_id = "enchanting_with_tfc";

	public EnchantingWithTFC() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

	}
}
