package mods.railcraft.data.recipes.providers;

import java.util.function.Consumer;
import mods.railcraft.data.recipes.CrusherRecipeBuilder;
import mods.railcraft.world.item.RailcraftItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

public class CrusherRecipeProvider extends RecipeProvider {

  public CrusherRecipeProvider(DataGenerator generator) {
    super(generator);
  }

  @Override
  protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
    buildVanilla(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(RailcraftItems.COKE_OVEN_BRICKS.get()), 200)
        .addResult(Items.BRICK, 3, 1)
        .addResult(Items.BRICK, 1, 0.5)
        .addResult(Items.SAND, 1, 0.25)
        .addResult(Items.SAND, 1, 0.25)
        .addResult(Items.SAND, 1, 0.25)
        .addResult(Items.SAND, 1, 0.25)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(RailcraftItems.BLAST_FURNACE_BRICKS.get()), 200)
        .addResult(Items.NETHER_BRICK, 1, 0.75)
        .addResult(Items.SOUL_SAND, 1, 0.75)
        .addResult(Items.BLAZE_POWDER, 1, 0.05)
        .save(consumer);

    CrusherRecipeBuilder.crush(Ingredient.of(RailcraftItems.CRUSHED_OBSIDIAN.get()), 200)
        .addResult(RailcraftItems.OBSIDIAN_DUST.get(), 1, 1)
        .addResult(RailcraftItems.OBSIDIAN_DUST.get(), 1, 0.25)
        .save(consumer);
  }

  private void buildVanilla(Consumer<FinishedRecipe> consumer) {
    CrusherRecipeBuilder.crush(Ingredient.of(Items.OBSIDIAN), 200)
        .addResult(RailcraftItems.CRUSHED_OBSIDIAN.get(), 1, 1)
        .addResult(RailcraftItems.OBSIDIAN_DUST.get(), 1, 0.25)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.COBBLESTONE), 200)
        .addResult(Items.GRAVEL, 1, 1)
        .addResult(Items.FLINT, 1, 0.1)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.MOSSY_COBBLESTONE), 200)
        .addResult(Items.GRAVEL, 1, 1)
        .addResult(Items.VINE, 1, 0.8)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.GRAVEL), 200)
        .addResult(Items.SAND, 1, 1)
        .addResult(Items.GOLD_NUGGET, 1, 0.001)
        .addResult(Items.DIAMOND, 1, 0.00005)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Tags.Items.STONE), 200)
        .addResult(Items.COBBLESTONE, 1, 1)
        .save(consumer, "tags_stone");
    CrusherRecipeBuilder.crush(Ingredient.of(Tags.Items.SANDSTONE), 200)
        .addResult(Items.SAND, 4, 1)
        .save(consumer, "tags_sandstone");
    CrusherRecipeBuilder.crush(Ingredient.of(Items.BRICKS), 200)
        .addResult(Items.BRICK, 3, 1)
        .addResult(Items.BRICK, 1, 0.50)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.CLAY), 200)
        .addResult(Items.CLAY_BALL, 4, 1)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.COBBLESTONE_STAIRS), 200)
        .addResult(Items.GRAVEL, 1, 1)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.STONE_BRICK_STAIRS), 200)
        .addResult(Items.COBBLESTONE, 1, 1)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.NETHER_BRICK_STAIRS), 200)
        .addResult(Items.NETHER_BRICK, 1, 1)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.BRICK_STAIRS), 200)
        .addResult(Items.BRICK, 4, 1)
        .addResult(Items.BRICK, 1, 0.5)
        .addResult(Items.BRICK, 1, 0.5)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.STONE_SLAB), 200)
        .addResult(Items.COBBLESTONE, 1, 0.45)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.SANDSTONE_SLAB), 200)
        .addResult(Items.SAND, 1, 0.45)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.COBBLESTONE_SLAB), 200)
        .addResult(Items.GRAVEL, 1, 0.45)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.BRICK_SLAB), 200)
        .addResult(Items.BRICK, 1, 1)
        .addResult(Items.BRICK, 1, 0.75)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.STONE_BRICK_SLAB), 200)
        .addResult(Items.COBBLESTONE, 1, 0.45)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.ICE), 200)
        .addResult(Items.SNOW_BLOCK, 1, 0.85)
        .addResult(Items.SNOWBALL, 1, 0.25)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.NETHER_BRICK_FENCE), 200)
        .addResult(Items.NETHER_BRICK, 1, 1)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.GLOWSTONE), 200)
        .addResult(Items.GLOWSTONE_DUST, 3, 1)
        .addResult(Items.GLOWSTONE_DUST, 1, 0.75)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.REDSTONE_LAMP), 200)
        .addResult(Items.GLOWSTONE_DUST, 3, 1)
        .addResult(Items.GLOWSTONE_DUST, 1, 0.75)
        .addResult(Items.REDSTONE, 3, 1)
        .addResult(Items.REDSTONE, 1, 0.75)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.BONE), 200)
        .addResult(Items.BONE_MEAL, 4, 1)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.BLAZE_ROD), 200)
        .addResult(Items.BLAZE_POWDER, 2, 1)
        .addResult(Items.BLAZE_POWDER, 1, 0.65)
        .addResult(RailcraftItems.SULFUR_DUST.get(), 1, 0.5)
        .addResult(Items.BLAZE_POWDER, 1, 0.25)
        .addResult(Items.BLAZE_POWDER, 1, 0.25)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Tags.Items.ORES_REDSTONE), 200)
        .addResult(Items.REDSTONE, 6, 1)
        .addResult(Items.REDSTONE, 2, 0.85)
        .addResult(Items.REDSTONE, 1, 0.25)
        .addResult(Items.GLOWSTONE_DUST, 1, 0.1)
        .save(consumer, "tags_ores_redstone");
    CrusherRecipeBuilder.crush(Ingredient.of(Tags.Items.ORES_DIAMOND), 200)
        .addResult(Items.DIAMOND, 1, 1)
        .addResult(Items.DIAMOND, 1, 0.85)
        .addResult(Items.DIAMOND, 1, 0.25)
        .addResult(Items.COAL, 1, 0.1)
        .save(consumer, "tags_ores_diamond");
    CrusherRecipeBuilder.crush(Ingredient.of(Tags.Items.ORES_EMERALD), 200)
        .addResult(Items.EMERALD, 1, 1)
        .addResult(Items.EMERALD, 1, 0.85)
        .addResult(Items.EMERALD, 1, 0.25)
        .save(consumer, "tags_ores_emerald");
    CrusherRecipeBuilder.crush(Ingredient.of(Tags.Items.ORES_LAPIS), 200)
        .addResult(Items.LAPIS_LAZULI, 8, 1)
        .addResult(Items.LAPIS_LAZULI, 1, 0.85)
        .addResult(Items.LAPIS_LAZULI, 1, 0.35)
        .save(consumer, "tags_ores_lapis");
    CrusherRecipeBuilder.crush(Ingredient.of(Tags.Items.ORES_COAL), 200)
        .addResult(RailcraftItems.COAL_DUST.get(), 2, 1)
        .addResult(RailcraftItems.COAL_DUST.get(), 1, 0.65)
        .addResult(Items.COAL, 1, 0.15)
        .addResult(Items.DIAMOND, 1, 0.001)
        .save(consumer, "tags_ores_coal");
    CrusherRecipeBuilder.crush(Ingredient.of(Items.COAL), 200)
        .addResult(RailcraftItems.COAL_DUST.get(), 1, 1)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.CHARCOAL), 200)
        .addResult(RailcraftItems.COAL_DUST.get(), 1, 1)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.COAL_BLOCK), 200)
        .addResult(RailcraftItems.COAL_DUST.get(), 9, 1)
        .save(consumer);
    CrusherRecipeBuilder.crush(Ingredient.of(Items.ENDER_PEARL), 200)
        .addResult(RailcraftItems.ENDER_DUST.get(), 1, 1)
        .save(consumer);
  }

  @Override
  public String getName() {
    return "Railcraft Crusher";
  }
}