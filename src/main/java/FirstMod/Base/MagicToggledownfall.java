package FirstMod.Base;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.command.CommandToggleDownfall;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

public class MagicToggledownfall extends Item
{
	public IIcon full;
	public IIcon empty;
	
	public MagicToggledownfall()
	{
		this.setCreativeTab(derpTab.tabDerpCoin);
		this.setMaxStackSize(1);
		this.setUnlocalizedName("magicDownfall");
		this.itemIcon = empty;
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.full = iconRegister.registerIcon("derpcoin:magictogglefull");
		this.empty = iconRegister.registerIcon("derpcoin:magictoggleempty");
		
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) 
	{
		if (meta == 0)
		{
			return full;
		}
		else if(meta == 1)
		{
			return empty;
		}
		else
		{
			return empty;
		}
	}
	
	 public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) 
	 {
		 CommandToggleDownfall toggle = new CommandToggleDownfall();
		 System.out.println("toggledown");
		 //par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		 if(par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(Thingy.derpCoin))
		 {
			 if(par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(Thingy.derpCoin))
			 {
				 WorldInfo worldinfo = MinecraftServer.getServer().worldServers[0].getWorldInfo();
				 worldinfo.setRaining(!worldinfo.isRaining());
			 }		 
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