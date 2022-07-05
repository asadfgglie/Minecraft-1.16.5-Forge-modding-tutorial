package net.asadfgglie.tutorial.examplemod.Block;

import net.asadfgglie.tutorial.examplemod.ExampleMod;
import net.asadfgglie.tutorial.examplemod.Item.MyItem;
import net.asadfgglie.tutorial.examplemod.Item.Group.MyItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class MyBlock {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.ID);

    public static final RegistryObject<Block> gura_block = registerBlock("gura_block", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .hardnessAndResistance(6f)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
            ));

    public static final RegistryObject<Block> haha_block = registerBlock("haha_block", () ->
            new HahaBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .hardnessAndResistance(6f)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
            ));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        // register block to eventBus
        RegistryObject<T> tmp = BLOCKS.register(name, block);

        // register blockItem to eventBus
        MyItem.ITEM.register(name, () -> new BlockItem(tmp.get(), new Item.Properties().group(MyItemGroup.group)));

        return tmp;
    }
    // Register Block instance
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
