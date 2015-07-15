package FirstMod.Base;

import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DerpPickaxe extends ItemPickaxe
{
	public DerpPickaxe(ToolMaterial p_i45347_1_) 
	{
		super(p_i45347_1_);
    	GameRegistry.registerItem(this, "derpPickaxe");
    	
    	setUnlocalizedName("derpPickaxe");
	}	
}