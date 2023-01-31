
package net.mcreator.howsex.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.howsex.world.inventory.QuestionMenu;
import net.mcreator.howsex.network.QuestionButtonMessage;
import net.mcreator.howsex.HowsexMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class QuestionScreen extends AbstractContainerScreen<QuestionMenu> {
	private final static HashMap<String, Object> guistate = QuestionMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox anwser;

	public QuestionScreen(QuestionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("howsex:textures/screens/question.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
//		if (key == 256) {
//			this.minecraft.player.closeContainer();
//			return true;
//		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Google Forms", 53, 18, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		anwser = new Checkbox(this.leftPos + 24, this.topPos + 55, 20, 20, Component.literal("Czy nie jesteś żydem?"), false);
		guistate.put("checkbox:anwser", anwser);
		this.addRenderableWidget(anwser);
		this.addRenderableWidget(new Button(this.leftPos + 51, this.topPos + 103, 67, 20, Component.literal("Prześlij"), e -> {
			if (true) {
				HowsexMod.PACKET_HANDLER.sendToServer(new QuestionButtonMessage(0, x, y, z));
				QuestionButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
