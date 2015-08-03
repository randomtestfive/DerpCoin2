package labyrinth.derpcoin.client;

import labyrinth.derpcoin.base.CommonProxy;
import labyrinth.derpcoin.base.DerpCoinProjectile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
//import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends CommonProxy 
{
    public void init(FMLInitializationEvent e) 
    {
    	super.init(e);
    	registerRenderers();
    }
	
    public void registerRenderers() 
    {
    	RenderingRegistry.registerEntityRenderingHandler(DerpCoinProjectile.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), labyrinth.derpcoin.base.Main.derpCoinU, Minecraft.getMinecraft().getRenderItem()));
    }
}