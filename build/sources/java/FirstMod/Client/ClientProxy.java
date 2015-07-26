package FirstMod.Client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import FirstMod.Base.CommonProxy;
//import cpw.mods.fml.client.registry.RenderingRegistry;
import FirstMod.Base.DerpCoinProjectile;


public class ClientProxy extends CommonProxy 
{
    public void init(FMLInitializationEvent e) 
    {
    	super.init(e);
    	registerRenderers();
    }
	
    public void registerRenderers() 
    {
    	RenderingRegistry.registerEntityRenderingHandler(DerpCoinProjectile.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), FirstMod.Base.Thingy.derpCoinU, Minecraft.getMinecraft().getRenderItem()));
    }
}