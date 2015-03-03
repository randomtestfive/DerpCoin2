package FirstMod.Base;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class DerpCoinProjectile extends EntityThrowable
{
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
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
    	MinecraftServer.getServer().worldServerForDimension(this.dimension).playSoundAtEntity(this, "random.bow", 2.0F, 1.0F);
    	MinecraftServer.getServer().worldServerForDimension(this.dimension).createExplosion(this, this.posX, this.posY, this.posZ,  (float)(this.explosionRadius), true);
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