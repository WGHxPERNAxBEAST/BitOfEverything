package cjminecraft.bitofeverything.init;

import cjminecraft.bitofeverything.BitOfEverything;
import cjminecraft.bitofeverything.Reference;
import cjminecraft.bitofeverything.handlers.EnumHandler;
import cjminecraft.bitofeverything.items.ItemChip;
import cjminecraft.bitofeverything.items.ItemHeart;
import cjminecraft.bitofeverything.items.ItemModFood;
import cjminecraft.bitofeverything.items.ItemTinIngot;
import cjminecraft.bitofeverything.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Handles the item registration and render
 * @author CJMinecraft
 *
 */
public class ModItems {
	
	/**
	 * State the items
	 */
	public static Item tinIngot;
	public static Item heart;
	public static Item chip;
	public static Item tinApple;
	public static Item niceBiscuit;
	public static Item infinityFlame;
	
	/**
	 * Initialize the items
	 */
	public static void init() {
		tinIngot = new ItemTinIngot("tin_ingot", "tin_ingot");
		heart = new ItemHeart("heart");
		chip = new ItemChip("chip");
		tinApple = new ItemModFood("tin_apple", 4, 4, false, new PotionEffect(Potion.getPotionById(3), 3600, 2), new PotionEffect(Potion.getPotionById(8), 3600, 256, false, false));
		niceBiscuit = new ItemModFood("nice_biscuit", 2, 2, false);
		infinityFlame = new Item().setUnlocalizedName("infinity_flame").setRegistryName(new ResourceLocation(Reference.MODID, "infinity_flame"));
	}
	
	/**
	 * Register the items
	 */
	public static void register() {
		registerItem(tinIngot);
		registerItem(heart);
		registerItem(chip);
		registerItem(tinApple);
		registerItem(niceBiscuit);
		registerItem(infinityFlame);
	}
	
	/**
	 * Register the items renders
	 */
	public static void registerRenders() {
		registerRender(tinIngot);
		registerRender(heart);
		registerRender(tinApple);
		registerRender(niceBiscuit);
		registerRender(infinityFlame);
		for(int i = 0; i < EnumHandler.ChipTypes.values().length; i++) {
			registerRender(chip, i, "chip_" + EnumHandler.ChipTypes.values()[i].getName());
		}
	}
	
	/**
	 * Register an item
	 * @param item The item
	 */
	public static void registerItem(Item item) {
		item.setCreativeTab(BitOfEverything.items); //Sets the creative tab
		GameRegistry.register(item);
		Utils.getLogger().info("Registered item: " + item.getUnlocalizedName().substring(5));
	}
	
	/**
	 * Registers the item render MUST BE CALLED IN THE PRE INIT METHOD IN YOUR MAIN CLASS
	 * @param item The item
	 */
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Register render for " + item.getUnlocalizedName().substring(5));
	}
	
	/**
	 * Registers the item render for an item which has meta data
	 * @param item The item
	 * @param meta The meta data
	 * @param fileName The file name
	 */
	public static void registerRender(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, fileName), "inventory"));
		Utils.getLogger().info("Register render for " + item.getUnlocalizedName().substring(5));
	}

}
