package labyrinth.derpcoin.base;

import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class MagicArmor extends ItemArmor
{
	public MagicArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, int armorType)
    {
        super(material, renderIndex, armorType);
        this.setUnlocalizedName(unlocalizedName);
    }
}
