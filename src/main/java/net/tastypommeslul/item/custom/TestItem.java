package net.tastypommeslul.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class TestItem extends Item {
    private static final Map<Block, Block> BLOCK_MAP = Map.of(
            // Stone => Stone Bricks
            Blocks.STONE, Blocks.STONE_BRICKS,
            // End Stone => End Stone Bricks
            Blocks.END_STONE, Blocks.END_STONE_BRICKS,
            // Deepslate => Deepslate Bricks
            Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
            // Gold Block => Netherite Block
            Blocks.GOLD_BLOCK, Blocks.NETHERITE_BLOCK
    );

    public TestItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        // get world and clicked block from the usage Context
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        // check if the block is in the map (BLOCK_MAP) (Gold Block, Stone, End Stone, Deepslate)
        if (BLOCK_MAP.containsKey(clickedBlock)) {
            // check if the environment the player is on is a server
            if (!world.isClient) {
                // set the block to the new block (Stone => Stone Bricks, etc.)
                world.setBlockState(context.getBlockPos(), BLOCK_MAP.get(clickedBlock).getDefaultState());

                // damage the item (decrease durability)
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                // play a sound after (successfull) use
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
            }
        }
        // success ((borat) very nice)
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.yoltronzmod4j.test_item.shift"));
        } else {
            tooltip.add(Text.translatable("tooltip.yoltronzmod4j.test_item"));
        }


        super.appendTooltip(stack, context, tooltip, type);
    }
}
