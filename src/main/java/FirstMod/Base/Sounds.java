package FirstMod.Base;

import net.minecraftforge.client.event.sound.SoundLoadEvent;

public class Sounds 
{
	   //@ForgeSubscribe
	   public void onSound(SoundLoadEvent event)
	   {
	       try
	       {
	       		String [] soundFiles = 
	       			{
	       	
	       			};
	       		for (int i = 0; i < soundFiles.length; i++){
	       			//event.
	       		}
	      
	       }
	       catch (Exception e)
	       {
	           System.err.println("Space Marine Mod: Failed to register one or more sounds.");
	       }
	   }
}