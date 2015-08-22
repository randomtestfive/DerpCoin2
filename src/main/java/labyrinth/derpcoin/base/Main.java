//As a person, This is my first Change to the project (snydecor000)
package labyrinth.derpcoin.base;

import labyrinth.derpcoin.client.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;



@Mod(modid = "DerpCoin", version = Main.VERSION)
public class Main
{
	@Instance(value="DerpCoin")
	public static Main instance;
    public static final String MODID = "DerpCoin";
    public static final String VERSION = "0.10.26";
    
    
    @SidedProxy(clientSide="labyrinth.derpcoin.client.ClientProxy", serverSide="CommonProxy")
    public static CommonProxy proxy;
    public static ClientProxy client;
    public static DerpCoin derpCoin;
    public static Item derpIngot;
    public static Block derpCoinBlock;
    public static MagicClock magicClock;
    public static MagicToggledownfall magicDownfall;
    public static ArmorMaterial derpArmor = EnumHelper.addArmorMaterial("derpArmor", "derpcoin:derpArmor", 20, new int[]{3, 7, 6, 3} , 25);
    public static ArmorMaterial magicArmor = EnumHelper.addArmorMaterial("magicArmor", "derpcoin:magicArmor", 40, new int[]{4, 8, 7, 4} , 30);//XXX We need to change this
    public static DerpArmor derpHelmet;
    public static DerpArmor derpChestplate;
    public static DerpArmor derpLeggings;
    public static DerpArmor derpBoots;
    public static MagicArmor magicHelmet;
    public static MagicArmor magicChestplate;
    public static MagicArmor magicLeggings;
    public static MagicArmor magicBoots;
    public static ToolMaterial derpMaterial = EnumHelper.addToolMaterial("derpMaterial", 3, 600, 7.0F, 2.5F, 22);
    public static ToolMaterial magicMaterial = EnumHelper.addToolMaterial("magicMaterial", 4, 1800, 8.0F, 4.0F, 20);
    public static ItemSword derpSword;
    public static DerpPickaxe derpPickaxe;
    public static ItemSpade derpShovel;
    public static DerpAxe derpAxe;
    public static ItemHoe derpHoe;
    public static MagicItem magicItem;
    public static Item derpCoinU;
    public static DerpSack derpSack;
    public static DerpHealer magicHealer;
    public static DerpFood magicFood;
    public static MagicPickaxe magicPickaxe;
    public static MagicSword magicSword;
    //public static DerpBackpack derpBackpack;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	Main.proxy.preInit(event);
    	derpSword = new ItemSword(derpMaterial);
    	derpSword.setUnlocalizedName("derpSword");
    	
    	derpPickaxe = new DerpPickaxe(derpMaterial);
    	
    	derpAxe = new DerpAxe(derpMaterial);
    	
    	derpHoe = new ItemHoe(derpMaterial);
    	derpHoe.setUnlocalizedName("derpHoe");
    	
		derpShovel = new ItemSpade(derpMaterial);
		derpShovel.setUnlocalizedName("derpShovel");

    	//client.registerRenderers();
    	
		magicItem = new MagicItem();
		magicItem.setUnlocalizedName("magicItem");
		magicItem.setMaxStackSize(1);
		
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
		
		magicHealer = new DerpHealer();
		
		magicFood = new DerpFood(4, 10, false);
		
		magicPickaxe = new MagicPickaxe(magicMaterial);
		
		magicSword = new MagicSword(magicMaterial);
		
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
		GameRegistry.addRecipe(new ItemStack(magicHelmet), "   ", "XXX", "X X", 'X', new ItemStack(magicItem));
		GameRegistry.addRecipe(new ItemStack(magicHelmet), "XXX", "X X", "   ", 'X', new ItemStack(magicItem));
		GameRegistry.addRecipe(new ItemStack(magicChestplate), "X X", "XXX", "XXX", 'X', new ItemStack(magicItem));
		GameRegistry.addRecipe(new ItemStack(magicLeggings), "XXX", "X X", "X X", 'X', new ItemStack(magicItem));
		GameRegistry.addRecipe(new ItemStack(magicBoots), "X X", "X X", "   ", 'X', new ItemStack(magicItem));
		GameRegistry.addRecipe(new ItemStack(magicBoots), "   ", "X X", "X X", 'X', new ItemStack(magicItem));
		GameRegistry.addRecipe(new ItemStack(derpSword), " X ", " X ", " Y ", 'X', new ItemStack(derpIngot), 'Y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(derpPickaxe), "XXX", " Y ", " Y ", 'X', new ItemStack(derpIngot), 'Y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(derpAxe), " XX", " YX", " Y ", 'X', new ItemStack(derpIngot), 'Y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(derpAxe), "XX ", "XY ", " Y ", 'X', new ItemStack(derpIngot), 'Y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(derpShovel), " X ", " Y ", " Y ", 'X', new ItemStack(derpIngot), 'Y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(derpShovel), "X  ", "Y  ", "Y  ", 'X', new ItemStack(derpIngot), 'Y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(derpShovel), "  X", "  Y", "  Y", 'X', new ItemStack(derpIngot), 'Y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(derpHoe), " XX", " Y ", " Y ", 'X', new ItemStack(derpIngot), 'Y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(derpHoe), "XX ", " Y ", " Y ", 'X', new ItemStack(derpIngot), 'Y', new ItemStack(Items.stick));
		GameRegistry.addShapelessRecipe(new ItemStack(derpIngot, 9), new ItemStack(derpCoinBlock, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(derpCoin, 9), new ItemStack(derpIngot, 1));
		GameRegistry.addSmelting(Items.gold_nugget, new ItemStack(derpCoin), 0.2f);
		System.out.println("Everything loaded...");
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	
    	//NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
    	Main.proxy.init(event);
    	//RenderingRegistry.registerEntityRenderingHandler(DerpCoinProjectile.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), derpCoin, Minecraft.getMinecraft().getRenderItem()));
    	ModelBakery.addVariantName(magicClock, "derpcoin:magicClockBackward", "derpcoin:magicClockForward");
    	ModelBakery.addVariantName(magicDownfall, "derpcoin:magicDownfallFull", "derpcoin:magicDownfallEmpty");
    	ModelBakery.addVariantName(magicPickaxe, "derpcoin:magicPickaxe", "derpcoin:magicPickaxeA");
    	ModelBakery.addVariantName(magicSword, "derpcoin:magicSword", "derpcoin:magicSwordA");
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
    		renderItem.getItemModelMesher().register(derpShovel, 0, new ModelResourceLocation("derpcoin:" + "derpShovel", "inventory"));
    		renderItem.getItemModelMesher().register(derpAxe, 0, new ModelResourceLocation("derpcoin:" + "derpAxe", "inventory"));
    		renderItem.getItemModelMesher().register(derpHoe, 0, new ModelResourceLocation("derpcoin:" + "derpHoe", "inventory"));
    		renderItem.getItemModelMesher().register(derpHelmet, 0, new ModelResourceLocation("derpcoin:" + "derp_helmet", "inventory"));
    		renderItem.getItemModelMesher().register(derpChestplate, 0, new ModelResourceLocation("derpcoin:" + "derp_chestplate", "inventory"));
    		renderItem.getItemModelMesher().register(derpLeggings, 0, new ModelResourceLocation("derpcoin:" + "derp_leggings", "inventory"));
    		renderItem.getItemModelMesher().register(derpBoots, 0, new ModelResourceLocation("derpcoin:" + "derp_boots", "inventory"));
    		renderItem.getItemModelMesher().register(magicHelmet, 0, new ModelResourceLocation("derpcoin:" + "magic_helmet", "inventory"));
    		renderItem.getItemModelMesher().register(magicChestplate, 0, new ModelResourceLocation("derpcoin:" + "magic_chestplate", "inventory"));
    		renderItem.getItemModelMesher().register(magicLeggings, 0, new ModelResourceLocation("derpcoin:" + "magic_leggings", "inventory"));
    		renderItem.getItemModelMesher().register(magicBoots, 0, new ModelResourceLocation("derpcoin:" + "magic_boots", "inventory"));
    		renderItem.getItemModelMesher().register(magicItem, 0, new ModelResourceLocation("derpcoin:" + "magicItem", "inventory"));
    		renderItem.getItemModelMesher().register(derpIngot, 0, new ModelResourceLocation("derpcoin:" + "derpIngot", "inventory"));
    		renderItem.getItemModelMesher().register(derpCoinU, 0, new ModelResourceLocation("derpcoin:derpCoinU", "inventory"));
    		renderItem.getItemModelMesher().register(derpSack, 0, new ModelResourceLocation("derpcoin:derpsackEmpty", "inventory"));
    		renderItem.getItemModelMesher().register(derpSack, 1, new ModelResourceLocation("derpcoin:derpsackPartial1", "inventory"));
    		renderItem.getItemModelMesher().register(derpSack, 2, new ModelResourceLocation("derpcoin:derpsackPartial2", "inventory"));
    		renderItem.getItemModelMesher().register(derpSack, 3, new ModelResourceLocation("derpcoin:derpsackPartial3", "inventory"));
    		renderItem.getItemModelMesher().register(derpSack, 4, new ModelResourceLocation("derpcoin:derpsackFull", "inventory"));
    		renderItem.getItemModelMesher().register(derpShovel, 4, new ModelResourceLocation("derpcoin:derpShovel", "inventory"));
    		renderItem.getItemModelMesher().register(magicHealer, 0, new ModelResourceLocation("derpcoin:magicHealer", "inventory"));
    		renderItem.getItemModelMesher().register(magicFood, 0, new ModelResourceLocation("derpcoin:magicFood", "inventory"));
    		renderItem.getItemModelMesher().register(magicPickaxe, 0, new ModelResourceLocation("derpcoin:magicPickaxe", "inventory"));
    		renderItem.getItemModelMesher().register(magicSword, 0, new ModelResourceLocation("derpcoin:magicSword", "inventory"));
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
		GameRegistry.registerItem(derpAxe, "derpAxe");
		GameRegistry.registerItem(derpShovel, "derpShovel");
		GameRegistry.registerItem(derpHoe, "derpHoe");
		GameRegistry.registerItem(derpHelmet = new DerpArmor("derpHelmet", derpArmor, 1, 0), "derp_helmet");
		GameRegistry.registerItem(derpChestplate = new DerpArmor("derpChestplate", derpArmor, 1, 1), "derp_chestplate"); 
		GameRegistry.registerItem(derpLeggings = new DerpArmor("derpLeggings", derpArmor, 2, 2), "derp_leggings"); 
		GameRegistry.registerItem(derpBoots = new DerpArmor("derpBoots", derpArmor, 1, 3), "derp_boots");
		GameRegistry.registerItem(magicHelmet = new MagicArmor("magicHelmet", magicArmor, 1, 0), "magic_helmet");
		GameRegistry.registerItem(magicChestplate = new MagicArmor("magicChestplate", magicArmor, 1, 1), "magic_chestplate"); 
		GameRegistry.registerItem(magicLeggings = new MagicArmor("magicLeggings", magicArmor, 2, 2), "magic_leggings"); 
		GameRegistry.registerItem(magicBoots = new MagicArmor("magicBoots", magicArmor, 1, 3), "magic_boots");	
		GameRegistry.registerItem(magicItem, "magicItem");
		GameRegistry.registerItem(magicClock, "magicClock");
		GameRegistry.registerItem(magicDownfall, "MagicDownfall");
		GameRegistry.registerItem(derpSack, "derpSack");
		GameRegistry.registerItem(derpCoinU, "derpCoinU");
		GameRegistry.registerItem(magicHealer, "magicHealer");
		GameRegistry.registerItem(magicFood, "magicFood");
		GameRegistry.registerItem(magicPickaxe, "magicPickaxe");
		GameRegistry.registerItem(magicSword, "magicSword");
		
		//GameRegistry.registerItem(derpBackpack, "derpBackpack");
    }
    
    public void setupDerpTab()
    {
    	derpCoin.setCreativeTab(DerpTab.tabDerpCoin);
    	derpIngot.setCreativeTab(DerpTab.tabDerpCoin);
    	derpCoinBlock.setCreativeTab(DerpTab.tabDerpCoin);
    	derpSword.setCreativeTab(DerpTab.tabDerpCoin);
    	derpPickaxe.setCreativeTab(DerpTab.tabDerpCoin);
    	derpAxe.setCreativeTab(DerpTab.tabDerpCoin);
    	derpShovel.setCreativeTab(DerpTab.tabDerpCoin);
    	derpHoe.setCreativeTab(DerpTab.tabDerpCoin);
    	derpHelmet.setCreativeTab(DerpTab.tabDerpCoin);
    	derpChestplate.setCreativeTab(DerpTab.tabDerpCoin);
    	derpLeggings.setCreativeTab(DerpTab.tabDerpCoin);
    	derpBoots.setCreativeTab(DerpTab.tabDerpCoin);
    	magicItem.setCreativeTab(DerpTab.tabDerpCoin);
    	magicClock.setCreativeTab(DerpTab.tabDerpCoin);
    	magicDownfall.setCreativeTab(DerpTab.tabDerpCoin);
    	derpSack.setCreativeTab(DerpTab.tabDerpCoin);
    	magicHealer.setCreativeTab(DerpTab.tabDerpCoin);
    	magicFood.setCreativeTab(DerpTab.tabDerpCoin);
    	magicPickaxe.setCreativeTab(DerpTab.tabDerpCoin);
    	magicSword.setCreativeTab(DerpTab.tabDerpCoin);
    	magicHelmet.setCreativeTab(DerpTab.tabDerpCoin);
    	magicChestplate.setCreativeTab(DerpTab.tabDerpCoin);
    	magicLeggings.setCreativeTab(DerpTab.tabDerpCoin);
    	magicBoots.setCreativeTab(DerpTab.tabDerpCoin);
    	//derpBackpack.setCreativeTab(derpTab.tabDerpCoin);
    }
}
