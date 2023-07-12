package io.github.andrew6rant.sandyglass;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TintedGlassBlock;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SandyGlass implements ModInitializer {
	public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier("sandyglass", "test_group"));

	public static void registerBlock(String blockName, Block block) {
		Registry.register(Registries.BLOCK, new Identifier("sandyglass", blockName), block);
		Registry.register(Registries.ITEM, new Identifier("sandyglass", blockName), new BlockItem(block, new FabricItemSettings()));
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

		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
				       .icon(() -> new ItemStack(SANDY_FULGURITE))
				       .displayName(Text.translatable("sandyglass.test_group"))
				       .build());

		//Registry.register(Registries.ITEM_GROUP, new Identifier("sandyglass", "test_group"), ITEM_GROUP);

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
			content.add(SANDY_FULGURITE);
			content.add(RED_SANDY_FULGURITE);
			content.add(SANDY_GLASS);
			content.add(RED_SANDY_GLASS);
		});
	}
}