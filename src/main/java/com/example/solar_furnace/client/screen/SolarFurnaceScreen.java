package com.example.solar_furnace.client.screen;

import com.example.solar_furnace.SolarFurnaceMod;
import com.example.solar_furnace.menu.SolarFurnaceMenu;

import net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SolarFurnaceScreen extends NoFuelFurnaceScreen<SolarFurnaceMenu> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(SolarFurnaceMod.MODID, "textures/gui/solar_furnace.png");

	public SolarFurnaceScreen(SolarFurnaceMenu menu, Inventory inventory, Component component) {
		super(menu, new SmeltingRecipeBookComponent(), inventory, component, TEXTURE);
	}
}