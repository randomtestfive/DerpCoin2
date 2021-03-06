package labyrinth.derpcoin.base;

//import java.awt.List;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DerpSack extends Item
{
	
	public DerpSack()
	{
		super();
		this.setMaxStackSize(1);
	}
	
	@Override
	public void onCreated(ItemStack par1Item, World par2World, EntityPlayer par3Player)
	{
		par1Item.setTagCompound(new NBTTagCompound());
		par1Item.getTagCompound().setInteger("DerpCoins", 0);
	}
	
	@Override
	public void onUpdate(ItemStack par1Item, World par2World, Entity par3Entity, int meta, boolean bool)
	{
		NBTTagCompound tag = par1Item.getTagCompound();
		if (tag == null) 
		{
			tag = new NBTTagCompound();
			par1Item.setTagCompound(tag);
		}
		if(par1Item.getTagCompound().getInteger("DerpCoins") == 0)
		{
			par1Item.setItemDamage(0);
		}
		else if(par1Item.getTagCompound().getInteger("DerpCoins") == 512)
		{
			par1Item.setItemDamage(4);
		}
		else if(par1Item.getTagCompound().getInteger("DerpCoins") < 512 && par1Item.getTagCompound().getInteger("DerpCoins") >= 342)
		{
			par1Item.setItemDamage(3);
		}
		else if(par1Item.getTagCompound().getInteger("DerpCoins") < 342 && par1Item.getTagCompound().getInteger("DerpCoins") >= 171)
		{
			par1Item.setItemDamage(2);
		}
		else if(par1Item.getTagCompound().getInteger("DerpCoins") < 171 && par1Item.getTagCompound().getInteger("DerpCoins") != 0)
		{
			par1Item.setItemDamage(1);
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3Player) 
	{
		NBTTagCompound tag = par1ItemStack.getTagCompound();
		if (tag == null) 
		{
			tag = new NBTTagCompound();
			par1ItemStack.setTagCompound(tag);
		}
		
		if(par3Player.isSneaking())
		{
			consumeDerpcoinStack(par3Player.inventory, par1ItemStack);
		}
		else
		{
			if(par1ItemStack.getTagCompound().getInteger("DerpCoins") < 512)
			{
				if (par1ItemStack.getTagCompound() != null)
				{
					if (par3Player.inventory.consumeInventoryItem(Main.derpCoin))
					{
						par1ItemStack.getTagCompound().setInteger("DerpCoins", par1ItemStack.getTagCompound().getInteger("DerpCoins") + 1);
						//System.out.println(par1ItemStack.getTagCompound().getInteger("DerpCoins"));
					}
				}
				else
				{
					par1ItemStack.getTagCompound().setInteger("DerpCoins", 0);
				}
			}
		}
		return par1ItemStack;
	 }
	
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, @SuppressWarnings("rawtypes") List list, boolean par4) 
	{
		if (itemStack.getTagCompound() != null) 
		{
            int coins = itemStack.getTagCompound().getInteger("DerpCoins");
            list.add(EnumChatFormatting.YELLOW + "DerpCoins: " + coins);
		}
	}
	
	public void consumeDerpcoinStack(InventoryPlayer inventory, ItemStack derpsack)
	{
		ItemStack itemstack = null;
		int stackAmount = 0;
		int roomLeftInSack = 0;
		int stackRemains = 0;
		
		for (ItemStack s : inventory.mainInventory)
		{
			if (s != null && s.getItem() instanceof DerpCoin) 
			{
				itemstack = s;
				break;
			}
		}
		if(itemstack != null)
		{
			stackAmount = itemstack.stackSize;
			
			if(!(derpsack.getTagCompound().getInteger("DerpCoins") == 512))
			{
				if(derpsack.getTagCompound().getInteger("DerpCoins") + stackAmount <= 512)
				{
					itemstack.stackSize = 1;
					derpsack.getTagCompound().setInteger("DerpCoins", derpsack.getTagCompound().getInteger("DerpCoins") + stackAmount);
					inventory.consumeInventoryItem(Main.derpCoin);
				}
				else
				{
					roomLeftInSack = 512 - derpsack.getTagCompound().getInteger("DerpCoins");
					stackRemains = stackAmount - roomLeftInSack;
					itemstack.stackSize = stackRemains;
					derpsack.getTagCompound().setInteger("DerpCoins", derpsack.getTagCompound().getInteger("DerpCoins") + roomLeftInSack);
				}
			}
		}
	}
}
