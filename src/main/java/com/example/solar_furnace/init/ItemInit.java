package com.example.solar_furnace.init;

import com.example.solar_furnace.SolarFurnaceMod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			SolarFurnaceMod.MODID);

	public static final RegistryObject<BlockItem> SOLAR_FURNACE = ITEMS.register("solar_furnace",
			() -> new BlockItem(BlockInit.SOLAR_FURNACE.get(),
					(new Item.Properties())));
}
