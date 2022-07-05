package net.asadfgglie.tutorial.examplemod.Item;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class GuraItem extends Item {

    public GuraItem (Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick (World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemStack = (playerIn.getHeldItem(Hand.MAIN_HAND).getItem() == MyItem.gura.get()) ? playerIn.getHeldItem(Hand.MAIN_HAND) : playerIn.getHeldItem(Hand.OFF_HAND);
        if(worldIn.isRemote() && handIn == Hand.MAIN_HAND){
            int count = itemStack.getOrCreateTag().getInt("times") + 1;
            itemStack.getOrCreateTag().putInt("times", count);

            String tmp = "";
            for(int i = 0; i < count; i++){
                tmp += " SO";
            }
            playerIn.sendStatusMessage(new TranslationTextComponent("message.tutorial.gura_text", tmp), false);

            return ActionResult.resultSuccess(itemStack);
        }
        return ActionResult.resultPass(itemStack);
    }

    @Override
    public void addInformation (ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(Screen.hasShiftDown())
            tooltip.add(new TranslationTextComponent("tooltip.tuitionmod.gura_shift"));
        else
            tooltip.add(new TranslationTextComponent("tooltip.tuitionmod.gura"));
    }

    public static class GuraItemProperties extends Item.Properties{
        private int times = 0;
        public GuraItemProperties setTimes (int i){
            times = i;
            return this;
        }
    }
}
