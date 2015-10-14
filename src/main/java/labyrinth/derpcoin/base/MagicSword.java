package labyrinth.derpcoin.base;


import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MagicSword extends ItemSword
{
	private int counter = 0;
	private double damageLow = 8;
	private double damageHigh = 50;
	
	public MagicSword(ToolMaterial p_i45356_1_) 
	{
		super(p_i45356_1_);
		this.setUnlocalizedName("magicSword");
		this.setMaxStackSize(1);
	}
	
	@Override
	public void onCreated(ItemStack par1Item, World par2World, EntityPlayer par3Player)
	{
		par1Item.setTagCompound(new NBTTagCompound());
		par1Item.getTagCompound().setBoolean("Active", false);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3Player)
	{
		NBTTagCompound tag = par1ItemStack.getTagCompound();
		if(par3Player.isSneaking())
		{
			if(tag != null)
			{
				tag.setBoolean("Active", !tag.getBoolean("Active"));
			}
			else
			{
				tag = new NBTTagCompound();
				par1ItemStack.setTagCompound(tag);
			}
		}
		else
		{
			par3Player.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		}
		return par1ItemStack;
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
						if(DCConsumer.subDerpsack(player.inventory) || player.inventory.consumeInventoryItem(Main.derpCoin))
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
	
	/*@Override    
	public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", (double)this.material.getDamageVsEntity(), 0));
        return multimap;
    }*/
	
	@Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	if (this.getDamage(par1ItemStack) >= 998)
    		return false;
    	float damage = (float) damageLow;
    	if(par1ItemStack.hasTagCompound())
    	{
    		System.out.println("works");
			if(par1ItemStack.getTagCompound().getBoolean("Active"))
			{
				System.out.println("works1");
				damage = (float) damageHigh;
			}
    	}
    	DamageSource damagesource = DamageSource.causePlayerDamage((EntityPlayer)par3EntityLivingBase);
    	par2EntityLivingBase.attackEntityFrom(damagesource, damage);
    	par1ItemStack.damageItem(1, par3EntityLivingBase);
    	return true;
    }

}
