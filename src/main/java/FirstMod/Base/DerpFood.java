package FirstMod.Base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class DerpFood extends ItemFood
{
	public DerpFood(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) 
	{
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		this.setUnlocalizedName("magicFood");
	}
	
	@Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        if(subDerpsack(playerIn.inventory) || playerIn.inventory.consumeInventoryItem(Thingy.derpCoin))
        {
        	playerIn.getFoodStats().addStats(this, stack);
        	worldIn.playSoundAtEntity(playerIn, "random.burp", 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
        	this.onFoodEaten(stack, worldIn, playerIn);
        	playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        }
        return stack;
    }
	
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
