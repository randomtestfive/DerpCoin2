//As a person, This is my first Change to the project (snydecor000)
package FirstMod.Base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
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
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
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
    
    
    @SidedProxy(clientSide="FirstMod.Client.ClientProxy", serverSide="CommonProxy")
    public static CommonProxy proxy;
    public static ClientProxy client;
    public static DerpCoin derpCoin;
    public static Item derpIngot;
    public static Block derpCoinBlock;
    public static MagicClock magicClock;
    public static MagicToggledownfall magicDownfall;
    public static ArmorMaterial derpArmor = EnumHelper.addArmorMaterial("derpArmor", "derpcoin:derpArmor", 20, new int[]{3, 7, 6, 3} , 25);
    public static DerpArmor derpHelmet;
    public static DerpArmor derpChestplate;
    public static DerpArmor derpLeggings;
    public static DerpArmor derpBoots;
    public static ToolMaterial derpMaterial = EnumHelper.addToolMaterial("derpMaterial", 3, 600, 7.0F, 2.5F, 22);
    public static ItemSword derpSword;
    public static DerpPickaxe derpPickaxe;
    public static ItemSpade derpShovel;
    public static MagicItem magicItem;
    public static Item derpCoinU;
    public static DerpSack derpSack;
    //public static DerpBackpack derpBackpack;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	
    	this.proxy.preInit(event);
    	derpSword = new ItemSword(derpMaterial);
    	
    	
    	derpSword.setUnlocalizedName("derpSword");
    	
    	derpPickaxe = new DerpPickaxe(derpMaterial);

    	//client.registerRenderers();
    	
		magicItem = new MagicItem();

		magicItem.setUnlocalizedName("magicItem");
		magicItem.setMaxStackSize(1);
		
		derpShovel = new ItemSpade(derpMaterial);
		derpShovel.setUnlocalizedName("derpShovel");
		
		magicDownfall = new MagicToggledownfall();

		derpCoinU = new Item();
		derpCoinU.setUnlocalizedName("derpCoinU");

		//derpBackpack = new DerpBackpack();
		//derpBackpack.setUnlocalizedName("derpBackpack");
		derpSack = new DerpSack();
		derpSack.setUnlocalizedName("derpSack");
		
		magicClock = new MagicClock();
    	
		derpCoin = new DerpCoin();
		
		derpIngot = new GenericItem();
		derpIngot.setUnlocalizedName("derpIngot");
		
		
		derpCoinBlock = new GenericBlock(Material.iron);
		derpCoinBlock.setHardness(1.0f);
		derpCoinBlock.setUnlocalizedName("derpCoinBlock");
		derpCoinBlock.setStepSound(Block.soundTypeMetal);
		
		registerItems();
		setupDerpTab();
		 
		//EntityRegistry.registerModEntity(DerpCoinProjectile.class, "MyEntity", 1, this, 350, 5, false );
		
		ItemStack derpCoinStack = new ItemStack(derpCoin);
		ItemStack diamondStack = new ItemStack(Items.diamond);
		GameRegistry.addRecipe(new ItemStack(magicItem)," X ", "XYX", " X ", 'X', derpCoinStack, 'Y', diamondStack);
		GameRegistry.addRecipe(new ItemStack(derpCoinBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(derpIngot));
		GameRegistry.addRecipe(new ItemStack(derpIngot), "XXX", "XXX", "XXX", 'X', new ItemStack(derpCoin));
		GameRegistry.addRecipe(new ItemStack(magicClock), " X ", "XYX", " X ", 'X', new ItemStack(magicItem), 'Y', new ItemStack(Items.clock));
		GameRegistry.addRecipe(new ItemStack(derpHelmet), "   ", "XXX", "X X", 'X', new ItemStack(derpIngot));
		GameRegistry.addRecipe(new ItemStack(derpHelmet), "XXX", "X X", "   ", 'X', new ItemStack(derpIngot));
		GameRegistry.addRecipe(new ItemStack(derpChestplate), "X X", "XXX", "XXX", 'X', new ItemStack(derpIngot));
		GameRegistry.addRecipe(new ItemStack(derpLeggings), "XXX", "X X", "X X", 'X', new ItemStack(derpIngot));
		GameRegistry.addRecipe(new ItemStack(derpBoots), "X X", "X X", "   ", 'X', new ItemStack(derpIngot));
		GameRegistry.addRecipe(new ItemStack(derpBoots), "   ", "X X", "X X", 'X', new ItemStack(derpIngot));
		GameRegistry.addRecipe(new ItemStack(derpSword), " X ", " X ", " Y ", 'X', new ItemStack(derpIngot), 'Y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(derpPickaxe), "XXX", " Y ", " Y ", 'X', new ItemStack(derpIngot), 'Y', new ItemStack(Items.stick));
		GameRegistry.addShapelessRecipe(new ItemStack(derpIngot, 9), new ItemStack(derpCoinBlock, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(derpCoin, 9), new ItemStack(derpIngot, 1));
		GameRegistry.addSmelting(Items.gold_nugget, new ItemStack(derpCoin), 0.2f);
		System.out.println("Everything loaded...");
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	//NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
    	this.proxy.init(event);
    	//RenderingRegistry.registerEntityRenderingHandler(DerpCoinProjectile.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), derpCoin, Minecraft.getMinecraft().getRenderItem()));
    	ModelBakery.addVariantName(magicClock, "derpcoin:magicClockBackward", "derpcoin:magicClockForward");
    	ModelBakery.addVariantName(magicDownfall, "derpcoin:magicDownfallFull", "derpcoin:magicDownfallEmpty");
    	ModelBakery.addVariantName(derpSack, "derpcoin:derpsackEmpty", "derpcoin:derpsackPartial1", "derpcoin:derpsackPartial2", "derpcoin:derpsackPartial3", "derpcoin:derpsackFull");
    	
    	if(event.getSide() == Side.CLIENT)
    	{
    		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    		
    		renderItem.getItemModelMesher().register(derpCoin, 0, new ModelResourceLocation("derpcoin:" + "derpCoin", "inventory"));
    		renderItem.getItemModelMesher().register(magicClock, 1, new ModelResourceLocation("derpcoin:" + "magicClockBackward", "inventory"));
    		renderItem.getItemModelMesher().register(magicClock, 0, new ModelResourceLocation("derpcoin:" + "magicClockForward", "inventory"));
    		renderItem.getItemModelMesher().register(magicDownfall, 1, new ModelResourceLocation("derpcoin:" + "magicDownfallEmpty", "inventory"));
    		renderItem.getItemModelMesher().register(magicDownfall, 0, new ModelResourceLocation("derpcoin:" + "magicDownfallFull", "inventory"));
    		renderItem.getItemModelMesher().register(derpSword, 0, new ModelResourceLocation("derpcoin:" + "derpSword", "inventory"));
    		renderItem.getItemModelMesher().register(derpPickaxe, 0, new ModelResourceLocation("derpcoin:" + "derpPickaxe", "inventory"));
    		renderItem.getItemModelMesher().register(derpHelmet, 0, new ModelResourceLocation("derpcoin:" + "derp_helmet", "inventory"));
    		renderItem.getItemModelMesher().register(derpChestplate, 0, new ModelResourceLocation("derpcoin:" + "derp_chestplate", "inventory"));
    		renderItem.getItemModelMesher().register(derpLeggings, 0, new ModelResourceLocation("derpcoin:" + "derp_leggings", "inventory"));
    		renderItem.getItemModelMesher().register(derpBoots, 0, new ModelResourceLocation("derpcoin:" + "derp_boots", "inventory"));
    		renderItem.getItemModelMesher().register(magicItem, 0, new ModelResourceLocation("derpcoin:" + "magicItem", "inventory"));
    		renderItem.getItemModelMesher().register(derpIngot, 0, new ModelResourceLocation("derpcoin:" + "derpIngot", "inventory"));
    		renderItem.getItemModelMesher().register(derpCoinU, 0, new ModelResourceLocation("derpcoin:derpCoinU", "inventory"));
    		renderItem.getItemModelMesher().register(derpSack, 0, new ModelResourceLocation("derpcoin:derpsackEmpty", "inventory"));
    		renderItem.getItemModelMesher().register(derpSack, 1, new ModelResourceLocation("derpcoin:derpsackPartial1", "inventory"));
    		renderItem.getItemModelMesher().register(derpSack, 2, new ModelResourceLocation("derpcoin:derpsackPartial2", "inventory"));
    		renderItem.getItemModelMesher().register(derpSack, 3, new ModelResourceLocation("derpcoin:derpsackPartial3", "inventory"));
    		renderItem.getItemModelMesher().register(derpSack, 4, new ModelResourceLocation("derpcoin:derpsackFull", "inventory"));
    		renderItem.getItemModelMesher().register(derpShovel, 4, new ModelResourceLocation("derpcoin:derpShovel", "inventory"));
    		//renderItem.getItemModelMesher().register(derpBackpack, 0, new ModelResourceLocation("derpcoin:derpBackpack", "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(derpCoinBlock), 0, new ModelResourceLocation("derpcoin:" + "derpCoinBlock", "inventory"));
    	}
    }
    
    public void registerItems()
    {
    	GameRegistry.registerItem(derpCoin, "derpCoin");
    	GameRegistry.registerItem(derpIngot, "derpIngot");
    	GameRegistry.registerBlock(derpCoinBlock, "derpCoinBlock");
    	GameRegistry.registerItem(derpSword, "derpSword");
		GameRegistry.registerItem(derpPickaxe, "derpPickaxe");
		GameRegistry.registerItem(derpShovel, "derpShovel");
		GameRegistry.registerItem(derpHelmet = new DerpArmor("derpHelmet", derpArmor, 1, 0), "derp_helmet");
		GameRegistry.registerItem(derpChestplate = new DerpArmor("derpChestplate", derpArmor, 1, 1), "derp_chestplate"); 
		GameRegistry.registerItem(derpLeggings = new DerpArmor("derpLeggings", derpArmor, 2, 2), "derp_leggings"); 
		GameRegistry.registerItem(derpBoots = new DerpArmor("derpBoots", derpArmor, 1, 3), "derp_boots");
		GameRegistry.registerItem(magicItem, "magicItem");
		GameRegistry.registerItem(magicClock, "magicClock");
		GameRegistry.registerItem(magicDownfall, "MagicDownfall");
		GameRegistry.registerItem(derpSack, "derpSack");
		GameRegistry.registerItem(derpCoinU, "derpCoinU");
		
		//GameRegistry.registerItem(derpBackpack, "derpBackpack");
    }
    
    public void setupDerpTab()
    {
    	derpCoin.setCreativeTab(derpTab.tabDerpCoin);
    	derpIngot.setCreativeTab(derpTab.tabDerpCoin);
    	derpCoinBlock.setCreativeTab(derpTab.tabDerpCoin);
    	derpSword.setCreativeTab(derpTab.tabDerpCoin);
    	derpPickaxe.setCreativeTab(derpTab.tabDerpCoin);
    	derpShovel.setCreativeTab(derpTab.tabDerpCoin);
    	derpHelmet.setCreativeTab(derpTab.tabDerpCoin);
    	derpChestplate.setCreativeTab(derpTab.tabDerpCoin);
    	derpLeggings.setCreativeTab(derpTab.tabDerpCoin);
    	derpBoots.setCreativeTab(derpTab.tabDerpCoin);
    	magicItem.setCreativeTab(derpTab.tabDerpCoin);
    	magicClock.setCreativeTab(derpTab.tabDerpCoin);
    	magicDownfall.setCreativeTab(derpTab.tabDerpCoin);
    	derpSack.setCreativeTab(derpTab.tabDerpCoin);
    	//derpBackpack.setCreativeTab(derpTab.tabDerpCoin);
    }
}
