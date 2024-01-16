package com.isextraordinary.genocraft.client.screen;

import com.isextraordinary.genocraft.Genocraft;
import com.isextraordinary.genocraft.block.entity.GeneSequencerBlockEntity;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public class GeneSequencerScreen extends Screen {
    private static final Component TITLE =
            Component.translatable("gui." + Genocraft.MODID + ".gene_sequencer_screen");
    private static final Component COOL_BUTON =
            Component.translatable("gui."+Genocraft.MODID+".gene_sequencer_screen.button.cool_button");

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Genocraft.MODID, "textues/gui/gene_sequencer_screen.png");

    private final BlockPos position;
    private final int imageWidth, imageHeight;

    private Button button;

    private GeneSequencerBlockEntity blockEntity;
    private int leftPos, topPos;


    public GeneSequencerScreen(BlockPos position) {
        super(TITLE);

        this.position = position;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void init() {
        super.init();

        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;

        if(this.minecraft == null) return;
        Level level = this.minecraft.level;
        if(level == null) return;

        BlockEntity be = level.getBlockEntity(this.position);
        if(be instanceof GeneSequencerBlockEntity blockEntity) {
            this.blockEntity = blockEntity;
        } else {
            System.err.printf("BlockEntity at %s is not of type GeneSequencerBlockEntity!\n", this.position);
            return;
        }

        this.button = addRenderableWidget(
                Button.builder(COOL_BUTON, this::HandleCoolButton)
                        .bounds(this.leftPos + 8, this.topPos + 20, 20, 20)
                        .build());
    }

    @Override
    public void render(GuiGraphics graphics, int pMouseX, int pMouseY, float pPartialTick) {

        // Make behind screen dark
        renderBackground(graphics, pMouseX, pMouseY, pPartialTick);


        graphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        super.render(graphics, pMouseX, pMouseY, pPartialTick);

        graphics.drawString(
                this.font,
                TITLE,
                this.leftPos+8,
                this.topPos+8,
                0x404040,
                false);

        graphics.drawString(this.font,
                "O hio!",
                this.leftPos+40,
                this.topPos+20,
                0xFF0000,
                false);
    }

    private void HandleCoolButton(Button button) {

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
