package mods.railcraft.integrations.jei.category;

import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mods.railcraft.Railcraft;
import mods.railcraft.Translations.Jei;
import mods.railcraft.integrations.jei.RecipeTypes;
import mods.railcraft.world.item.RailcraftItems;
import mods.railcraft.world.item.crafting.BlastFurnaceRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class BlastFurnaceRecipeCategory implements IRecipeCategory<BlastFurnaceRecipe> {

  private static final int WIDTH = 82;
  private static final int HEIGHT = 54;

  private static final ResourceLocation BLAST_FURNACE_BACKGROUND =
      new ResourceLocation(Railcraft.ID, "textures/gui/container/blast_furnace.png");

  private final IGuiHelper guiHelper;
  private final ItemStack icon;
  private final IDrawable flame, arrow;

  public BlastFurnaceRecipeCategory(IGuiHelper guiHelper) {
    this.guiHelper = guiHelper;
    this.icon = new ItemStack(RailcraftItems.BLAST_FURNACE_BRICKS.get());

    this.flame = guiHelper.createAnimatedDrawable(
        guiHelper.createDrawable(BLAST_FURNACE_BACKGROUND, 176, 0, 14, 14),
        200, IDrawableAnimated.StartDirection.TOP, true);
    this.arrow = guiHelper.createAnimatedDrawable(
        guiHelper.createDrawable(BLAST_FURNACE_BACKGROUND, 177, 14, 22, 15),
        200, IDrawableAnimated.StartDirection.LEFT, false);
  }

  @Override
  public RecipeType<BlastFurnaceRecipe> getRecipeType() {
    return RecipeTypes.BLAST_FURNACE;
  }

  @Override
  public Component getTitle() {
    return Component.translatable(Jei.BLAST_FURNACE);
  }

  @Override
  public IDrawable getBackground() {
    return guiHelper.createDrawable(BLAST_FURNACE_BACKGROUND, 55, 16, WIDTH, HEIGHT);
  }

  @Override
  public IDrawable getIcon() {
    return guiHelper.createDrawableItemStack(icon);
  }

  @Override
  public void draw(BlastFurnaceRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack,
      double mouseX, double mouseY) {
    flame.draw(stack, 1, 20);
    arrow.draw(stack, 25, 19);

    int cookTime = recipe.getCookingTime();
    if (cookTime > 0) {
      int cookTimeSeconds = cookTime / 20;
      var timeString = Component.translatable("gui.jei.category.smelting.time.seconds",
          cookTimeSeconds);
      Font fontRenderer = Minecraft.getInstance().font;
      int stringWidth = fontRenderer.width(timeString);
      fontRenderer.draw(stack, timeString, getBackground().getWidth() - stringWidth - 30, 45,
          0xFF808080);
    }
  }

  @Override
  public void setRecipe(IRecipeLayoutBuilder builder, BlastFurnaceRecipe recipe, IFocusGroup focuses) {
    var ingredients = recipe.getIngredients();
    builder
        .addSlot(RecipeIngredientRole.INPUT, 1, 1)
        .addIngredients(ingredients.get(0));
    builder
        .addSlot(RecipeIngredientRole.OUTPUT, 61, 5)
        .addItemStack(recipe.getResultItem());
    builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 37)
        .addItemStack(new ItemStack(RailcraftItems.SLAG.get(), recipe.getSlagOutput()));
  }
}