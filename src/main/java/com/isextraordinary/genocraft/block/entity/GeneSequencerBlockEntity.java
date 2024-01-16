package com.isextraordinary.genocraft.block.entity;

import com.isextraordinary.genocraft.Genocraft;
import com.isextraordinary.genocraft.menu.GeneSequencerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GeneSequencerBlockEntity extends BlockEntity implements MenuProvider {
    private static final Component TITLE =
            Component.translatable("container."+Genocraft.MODID+".gene_sequencer_block");
    private ItemStackHandler inventory = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            GeneSequencerBlockEntity.this.setChanged();
        }
    };

    public LazyOptional<ItemStackHandler> getOptional() {

    }

    public GeneSequencerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GENE_SEQUENCER_BLOCK.get(), pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);

        CompoundTag syringe = new CompoundTag();
        syringe.putInt("Syringe", 123);
        nbt.put(Genocraft.MODID, syringe);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);

        CompoundTag syringe = nbt.getCompound(Genocraft.MODID);
    }

    public void tick() {

    }

    @Override
    @NotNull
    public CompoundTag getUpdateTag() {
        CompoundTag nbt = super.getUpdateTag();
        saveAdditional(nbt);
        return(nbt);
    }

    @Override
    public Component getDisplayName() {
        return TITLE;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new GeneSequencerMenu(i, inventory, this);
    }
}
