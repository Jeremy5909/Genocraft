package com.isextraordinary.genocraft.item;

import com.isextraordinary.genocraft.Genocraft;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Genocraft.MODID);

    public static final RegistryObject<Item> DNA_SAMPLE_ITEM = ITEMS.register("dna_sample",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> SYRINGE_ITEM = ITEMS.register("syringe",
            () -> new SyringeItem(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
