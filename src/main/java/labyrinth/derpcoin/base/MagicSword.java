package labyrinth.derpcoin.base;

import com.google.common.collect.Multimap;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MagicSword extends ItemSword
{
	private DCConsumer consumer;
	
	private int counter = 0;
	private ToolMaterial material;
	private double damageLow = 8;
	private double damageHigh = 500;
	
	public MagicSword(ToolMaterial p_i45356_1_) 
	{
		super(p_i45356_1_);
		this.setUnlocalizedName("magicPickaxe");
		consumer = new DCConsumer();
		this.setMaxStackSize(1);
		this.material = p_i45356_1_;
	}
	
	@Override
	public void onCreated(ItemStack par1Item, World par2World, EntityPlayer par3Player)
	{
		par1Item.setTagCompound(new NBTTagCompound());
		par1Item.getTagCompound().setBoolean("Active", false);
	}
	
	@Override
	public void onUpdate(ItemStack par1stack, World par2world, Entity par3entity, int par4slot, boolean isSelected) 
	{
		counter = counter + 1;
		if(counter == 20)
		{
			counter = 0;
			
			if(par3entity instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) par3entity;
				if(par1stack.getTagCompound() != null)
				{
					if(par1stack.getTagCompound().getBoolean("Active"))
					{
						if(consumer.subDerpsack(player.inventory) || player.inventory.consumeInventoryItem(Main.derpCoin))
						{
						
						}
						else
						{
							par1stack.getTagCompound().setBoolean("Active", false);
						}
					}
				}
				else
				{
					par1stack.setTagCompound(new NBTTagCompound());
				}
			}
		}
		
		if(par3entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) par3entity;
			if(par1stack.getTagCompound() != null)
			{
				if(par1stack.getTagCompound().getBoolean("Active"))
				{
					
				}
				else
				{
					
				}
			}
			else
			{
				par1stack.setTagCompound(new NBTTagCompound());
			}
		}
	}
	
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int useRemaining)
	{
		NBTTagCompound tag = stack.getTagCompound();
		ModelResourceLocation out = new ModelResourceLocation("derpcoin:magicSword", "inventory");
		if(tag != null)
		{
			if(stack.getTagCompound().getBoolean("Active"))
			{	
				out = new ModelResourceLocation("derpcoin:magicSwordA", "inventory");
			}
		}
		return out;
	}
	
	@Override    
	public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", (double)this.material.getDamageVsEntity(), 0));
        return multimap;
    }

}
