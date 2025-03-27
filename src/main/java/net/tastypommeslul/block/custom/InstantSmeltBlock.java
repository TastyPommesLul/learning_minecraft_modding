package net.tastypommeslul.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tastypommeslul.item.ModItems;
import net.tastypommeslul.util.ModTags;

import java.util.List;

public class InstantSmeltBlock extends Block {
    public InstantSmeltBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack heldItem = player.getMainHandStack();
        final TextColor BLUE = TextColor.fromFormatting(Formatting.BLUE);
        final TextColor RED = TextColor.fromFormatting(Formatting.RED);

        if (!isValidItem(heldItem)) {
            if (heldItem.isEmpty()) {
                player.sendMessage(Text.literal("You cannot smelt your Hand xd").styled(style -> style.withColor(RED).withBold(true).withItalic(true)), true);
                world.playSound(player, pos, SoundEvents.ENTITY_TURTLE_EGG_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
            } else {
                world.playSound(player, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            return ActionResult.SUCCESS;
        }

        // Find a slot with BLUE_GEM that is less than 64
        int blueGemSlot = -1;
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (stack.isOf(ModItems.BLUE_GEM) && stack.getCount() < stack.getMaxCount()) {
                blueGemSlot = i;
                break;
            }
        }

        // If no BLUE_GEM slot found, find an empty slot
        if (blueGemSlot == -1) {
            for (int i = 0; i < player.getInventory().size(); i++) {
                if (player.getInventory().getStack(i).isEmpty()) {
                    blueGemSlot = i;
                    break;
                }
            }
        }

        // If no BLUE_GEM or empty slot found, do nothing (or handle it differently)
        if (blueGemSlot == -1) {
            player.sendMessage(Text.literal("No space for Blue Gem!").styled(style -> style.withColor(RED).withBold(true).withItalic(true)), true);
            world.playSound(player, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        }

        // Perform the smelting
        ItemStack targetStack = player.getInventory().getStack(blueGemSlot);
        if (targetStack.isEmpty()) {
            player.getInventory().setStack(blueGemSlot, new ItemStack(ModItems.BLUE_GEM, 1));
        } else {
            targetStack.increment(1);
        }
        heldItem.decrement(1);

        player.sendMessage(Text.literal("You smelted 1 raw blue gem into 1 blue gem").styled(style -> style.withColor(BLUE).withBold(true).withItalic(true)), true);
        world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_ANVIL_USE, SoundCategory.BLOCKS, 1.0F, 1.0F, 1L);

        return ActionResult.SUCCESS;
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.yoltronzmod4j.instant_smelt_block"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}