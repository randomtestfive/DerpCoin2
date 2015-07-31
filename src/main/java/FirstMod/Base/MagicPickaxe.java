package FirstMod.Base;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MagicPickaxe extends ItemPickaxe
{
	private DCConsumer consumer;
	
	private int counter = 0;

	public MagicPickaxe(ToolMaterial p_i45347_1_) 
	{
		super(p_i45347_1_);
		this.setUnlocalizedName("magicPickaxe");
		consumer = new DCConsumer();
	}
	
	@Override
	public void onCreated(ItemStack par1Item, World par2World, EntityPlayer par3Player)
	{
		par1Item.setTagCompound(new NBTTagCompound());
		//par1Item.getTagCompound().setInteger("MagicTime", 0);
		par1Item.getTagCompound().setBoolean("Active", false);
	}
	
	@Override
	public void onUpdate(ItemStack par1stack, World par2world, Entity par3entity, int par4slot, boolean isSelected) 
	{
		counter = counter + 1;
		if(counter == 100)
		{
			counter = 0;
			System.out.println("pickcount");
			if(par3entity instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) par3entity;
				if(par1stack.getTagCompound() != null)
				{
					if(par1stack.getTagCompound().getBoolean("Active"))
					{
						if(consumer.subDerpsack(player.inventory) || player.inventory.consumeInventoryItem(Thingy.derpCoin))
						{
						
						}
						else
						{
							par1stack.getTagCompound().setBoolean("Active", false);
						}
					}
				}
				else
				{
					par1stack.setTagCompound(new NBTTagCompound());
				}
			}
		}
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3Player)
	{
		NBTTagCompound tag = par1ItemStack.getTagCompound();
		if(tag != null)
		{
			tag.setBoolean("Active", !tag.getBoolean("Active"));
		}
		else
		{
			tag = new NBTTagCompound();
			par1ItemStack.setTagCompound(tag);
		}
		return par1ItemStack;
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, net.minecraft.block.state.IBlockState state)
	{
		NBTTagCompound tag = stack.getTagCompound();
		if(tag != null)
		{
			if(tag.getBoolean("Active"))
			{
				return 2000.0F;
			}
		}
		else
		{
			tag = new NBTTagCompound();
			stack.setTagCompound(tag);
		}
		return 8.0F;
	}
	
	/*@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) 
	{
		if (itemStack.getTagCompound() != null) 
		{
            int magicTime = itemStack.getTagCompound().getInteger("MagicTime");
            list.add(EnumChatFormatting.DARK_PURPLE + "Magic Time: " + magicTime);
		}
	}*/
}
