package mods.railcraft.data.recipes.providers;

import java.util.function.Consumer;
import mods.railcraft.Railcraft;
import mods.railcraft.data.recipes.RollingRecipeBuilder;
import mods.railcraft.data.recipes.patterns.RollingRecipePattern;
import mods.railcraft.tags.RailcraftTags;
import mods.railcraft.world.item.RailcraftItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;

public class RollingRecipeProvider extends RecipeProvider {

  public RollingRecipeProvider(DataGenerator generator) {
    super(generator);
  }

  @Override
  protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
    this.misc(consumer);
    this.buildChargeSpool(consumer);
    this.buildTrackParts(consumer);
    this.buildRebars(consumer);
    this.buildElectrodes(consumer);
    this.buildRails(consumer);
    this.buildPlates(consumer);
  }

  private void misc(Consumer<FinishedRecipe> consumer) {
    RollingRecipePattern.hForm(consumer, Tags.Items.INGOTS_IRON,
        RailcraftItems.POST.variantFor(DyeColor.BLACK).get(), 16);

    RollingRecipePattern.diagonalLine(consumer, RailcraftTags.Items.STEEL_PLATE,
        RailcraftItems.TURBINE_BLADE.get(), 1, "steel_turbine_blade");
    RollingRecipePattern.diagonalLine(consumer, RailcraftTags.Items.NICKEL_PLATE,
        RailcraftItems.TURBINE_BLADE.get(), 1, "nickel_turbine_blade");

    RollingRecipePattern.square2x2(consumer, RailcraftTags.Items.BRONZE_PLATE,
        RailcraftItems.BUSHING_GEAR.get(), 4, "_bronze");
    RollingRecipePattern.square2x2(consumer, RailcraftTags.Items.BRASS_PLATE,
        RailcraftItems.BUSHING_GEAR.get(), 4, "_brass");
  }

  private void buildChargeSpool(Consumer<FinishedRecipe> consumer) {
    final var largeChargeSpool = RailcraftItems.CHARGE_SPOOL_LARGE.get();
    RollingRecipeBuilder.rolled(largeChargeSpool)
        .pattern("a")
        .define('a', Tags.Items.STORAGE_BLOCKS_COPPER)
        .save(consumer, new ResourceLocation(Railcraft.ID, "rolling/" + largeChargeSpool));

    final var smallChargeSpool = RailcraftItems.CHARGE_SPOOL_SMALL.get();
    RollingRecipeBuilder.rolled(smallChargeSpool)
        .pattern("a")
        .define('a', Tags.Items.INGOTS_COPPER)
        .save(consumer, new ResourceLocation(Railcraft.ID, "rolling/" + smallChargeSpool));
  }

  private void buildTrackParts(Consumer<FinishedRecipe> consumer) {
    final var trackParts = RailcraftItems.TRACK_PARTS.get();
    var name = RecipeBuilder.getDefaultRecipeId(trackParts).getPath();
    RollingRecipeBuilder.rolled(trackParts)
        .pattern("aa ")
        .pattern("a  ")
        .define('a', RailcraftTags.Items.BRONZE_NUGGET)
        .save(consumer, new ResourceLocation(Railcraft.ID, "rolling/" + name + "_bronze_nugget"));
    RollingRecipeBuilder.rolled(trackParts)
        .pattern("aa")
        .define('a', Tags.Items.NUGGETS_IRON)
        .save(consumer, new ResourceLocation(Railcraft.ID, "rolling/" + name + "_iron_nugget"));
    RollingRecipeBuilder.rolled(trackParts)
        .pattern("a")
        .define('a', RailcraftTags.Items.STEEL_NUGGET)
        .save(consumer, new ResourceLocation(Railcraft.ID, "rolling/" + name + "_steel_nugget"));
  }

  private void buildRebars(Consumer<FinishedRecipe> consumer) {
    RollingRecipePattern.diagonalLine(consumer, Tags.Items.INGOTS_IRON,
        RailcraftItems.REBAR.get(), 4, "rebar_iron");
    RollingRecipePattern.diagonalLine(consumer, RailcraftTags.Items.BRONZE_INGOT,
        RailcraftItems.REBAR.get(), 4, "rebar_bronze");
    RollingRecipePattern.diagonalLine(consumer, RailcraftTags.Items.INVAR_INGOT,
        RailcraftItems.REBAR.get(), 6, "rebar_invar");
    RollingRecipePattern.diagonalLine(consumer, RailcraftTags.Items.STEEL_INGOT,
        RailcraftItems.REBAR.get(), 8, "rebar_steel");
  }

  private void buildElectrodes(Consumer<FinishedRecipe> consumer) {
    RollingRecipePattern.line(consumer, Items.COAL, RailcraftItems.CARBON_ELECTRODE.get(), 1,
        "coal_carbon_electrode");
    RollingRecipePattern.line(consumer, Items.CHARCOAL, RailcraftItems.CARBON_ELECTRODE.get(), 1,
        "charcoal_carbon_electrode");
    RollingRecipePattern.line(consumer, RailcraftTags.Items.NICKEL_PLATE,
        RailcraftItems.NICKEL_ELECTRODE.get(), 1);
    RollingRecipePattern.line(consumer, RailcraftTags.Items.IRON_PLATE,
        RailcraftItems.IRON_ELECTRODE.get(), 1);
    RollingRecipePattern.line(consumer, RailcraftTags.Items.ZINC_PLATE,
        RailcraftItems.ZINC_ELECTRODE.get(), 1);
    RollingRecipePattern.line(consumer, RailcraftTags.Items.SILVER_PLATE,
        RailcraftItems.SILVER_ELECTRODE.get(), 1);
    RollingRecipePattern.line(consumer, RailcraftTags.Items.STEEL_PLATE,
        RailcraftItems.STEEL_ELECTRODE.get(), 1);
    RollingRecipePattern.line(consumer, RailcraftTags.Items.TIN_PLATE,
        RailcraftItems.TIN_ELECTRODE.get(), 1);
    RollingRecipePattern.line(consumer, RailcraftTags.Items.GOLD_PLATE,
        RailcraftItems.GOLD_ELECTRODE.get(), 1);
    RollingRecipePattern.line(consumer, RailcraftTags.Items.LEAD_PLATE,
        RailcraftItems.LEAD_ELECTRODE.get(), 1);
    RollingRecipePattern.line(consumer, RailcraftTags.Items.BRASS_PLATE,
        RailcraftItems.BRASS_ELECTRODE.get(), 1);
    RollingRecipePattern.line(consumer, RailcraftTags.Items.INVAR_PLATE,
        RailcraftItems.INVAR_ELECTRODE.get(), 1);
    RollingRecipePattern.line(consumer, RailcraftTags.Items.BRONZE_PLATE,
        RailcraftItems.BRONZE_ELECTRODE.get(), 1);
    RollingRecipePattern.line(consumer, RailcraftTags.Items.COPPER_PLATE,
        RailcraftItems.COPPER_ELECTRODE.get(), 1);
  }

  private void buildRails(Consumer<FinishedRecipe> consumer) {
    RollingRecipePattern.parallelLines(consumer, Tags.Items.INGOTS_IRON,
        RailcraftItems.STANDARD_RAIL.get(), 8, "standard_rail");
    RollingRecipePattern.parallelLines(consumer, RailcraftTags.Items.BRONZE_INGOT,
        RailcraftItems.STANDARD_RAIL.get(), 8, "bronze_rail");
    RollingRecipePattern.parallelLines(consumer, RailcraftTags.Items.INVAR_INGOT,
        RailcraftItems.STANDARD_RAIL.get(), 12, "invar_rail");
    RollingRecipePattern.parallelLines(consumer, RailcraftTags.Items.STEEL_INGOT,
        RailcraftItems.STANDARD_RAIL.get(), 16, "steel_rail");
    RollingRecipePattern.parallelLines(consumer, Tags.Items.INGOTS_COPPER,
        RailcraftItems.ELECTRIC_RAIL.get(), 6, "copper_electric_rail");
    RollingRecipePattern.parallelLines(consumer, Tags.Items.DUSTS_REDSTONE, Tags.Items.INGOTS_GOLD,
        RailcraftItems.ADVANCED_RAIL.get(), 8, "advanced_rail");
    RollingRecipePattern.parallelThreeLines(consumer, RailcraftTags.Items.STEEL_INGOT,
        Items.BLAZE_POWDER,
        Tags.Items.INGOTS_GOLD, RailcraftItems.HIGH_SPEED_RAIL.get(), 8,
        "standard_high_speed_rail");
    RollingRecipePattern.parallelThreeLines(consumer, RailcraftTags.Items.STEEL_INGOT,
        RailcraftTags.Items.OBSIDIAN_DUST,
        RailcraftTags.Items.STEEL_INGOT, RailcraftItems.REINFORCED_RAIL.get(), 8,
        "steel_reinforced_rail");
    RollingRecipePattern.parallelThreeLines(consumer, RailcraftTags.Items.INVAR_INGOT,
        RailcraftTags.Items.OBSIDIAN_DUST,
        RailcraftTags.Items.INVAR_INGOT, RailcraftItems.REINFORCED_RAIL.get(), 4,
        "invar_reinforced_rail");
    RollingRecipePattern.parallelThreeLines(consumer, RailcraftTags.Items.STEEL_INGOT,
        Tags.Items.INGOTS_COPPER, RailcraftTags.Items.STEEL_INGOT,
        RailcraftItems.ELECTRIC_RAIL.get(), 12);
  }

  private void buildPlates(Consumer<FinishedRecipe> consumer) {
    RollingRecipePattern.square2x2(consumer, Tags.Items.INGOTS_IRON,
        RailcraftItems.IRON_PLATE.get(), 4);
    RollingRecipePattern.square2x2(consumer, Tags.Items.INGOTS_GOLD,
        RailcraftItems.GOLD_PLATE.get(), 4);
    RollingRecipePattern.square2x2(consumer, Tags.Items.INGOTS_COPPER,
        RailcraftItems.COPPER_PLATE.get(), 4);
    RollingRecipePattern.square2x2(consumer, RailcraftTags.Items.STEEL_INGOT,
        RailcraftItems.STEEL_PLATE.get(), 4);
    RollingRecipePattern.square2x2(consumer, RailcraftTags.Items.NICKEL_INGOT,
        RailcraftItems.NICKEL_PLATE.get(), 4);
    RollingRecipePattern.square2x2(consumer, RailcraftTags.Items.INVAR_INGOT,
        RailcraftItems.INVAR_PLATE.get(), 4);
    RollingRecipePattern.square2x2(consumer, RailcraftTags.Items.BRASS_INGOT,
        RailcraftItems.BRASS_PLATE.get(), 4);
    RollingRecipePattern.square2x2(consumer, RailcraftTags.Items.TIN_INGOT,
        RailcraftItems.TIN_PLATE.get(), 4);
    RollingRecipePattern.square2x2(consumer, RailcraftTags.Items.BRONZE_INGOT,
        RailcraftItems.BRONZE_PLATE.get(), 4);
    RollingRecipePattern.square2x2(consumer, RailcraftTags.Items.LEAD_INGOT,
        RailcraftItems.LEAD_PLATE.get(), 4);
    RollingRecipePattern.square2x2(consumer, RailcraftTags.Items.SILVER_INGOT,
        RailcraftItems.SILVER_PLATE.get(), 4);
    RollingRecipePattern.square2x2(consumer, RailcraftTags.Items.ZINC_INGOT,
        RailcraftItems.ZINC_PLATE.get(), 4);
  }
}