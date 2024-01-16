package com.isextraordinary.genocraft.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SyringeItem extends Item {
    private ItemStack inventorySlot = ItemStack.EMPTY;

    public void SetInventorySlot(ItemStack itemStack) {
        this.inventorySlot = itemStack;
    }

    public ItemStack GetInventorySlot(ItemStack itemStack) {
        return this.inventorySlot;
    }

    public SyringeItem(Properties pProperties) {
        super(pProperties);
    }

    String SyringeMode = "Inject";

    @NotNull
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        if(!pLevel.isClientSide()) {
            if (pPlayer.isCrouching()) {
                ToggleSyringeMode();
                pPlayer.sendSystemMessage(Component.literal("Set Mode To: " + SyringeMode));
            }
        }
        return super.use(pLevel, pPlayer, pHand);
    }

    @NotNull
    @Override
    public InteractionResult interactLivingEntity(ItemStack pItem, Player pPlayer, LivingEntity pEntity, InteractionHand pHand) {
        if(!pPlayer.level().isClientSide()) {
            switch (SyringeMode)
            {
                case "Inject":
                    pPlayer.sendSystemMessage(Component.literal("Injected " + pEntity.getName().getString()));
                    break;
                case "Extract":
                    pPlayer.sendSystemMessage(Component.literal("Extracted " + pEntity.getName().getString() + "'s DNA"));
            }
        }

        return super.interactLivingEntity(pItem, pPlayer, pEntity, pHand);
    }

    private String ToggleSyringeMode() {
        if(SyringeMode.equals("Extract")) {
            SyringeMode = "Inject";
        } else if(SyringeMode.equals("Inject")) {
            SyringeMode = "Extract";
        }
        return SyringeMode;
    }

}

