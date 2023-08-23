package com.example.solar_furnace.init;

import com.example.solar_furnace.SolarFurnaceMod;
import com.example.solar_furnace.menu.SolarFurnaceMenu;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuInit {
	public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SolarFurnaceMod.MODID);

	public static final RegistryObject<MenuType<SolarFurnaceMenu>> SOLAR_FURNACE = MENUS.register("solar_furnace_menu",
			(() -> IForgeMenuType.create((pWindowID, pInventory, pData) -> {
				return new SolarFurnaceMenu(pWindowID, pInventory);
			})));

	// TODO test this
//	() -> new MenuType<SolarFurnaceMenu>(SolarFurnaceMenu::new, FeatureFlags.DEFAULT_FLAGS));
}
