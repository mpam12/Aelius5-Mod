package net.aelius5.aelius5mod.item;

import net.aelius5.aelius5mod.Aelius5Mod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item OBSIDIAN_TABLET_BLANK = registerItem("obsidian_tablet_blank", new Item(new Item.Settings()));
    public static final Item EMBLAZONED_OBSIDIAN_TABLET = registerItem("obsidian_tablet_emblazoned", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Aelius5Mod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Aelius5Mod.LOGGER.info("Registering Mod Items for " + Aelius5Mod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(OBSIDIAN_TABLET_BLANK);
            entries.add(EMBLAZONED_OBSIDIAN_TABLET);
        });
    }
}
