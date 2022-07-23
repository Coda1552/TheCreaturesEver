package coda.thecreaturesever.client.model.armor;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import coda.thecreaturesever.TheCreaturesEver;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

// some code from BetterAnimalsPlus!
public class BearCapeModel<T extends LivingEntity> extends HumanoidModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TheCreaturesEver.MOD_ID, "bear_cape"), "main");
	public static BearCapeModel<LivingEntity> INSTANCE = null;
	private float f1_r;
	private float f2_r;
	private float f3_r;
	private boolean isPlayer;

	public ModelPart armorHead;
	public ModelPart armorBody;
	public ModelPart armorRightArm;
	public ModelPart armorLeftArm;

	public BearCapeModel(ModelPart root) {
		super(root);
		this.armorHead = head.getChild("armorHead");
		this.armorBody = body.getChild("armorBody");
		this.armorRightArm = rightArm.getChild("armorRightArm");
		this.armorLeftArm = leftArm.getChild("armorLeftArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(new CubeDeformation(0F), 0F);
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition armorHead = partdefinition.getChild("head").addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -13.0F, -5.0F, 10.0F, 13.0F, 9.0F, new CubeDeformation(0.01F))
		.texOffs(64, 15).addBox(-2.0F, -6.0F, -10.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(3.0F, -15.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(35, 24).addBox(-6.0F, -15.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(17, 63).addBox(-2.0F, -11.0F, -10.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(69, 28).addBox(-3.0F, -6.0F, -4.9F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition armorBody = partdefinition.getChild("body").addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(0, 23).addBox(-8.0F, 0.0F, 2.1F, 16.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorRightArm = partdefinition.getChild("right_arm").addOrReplaceChild("armorRightArm", CubeListBuilder.create().texOffs(0, 41).addBox(7.0F, -6.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.3F))
		.texOffs(60, 41).addBox(7.0F, 1.6F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.offset(-12.0F, 0.0F, 0.0F));

		PartDefinition armorLeftArm = partdefinition.getChild("left_arm").addOrReplaceChild("armorLeftArm", CubeListBuilder.create().texOffs(16, 50).addBox(0.0F, -6.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.3F))
		.texOffs(64, 7).addBox(0.0F, 1.6F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		this.leftArm.visible = false;
		this.rightArm.visible = false;

		if (isPlayer) {
			matrixStackIn.pushPose();
			matrixStackIn.translate(0.0F, 0.05F, 0.025F);
			float angle = 6.0F + f2_r / 2.0F + f1_r;
			angle = Math.min(angle, 90F);
			matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(angle));
			matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(f3_r / 2.0F));
			super.renderToBuffer(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
			matrixStackIn.popPose();
			this.armorLeftArm.visible = true;
			this.armorRightArm.visible = true;
			this.armorBody.visible = false;
			super.renderToBuffer(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
			this.armorLeftArm.visible = false;
			this.armorRightArm.visible = false;
			this.armorBody.visible = true;
		} else {
			this.armorLeftArm.visible = true;
			this.armorRightArm.visible = true;
			super.renderToBuffer(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		}
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float f33, float f44) {
		this.isPlayer = entity instanceof Player;
		if (isPlayer) {
			Player player = (Player) entity;
			float partialTicks = Minecraft.getInstance().getFrameTime();
			double d0 = player.xCloakO + (player.xCloak - player.xCloakO) * (double) partialTicks - (player.xo + (player.getX() - player.xo) * (double) partialTicks);
			double d1 = player.yCloakO + (player.yCloak - player.yCloakO) * (double) partialTicks - (player.yo + (player.getY() - player.yo) * (double) partialTicks);
			double d2 = player.zCloakO + (player.zCloak - player.zCloakO) * (double) partialTicks - (player.zo + (player.getZ() - player.zo) * (double) partialTicks);
			float f = player.yBodyRotO + (player.yBodyRot - player.yBodyRotO) * partialTicks;
			double d3 = Mth.sin(f * 0.017453292F);
			double d4 = -Mth.cos(f * 0.017453292F);
			float f1 = (float) d1 * 10.0F;
			f1 = Mth.clamp(f1, -6.0F, 32.0F);
			float f2 = (float) (d0 * d3 + d2 * d4) * 100.0F;
			float f3 = (float) (d0 * d4 - d2 * d3) * 100.0F;

			if (f2 < 0.0F) {
				f2 = 0.0F;
			}

			float f4 = player.oBob + (player.bob - player.oBob) * partialTicks;
			f1 = f1 + Mth.sin((player.walkDistO + (player.walkDist - player.walkDistO) * partialTicks) * 6.0F) * 32.0F * f4;
			this.f1_r = f1;
			this.f2_r = f2;
			this.f3_r = f3;
		}
	}
}