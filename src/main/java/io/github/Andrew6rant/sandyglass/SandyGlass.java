package io.github.Andrew6rant.sandyglass;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TintedGlassBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SandyGlass implements ModInitializer {
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier("sandyglass", "general"),
			() -> new ItemStack(SandyGlass.SANDY_FULGURITE));

	public static void registerItem(String itemName, Item item) {
		Registry.register(Registry.ITEM, new Identifier("workings", itemName), item);
	}
	public static void registerBlock(String blockName, Block block) {
		Registry.register(Registry.BLOCK, new Identifier("sandyglass", blockName), block);
		Registry.register(Registry.ITEM, new Identifier("sandyglass", blockName), new BlockItem(block, new FabricItemSettings().group(SandyGlass.ITEM_GROUP)));
	}

	public static final Block SANDY_FULGURITE = new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE));
	public static final Block RED_SANDY_FULGURITE = new Block(FabricBlockSettings.copyOf(Blocks.RED_SANDSTONE));
	public static final TintedGlassBlock SANDY_GLASS = new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.TINTED_GLASS));
	public static final TintedGlassBlock RED_SANDY_GLASS = new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.TINTED_GLASS));

	@Override
	public void onInitialize() {
		registerBlock(Names.SANDY_FULGURITE, SANDY_FULGURITE);
		registerBlock(Names.RED_SANDY_FULGURITE, RED_SANDY_FULGURITE);
		registerBlock(Names.SANDY_GLASS, SANDY_GLASS);
		registerBlock(Names.RED_SANDY_GLASS, RED_SANDY_GLASS);
	}
}