package labyrinth.derpcoin.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IChatComponent;

public class InventoryBackpack implements IInventory
{
	
	public ItemStack[] itemStacks;
	private static final String LIST_TAG = "DERP_BACKPACK";
	public String uniqueId = "";

	public void writeToNBT(NBTTagCompound compound)
	{
		NBTTagList list = new NBTTagList();
		
		for(byte b = 0; b < itemStacks.length; b++)
		{
			if(itemStacks[b] != null && itemStacks[b].stackSize > 0)
			{
				NBTTagCompound tag = new NBTTagCompound();
				list.appendTag(tag);
				tag.setByte("slot", b);
				itemStacks[b].writeToNBT(tag);
			} 
		}
		
		compound.setTag(LIST_TAG, list);
		compound.setString("uniqueID", uniqueId);
		compound.setInteger("invSize", getSizeInventory());
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IChatComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 54;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void openInventory(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
