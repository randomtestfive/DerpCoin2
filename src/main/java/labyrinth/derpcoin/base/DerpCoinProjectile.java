package labyrinth.derpcoin.base;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class DerpCoinProjectile extends EntityThrowable
{
	
	private int ticksAlive = 0;
	public static float explosionRadius = 2.0F;
	
    public DerpCoinProjectile(World par1World)
    {
        super(par1World);
    }
    public DerpCoinProjectile(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }
    public DerpCoinProjectile(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
    
    @Override
    public void onUpdate()
    {
    	super.onUpdate();
    	if(!field_174854_a)
    	{
    		++ticksAlive;
    		if(ticksAlive >= 200)
    		{
    			if(!this.worldObj.isRemote)
    			{
    				this.entityDropItem(new ItemStack(Main.derpCoin, 1), 0.0F);
    			}
    			//this.dropItem(Thingy.derpCoin, 1);
    			//this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Thingy.derpCoin)));
    			this.setDead();
    		}
    	}
    	else
    	{
    		ticksAlive = 0;
    	}
    	//System.out.println(ticksAlive);
    }
    
	@Override
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
    	//MinecraftServer.getServer().worldServerForDimension(this.dimension).playSoundAtEntity(this, "random.bow", 2.0F, 1.0F);
    	MinecraftServer.getServer().worldServerForDimension(this.dimension).createExplosion(this, this.posX, this.posY, this.posZ,  (float)(DerpCoinProjectile.explosionRadius), true);
    	if (!MinecraftServer.getServer().worldServerForDimension(this.dimension).isRemote)
    	{
    		System.out.println("Hit");
    	}
    	this.setDead();
    }
    
    @Override
    protected float getGravityVelocity()
    {
    	return 0;
    }
}