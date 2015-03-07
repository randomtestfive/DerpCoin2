package FirstMod.Base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MagicToggledownfall extends Item
{
	public MagicToggledownfall()
	{
		this.setCreativeTab(derpTab.tabDerpCoin);
		this.setMaxStackSize(1);
		this.setUnlocalizedName("magicDownfall");
	}
	
	 public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) 
	 {
		 System.out.println("toggledown");
		 //par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		 if(par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(Thingy.derpCoin))
		 {
			 if (par2World.isRemote)
			 {
				 if(par2World.isRaining())
				 {
					 par2World.setRainStrength(0);
				 }
				 else
				 {
					 par2World.setRainStrength(1);
				 }
			 }		 
		 }
		 return par1ItemStack;
	 }
	 
}