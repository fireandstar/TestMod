package com.wangjustar.NewMod.items;

import com.wangjustar.NewMod.items.tools.TimerBlock;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,"newmod");
    public static final RegistryObject<Block> timerBlock = BLOCKS.register("timer_block", TimerBlock::new);
}
