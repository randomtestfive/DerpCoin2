package FirstMod.Base;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MagicItem extends Item
{
	public MagicItem()
	{
		super();
		Item magicItem = new Item();
		magicItem.setCreativeTab(derpTab.tabDerpCoin);
		magicItem.setMaxStackSize(1);
	}
	
	 @Override
	 public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) 
	 {
			 System.out.println("pls work");
			 //par2World.setWorldTime(0);
			 //par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F);
			 par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			 if(par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(Thingy.derpCoin))
			 {
				 if (par2World.isRemote)
				 {
				 //par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				 par2World.spawnEntityInWorld(new DerpCoinProjectile(par2World, par3EntityPlayer));
				 }
				 
			 }
	
		 return par1ItemStack;
	 }
	 
	 @Override
	 public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz)
	 {
		 System.out.println("USE");
		 return true;
	 }
}