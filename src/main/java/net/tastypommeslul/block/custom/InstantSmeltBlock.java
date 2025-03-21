package net.tastypommeslul.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
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

public class InstantSmeltBlock extends Block {
    private final int emptySlot = 8;
    public InstantSmeltBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        final TextColor BLUE = TextColor.fromFormatting(Formatting.BLUE);
        final TextColor RED = TextColor.fromFormatting(Formatting.RED);
        if (player.getMainHandStack().getItem() == ModItems.RAW_BLUE_GEM) {
            player.getInventory().setStack(player.getInventory().getSlotWithStack(new ItemStack(ModItems.BLUE_GEM)) == -1 ? emptySlot : player.getInventory().getSlotWithStack(new ItemStack(ModItems.BLUE_GEM)),
                    new ItemStack(ModItems.BLUE_GEM, player.getInventory().getSlotWithStack(new ItemStack(ModItems.BLUE_GEM)) == -1 ?
                            1 : player.getInventory().getStack(player.getInventory().getSlotWithStack(new ItemStack(ModItems.BLUE_GEM))).getCount() + 1));
            player.getMainHandStack().setCount(player.getMainHandStack().getCount() - 1);
            player.sendMessage(Text.literal("You smelted 1 raw blue gem into 1 blue gem").styled(style -> style.withColor(BLUE).withBold(true).withItalic(true)), true);

            world.playSound(player, pos, SoundEvents.BLOCK_VAULT_ACTIVATE, SoundCategory.BLOCKS, 1.0F, 1.0F);
        } else if (player.getMainHandStack().isEmpty()) {
            player.sendMessage(Text.literal("You cannot smelt your Hand xd").styled(style -> style.withColor(RED).withBold(true).withItalic(true)), true);
            world.playSound(player, pos, SoundEvents.ENTITY_TURTLE_EGG_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
        } else {
            world.playSound(player, pos, SoundEvents.BLOCK_VAULT_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
        return ActionResult.SUCCESS;
    }

//    @Override
//    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
//        PlayerEntity player = world.getClosestPlayer(entity, 1.0D);
//
//        if (entity instanceof ItemEntity itemEntity) {
//            if (itemEntity.getStack().getItem() == ModItems.RAW_BLUE_GEM) {
//                itemEntity.setStack(new ItemStack(ModItems.BLUE_GEM, itemEntity.getStack().getCount()));
//                world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1.0F, 1.0F);
//            }
//        }
//        super.onSteppedOn(world, pos, state, entity);
//    }
}
