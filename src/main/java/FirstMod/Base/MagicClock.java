package FirstMod.Base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MagicClock extends Item
{
	/*public IIcon forward;
	public IIcon backward;
	//public boolean mode = true;
	//public boolean clickcooldown = true;
	
	public MagicClock()
	{
		Item magicClock = new Item();
		//this.mode = true;
		this.itemIcon = forward;
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.forward = iconRegister.registerIcon("derpcoin:magicClockForward");
		this.backward = iconRegister.registerIcon("derpcoin:magicClockBackward");
		
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) 
	{
		if (meta == 0)
		{
			return forward;
		}
		else if(meta == 1)
		{
			return backward;
		}
		else
		{
			return forward;
		}
	}
	
	@Override
	public void onCreated(ItemStack par1Item, World par2World, EntityPlayer par3Player)
	{
		par1Item.setItemDamage(0);
	}
	
	public void changeTexture(ItemStack stack, boolean forwardbackward)
	{
		if(forwardbackward)
		{
			stack.setItemDamage(0);
		}
		else
		{
			stack.setItemDamage(1);
		}
	}
	
	/*@Override
	public void onCreated(ItemStack p_77622_1_, World p_77622_2_, EntityPlayer p_77622_3_) 
	{
		this.mode = true;
		changeTexture(this.mode);
	}*/
	
	/*@Override
	public ItemStack onItemRightClick(ItemStack par1Stack, World par2World, EntityPlayer par3Player)
	{
		System.out.println("rightclick");
		ItemStack Output = par1Stack;
		if(par3Player.isSneaking())
		{
				System.out.println(par1Stack.getItemDamage());
				if(par1Stack.getItemDamage() == 0)
				{
					par3Player.setItemInUse(par1Stack, 100000);
					par1Stack.setItemDamage(1);
					System.out.println("went to 3");
				}
				else if(par1Stack.getItemDamage() == 1)
				{
					par3Player.setItemInUse(par1Stack, 100000);
					par1Stack.setItemDamage(0);
					System.out.println("went to 1");
				}
				getIconFromDamage(par1Stack.getItemDamage());
				System.out.println("started using");
				return Output;
		}
		else
		{
			if (par3Player.capabilities.isCreativeMode||par3Player.inventory.consumeInventoryItem(Thingy.derpCoin))
			{
				if(par1Stack.getItemDamage() == 0)
				{
					par2World.setWorldTime(par2World.getWorldTime() + 1000);
					
				}
				else
				{
					par2World.setWorldTime(par2World.getWorldTime() - 1000);
					
				}
			}
		}
		System.out.println(par1Stack.getItemDamage());
		//par3Player.setItemInUse(par1Stack, 20);
		return Output;
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack par1Stack, World p_77974_1_, EntityPlayer p_77974_2_, int p_77974_3_)
	{
		System.out.println("stopclick");
		//getIconFromDamage(par1Stack.getItemDamage());
		System.out.println("stopped using");
		System.out.println(par1Stack.getItemDamage());
	}*/
	
}