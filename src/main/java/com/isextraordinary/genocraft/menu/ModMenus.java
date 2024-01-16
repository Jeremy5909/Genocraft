package com.isextraordinary.genocraft.menu;

import com.isextraordinary.genocraft.Genocraft;
import com.isextraordinary.genocraft.block.GeneSequencerBlock;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Genocraft.MODID);

    public static final RegistryObject<MenuType<GeneSequencerMenu>> GENE_SEQUENCER_MENU =
            MENU_TYPES.register("gene_sequencer_menu",
                    () -> IForgeMenuType.create(GeneSequencerMenu::new));

    public static void register(IEventBus eventBus) { MENU_TYPES.register(eventBus); }
}
