package labyrinth.derpcoin.base;


import net.minecraft.item.Item;

public class DerpCoin extends Item 
{
	private final String name = "derpCoin";
	
	public DerpCoin()
	{
		setUnlocalizedName("derpcoin" + "_" + name);
		
	}
	
	public String getName()
	{
		return name;
	}
	//- See more at: http://www.wuppy29.com/minecraft/1-8-tutorial/updating-1-7-to-1-8-part-2-basic-items/#sthash.nTxAZQwa.NQWRfZL4.dpuf
}
