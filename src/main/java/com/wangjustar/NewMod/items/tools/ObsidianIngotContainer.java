package com.wangjustar.NewMod.items.tools;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ObsidianIngotContainer extends Container {
	   private final IInventory container;
	   private final int containerRows;

	   private ObsidianIngotContainer(ContainerType<?> p_i50091_1_, int p_i50091_2_, PlayerInventory p_i50091_3_, int p_i50091_4_) {
	      this(p_i50091_1_, p_i50091_2_, p_i50091_3_, new Inventory(9 * p_i50091_4_), p_i50091_4_);
	   }

	   public static ObsidianIngotContainer oneRow(int p_216986_0_, PlayerInventory p_216986_1_) {
	      return new ObsidianIngotContainer(ContainerType.GENERIC_9x1, p_216986_0_, p_216986_1_, 1);
	   }

	   public static ObsidianIngotContainer twoRows(int p_216987_0_, PlayerInventory p_216987_1_) {
	      return new ObsidianIngotContainer(ContainerType.GENERIC_9x2, p_216987_0_, p_216987_1_, 2);
	   }

	   public static ObsidianIngotContainer threeRows(int p_216988_0_, PlayerInventory p_216988_1_) {
	      return new ObsidianIngotContainer(ContainerType.GENERIC_9x3, p_216988_0_, p_216988_1_, 3);
	   }

	   public static ObsidianIngotContainer fourRows(int p_216991_0_, PlayerInventory p_216991_1_) {
	      return new ObsidianIngotContainer(ContainerType.GENERIC_9x4, p_216991_0_, p_216991_1_, 4);
	   }

	   public static ObsidianIngotContainer fiveRows(int p_216989_0_, PlayerInventory p_216989_1_) {
	      return new ObsidianIngotContainer(ContainerType.GENERIC_9x5, p_216989_0_, p_216989_1_, 5);
	   }

	   public static ObsidianIngotContainer sixRows(int p_216990_0_, PlayerInventory p_216990_1_) {
	      return new ObsidianIngotContainer(ContainerType.GENERIC_9x6, p_216990_0_, p_216990_1_, 6);
	   }

	   public static ObsidianIngotContainer threeRows(int p_216992_0_, PlayerInventory p_216992_1_, IInventory p_216992_2_) {
	      return new ObsidianIngotContainer(ContainerType.GENERIC_9x3, p_216992_0_, p_216992_1_, p_216992_2_, 3);
	   }

	   public static ObsidianIngotContainer sixRows(int p_216984_0_, PlayerInventory p_216984_1_, IInventory p_216984_2_) {
	      return new ObsidianIngotContainer(ContainerType.GENERIC_9x6, p_216984_0_, p_216984_1_, p_216984_2_, 6);
	   }

	   public ObsidianIngotContainer(ContainerType<?> p_i50092_1_, int p_i50092_2_, PlayerInventory p_i50092_3_, IInventory p_i50092_4_, int p_i50092_5_) {
	      super(p_i50092_1_, p_i50092_2_);
	      checkContainerSize(p_i50092_4_, p_i50092_5_ * 9);
	      this.container = p_i50092_4_;
	      this.containerRows = p_i50092_5_;
	      p_i50092_4_.startOpen(p_i50092_3_.player);
	      int i = (this.containerRows - 4) * 18;

	      for(int j = 0; j < this.containerRows; ++j) {
	         for(int k = 0; k < 9; ++k) {
	            this.addSlot(new Slot(p_i50092_4_, k + j * 9, 8 + k * 18, 18 + j * 18));
	         }
	      }

	      for(int l = 0; l < 3; ++l) {
	         for(int j1 = 0; j1 < 9; ++j1) {
	            this.addSlot(new Slot(p_i50092_3_, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
	         }
	      }

	      for(int i1 = 0; i1 < 9; ++i1) {
	         this.addSlot(new Slot(p_i50092_3_, i1, 8 + i1 * 18, 161 + i));
	      }

	   }

	   public boolean stillValid(PlayerEntity p_75145_1_) {
	      return this.container.stillValid(p_75145_1_);
	   }

	   public ItemStack quickMoveStack(PlayerEntity p_82846_1_, int p_82846_2_) {
	      ItemStack itemstack = ItemStack.EMPTY;
	      Slot slot = this.slots.get(p_82846_2_);
	      if (slot != null && slot.hasItem()) {
	         ItemStack itemstack1 = slot.getItem();
	         itemstack = itemstack1.copy();
	         if (p_82846_2_ < this.containerRows * 9) {
	            if (!this.moveItemStackTo(itemstack1, this.containerRows * 9, this.slots.size(), true)) {
	               return ItemStack.EMPTY;
	            }
	         } else if (!this.moveItemStackTo(itemstack1, 0, this.containerRows * 9, false)) {
	            return ItemStack.EMPTY;
	         }

	         if (itemstack1.isEmpty()) {
	            slot.set(ItemStack.EMPTY);
	         } else {
	            slot.setChanged();
	         }
	      }

	      return itemstack;
	   }

	   public void removed(PlayerEntity p_75134_1_) {
	      super.removed(p_75134_1_);
	      this.container.stopOpen(p_75134_1_);
	   }

	   public IInventory getContainer() {
	      return this.container;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public int getRowCount() {
	      return this.containerRows;
	   }
}
