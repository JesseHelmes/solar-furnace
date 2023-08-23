package com.example.solar_furnace.init;

import com.example.solar_furnace.SolarFurnaceMod;
import com.example.solar_furnace.block.SolarFurnace;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SolarFurnaceMod.MODID);

	public static final RegistryObject<SolarFurnace> SOLAR_FURNACE = BLOCKS.register("solar_furnace",
			() -> new SolarFurnace(BlockBehaviour.Properties.copy(Blocks.FURNACE)));
}
