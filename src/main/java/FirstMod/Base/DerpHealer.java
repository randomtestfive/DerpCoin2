package FirstMod.Base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DerpHealer extends DCConsumer
{
	public DerpHealer()
	{
		setMaxStackSize(1);
		setUnlocalizedName("magicHealer");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3Player)
	{
		if(par3Player.getHealth() != 20)
		{
			if(subDerpsack(par3Player.inventory) || par3Player.inventory.consumeInventoryItem(Main.derpCoin))
			{
				if(par3Player.getHealth() == 19)
				{
					par3Player.setHealth(20);
				}
				else if(par3Player.getHealth() <= 18)
				{
					par3Player.setHealth(par3Player.getHealth() + 1);
				}
			}
		}
		return par1ItemStack;
	}
}
