package FirstMod.Client;

import net.minecraft.client.renderer.entity.RenderSnowball;
import cpw.mods.fml.client.registry.RenderingRegistry;
import FirstMod.Base.CommonProxy;
import FirstMod.Base.DerpCoinProjectile;

public class ClientProxy extends CommonProxy 
{
    public void registerRenderers() 
    {
		RenderingRegistry.registerEntityRenderingHandler(DerpCoinProjectile.class, new RenderSnowball(FirstMod.Base.Thingy.derpCoin));
    }
}