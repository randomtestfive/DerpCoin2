package labyrinth.derpcoin.base;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class DCConsumer extends Item
{
	 public static boolean subDerpsack(InventoryPlayer inventory) 
	 {
		ItemStack itemstack = null;
		for (ItemStack s : inventory.mainInventory)
		{
			if (s != null && s.getItem() instanceof DerpSack) 
			{
				itemstack = s;
				break;
			}
		}
		if(itemstack != null)
		{
			NBTTagCompound tag = itemstack.getTagCompound();
			if (tag != null)
			{
				if(itemstack.getTagCompound().getInteger("DerpCoins") > 0)
				{
					itemstack.getTagCompound().setInteger("DerpCoins", itemstack.getTagCompound().getInteger("DerpCoins") - 1);
					return true;
				}
			}
		}
		return false;
	}
}
