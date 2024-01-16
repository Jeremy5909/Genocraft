package com.isextraordinary.genocraft.menu;

import com.isextraordinary.genocraft.block.ModBlocks;
import com.isextraordinary.genocraft.block.entity.GeneSequencerBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class GeneSequencerMenu extends AbstractContainerMenu {
    private final GeneSequencerBlockEntity blockEntity;
    private final ContainerLevelAccess levelAccess;

    // Client Constructor
    public GeneSequencerMenu(int containerId, Inventory playerInv, FriendlyByteBuf additionalData) {
        this(containerId, playerInv, playerInv.player.level().getBlockEntity(additionalData.readBlockPos()));
    }

    // Server Constructor
    public GeneSequencerMenu(int containerId, Inventory playerInv, BlockEntity blockEntity) {
        super(ModMenus.GENE_SEQUENCER_MENU.get(), containerId);

        if(blockEntity instanceof GeneSequencerBlockEntity be) {
            this.blockEntity = be;
        } else {
            throw new IllegalStateException("Incorrect Block Entity Class (%s) passed into gene sequencer menu".formatted(blockEntity.getClass().getCanonicalName()));
        }

        this.levelAccess = ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos());

        createPlayerHotbar(playerInv);
        createPlayerInventory(playerInv);
        createBlockEntityInventory(be);
    }

    private void createBlockEntityInventory(GeneSequencerBlockEntity be) {
        be.getOop
    }

    private void createPlayerInventory(Inventory playerInv) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInv, 9 + column + (row * 9), 8 + (column * 18), 84 + (row * 18)));
            }
        }
    }

    private void createPlayerHotbar(Inventory playerInv) {
        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(playerInv, column, 8 + (column * 18), 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.levelAccess, player, ModBlocks.GENE_SEQUENCER_BLOCK.get());
    }

    public GeneSequencerBlockEntity getBlockEntity() {
        return this.blockEntity;
    }
}
