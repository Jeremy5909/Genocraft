package com.isextraordinary.genocraft.block.entity;

import com.isextraordinary.genocraft.Genocraft;
import com.isextraordinary.genocraft.block.ModBlocks;
import com.isextraordinary.genocraft.block.entity.GeneSequencerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Genocraft.MODID);

    public static final RegistryObject<BlockEntityType<GeneSequencerBlockEntity>> GENE_SEQUENCER_BLOCK = BLOCK_ENTITIES.register("gene_sequencer",
            () -> BlockEntityType.Builder.of(GeneSequencerBlockEntity::new, ModBlocks.GENE_SEQUENCER_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
