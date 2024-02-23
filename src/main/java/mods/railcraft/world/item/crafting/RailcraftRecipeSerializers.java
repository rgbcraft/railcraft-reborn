package mods.railcraft.world.item.crafting;

import mods.railcraft.api.core.RailcraftConstants;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RailcraftRecipeSerializers {

    private static final DeferredRegister<RecipeSerializer<?>> deferredRegister =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, RailcraftConstants.ID);

    public static final RegistryObject<RecipeSerializer<?>> ROLLING =
            deferredRegister.register("rolling", RollingRecipe.Serializer::new);

    public static final RegistryObject<RecipeSerializer<?>> COKING =
            deferredRegister.register("coking", CokeOvenRecipe.Serializer::new);

    public static final RegistryObject<RecipeSerializer<?>> BLASTING =
            deferredRegister.register("blasting", BlastFurnaceRecipe.Serializer::new);

    public static final RegistryObject<RecipeSerializer<?>> CRUSHER =
            deferredRegister.register("crusher", CrusherRecipe.Serializer::new);

    public static final RegistryObject<SimpleRecipeSerializer<TicketDuplicateRecipe>> TICKET_DUPLICATE =
            deferredRegister.register("ticket_duplicate",
                    () -> new SimpleRecipeSerializer<>(TicketDuplicateRecipe::new));

    public static final RegistryObject<SimpleRecipeSerializer<LocomotivePaintingRecipe>> LOCOMOTIVE_PAINTING =
            deferredRegister.register("locomotive_painting",
                    () -> new SimpleRecipeSerializer<>(LocomotivePaintingRecipe::new));

    public static final RegistryObject<SimpleRecipeSerializer<RotorRepairRecipe>> ROTOR_REPAIR =
            deferredRegister.register("rotor_repair",
                    () -> new SimpleRecipeSerializer<>(RotorRepairRecipe::new));

    public static final RegistryObject<SimpleRecipeSerializer<CartDisassemblyRecipe>> CART_DISASSEMBLY =
            deferredRegister.register("cart_disassembly",
                    () -> new SimpleRecipeSerializer<>(CartDisassemblyRecipe::new));

    public static final RegistryObject<SimpleRecipeSerializer<PatchouliBookCrafting>> PATCHOULI_BOOK_CRAFTING =
            deferredRegister.register("patchouli_book_crafting",
                    () -> new SimpleRecipeSerializer<>(PatchouliBookCrafting::new));

    public static void register(IEventBus modEventBus) {
        deferredRegister.register(modEventBus);
    }
}
