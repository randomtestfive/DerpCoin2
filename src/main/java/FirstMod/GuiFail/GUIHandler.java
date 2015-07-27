package FirstMod.GuiFail;

import FirstMod.Base.Thingy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler 
{
	
	//private ItemStack derpBackpack = new ItemStack(Thingy.derpBackpack);

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		ItemStack heldItem = player.getHeldItem();
		if(heldItem != null)
		{
			switch(ID)
			{
				case References.GUI_BACKPACK:
					//if(heldItem == derpBackpack)
					{
						//return new ContainerDerpBackpack(player.inventory, heldItem);
					}
					break;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		ItemStack heldItem = player.getHeldItem();
		if(heldItem != null)
		{
			switch(ID)
			{
				case References.GUI_BACKPACK:
					//if(heldItem == derpBackpack)
					{
						//return new GuiDerpBackpack(player.inventory, heldItem);
					}
					//break;
			}
		}
		return null;
	}

}
