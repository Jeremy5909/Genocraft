package com.isextraordinary.genocraft.client;

import com.isextraordinary.genocraft.client.screen.GeneSequencerScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;

public class ClientHooks {
    public static void OpenGeneSequencerScreen(BlockPos pos) {
        Minecraft.getInstance().setScreen(new GeneSequencerScreen(pos));
    }
}
