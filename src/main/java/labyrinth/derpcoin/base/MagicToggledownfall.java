package labyrinth.derpcoin.base;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

public class MagicToggledownfall extends DCConsumer
{
	
	public MagicToggledownfall()
	{
		this.setMaxStackSize(1);
		this.setUnlocalizedName("magicDownfall");
	}
	
	
	 public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) 
	 {
		 //CommandToggleDownfall toggle = new CommandToggleDownfall();
		 System.out.println("toggledown");
		 //par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		 if(par3EntityPlayer.capabilities.isCreativeMode || subDerpsack(par3EntityPlayer.inventory) || par3EntityPlayer.inventory.consumeInventoryItem(Main.derpCoin))
		 {
			 WorldInfo worldinfo = MinecraftServer.getServer().worldServers[0].getWorldInfo();
			 //worldinfo.setRaining(!worldinfo.isRaining());
			 boolean IsRaining = !par2World.isRaining();
			 worldinfo.setRaining(IsRaining);	 
		 }
		 return par1ItemStack;
	 }
	 
	 @Override
	 public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int p_77663_4_, boolean p_77663_5_)
	 {
		 if(par2World.isRaining())
		 {
			 par1ItemStack.setItemDamage(0);
		 }
		 else
		 {
			 par1ItemStack.setItemDamage(1);
		 }
	 }
	 
}