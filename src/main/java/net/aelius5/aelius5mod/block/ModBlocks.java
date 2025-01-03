package net.aelius5.aelius5mod.block;

import net.aelius5.aelius5mod.Aelius5Mod;
import net.aelius5.aelius5mod.block.custom.EngravingTableBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block PAPER_BLOCK = registerBlock("paper_block",
            new Block(AbstractBlock.Settings.create().strength(.2f)
                    .sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ENGRAVING_TABLE = registerBlock("engraving_table",
            new EngravingTableBlock(AbstractBlock.Settings.create().strength(1f)
                    .sounds(BlockSoundGroup.STONE).requiresTool().nonOpaque()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Aelius5Mod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Aelius5Mod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        Aelius5Mod.LOGGER.info("Registering mod blocks for" + Aelius5Mod.MOD_ID);

    }
}
