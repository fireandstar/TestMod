package com.wangjustar.NewMod.groups;

import com.wangjustar.NewMod.items.ItemRegistry;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CraftingGroup extends ItemGroup {
    public CraftingGroup() {
        super("crafting_group");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemRegistry.obsidianIngot.get());
    }
}
