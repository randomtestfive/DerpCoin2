package FirstMod.Base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import FirstMod.Client.ClientProxy;

@Mod(modid = "DerpCoin", version = Thingy.VERSION)
public class Thingy
{
	@Instance(value="DerpCoin")
	public static Thingy instance;
    public static final String MODID = "ThingyTest";
    public static final String VERSION = "0.4.7";
    
    @SidedProxy(clientSide="FirstMod.Client.ClientProxy", serverSide="FirstMod.Base.CommonProxy")
    public static CommonProxy proxy;
    public static ClientProxy client;
    public static DerpCoin derpCoin;
    public static Block derpCoinBlock;
    public static MagicClockForward magicClockForward;
    public static MagicClockBackward magicClockBackward;
    public static MagicClock magicClock;
    public static Item derpIngot;
    public static MagicToggledownfall magicDownfall;
    public static ArmorMaterial derpArmor = EnumHelper.addArmorMaterial("DerpCoin", null, 20, new int[]{3, 7, 6, 3} , 25);
    public static Item derpHelmet;
    public static Item derpChestplate;
    public static Item derpLeggings;
    public static Item derpBoots;
    public static ToolMaterial derpMaterial = EnumHelper.addToolMaterial("derpMaterial", 3, 600, 7.0F, 2.5F, 22);
    public static ItemSword derpSword;
    public static ItemPickaxe derpPickaxe;
    //TutorialEventHandler events = new TutorialEventHandler();
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	//FMLCommonHandler.instance().bus().register(events);
    	//MinecraftForge.EVENT_BUS.register(events);

    	derpSword = new ItemSword(derpMaterial);
    	GameRegistry.registerItem(derpSword, "derpSword");
    	derpSword.setCreativeTab(derpTab.tabDerpCoin);
    	derpSword.setUnlocalizedName("derpSword");
    	
    	/*derpPickaxe = new ItemPickaxe(derpMaterial);
    	GameRegistry.registerItem(derpPickaxe, "derpPickaxe");
    	derpPickaxe.setTextureName("derpcoin:derpPickaxe");
    	derpPickaxe.setCreativeTab(derpTab.tabDerpCoin);
    	derpPickaxe.setUnlocalizedName("derpPickaxe");*/
    	
		Item magicItem = new MagicItem();
		GameRegistry.registerItem(magicItem, "magicItem");
		//magicItem.setTextureName("derpcoin:magicItem");
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
		
		GameRegistry.registerItem(derpHelmet = new DerpArmor("derp_helmet", derpArmor, "DerpArmor", 0), "derp_helmet"); //0 for helmet
		derpHelmet.setCreativeTab(derpTab.tabDerpCoin);
		//derpHelmet.set ("derpcoin:derpHelmet");
		GameRegistry.registerItem(derpChestplate = new DerpArmor("derp_chestplate", derpArmor, "DerpArmor", 1), "derp_chestplate"); // 1 for chestplate
		derpChestplate.setCreativeTab(derpTab.tabDerpCoin);
		//derpChestplate.setTextureName("derpcoin:derpChestplate");
		GameRegistry.registerItem(derpLeggings = new DerpArmor("derp_leggings", derpArmor, "DerpArmor", 2), "derp_leggings"); // 2 for leggings
		derpLeggings.setCreativeTab(derpTab.tabDerpCoin);
		//derpLeggings.setTextureName("derpcoin:derpLeggings");
		GameRegistry.registerItem(derpBoots = new DerpArmor("derp_boots", derpArmor, "DerpArmor", 3), "derp_boots");
		derpBoots.setCreativeTab(derpTab.tabDerpCoin);
		//derpBoots.setTextureName("derpcoin:derpBoots");
		
		
		
		magicClock = new MagicClock();
		GameRegistry.registerItem(magicClock, "magicClock");
		//magicClock.setTextureName("derpcoin:magicClockForward");
		magicClock.setUnlocalizedName("magicClock");
		magicClock.setMaxStackSize(1);
		magicClock.setCreativeTab(derpTab.tabDerpCoin);
    	
		derpCoin = new DerpCoin();
		//derpCoin.
		//derpCoin.setUnlocalizedName("derpCoin");
		//derpCoin.setCreativeTab(derpTab.tabDerpCoin);
		//GameRegistry.registerItem(derpCoin, "derpCoin");
		//derpCoin.setTextureName("derpcoin:derpCoin");
		
		derpIngot = new GenericItem();
		derpIngot.setUnlocalizedName("derpIngot");
		derpIngot.setCreativeTab(derpTab.tabDerpCoin);
		//derpIngot.setTextureName("derpcoin:derpIngot");
		GameRegistry.registerItem(derpIngot, "derpIngot");
		
		derpCoinBlock = new GenericBlock(Material.iron);
		derpCoinBlock.setHardness(1.0f);
		derpCoinBlock.setCreativeTab(derpTab.tabDerpCoin);
		derpCoinBlock.setStepSound(Block.soundTypeMetal);
		//derpCoinBlock.setBlockName("derpCoinBlock");
		GameRegistry.registerBlock(derpCoinBlock, "derpCoinBlock");
		//derpCoinBlock.setBlockTextureName("derpcoin:derpCoinBlock");
		
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
		RenderingRegistry.registerEntityRenderingHandler(DerpCoinProjectile.class, new RenderSnowball(null, derpCoin, null));
		System.out.println("Everything loaded...");
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	if(event.getSide() == Side.CLIENT)
    	{
    		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    		
    		renderItem.getItemModelMesher().register(derpCoin, 0, new ModelResourceLocation("derpcoin" + ":" + ((DerpCoin) derpCoin).getName(), "inventory"));
    	}
    }
}
