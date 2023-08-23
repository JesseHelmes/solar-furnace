package com.example.solar_furnace.client;

import com.example.solar_furnace.SolarFurnaceMod;
import com.example.solar_furnace.client.screen.SolarFurnaceScreen;
import com.example.solar_furnace.init.MenuInit;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SolarFurnaceMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventMod {
	public static void init(final FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MenuInit.SOLAR_FURNACE.get(), SolarFurnaceScreen::new);
		});
	}
}
