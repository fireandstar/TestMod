package com.wangjustar.NewMod.items.tools;
import com.wangjustar.NewMod.groups.ModGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;


public class ObsidianIngot extends Item implements IInventory, INamedContainerProvider{
	private NonNullList<ItemStack> itemStacks = NonNullList.withSize(36, ItemStack.EMPTY);
	public ObsidianIngot() {
        super(new Properties().stacksTo(1).tab(ModGroup.itemGroup));
    }
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
    	p_77659_1_.playSound((PlayerEntity)null, p_77659_2_.getX(), p_77659_2_.getY(), p_77659_2_.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
    	ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
        p_77659_2_.openMenu(this);	
        p_77659_2_.awardStat(Stats.ITEM_USED.get(this));
        return ActionResult.sidedSuccess(itemstack, p_77659_1_.isClientSide());
     }
    @Override
     public ITextComponent getDisplayName() {
	return new TranslationTextComponent("idea");
		}	
    public Container createMenu(int p_213968_1_, PlayerInventory p_213968_2_) {
	      return ObsidianIngotContainer.threeRows(p_213968_1_, p_213968_2_, this);
	   }
	@Override
	public void clearContent() {
	      this.itemStacks.clear();
		
	}
    @Override
	public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
		   if (p_createMenu_3_.isSpectator()) {
		         return null;
		      } else {
		         return this.createMenu(p_createMenu_1_, p_createMenu_2_);
		      }
	}
	  @Override
	public int getContainerSize() {
		return 27;
	}
	@Override
	public boolean isEmpty() {
		 for(ItemStack itemstack : this.itemStacks) {
	         if (!itemstack.isEmpty()) {
	            return false;
	         }
	      }

	      return true;
	}
	@Override
	public ItemStack getItem(int p_70301_1_) {
	      return this.itemStacks.get(p_70301_1_);
	}
	@Override
	public ItemStack removeItem(int p_70298_1_, int p_70298_2_) {
	      return ItemStackHelper.removeItem(this.itemStacks, p_70298_1_, p_70298_2_);
	}
	@Override
	public ItemStack removeItemNoUpdate(int p_70304_1_) {
	      ItemStack itemstack = this.itemStacks.get(p_70304_1_);
	      if (itemstack.isEmpty()) {
	         return ItemStack.EMPTY;
	      } else {
	         this.itemStacks.set(p_70304_1_, ItemStack.EMPTY);
	         return itemstack;
	      }
	}
	@Override
	public void setItem(int p_70299_1_, ItemStack p_70299_2_) {
	      this.itemStacks.set(p_70299_1_, p_70299_2_);
	      if (!p_70299_2_.isEmpty() && p_70299_2_.getCount() > 64) {
	         p_70299_2_.setCount(64);
	      }
		
	}
	public boolean setSlot(int p_174820_1_, ItemStack p_174820_2_) {
	      if (p_174820_1_ >= 0 && p_174820_1_ < this.getContainerSize()) {
	         this.setItem(p_174820_1_, p_174820_2_);
	         return true;
	      } else {
	         return false;
	      }
	   }

	@Override
	public void setChanged() {
	}
	@Override
	public boolean stillValid(PlayerEntity p_70300_1_) {
		 return true;
	}
	  protected void addAdditionalSaveData(CompoundNBT p_213281_1_) {
	      ItemStackHelper.saveAllItems(p_213281_1_, this.itemStacks);
	     
	   }

	   protected void readAdditionalSaveData(CompoundNBT p_70037_1_) {
	    
	      this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
	      ItemStackHelper.loadAllItems(p_70037_1_, this.itemStacks);
	     
	
}
}


