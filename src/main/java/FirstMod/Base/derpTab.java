package FirstMod.Base;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class derpTab extends CreativeTabs 
{

	public derpTab(int par1, String par2Str) 
	{
		super(par1, par2Str);
	}
	
    public static CreativeTabs tabDerpCoin = new CreativeTabs("DerpCoin") 
    {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() 
        {
            return Thingy.derpCoin;
        }
    };

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack()
	{
		return new ItemStack(Thingy.derpCoin);
	}
	public String getTranslatedTabLabel()
	{
		return "DerpCoin";
	}

	@Override
	public Item getTabIconItem() 
	{
		return Thingy.derpCoin;
	}

}