package FirstMod.Base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class MagicClockBackward extends Item
{
	public boolean mode = false;
	
	public MagicClockBackward()
	{
		super();
		Item magicClockBackward = new Item();
		magicClockBackward.setCreativeTab(derpTab.tabDerpCoin);
		magicClockBackward.setMaxStackSize(1);
	}
	
	 @Override
	 public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) 
	 {
		 ItemStack Output;
		 if(par3EntityPlayer.isSneaking())
		 {
			 //if(this.mode)
			 //{
			 Output = new ItemStack(Thingy.magicClockForward, 1);
			 //}
			 /*else
			 {
				 Output = par1ItemStack;
			 }*/
		 }
		 else
		 {
			 Output = par1ItemStack;
			 if (par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(Thingy.derpCoin))
			 {
				 par2World.setWorldTime(par2World.getWorldTime() - 6000);
			 }
		 }
		 return par1ItemStack;
	 }
	 
	 public void onPlayerStoppedUsing(ItemStack par1Stack, World p_77974_1_, EntityPlayer p_77974_2_, int p_77974_3_)
	 {
		 this.mode = true;
	 }
}