package mods.railcraft.data.recipes.providers;

import java.util.function.Consumer;

import mods.railcraft.data.recipes.builders.CokeOvenRecipeBuilder;
import mods.railcraft.world.item.RailcraftItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class CokeOvenRecipeProvider extends RecipeProvider {

    private CokeOvenRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
    }

    public static void genRecipes(Consumer<FinishedRecipe> consumer) {
        CokeOvenRecipeBuilder
                .coking(Items.CHARCOAL, Ingredient.of(ItemTags.LOGS), 0, 300, 250)
                .unlockedBy("has_logs", has(ItemTags.LOGS))
                .save(consumer);

        CokeOvenRecipeBuilder
                .coking(RailcraftItems.COAL_COKE.get(), Ingredient.of(Items.COAL), 0, 500)
                .unlockedBy(getHasName(Items.COAL), has(Items.COAL))
                .save(consumer);

        CokeOvenRecipeBuilder
                .coking(RailcraftItems.COKE_BLOCK.get(), Ingredient.of(Items.COAL_BLOCK), 0,
                        CokeOvenRecipeBuilder.DEFAULT_COOKING_TIME * 9, 5000)
                .unlockedBy(getHasName(Items.COAL_BLOCK), has(Items.COAL_BLOCK))
                .save(consumer);
    }
}
