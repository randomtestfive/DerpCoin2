package FirstMod.Base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import FirstMod.Base.CommonProxy;
import FirstMod.Client.ClientProxy;

@Mod(modid = "DerpCoin", version = Thingy.VERSION)
public class Thingy
{
	@Instance(value="DerpCoin")
	public static Thingy instance;
    public static final String MODID = "ThingyTest";
    public static final String VERSION = "0.3.1";
    
    @SidedProxy(clientSide="FirstMod.Client.ClientProxy", serverSide="FirstMod.Base.CommonProxy")
    public static CommonProxy proxy;
    public static ClientProxy client;
    public static Item derpCoin;
    public static Block derpCoinBlock;
    public static MagicClockForward magicClockForward;
    public static MagicClockBackward magicClockBackward;
    public static MagicClock magicClock;
    public static Item derpIngot;
    public static MagicToggledownfall magicDownfall;
    //TutorialEventHandler events = new TutorialEventHandler();
    
    @EventHandler
    public void preInit(FMLInitializationEvent event)
    {
    	//FMLCommonHandler.instance().bus().register(events);
    	//MinecraftForge.EVENT_BUS.register(events);

		Item magicItem = new MagicItem();
		GameRegistry.registerItem(magicItem, "magicItem");
		magicItem.setTextureName("derpcoin:magicItem");
		magicItem.setUnlocalizedName("magicItem");
		magicItem.setMaxStackSize(1);
		magicItem.setCreativeTab(derpTab.tabDerpCoin);
		
		magicDownfall = new MagicToggledownfall();
		GameRegistry.registerItem(magicDownfall, "MagicDownfall");
		
		/*magicClockForward = new MagicClockForward();
		GameRegistry.registerItem(magicClockForward, "magicClockForward");
		magicClockForward.setTextureName("derpcoin:magicClockForward");	
		magicClockForward.setUnlocalizedName("magicClockForward");
		magicClockForward.setMaxStackSize(1);
		//magicClockForward.setCreativeTab(derpTab.tabDerpCoin);
		
		/*magicClockBackward = new MagicClockBackward();
		GameRegistry.registerItem(magicClockBackward, "magicClockBackward");
		magicClockBackward.setTextureName("derpcoin:magicClockBackward");	
		magicClockBackward.setUnlocalizedName("magicClockBackward");
		magicClockBackward.setMaxStackSize(1);
		//magicClockBackward.setCreativeTab(derpTab.tabDerpCoin);*/
		
		magicClock = new MagicClock();
		GameRegistry.registerItem(magicClock, "magicClock");
		magicClock.setTextureName("derpcoin:magicClockForward");
		magicClock.setUnlocalizedName("magicClock");
		magicClock.setMaxStackSize(1);
		magicClock.setCreativeTab(derpTab.tabDerpCoin);
    	
		derpCoin = new GenericItem();
		derpCoin.setUnlocalizedName("derpCoin");
		derpCoin.setCreativeTab(derpTab.tabDerpCoin);
		GameRegistry.registerItem(derpCoin, "derpCoin");
		derpCoin.setTextureName("derpcoin:derpCoin");
		
		derpIngot = new GenericItem();
		derpIngot.setUnlocalizedName("derpIngot");
		derpIngot.setCreativeTab(derpTab.tabDerpCoin);
		derpIngot.setTextureName("derpcoin:derpIngot");
		GameRegistry.registerItem(derpIngot, "derpIngot");
		
		derpCoinBlock = new GenericBlock(Material.iron);
		derpCoinBlock.setHardness(1.0f);
		derpCoinBlock.setCreativeTab(derpTab.tabDerpCoin);
		derpCoinBlock.setStepSound(Block.soundTypeMetal);
		derpCoinBlock.setBlockName("derpCoinBlock");
		GameRegistry.registerBlock(derpCoinBlock, "derpCoinBlock");
		derpCoinBlock.setBlockTextureName("derpcoin:derpCoinBlock");
		
		ItemStack derpCoinStack = new ItemStack(derpCoin);
		ItemStack diamondStack = new ItemStack(Items.diamond);
		GameRegistry.addRecipe(new ItemStack(magicItem)," X ", "XYX", " X ", 'X', derpCoinStack, 'Y', diamondStack);
		GameRegistry.addRecipe(new ItemStack(derpCoinBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(derpIngot));
		GameRegistry.addRecipe(new ItemStack(derpIngot), "XXX", "XXX", "XXX", 'X', new ItemStack(derpCoin));
		GameRegistry.addRecipe(new ItemStack(magicClock), " X ", "XYX", " X ", 'X', new ItemStack(magicItem), 'Y', new ItemStack(Items.clock));
		GameRegistry.addShapelessRecipe(new ItemStack(derpIngot, 9), new ItemStack(derpCoinBlock, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(derpCoin, 9), new ItemStack(derpIngot, 1));
		GameRegistry.addSmelting(Items.gold_nugget, new ItemStack(derpCoin), 0.2f);
		//client.registerRenderers();
		RenderingRegistry.registerEntityRenderingHandler(DerpCoinProjectile.class, new RenderSnowball(derpCoin));
		System.out.println("Everything loaded...");
    }
}
