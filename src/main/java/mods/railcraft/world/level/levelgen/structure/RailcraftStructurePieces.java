//package mods.railcraft.world.level.levelgen.structure;
//
//import mods.railcraft.api.core.RailcraftConstants;
//import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.RegistryObject;
//
//public class RailcraftStructurePieces {
//
//    private static final DeferredRegister<StructurePieceType> deferredRegister =
//            DeferredRegister.create(Registries.STRUCTURE_PIECE, RailcraftConstants.ID);
//
//    public static final RegistryObject<StructurePieceType.ContextlessType> GEODE =
//            deferredRegister.register("geode", () -> GeodeStructurePiece::new);
//
//    public static void register(IEventBus modEventBus) {
//        deferredRegister.register(modEventBus);
//    }
//}
