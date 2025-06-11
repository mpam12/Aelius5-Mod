package net.aelius5.aelius5mod.block.entity.custom;

import net.aelius5.aelius5mod.Aelius5Mod;
import net.aelius5.aelius5mod.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<EngravingTableBlockEntity> ENGRAVING_TABLE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Aelius5Mod.MOD_ID, "engraving_table_e")
            , BlockEntityType.Builder.create(EngravingTableBlockEntity::new, ModBlocks.ENGRAVING_TABLE).build(null));

    public static void registerBlockEntities() {
        Aelius5Mod.LOGGER.info("Registering Block Entities for" + Aelius5Mod.MOD_ID);
    }

}
