package net.asadfgglie.tutorial.examplemod.Item;

import net.asadfgglie.tutorial.examplemod.ExampleMod;
import net.asadfgglie.tutorial.examplemod.Item.Group.MyItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MyItem {
    public static DeferredRegister<Item> ITEM =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.ID);

    public static RegistryObject<Item> haha =
            ITEM.register("haha", () -> new Item(new Item.Properties().group(MyItemGroup.group)));

    public static RegistryObject<Item> gg =
            ITEM.register("gg", () -> new Item(new Item.Properties().group(MyItemGroup.group)));

    public static RegistryObject<Item> gura =
            ITEM.register("gura", () -> new GuraItem(new GuraItem.GuraItemProperties()
                    .group(MyItemGroup.group)
                    .rarity(Rarity.EPIC)
                    .maxStackSize(1)
                    .isImmuneToFire()
            ));

    public static void register(IEventBus eventBus) {
        ITEM.register(eventBus);
    }
}
