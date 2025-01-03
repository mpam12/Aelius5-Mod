package net.aelius5.aelius5mod.item;

import net.aelius5.aelius5mod.Aelius5Mod;
import net.aelius5.aelius5mod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup AELIUS5MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Aelius5Mod.MOD_ID, "aelius5mod"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.aelius5mod"))
                    .icon(() -> new ItemStack(ModItems.OBSIDIAN_TABLET_BLANK)).entries((displayContext, entries) -> {
                        entries.add(ModItems.EMBLAZONED_OBSIDIAN_TABLET);
                        entries.add(ModItems.OBSIDIAN_TABLET_BLANK);
                        entries.add(ModBlocks.PAPER_BLOCK);
                        entries.add(ModBlocks.ENGRAVING_TABLE);
                    }).build());
    public static void registerItemGroups() {
        Aelius5Mod.LOGGER.info("Registering Item Groups for " + Aelius5Mod.MOD_ID);
    }
}
