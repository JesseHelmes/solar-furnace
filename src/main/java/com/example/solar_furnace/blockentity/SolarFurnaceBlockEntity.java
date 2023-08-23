package com.example.solar_furnace.blockentity;

import com.example.solar_furnace.init.BlockEntityInit;
import com.example.solar_furnace.menu.SolarFurnaceMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;

public class SolarFurnaceBlockEntity extends NoFuelFurnaceBlockEntity {
	public SolarFurnaceBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(BlockEntityInit.SOLAR_FURNACE.get(), blockPos, blockState, RecipeType.SMELTING);
	}

	protected Component getDefaultName() {
		return Component.translatable("gui.solar_furnace.container.solar_furnace");
	}

	protected AbstractContainerMenu createMenu(int p_59293_, Inventory inventory) {
		return new SolarFurnaceMenu(p_59293_, inventory, this, this.dataAccess);
	}

	public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, SolarFurnaceBlockEntity entity) {
		boolean flag = updateSignalStrength(blockState, level, blockPos) > 7;
		// to make it more realistic because solar panels generate less energy then
		boolean rainFlag = !level.isRaining();
		entity.updateBurnDuratation(90, flag && rainFlag);

		NoFuelFurnaceBlockEntity.serverTick(level, blockPos, blockState, entity);
	}

	private static int updateSignalStrength(BlockState blockState, Level level, BlockPos blockPos) {
		int i = level.getBrightness(LightLayer.SKY, blockPos.above(1)) - level.getSkyDarken();
		float f = level.getSunAngle(1.0F);
		if (i > 0) {
			float f1 = f < (float)Math.PI ? 0.0F : ((float)Math.PI * 2F);
			f += (f1 - f) * 0.2F;
			i = Math.round((float)i * Mth.cos(f));
		}

		i = Mth.clamp(i, 0, 15);
		return Integer.valueOf(i);
	}
}
