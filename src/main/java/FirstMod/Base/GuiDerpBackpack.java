package FirstMod.Base;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiDerpBackpack extends GuiContainer{

	public ItemStack derpBackpack;
	public static final ResourceLocation texture = new ResourceLocation(Thingy.MODID, "textures/gui/backpack.png");
	
	public GuiDerpBackpack(InventoryPlayer inventoryPlayer, ItemStack item) 
	{
		super(new ContainerBackpack(inventoryPlayer, item));
		this.derpBackpack = item;
		
		this.xSize = 176;
		this.ySize = 222;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String name = this.derpBackpack.isInvNameLocalized();
		
		this.fontRendererObj.drawString(Il8n.func_135053_a(""), x, y, color)
	}
	
	@Override
	public void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{

	}

}
