package net.mcreator.howsex.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelballisticMissile<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("howsex", "modelballistic_missile"), "main");
	public final ModelPart missle;

	public ModelballisticMissile(ModelPart root) {
		this.missle = root.getChild("missle");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition missle = partdefinition.addOrReplaceChild("missle", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition hexadecagon = missle.addOrReplaceChild("hexadecagon",
				CubeListBuilder.create().texOffs(0, 76).addBox(-0.5F, -0.5967F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(24, 152)
						.addBox(-0.5F, -3.0F, -0.5967F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -144.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition hexadecagon_r1 = hexadecagon.addOrReplaceChild("hexadecagon_r1",
				CubeListBuilder.create().texOffs(20, 152).addBox(-0.5F, -3.0F, -0.5967F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 64)
						.addBox(-0.5F, -0.5967F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r2 = hexadecagon.addOrReplaceChild("hexadecagon_r2",
				CubeListBuilder.create().texOffs(28, 152).addBox(-0.5F, -3.0F, -0.5967F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 83)
						.addBox(-0.5F, -0.5967F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r3 = hexadecagon.addOrReplaceChild("hexadecagon_r3",
				CubeListBuilder.create().texOffs(0, 57).addBox(-0.5F, -0.5967F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r4 = hexadecagon.addOrReplaceChild("hexadecagon_r4",
				CubeListBuilder.create().texOffs(0, 152).addBox(-0.5F, -0.5967F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon2 = missle.addOrReplaceChild("hexadecagon2",
				CubeListBuilder.create().texOffs(88, 152).addBox(-0.5F, -1.1935F, -6.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(10, 19)
						.addBox(-0.5F, -6.0F, -1.1935F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -143.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition hexadecagon_r5 = hexadecagon2.addOrReplaceChild("hexadecagon_r5",
				CubeListBuilder.create().texOffs(10, 0).addBox(-0.5F, -6.0F, -1.1935F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(54, 152)
						.addBox(-0.5F, -1.1935F, -6.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r6 = hexadecagon2.addOrReplaceChild("hexadecagon_r6",
				CubeListBuilder.create().texOffs(10, 38).addBox(-0.5F, -6.0F, -1.1935F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
						.texOffs(122, 152).addBox(-0.5F, -1.1935F, -6.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r7 = hexadecagon2.addOrReplaceChild("hexadecagon_r7",
				CubeListBuilder.create().texOffs(20, 152).addBox(-0.5F, -1.1935F, -6.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r8 = hexadecagon2.addOrReplaceChild("hexadecagon_r8",
				CubeListBuilder.create().texOffs(156, 152).addBox(-0.5F, -1.1935F, -6.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon3 = missle.addOrReplaceChild("hexadecagon3",
				CubeListBuilder.create().texOffs(68, 152).addBox(-2.5F, -1.3924F, -7.0F, 3.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(0, 19)
						.addBox(-2.5F, -7.0F, -1.3924F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -140.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition hexadecagon_r9 = hexadecagon3.addOrReplaceChild("hexadecagon_r9",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -7.0F, -1.3924F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 152)
						.addBox(-2.5F, -1.3924F, -7.0F, 3.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r10 = hexadecagon3.addOrReplaceChild("hexadecagon_r10",
				CubeListBuilder.create().texOffs(0, 38).addBox(-2.5F, -7.0F, -1.3924F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(102, 152)
						.addBox(-2.5F, -1.3924F, -7.0F, 3.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r11 = hexadecagon3.addOrReplaceChild("hexadecagon_r11",
				CubeListBuilder.create().texOffs(0, 152).addBox(-2.5F, -1.3924F, -7.0F, 3.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r12 = hexadecagon3.addOrReplaceChild("hexadecagon_r12",
				CubeListBuilder.create().texOffs(136, 152).addBox(-2.5F, -1.3924F, -7.0F, 3.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon4 = missle.addOrReplaceChild("hexadecagon4",
				CubeListBuilder.create().texOffs(0, 38).addBox(-139.5F, -1.5913F, -8.0F, 140.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
						.texOffs(0, 114).addBox(-139.5F, -8.0F, -1.5913F, 140.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition hexadecagon_r13 = hexadecagon4.addOrReplaceChild("hexadecagon_r13",
				CubeListBuilder.create().texOffs(0, 95).addBox(-139.5F, -8.0F, -1.5913F, 140.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
						.texOffs(0, 19).addBox(-139.5F, -1.5913F, -8.0F, 140.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r14 = hexadecagon4.addOrReplaceChild("hexadecagon_r14",
				CubeListBuilder.create().texOffs(0, 133).addBox(-139.5F, -8.0F, -1.5913F, 140.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
						.texOffs(0, 57).addBox(-139.5F, -1.5913F, -8.0F, 140.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r15 = hexadecagon4.addOrReplaceChild("hexadecagon_r15",
				CubeListBuilder.create().texOffs(0, 0).addBox(-139.5F, -1.5913F, -8.0F, 140.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r16 = hexadecagon4.addOrReplaceChild("hexadecagon_r16",
				CubeListBuilder.create().texOffs(0, 76).addBox(-139.5F, -1.5913F, -8.0F, 140.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		missle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.missle.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.missle.xRot = headPitch / (180F / (float) Math.PI);
	}
}
