package com.example.solar_furnace;

import com.example.solar_furnace.client.ClientEventMod;
import com.example.solar_furnace.init.BlockEntityInit;
import com.example.solar_furnace.init.BlockInit;
import com.example.solar_furnace.init.ItemInit;
import com.example.solar_furnace.init.MenuInit;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SolarFurnaceMod.MODID)
public class SolarFurnaceMod {
	// Define mod id in a common place for everything to reference
	public static final String MODID = "solar_furnace";
	// Directly reference a slf4j logger
	private static final Logger LOGGER = LogUtils.getLogger();

	public SolarFurnaceMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		bus.addListener(ClientEventMod::init);

		// Register the Deferred Register to the mod event bus so blocks get registered
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		BlockEntityInit.BLOCK_ENTITIES.register(bus);
		MenuInit.MENUS.register(bus);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);

		// Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
	}
}
