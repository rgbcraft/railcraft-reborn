package mods.railcraft.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mods.railcraft.world.item.RailcraftItems;
import mods.railcraft.world.level.block.RitualBlock;
import mods.railcraft.world.level.block.entity.RitualBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class RitualBlockRenderer implements BlockEntityRenderer<RitualBlockEntity> {

  private final ItemRenderer itemRenderer;

  public RitualBlockRenderer(BlockEntityRendererProvider.Context context) {
    this.itemRenderer = context.getItemRenderer();
  }

  @Override
  public void render(RitualBlockEntity blockEntity, float partialTick, PoseStack poseStack,
      MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
    poseStack.pushPose();
    var yOffset = blockEntity.getYOffset(partialTick);
    poseStack.translate(0.5F, 0.95F + yOffset, 0.5F);

    var yaw = blockEntity.getRotationYaw(partialTick);
    poseStack.mulPose(Axis.YP.rotation(yaw));

    poseStack.scale(0.6F, 0.6F, 0.6F);

    var firestone = new ItemStack(blockEntity.getBlockState().getValue(RitualBlock.CRACKED)
        ? RailcraftItems.CRACKED_FIRESTONE.get()
        : RailcraftItems.REFINED_FIRESTONE.get());

    int id = (int) blockEntity.getBlockPos().asLong();
    this.itemRenderer.renderStatic(firestone, ItemDisplayContext.NONE, packedLight, packedOverlay,
        poseStack, bufferSource, blockEntity.getLevel(), id);
    poseStack.popPose();
  }
}
