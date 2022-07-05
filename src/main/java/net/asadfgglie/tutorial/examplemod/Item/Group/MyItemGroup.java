package net.asadfgglie.tutorial.examplemod.Item.Group;

import net.asadfgglie.tutorial.examplemod.Item.MyItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MyItemGroup {
    public static ItemGroup group = new ItemGroup("group") {
        @Override
        public ItemStack createIcon () {
            return new ItemStack(MyItem.haha.get());
        }
    };
}
