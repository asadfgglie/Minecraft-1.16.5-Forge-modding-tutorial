package net.asadfgglie.tutorial.examplemod.Block.TileEntity;

import net.asadfgglie.tutorial.examplemod.Block.MyBlock;
import net.asadfgglie.tutorial.examplemod.ExampleMod;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MyTileEntity {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ExampleMod.ID);

    public static final RegistryObject<TileEntityType<HahaBlockTileEntity>> hahaBlockTileEntity = TILE_ENTITIES.register("haha_block_tile_entity", () ->
        TileEntityType.Builder.create(() -> new HahaBlockTileEntity(), MyBlock.haha_block.get())
                .build(null) // datafixer: 用來讀取低版本資料的格式轉換器實例，null表示不需要
    );

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
