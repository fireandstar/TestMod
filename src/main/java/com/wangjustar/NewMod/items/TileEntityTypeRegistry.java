package com.wangjustar.NewMod.items;

import com.wangjustar.NewMod.items.tools.TimerBlockTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, "newmod");
    public static final RegistryObject<TileEntityType<TimerBlockTileEntity>> timerBlockTileEntity =TILE_ENTITIES.register("timer_block__tileentity", () -> TileEntityType.Builder.of(TimerBlockTileEntity::new, BlockRegistry.timerBlock.get()).build(null));
}