package com.isextraordinary.genocraft.item;

import com.isextraordinary.genocraft.Genocraft;
import com.isextraordinary.genocraft.block.ModBlocks;
import com.isextraordinary.genocraft.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Genocraft.MODID);

    public static final RegistryObject<CreativeModeTab> GENOCRAFT_TAB = CREATIVE_MODE_TABS.register("genocraft_tab",
            () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.DNA_SAMPLE_ITEM.get()))
            .title(Component.translatable("creativetab.genocraft_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.DNA_SAMPLE_ITEM.get());
                pOutput.accept(ModItems.SYRINGE_ITEM.get());
                pOutput.accept(ModBlocks.GENE_SEQUENCER_BLOCK.get());
            })
            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
