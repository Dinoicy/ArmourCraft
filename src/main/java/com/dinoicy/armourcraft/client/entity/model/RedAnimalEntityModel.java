package com.dinoicy.armourcraft.client.entity.model;

import com.dinoicy.armourcraft.entities.RedAnimalEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.Pose;
import net.minecraft.util.math.MathHelper;

public class RedAnimalEntityModel<T extends RedAnimalEntity> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer Legs;
	private final ModelRenderer Back;
	private final ModelRenderer RightBack;
	private final ModelRenderer LeftBack;
	private final ModelRenderer Front;
	private final ModelRenderer RightFront;
	private final ModelRenderer LeftFront;
	private final ModelRenderer Head;

	public RedAnimalEntityModel() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 20.0F, 0.0F);
		Body.setTextureOffset(0, 0).addBox(-4.0F, -10.5F, -5.1667F, 8, 7, 11, 0.0F, false);

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 6.5F, -0.1667F);
		Body.addChild(Legs);

		Back = new ModelRenderer(this);
		Back.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs.addChild(Back);

		RightBack = new ModelRenderer(this);
		RightBack.setRotationPoint(-2.5F, -11.5F, 4.5F);
		Back.addChild(RightBack);
		RightBack.setTextureOffset(0, 30).addBox(-1.5F, -0.5F, -1.5F, 3, 9, 3, 0.0F, false);

		LeftBack = new ModelRenderer(this);
		LeftBack.setRotationPoint(2.5F, -11.5F, 4.5F);
		Back.addChild(LeftBack);
		LeftBack.setTextureOffset(24, 24).addBox(-1.5F, -0.5F, -1.5F, 3, 9, 3, 0.0F, false);

		Front = new ModelRenderer(this);
		Front.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs.addChild(Front);

		RightFront = new ModelRenderer(this);
		RightFront.setRotationPoint(-2.5F, -11.5F, -3.5F);
		Front.addChild(RightFront);
		RightFront.setTextureOffset(33, 33).addBox(-1.5F, -0.5F, -1.5F, 3, 9, 3, 0.0F, false);

		LeftFront = new ModelRenderer(this);
		LeftFront.setRotationPoint(2.5F, -11.5F, -3.5F);
		Front.addChild(LeftFront);
		LeftFront.setTextureOffset(12, 30).addBox(-1.5F, -0.5F, -1.5F, 3, 9, 3, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -8.75F, -3.6667F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 18).addBox(-3.0F, -4.75F, -4.5F, 6, 6, 6, 0.0F, false);
		Head.setTextureOffset(27, 0).addBox(-2.0F, -1.75F, -6.5F, 4, 3, 4, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
					   float red, float green, float blue, float alpha) {
		Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.Body.rotateAngleX = ((float)Math.PI / 0.001F);
		this.RightBack.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LeftBack.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.RightFront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.LeftFront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}



	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}

	public ModelRenderer getBack() {
		return Back;
	}

	public ModelRenderer getBody() {
		return Body;
	}

	public ModelRenderer getFront() {
		return Front;
	}

	public ModelRenderer getHead() {
		return Head;
	}

	public ModelRenderer getLeftBack() {
		return LeftBack;
	}

	public ModelRenderer getLeftFront() {
		return LeftFront;
	}

	public ModelRenderer getLegs() {
		return Legs;
	}

	public ModelRenderer getRightBack() {
		return RightBack;
	}

	public ModelRenderer getRightFront() {
		return RightFront;
	}
}