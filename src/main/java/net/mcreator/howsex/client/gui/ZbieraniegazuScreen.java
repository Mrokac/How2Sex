
package net.mcreator.howsex.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.howsex.world.inventory.ZbieraniegazuMenu;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ZbieraniegazuScreen extends AbstractContainerScreen<ZbieraniegazuMenu> {
	private final static HashMap<String, Object> guistate = ZbieraniegazuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ZbieraniegazuScreen(ZbieraniegazuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("howsex:textures/screens/zbieraniegazu.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("howsex:textures/screens/aaaa.png"));
		this.blit(ms, this.leftPos + 72, this.topPos + -19, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("howsex:textures/screens/aaaaaa.png"));
		this.blit(ms, this.leftPos + 72, this.topPos + 28, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("howsex:textures/screens/aaaaaa.png"));
		this.blit(ms, this.leftPos + 72, this.topPos + 12, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("howsex:textures/screens/aaaaaaaaaaaaa.png"));
		this.blit(ms, this.leftPos + 42, this.topPos + 45, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("howsex:textures/screens/aaaaaaaaaaaaa.png"));
		this.blit(ms, this.leftPos + 56, this.topPos + 45, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("howsex:textures/screens/aaaaaaaaaaaaa.png"));
		this.blit(ms, this.leftPos + 81, this.topPos + 4, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("howsex:textures/screens/aaaaaaaaaaaaa.png"));
		this.blit(ms, this.leftPos + 89, this.topPos + 27, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("howsex:textures/screens/aaaaaaaaaaaaa.png"));
		this.blit(ms, this.leftPos + 81, this.topPos + 27, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("howsex:textures/screens/aaaaaa.png"));
		this.blit(ms, this.leftPos + 72, this.topPos + -3, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("howsex:textures/screens/aaaaaaaaaaaaa.png"));
		this.blit(ms, this.leftPos + 95, this.topPos + 4, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Insert Fuel", 5, 30, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 105, this.topPos + 5, 46, 20, Component.literal("Azot"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 105, this.topPos + 24, 46, 20, Component.literal("Tlen"), e -> {
		}));
	}
}
