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
    public static MagicClock magicClock;
    public static Item derpIngot;
    public static MagicToggledownfall magicDownfall;
    public static ArmorMaterial derpArmor = EnumHelper.addArmorMaterial("derpArmor", "derpcoin:derpArmor", 20, new int[]{3, 7, 6, 3} , 25);
    public static DerpArmor derpHelmet;
    public static DerpArmor derpChestplate;
    public static DerpArmor derpLeggings;
    public static DerpArmor derpBoots;
    public static ToolMaterial derpMaterial = EnumHelper.addToolMaterial("derpMaterial", 3, 600, 7.0F, 2.5F, 22);
    public static ItemSword derpSword;
    public static DerpPickaxe derpPickaxe;
    public static MagicItem magicItem;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    	derpSword = new ItemSword(derpMaterial);
    	GameRegistry.registerItem(derpSword, "derpSword");
    	
    	derpSword.setUnlocalizedName("derpSword");
    	
    	derpPickaxe = new DerpPickaxe(derpMaterial);

    	
		magicItem = new MagicItem();
		GameRegistry.registerItem(magicItem, "magicItem");
		magicItem.setUnlocalizedName("magicItem");
		magicItem.setMaxStackSize(1);
		
		
		magicDownfall = new MagicToggledownfall();
		GameRegistry.registerItem(magicDownfall, "MagicDownfall");
		
		
		GameRegistry.registerItem(derpHelmet = new DerpArmor("derpHelmet", derpArmor, 1, 0), "derp_helmet"); //0 for helmet
		
		GameRegistry.registerItem(derpChestplate = new DerpArmor("derpChestplate", derpArmor, 1, 1), "derp_chestplate"); // 1 for chestplate
		
		GameRegistry.registerItem(derpLeggings = new DerpArmor("derpLeggings", derpArmor, 2, 2), "derp_leggings"); // 2 for leggings
		
		GameRegistry.registerItem(derpBoots = new DerpArmor("derpBoots", derpArmor, 1, 3), "derp_boots");
		
		
		magicClock = new MagicClock();
    	
		derpCoin = new DerpCoin();
		
		derpIngot = new GenericItem();
		derpIngot.setUnlocalizedName("derpIngot");
		GameRegistry.registerItem(derpIngot, "derpIngot");
		
		derpCoinBlock = new GenericBlock(Material.iron);
		derpCoinBlock.setHardness(1.0f);
		derpCoinBlock.setUnlocalizedName("derpCoinBlock");
		derpCoinBlock.setStepSound(Block.soundTypeMetal);
		GameRegistry.registerBlock(derpCoinBlock, "derpCoinBlock");
		
		ItemStack derpCoinStack = new ItemStack(derpCoin);
		ItemStack diamondStack = new ItemStack(Items.diamond);
		GameRegistry.addRecipe(new ItemStack(magicItem)," X ", "XYX", " X ", 'X', derpCoinStack, 'Y', diamondStack);
		GameRegistry.addRecipe(new ItemStack(derpCoinBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(derpIngot));
		GameRegistry.addRecipe(new ItemStack(derpIngot), "XXX", "XXX", "XXX", 'X', new ItemStack(derpCoin));
		GameRegistry.addRecipe(new ItemStack(magicClock), " X ", "XYX", " X ", 'X', new ItemStack(magicItem), 'Y', new ItemStack(Items.clock));
		GameRegistry.addShapelessRecipe(new ItemStack(derpIngot, 9), new ItemStack(derpCoinBlock, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(derpCoin, 9), new ItemStack(derpIngot, 1));
		GameRegistry.addSmelting(Items.gold_nugget, new ItemStack(derpCoin), 0.2f);
		RenderingRegistry.registerEntityRenderingHandler(DerpCoinProjectile.class, new RenderSnowball(null, derpCoin, null));
		System.out.println("Everything loaded...");
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	ModelBakery.addVariantName(magicClock, "derpcoin:magicClockBackward", "derpcoin:magicClockForward");
    	ModelBakery.addVariantName(magicDownfall, "derpcoin:magicDownfallFull", "derpcoin:magicDownfallEmpty");
    	
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
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(derpCoinBlock), 0, new ModelResourceLocation("derpcoin:" + "derpCoinBlock", "inventory"));
    	}
    }
    
    public void setupDerpTab()
    {
    	derpCoin.setCreativeTab(derpTab.tabDerpCoin);
    	derpIngot.setCreativeTab(derpTab.tabDerpCoin);
    	derpCoinBlock.setCreativeTab(derpTab.tabDerpCoin);
    	derpSword.setCreativeTab(derpTab.tabDerpCoin);
    	derpPickaxe.setCreativeTab(derpTab.tabDerpCoin);
    	derpHelmet.setCreativeTab(derpTab.tabDerpCoin);
    	derpChestplate.setCreativeTab(derpTab.tabDerpCoin);
    	derpLeggings.setCreativeTab(derpTab.tabDerpCoin);
    	derpBoots.setCreativeTab(derpTab.tabDerpCoin);
    	magicItem.setCreativeTab(derpTab.tabDerpCoin);
    	magicClock.setCreativeTab(derpTab.tabDerpCoin);
    	magicDownfall.setCreativeTab(derpTab.tabDerpCoin);
    }
}
