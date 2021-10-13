package com.wangjustar.NewMod.items;

import com.wangjustar.NewMod.groups.ModGroup;
import com.wangjustar.NewMod.items.tools.ObsidianIngot;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "newmod");
    public static final RegistryObject<Item> obsidianIngot = ITEMS.register("obsidian_ingot", ObsidianIngot::new);
    public static final RegistryObject<Item> timerBlock = ITEMS.register("timer_block", () -> new BlockItem(BlockRegistry.timerBlock.get(), new Item.Properties().tab(ModGroup.itemGroup)));

}