package FirstMod.Base;


import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DerpCoin extends Item 
{
	private final String name = "derpCoin";
	
	public DerpCoin()
	{
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("derpcoin" + "_" + name);
		setCreativeTab(derpTab.tabDerpCoin);
	}
	
	public String getName()
	{
		return name;
	}
	//- See more at: http://www.wuppy29.com/minecraft/1-8-tutorial/updating-1-7-to-1-8-part-2-basic-items/#sthash.nTxAZQwa.NQWRfZL4.dpuf
}