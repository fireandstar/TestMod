package com.wangjustar.NewMod.items.tools;

import com.wangjustar.NewMod.items.TileEntityTypeRegistry;

import net.minecraft.tileentity.TileEntity;

public class TimerBlockTileEntity extends TileEntity {
       public TimerBlockTileEntity() {
        super(TileEntityTypeRegistry.timerBlockTileEntity.get());
    }
}