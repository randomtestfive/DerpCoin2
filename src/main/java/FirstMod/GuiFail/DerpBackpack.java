package FirstMod.GuiFail;

import FirstMod.Base.Thingy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class DerpBackpack extends Item
{
	public DerpBackpack()
	{
		super();
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		FMLNetworkHandler.openGui(par3EntityPlayer, Thingy.instance, References.GUI_BACKPACK, par2World, (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ);
		
		return par1ItemStack;
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) 
	{
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		
		EntityPlayer par3EntityPlayer = ((EntityPlayer)entityIn);
		
		if(worldIn.isRemote)
			return;
		
		if(par3EntityPlayer.openContainer == null || par3EntityPlayer.openContainer instanceof ContainerPlayer)
			return;
		
		if(!(stack.getItem() instanceof DerpBackpack))
			return;
		
		if(ContainerBackpack.class.isAssignableFrom(par3EntityPlayer.openContainer.getClass()))
		{
			ContainerBackpack backpack = (ContainerBackpack) par3EntityPlayer.openContainer;
			if(backpack.updateState)
			{
				backpack.saveToNBT(stack);
				backpack.updateState = false;
			}
		}
	}
}
