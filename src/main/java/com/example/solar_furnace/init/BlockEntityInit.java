package com.example.solar_furnace.init;

import com.example.solar_furnace.SolarFurnaceMod;
import com.example.solar_furnace.blockentity.SolarFurnaceBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
			DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SolarFurnaceMod.MODID);

	public static final RegistryObject<BlockEntityType<SolarFurnaceBlockEntity>> SOLAR_FURNACE = BLOCK_ENTITIES
			.register("solar_furnace",
					() -> BlockEntityType.Builder.of(SolarFurnaceBlockEntity::new, BlockInit.SOLAR_FURNACE.get())
							.build(null));
}
