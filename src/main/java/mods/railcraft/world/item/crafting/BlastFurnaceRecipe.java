package mods.railcraft.world.item.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mods.railcraft.data.recipes.builders.BlastFurnaceRecipeBuilder;
import mods.railcraft.world.level.block.RailcraftBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class BlastFurnaceRecipe extends AbstractCookingRecipe {

  private final int slagOutput;

  public BlastFurnaceRecipe(String group, Ingredient ingredient, ItemStack result,
      float experience, int cookingTime, int slagOutput) {
    super(RailcraftRecipeTypes.BLASTING.get(), group, CookingBookCategory.MISC,
        ingredient, result, experience, cookingTime);
    this.slagOutput = slagOutput;
  }

  public int getSlagOutput() {
    return this.slagOutput;
  }

  @Override
  public RecipeSerializer<?> getSerializer() {
    return RailcraftRecipeSerializers.BLASTING.get();
  }

  @Override
  public boolean isSpecial() {
    return true;
  }
  @Override
  public ItemStack getToastSymbol() {
    return new ItemStack(RailcraftBlocks.BLAST_FURNACE_BRICKS.get());
  }

  public static class Serializer implements RecipeSerializer<BlastFurnaceRecipe> {

    private static final Codec<BlastFurnaceRecipe> CODEC =
        RecordCodecBuilder.create(instance -> instance.group(
            ExtraCodecs.strictOptionalField(
                Codec.STRING, "group", "").forGetter(recipe -> recipe.group),
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(recipe -> recipe.ingredient),
                BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem).fieldOf("result").forGetter(recipe -> recipe.result),
                Codec.FLOAT.fieldOf("experience").orElse(0.0F).forGetter(recipe -> recipe.experience),
                Codec.INT.fieldOf("cookingTime").orElse(BlastFurnaceRecipeBuilder.DEFAULT_COOKING_TIME).forGetter(recipe -> recipe.cookingTime),
                Codec.INT.fieldOf("slagOutput").orElse(1).forGetter(recipe -> recipe.slagOutput))
            .apply(instance, BlastFurnaceRecipe::new));

    @Override
    public Codec<BlastFurnaceRecipe> codec() {
      return CODEC;
    }

    @Override
    public BlastFurnaceRecipe fromNetwork(FriendlyByteBuf buffer) {
      var group = buffer.readUtf();
      var slagOutput = buffer.readVarInt();
      var cookingTime = buffer.readVarInt();
      var ingredient = Ingredient.fromNetwork(buffer);
      var result = buffer.readItem();
      var experience = buffer.readFloat();
      return new BlastFurnaceRecipe(group, ingredient, result, experience, cookingTime, slagOutput);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, BlastFurnaceRecipe recipe) {
      buffer.writeUtf(recipe.group);
      buffer.writeVarInt(recipe.slagOutput);
      buffer.writeVarInt(recipe.cookingTime);
      recipe.ingredient.toNetwork(buffer);
      buffer.writeItem(recipe.result);
      buffer.writeFloat(recipe.experience);
    }
  }
}
