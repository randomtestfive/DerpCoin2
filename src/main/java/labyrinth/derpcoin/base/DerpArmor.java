package labyrinth.derpcoin.base;

import net.minecraft.item.ItemArmor;

public class DerpArmor extends ItemArmor 
{
	public String textureName = "derpArmor";
	
    
	public DerpArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, int armorType)
    {
        super(material, renderIndex, armorType);
        //this.textureName = unlocalizedName;
        this.setUnlocalizedName(unlocalizedName);
    }
	
	/*@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		String location = "derpcoin:assets/derpcoin/textures/armor/" + stack.getUnlocalizedName().substring(5) +".png";
		return location;
	}*/
}