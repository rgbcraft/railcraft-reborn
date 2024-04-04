package mods.railcraft.world.item;

import mods.railcraft.Translations;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

public class RailcraftCreativeModeTabs extends CreativeModeTab {
    public RailcraftCreativeModeTabs() {
        super(Component.translatable(Translations.Tab.RAILCRAFT).toString());
    }

    @Override
    public ItemStack makeIcon() {
        return RailcraftItems.IRON_CROWBAR.get().getDefaultInstance();
    }

    @Override
    public void fillItemList(NonNullList<ItemStack> items) {
        items.add(RailcraftItems.LOW_PRESSURE_STEAM_BOILER_TANK.get().getDefaultInstance());
        items.add(RailcraftItems.HIGH_PRESSURE_STEAM_BOILER_TANK.get().getDefaultInstance());
        items.add(RailcraftItems.SOLID_FUELED_FIREBOX.get().getDefaultInstance());
        items.add(RailcraftItems.FLUID_FUELED_FIREBOX.get().getDefaultInstance());
        items.add(RailcraftItems.TURBINE_BLADE.get().getDefaultInstance());
        items.add(RailcraftItems.TURBINE_DISK.get().getDefaultInstance());
        items.add(RailcraftItems.TURBINE_ROTOR.get().getDefaultInstance());
        items.add(RailcraftItems.STEAM_TURBINE.get().getDefaultInstance());
        items.add(RailcraftItems.STEAM_OVEN.get().getDefaultInstance());
        items.add(RailcraftItems.MANUAL_ROLLING_MACHINE.get().getDefaultInstance());
        items.add(RailcraftItems.POWERED_ROLLING_MACHINE.get().getDefaultInstance());
        items.add(RailcraftItems.CRUSHER.get().getDefaultInstance());
        items.add(RailcraftItems.COKE_OVEN_BRICKS.get().getDefaultInstance());
        items.add(RailcraftItems.BLAST_FURNACE_BRICKS.get().getDefaultInstance());
        items.add(RailcraftItems.WATER_TANK_SIDING.get().getDefaultInstance());
        items.add(RailcraftItems.FEED_STATION.get().getDefaultInstance());
        items.add(RailcraftItems.FRAME_BLOCK.get().getDefaultInstance());
        items.add(RailcraftItems.CHARGE_METER.get().getDefaultInstance());
        items.add(RailcraftItems.NICKEL_ZINC_BATTERY.get().getDefaultInstance());
        items.add(RailcraftItems.NICKEL_IRON_BATTERY.get().getDefaultInstance());
        items.add(RailcraftItems.ZINC_CARBON_BATTERY.get().getDefaultInstance());
        items.add(RailcraftItems.ZINC_CARBON_BATTERY_EMPTY.get().getDefaultInstance());
        items.add(RailcraftItems.ZINC_SILVER_BATTERY.get().getDefaultInstance());
        items.add(RailcraftItems.ZINC_SILVER_BATTERY_EMPTY.get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_ANVIL.get().getDefaultInstance());
        items.add(RailcraftItems.CHIPPED_STEEL_ANVIL.get().getDefaultInstance());
        items.add(RailcraftItems.DAMAGED_STEEL_ANVIL.get().getDefaultInstance());

        items.add(RailcraftItems.CRUSHED_OBSIDIAN.get().getDefaultInstance());
        items.add(RailcraftItems.COAL_COKE.get().getDefaultInstance());
        items.add(RailcraftItems.COKE_BLOCK.get().getDefaultInstance());

        items.add(RailcraftItems.SULFUR_ORE.get().getDefaultInstance());
        items.add(RailcraftItems.DEEPSLATE_SULFUR_ORE.get().getDefaultInstance());
        items.add(RailcraftItems.SALTPETER_ORE.get().getDefaultInstance());
        items.add(RailcraftItems.LEAD_ORE.get().getDefaultInstance());
        items.add(RailcraftItems.DEEPSLATE_LEAD_ORE.get().getDefaultInstance());
        items.add(RailcraftItems.NICKEL_ORE.get().getDefaultInstance());
        items.add(RailcraftItems.DEEPSLATE_NICKEL_ORE.get().getDefaultInstance());
        items.add(RailcraftItems.SILVER_ORE.get().getDefaultInstance());
        items.add(RailcraftItems.DEEPSLATE_SILVER_ORE.get().getDefaultInstance());
        items.add(RailcraftItems.TIN_ORE.get().getDefaultInstance());
        items.add(RailcraftItems.DEEPSLATE_TIN_ORE.get().getDefaultInstance());
        items.add(RailcraftItems.ZINC_ORE.get().getDefaultInstance());
        items.add(RailcraftItems.DEEPSLATE_ZINC_ORE.get().getDefaultInstance());

        items.add(RailcraftItems.LEAD_RAW.get().getDefaultInstance());
        items.add(RailcraftItems.NICKEL_RAW.get().getDefaultInstance());
        items.add(RailcraftItems.SILVER_RAW.get().getDefaultInstance());
        items.add(RailcraftItems.TIN_RAW.get().getDefaultInstance());
        items.add(RailcraftItems.ZINC_RAW.get().getDefaultInstance());

        items.add(RailcraftItems.LEAD_BLOCK.get().getDefaultInstance());
        items.add(RailcraftItems.NICKEL_BLOCK.get().getDefaultInstance());
        items.add(RailcraftItems.SILVER_BLOCK.get().getDefaultInstance());
        items.add(RailcraftItems.TIN_BLOCK.get().getDefaultInstance());
        items.add(RailcraftItems.ZINC_BLOCK.get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_BLOCK.get().getDefaultInstance());
        items.add(RailcraftItems.BRASS_BLOCK.get().getDefaultInstance());
        items.add(RailcraftItems.BRONZE_BLOCK.get().getDefaultInstance());
        items.add(RailcraftItems.INVAR_BLOCK.get().getDefaultInstance());

        items.add(RailcraftItems.LEAD_INGOT.get().getDefaultInstance());
        items.add(RailcraftItems.NICKEL_INGOT.get().getDefaultInstance());
        items.add(RailcraftItems.SILVER_INGOT.get().getDefaultInstance());
        items.add(RailcraftItems.TIN_INGOT.get().getDefaultInstance());
        items.add(RailcraftItems.ZINC_INGOT.get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_INGOT.get().getDefaultInstance());
        items.add(RailcraftItems.BRASS_INGOT.get().getDefaultInstance());
        items.add(RailcraftItems.BRONZE_INGOT.get().getDefaultInstance());
        items.add(RailcraftItems.INVAR_INGOT.get().getDefaultInstance());

        items.add(RailcraftItems.ADVANCED_DETECTOR.get().getDefaultInstance());
        items.add(RailcraftItems.AGE_DETECTOR.get().getDefaultInstance());
        items.add(RailcraftItems.ANIMAL_DETECTOR.get().getDefaultInstance());
        items.add(RailcraftItems.ANY_DETECTOR.get().getDefaultInstance());
        items.add(RailcraftItems.EMPTY_DETECTOR.get().getDefaultInstance());
        items.add(RailcraftItems.ITEM_DETECTOR.get().getDefaultInstance());
        items.add(RailcraftItems.LOCOMOTIVE_DETECTOR.get().getDefaultInstance());
        items.add(RailcraftItems.MOB_DETECTOR.get().getDefaultInstance());
        items.add(RailcraftItems.PLAYER_DETECTOR.get().getDefaultInstance());
        items.add(RailcraftItems.ROUTING_DETECTOR.get().getDefaultInstance());
        items.add(RailcraftItems.SHEEP_DETECTOR.get().getDefaultInstance());
        items.add(RailcraftItems.TANK_DETECTOR.get().getDefaultInstance());
        items.add(RailcraftItems.TRAIN_DETECTOR.get().getDefaultInstance());
        items.add(RailcraftItems.VILLAGER_DETECTOR.get().getDefaultInstance());

        items.add(RailcraftItems.IRON_SPIKE_MAUL.get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_SPIKE_MAUL.get().getDefaultInstance());
        items.add(RailcraftItems.DIAMOND_SPIKE_MAUL.get().getDefaultInstance());
        items.add(RailcraftItems.LEAD_NUGGET.get().getDefaultInstance());
        items.add(RailcraftItems.NICKEL_NUGGET.get().getDefaultInstance());
        items.add(RailcraftItems.SILVER_NUGGET.get().getDefaultInstance());
        items.add(RailcraftItems.TIN_NUGGET.get().getDefaultInstance());
        items.add(RailcraftItems.ZINC_NUGGET.get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_NUGGET.get().getDefaultInstance());
        items.add(RailcraftItems.BRASS_NUGGET.get().getDefaultInstance());
        items.add(RailcraftItems.BRONZE_NUGGET.get().getDefaultInstance());
        items.add(RailcraftItems.INVAR_NUGGET.get().getDefaultInstance());

        items.add(RailcraftItems.IRON_PLATE.get().getDefaultInstance());
        items.add(RailcraftItems.COPPER_PLATE.get().getDefaultInstance());
        items.add(RailcraftItems.GOLD_PLATE.get().getDefaultInstance());
        items.add(RailcraftItems.LEAD_PLATE.get().getDefaultInstance());
        items.add(RailcraftItems.NICKEL_PLATE.get().getDefaultInstance());
        items.add(RailcraftItems.SILVER_PLATE.get().getDefaultInstance());
        items.add(RailcraftItems.TIN_PLATE.get().getDefaultInstance());
        items.add(RailcraftItems.ZINC_PLATE.get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_PLATE.get().getDefaultInstance());
        items.add(RailcraftItems.BRASS_PLATE.get().getDefaultInstance());
        items.add(RailcraftItems.BRONZE_PLATE.get().getDefaultInstance());
        items.add(RailcraftItems.INVAR_PLATE.get().getDefaultInstance());

        items.add(RailcraftItems.BUSHING_GEAR.get().getDefaultInstance());
        items.add(RailcraftItems.IRON_GEAR.get().getDefaultInstance());
        items.add(RailcraftItems.COPPER_GEAR.get().getDefaultInstance());
        items.add(RailcraftItems.GOLD_GEAR.get().getDefaultInstance());
        items.add(RailcraftItems.LEAD_GEAR.get().getDefaultInstance());
        items.add(RailcraftItems.NICKEL_GEAR.get().getDefaultInstance());
        items.add(RailcraftItems.SILVER_GEAR.get().getDefaultInstance());
        items.add(RailcraftItems.TIN_GEAR.get().getDefaultInstance());
        items.add(RailcraftItems.ZINC_GEAR.get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_GEAR.get().getDefaultInstance());
        items.add(RailcraftItems.BRASS_GEAR.get().getDefaultInstance());
        items.add(RailcraftItems.BRONZE_GEAR.get().getDefaultInstance());
        items.add(RailcraftItems.INVAR_GEAR.get().getDefaultInstance());

        items.add(RailcraftItems.CARBON_ELECTRODE.get().getDefaultInstance());
        items.add(RailcraftItems.IRON_ELECTRODE.get().getDefaultInstance());
        items.add(RailcraftItems.COPPER_ELECTRODE.get().getDefaultInstance());
        items.add(RailcraftItems.GOLD_ELECTRODE.get().getDefaultInstance());
        items.add(RailcraftItems.LEAD_ELECTRODE.get().getDefaultInstance());
        items.add(RailcraftItems.NICKEL_ELECTRODE.get().getDefaultInstance());
        items.add(RailcraftItems.SILVER_ELECTRODE.get().getDefaultInstance());
        items.add(RailcraftItems.TIN_ELECTRODE.get().getDefaultInstance());
        items.add(RailcraftItems.ZINC_ELECTRODE.get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_ELECTRODE.get().getDefaultInstance());
        items.add(RailcraftItems.BRASS_ELECTRODE.get().getDefaultInstance());
        items.add(RailcraftItems.BRONZE_ELECTRODE.get().getDefaultInstance());
        items.add(RailcraftItems.INVAR_ELECTRODE.get().getDefaultInstance());

        items.add(RailcraftItems.SALTPETER_DUST.get().getDefaultInstance());
        items.add(RailcraftItems.COAL_DUST.get().getDefaultInstance());
        items.add(RailcraftItems.CHARCOAL_DUST.get().getDefaultInstance());
        items.add(RailcraftItems.SLAG.get().getDefaultInstance());
        items.add(RailcraftItems.ENDER_DUST.get().getDefaultInstance());
        items.add(RailcraftItems.SULFUR_DUST.get().getDefaultInstance());
        items.add(RailcraftItems.OBSIDIAN_DUST.get().getDefaultInstance());
        items.add(RailcraftItems.BRONZE_BLOCK.get().getDefaultInstance());
        items.add(RailcraftItems.INVAR_BLOCK.get().getDefaultInstance());

        items.add(RailcraftItems.IRON_TUNNEL_BORE_HEAD.get().getDefaultInstance());
        items.add(RailcraftItems.BRONZE_TUNNEL_BORE_HEAD.get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_TUNNEL_BORE_HEAD.get().getDefaultInstance());
        items.add(RailcraftItems.DIAMOND_TUNNEL_BORE_HEAD.get().getDefaultInstance());

        items.add(RailcraftItems.ITEM_LOADER.get().getDefaultInstance());
        items.add(RailcraftItems.ADVANCED_ITEM_LOADER.get().getDefaultInstance());
        items.add(RailcraftItems.ITEM_UNLOADER.get().getDefaultInstance());
        items.add(RailcraftItems.ADVANCED_ITEM_UNLOADER.get().getDefaultInstance());
        items.add(RailcraftItems.FLUID_LOADER.get().getDefaultInstance());
        items.add(RailcraftItems.FLUID_UNLOADER.get().getDefaultInstance());
        items.add(RailcraftItems.CART_DISPENSER.get().getDefaultInstance());
        items.add(RailcraftItems.TRAIN_DISPENSER.get().getDefaultInstance());

        items.add(RailcraftItems.IRON_SPIKE_MAUL.get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_SPIKE_MAUL.get().getDefaultInstance());
        items.add(RailcraftItems.DIAMOND_SPIKE_MAUL.get().getDefaultInstance());

        items.add(RailcraftItems.IRON_CROWBAR.get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_CROWBAR.get().getDefaultInstance());
        items.add(RailcraftItems.DIAMOND_CROWBAR.get().getDefaultInstance());
        items.add(RailcraftItems.SEASONS_CROWBAR.get().getDefaultInstance());

        items.add(RailcraftItems.IRON_TANK_GAUGE.variantFor(DyeColor.WHITE).get().getDefaultInstance());
        items.add(RailcraftItems.IRON_TANK_VALVE.variantFor(DyeColor.WHITE).get().getDefaultInstance());
        items.add(RailcraftItems.IRON_TANK_WALL.variantFor(DyeColor.WHITE).get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_TANK_GAUGE.variantFor(DyeColor.WHITE).get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_TANK_VALVE.variantFor(DyeColor.WHITE).get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_TANK_WALL.variantFor(DyeColor.WHITE).get().getDefaultInstance());

        items.add(RailcraftItems.ABANDONED_ACTIVATOR_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_BOOSTER_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_BUFFER_STOP_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_COUPLER_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_CONTROL_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_DETECTOR_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_EMBARKING_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_DISEMBARKING_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_DUMPING_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_GATED_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_LAUNCHER_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_LOCKING_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_WHISTLE_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_LOCOMOTIVE_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_THROTTLE_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_ROUTING_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_ONE_WAY_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_WYE_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_TURNOUT_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.ABANDONED_JUNCTION_TRACK.get().getDefaultInstance());
        items.add(RailcraftItems.REBAR.get().getDefaultInstance());
        items.add(RailcraftItems.WHISTLE_TUNER.get().getDefaultInstance());
        items.add(RailcraftItems.SIGNAL_TUNER.get().getDefaultInstance());
        items.add(RailcraftItems.SIGNAL_BLOCK_SURVEYOR.get().getDefaultInstance());
        items.add(RailcraftItems.SIGNAL_LABEL.get().getDefaultInstance());
        items.add(RailcraftItems.GOLDEN_TICKET.get().getDefaultInstance());
        items.add(RailcraftItems.TICKET.get().getDefaultInstance());
        items.add(RailcraftItems.ROUTING_TABLE_BOOK.get().getDefaultInstance());
        items.add(RailcraftItems.LOGBOOK.get().getDefaultInstance());
        items.add(RailcraftItems.GOGGLES.get().getDefaultInstance());
        items.add(RailcraftItems.OVERALLS.get().getDefaultInstance());

        items.add(RailcraftItems.CONTROLLER_CIRCUIT.get().getDefaultInstance());
        items.add(RailcraftItems.RECEIVER_CIRCUIT.get().getDefaultInstance());
        items.add(RailcraftItems.SIGNAL_CIRCUIT.get().getDefaultInstance());
        items.add(RailcraftItems.RADIO_CIRCUIT.get().getDefaultInstance());

        items.add(RailcraftItems.FIRESTONE_ORE.get().getDefaultInstance());
        RailcraftItems.RAW_FIRESTONE.get().fillItemCategory(items);
        RailcraftItems.REFINED_FIRESTONE.get().fillItemCategory(items);
        RailcraftItems.CRACKED_FIRESTONE.get().fillItemCategory(items);
        RailcraftItems.CUT_FIRESTONE.get().fillItemCategory(items);

        items.add(RailcraftItems.BAG_OF_CEMENT.get().getDefaultInstance());
        items.add(RailcraftItems.TRACK_PARTS.get().getDefaultInstance());
        items.add(RailcraftItems.WOODEN_TIE.get().getDefaultInstance());
        items.add(RailcraftItems.STONE_TIE.get().getDefaultInstance());
        items.add(RailcraftItems.WOODEN_RAILBED.get().getDefaultInstance());
        items.add(RailcraftItems.STONE_RAILBED.get().getDefaultInstance());

        items.add(RailcraftItems.WOODEN_RAIL.get().getDefaultInstance());
        items.add(RailcraftItems.STANDARD_RAIL.get().getDefaultInstance());
        items.add(RailcraftItems.ADVANCED_RAIL.get().getDefaultInstance());
        items.add(RailcraftItems.REINFORCED_RAIL.get().getDefaultInstance());
        items.add(RailcraftItems.HIGH_SPEED_RAIL.get().getDefaultInstance());
        items.add(RailcraftItems.ELECTRIC_RAIL.get().getDefaultInstance());

        items.add(RailcraftItems.FORCE_TRACK_EMITTER.get().getDefaultInstance());
        items.add(RailcraftItems.SIGNAL_LAMP.get().getDefaultInstance());
        items.add(RailcraftItems.CHARGE_SPOOL_SMALL.get().getDefaultInstance());
        items.add(RailcraftItems.CHARGE_SPOOL_MEDIUM.get().getDefaultInstance());
        items.add(RailcraftItems.CHARGE_SPOOL_LARGE.get().getDefaultInstance());
        items.add(RailcraftItems.CHARGE_MOTOR.get().getDefaultInstance());
        items.add(RailcraftItems.CHARGE_COIL.get().getDefaultInstance());
        items.add(RailcraftItems.CHARGE_TERMINAL.get().getDefaultInstance());

        items.add(RailcraftItems.CREOSOTE_BOTTLE.get().getDefaultInstance());
        items.add(RailcraftItems.CREOSOTE_BUCKET.get().getDefaultInstance());

        items.add(RailcraftItems.IRON_TANK_GAUGE.variantFor(DyeColor.WHITE).get().getDefaultInstance());
        items.add(RailcraftItems.IRON_TANK_VALVE.variantFor(DyeColor.WHITE).get().getDefaultInstance());
        items.add(RailcraftItems.IRON_TANK_WALL.variantFor(DyeColor.WHITE).get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_TANK_GAUGE.variantFor(DyeColor.WHITE).get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_TANK_VALVE.variantFor(DyeColor.WHITE).get().getDefaultInstance());
        items.add(RailcraftItems.STEEL_TANK_WALL.variantFor(DyeColor.WHITE).get().getDefaultInstance());
    }

//    public static final DeferredRegister<CreativeModeTab> deferredRegister =
//            DeferredRegister.create(ForgeRegistries.CREATIVE_MODE_TAB, RailcraftConstants.ID);
//    public static final RegistryObject<CreativeModeTab> OUTFITTED_TRACKS =
//            deferredRegister.register("outfitted_tracks", () -> CreativeModeTab.builder()
//                    .withTabsBefore(MAIN_TAB.getId())
//                    .title(Component.translatable(Translations.Tab.RAILCRAFT_OUTFITTED_TRACKS))
//                    .icon(() -> new ItemStack(RailcraftItems.IRON_DETECTOR_TRACK.get().getDefaultInstance()))
//                    .displayItems((params, output) -> {
//                        /*
//                         * TODO: - Messenger track - Delayed locking track
//                         */
//                        items.add(RailcraftItems.ABANDONED_ACTIVATOR_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_BOOSTER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_BUFFER_STOP_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_COUPLER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_CONTROL_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_DETECTOR_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_EMBARKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_DISEMBARKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_DUMPING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_GATED_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_LAUNCHER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_LOCKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_WHISTLE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_LOCOMOTIVE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_THROTTLE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_ROUTING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_ONE_WAY_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_WYE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_TURNOUT_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABANDONED_JUNCTION_TRACK.get().getDefaultInstance());
//
//                        items.add(RailcraftItems.IRON_ACTIVATOR_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_BOOSTER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_BUFFER_STOP_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_COUPLER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_CONTROL_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_DETECTOR_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_EMBARKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_DISEMBARKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_DUMPING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_GATED_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_LAUNCHER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_LOCKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_WHISTLE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_LOCOMOTIVE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_THROTTLE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_ROUTING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_ONE_WAY_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_WYE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_TURNOUT_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.IRON_JUNCTION_TRACK.get().getDefaultInstance());
//
//                        items.add(RailcraftItems.STRAP_IRON_ACTIVATOR_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_BOOSTER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_BUFFER_STOP_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_COUPLER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_CONTROL_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_DETECTOR_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_EMBARKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_DISEMBARKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_DUMPING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_GATED_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_LAUNCHER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_LOCKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_WHISTLE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_LOCOMOTIVE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_THROTTLE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_ROUTING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_ONE_WAY_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_WYE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_TURNOUT_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.STRAP_IRON_JUNCTION_TRACK.get().getDefaultInstance());
//
//                        items.add(RailcraftItems.REINFORCED_ACTIVATOR_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_BOOSTER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_BUFFER_STOP_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_COUPLER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_CONTROL_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_DETECTOR_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_EMBARKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_DISEMBARKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_DUMPING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_GATED_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_LAUNCHER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_LOCKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_WHISTLE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_LOCOMOTIVE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_THROTTLE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_ROUTING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_ONE_WAY_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_WYE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_TURNOUT_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.REINFORCED_JUNCTION_TRACK.get().getDefaultInstance());
//
//                        items.add(RailcraftItems.ELECTRIC_ACTIVATOR_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_BOOSTER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_BUFFER_STOP_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_COUPLER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_CONTROL_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_DETECTOR_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_EMBARKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_DISEMBARKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_DUMPING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_GATED_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_LAUNCHER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_LOCKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_WHISTLE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_LOCOMOTIVE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_THROTTLE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_ROUTING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_ONE_WAY_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_WYE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_TURNOUT_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.ELECTRIC_JUNCTION_TRACK.get().getDefaultInstance());
//
//                        items.add(RailcraftItems.HIGH_SPEED_ACTIVATOR_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_BOOSTER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_DETECTOR_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_LOCKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_WHISTLE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_LOCOMOTIVE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_THROTTLE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_TRANSITION_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_WYE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_TURNOUT_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_JUNCTION_TRACK.get().getDefaultInstance());
//
//                        items.add(RailcraftItems.HIGH_SPEED_ELECTRIC_ACTIVATOR_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_ELECTRIC_BOOSTER_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_ELECTRIC_DETECTOR_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_ELECTRIC_LOCKING_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_ELECTRIC_WHISTLE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_ELECTRIC_LOCOMOTIVE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_ELECTRIC_THROTTLE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_ELECTRIC_TRANSITION_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_ELECTRIC_WYE_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_ELECTRIC_TURNOUT_TRACK.get().getDefaultInstance());
//                        items.add(RailcraftItems.HIGH_SPEED_ELECTRIC_JUNCTION_TRACK.get().getDefaultInstance());
//                    }).build());
//    public static final RegistryObject<CreativeModeTab> DECORATIVE_BLOCKS =
//            deferredRegister.register("decorative_blocks", () -> CreativeModeTab.builder()
//                    .withTabsBefore(OUTFITTED_TRACKS.getId())
//                    .title(Component.translatable(Translations.Tab.RAILCRAFT_DECORATIVE_BLOCKS))
//                    .icon(() -> new ItemStack(
//                            RailcraftItems.STRENGTHENED_GLASS.variantFor(DyeColor.BLACK).get().getDefaultInstance()))
//                    .displayItems((params, output) -> {
//                        items.add(RailcraftItems.QUARRIED_STONE.get().getDefaultInstance());
//                        items.add(RailcraftItems.QUARRIED_COBBLESTONE.get().getDefaultInstance());
//                        items.add(RailcraftItems.POLISHED_QUARRIED_STONE.get().getDefaultInstance());
//                        items.add(RailcraftItems.CHISELED_QUARRIED_STONE.get().getDefaultInstance());
//                        items.add(RailcraftItems.ETCHED_QUARRIED_STONE.get().getDefaultInstance());
//                        items.add(RailcraftItems.QUARRIED_BRICKS.get().getDefaultInstance());
//                        items.add(RailcraftItems.QUARRIED_BRICK_STAIRS.get().getDefaultInstance());
//                        items.add(RailcraftItems.QUARRIED_BRICK_SLAB.get().getDefaultInstance());
//                        items.add(RailcraftItems.QUARRIED_PAVER.get().getDefaultInstance());
//                        items.add(RailcraftItems.QUARRIED_PAVER_STAIRS.get().getDefaultInstance());
//                        items.add(RailcraftItems.QUARRIED_PAVER_SLAB.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABYSSAL_STONE.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABYSSAL_COBBLESTONE.get().getDefaultInstance());
//                        items.add(RailcraftItems.POLISHED_ABYSSAL_STONE.get().getDefaultInstance());
//                        items.add(RailcraftItems.CHISELED_ABYSSAL_STONE.get().getDefaultInstance());
//                        items.add(RailcraftItems.ETCHED_ABYSSAL_STONE.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABYSSAL_BRICKS.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABYSSAL_BRICK_STAIRS.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABYSSAL_BRICK_SLAB.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABYSSAL_PAVER.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABYSSAL_PAVER_STAIRS.get().getDefaultInstance());
//                        items.add(RailcraftItems.ABYSSAL_PAVER_SLAB.get().getDefaultInstance());
//
//                        for (var color : DyeColor.values()) {
//                            items.add(RailcraftItems.STRENGTHENED_GLASS.variantFor(color).get().getDefaultInstance());
//                        }
//                        for (var color : DyeColor.values()) {
//                            items.add(RailcraftItems.POST.variantFor(color).get().getDefaultInstance());
//                        }
//                        for (var color : DyeColor.values()) {
//                            items.add(RailcraftItems.IRON_TANK_GAUGE.variantFor(color).get().getDefaultInstance());
//                        }
//                        for (var color : DyeColor.values()) {
//                            items.add(RailcraftItems.IRON_TANK_VALVE.variantFor(color).get().getDefaultInstance());
//                        }
//                        for (var color : DyeColor.values()) {
//                            items.add(RailcraftItems.IRON_TANK_WALL.variantFor(color).get().getDefaultInstance());
//                        }
//                        for (var color : DyeColor.values()) {
//                            items.add(RailcraftItems.STEEL_TANK_GAUGE.variantFor(color).get().getDefaultInstance());
//                        }
//                        for (var color : DyeColor.values()) {
//                            items.add(RailcraftItems.STEEL_TANK_VALVE.variantFor(color).get().getDefaultInstance());
//                        }
//                        for (var color : DyeColor.values()) {
//                            items.add(RailcraftItems.STEEL_TANK_WALL.variantFor(color).get().getDefaultInstance());
//                        }
//                    }).build());
//
//    public static void register(IEventBus modEventBus) {
//        deferredRegister.register(modEventBus);
//    }
//
//    public static void addToolsAndUtilities(
//            MutableHashedLinkedMap<ItemStack, TabVisibility> entries) {
//        entries.putAfter(
//                new ItemStack(Items.SHEARS),
//                new ItemStack(RailcraftItems.STEEL_SHEARS.get().getDefaultInstance()),
//                DEFAULT_VISIBILITY);
//        entries.putAfter(
//                new ItemStack(Items.CHEST_MINECART),
//                new ItemStack(RailcraftItems.TANK_MINECART.get().getDefaultInstance()),
//                DEFAULT_VISIBILITY);
//
//        var addAfterIronHoe = List.of(
//                Items.IRON_HOE,
//                RailcraftItems.STEEL_SHOVEL.get(),
//                RailcraftItems.STEEL_PICKAXE.get(),
//                RailcraftItems.STEEL_AXE.get(),
//                RailcraftItems.STEEL_HOE.get().getDefaultInstance());
//        var addAfterTNTMinecart = List.of(
//                Items.TNT_MINECART,
//                RailcraftItems.TRACK_LAYER.get(),
//                RailcraftItems.TRACK_RELAYER.get(),
//                RailcraftItems.TRACK_REMOVER.get(),
//                RailcraftItems.TRACK_UNDERCUTTER.get(),
//
//                RailcraftItems.TUNNEL_BORE.get(),
//                RailcraftItems.STEAM_LOCOMOTIVE.get(),
//                RailcraftItems.ELECTRIC_LOCOMOTIVE.get(),
//                RailcraftItems.CREATIVE_LOCOMOTIVE.get().getDefaultInstance());
//        var addAfterActivatorRail = List.of(
//                Items.ACTIVATOR_RAIL,
//                RailcraftItems.ABANDONED_TRACK.get(),
//                RailcraftItems.ELECTRIC_TRACK.get(),
//                RailcraftItems.HIGH_SPEED_TRACK.get(),
//                RailcraftItems.HIGH_SPEED_ELECTRIC_TRACK.get(),
//                RailcraftItems.REINFORCED_TRACK.get(),
//                RailcraftItems.STRAP_IRON_TRACK.get(),
//                RailcraftItems.ELEVATOR_TRACK.get(),
//                RailcraftItems.TRANSITION_TRACK_KIT.get(),
//                RailcraftItems.LOCKING_TRACK_KIT.get(),
//                RailcraftItems.BUFFER_STOP_TRACK_KIT.get(),
//                RailcraftItems.ACTIVATOR_TRACK_KIT.get(),
//                RailcraftItems.BOOSTER_TRACK_KIT.get(),
//                RailcraftItems.CONTROL_TRACK_KIT.get(),
//                RailcraftItems.GATED_TRACK_KIT.get(),
//                RailcraftItems.DETECTOR_TRACK_KIT.get(),
//                RailcraftItems.COUPLER_TRACK_KIT.get(),
//                RailcraftItems.EMBARKING_TRACK_KIT.get(),
//                RailcraftItems.DISEMBARKING_TRACK_KIT.get(),
//                RailcraftItems.DUMPING_TRACK_KIT.get(),
//                RailcraftItems.LAUNCHER_TRACK_KIT.get(),
//                RailcraftItems.ONE_WAY_TRACK_KIT.get(),
//                RailcraftItems.WHISTLE_TRACK_KIT.get(),
//                RailcraftItems.LOCOMOTIVE_TRACK_KIT.get(),
//                RailcraftItems.THROTTLE_TRACK_KIT.get(),
//                RailcraftItems.ROUTING_TRACK_KIT.get(),
//                RailcraftItems.SWITCH_TRACK_LEVER.get(),
//                RailcraftItems.SWITCH_TRACK_MOTOR.get(),
//                RailcraftItems.SWITCH_TRACK_ROUTER.get(),
//                RailcraftItems.ANALOG_SIGNAL_CONTROLLER_BOX.get(),
//                RailcraftItems.SIGNAL_SEQUENCER_BOX.get(),
//                RailcraftItems.SIGNAL_CAPACITOR_BOX.get(),
//                RailcraftItems.SIGNAL_INTERLOCK_BOX.get(),
//                RailcraftItems.SIGNAL_BLOCK_RELAY_BOX.get(),
//                RailcraftItems.SIGNAL_RECEIVER_BOX.get(),
//                RailcraftItems.SIGNAL_CONTROLLER_BOX.get(),
//                RailcraftItems.BLOCK_SIGNAL.get(),
//                RailcraftItems.DISTANT_SIGNAL.get(),
//                RailcraftItems.TOKEN_SIGNAL.get(),
//                RailcraftItems.DUAL_BLOCK_SIGNAL.get(),
//                RailcraftItems.DUAL_DISTANT_SIGNAL.get(),
//                RailcraftItems.DUAL_TOKEN_SIGNAL.get().getDefaultInstance());
//
//        addItemsToTab(addAfterIronHoe, entries);
//        addItemsToTab(addAfterTNTMinecart, entries);
//        addItemsToTab(addAfterActivatorRail, entries);
//    }
//
//    public static void addCombat(
//            MutableHashedLinkedMap<ItemStack, TabVisibility> entries) {
//        entries.putAfter(
//                new ItemStack(Items.IRON_SWORD),
//                new ItemStack(RailcraftItems.STEEL_SWORD.get().getDefaultInstance()),
//                DEFAULT_VISIBILITY);
//        entries.putAfter(
//                new ItemStack(Items.IRON_AXE),
//                new ItemStack(RailcraftItems.STEEL_AXE.get().getDefaultInstance()),
//                DEFAULT_VISIBILITY);
//
//        var addAfterIronBoots = List.of(
//                Items.IRON_BOOTS,
//                RailcraftItems.STEEL_HELMET.get(),
//                RailcraftItems.STEEL_CHESTPLATE.get(),
//                RailcraftItems.STEEL_LEGGINGS.get(),
//                RailcraftItems.STEEL_BOOTS.get().getDefaultInstance());
//        addItemsToTab(addAfterIronBoots, entries);
//    }
//
//    private static void addItemsToTab(List<Item> list,
//                                      MutableHashedLinkedMap<ItemStack, TabVisibility> entries) {
//        for (int i = 1; i < list.size(); i++) {
//            entries.putAfter(
//                    new ItemStack(list.get(i - 1)),
//                    new ItemStack(list.get(i)),
//                    DEFAULT_VISIBILITY);
//        }
//    }

}
