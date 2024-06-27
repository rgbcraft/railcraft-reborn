package mods.railcraft;

import mods.railcraft.advancements.RailcraftCriteriaTriggers;
import mods.railcraft.api.carts.RollingStock;
import mods.railcraft.api.charge.Charge;
import mods.railcraft.api.core.RailcraftConstants;
import mods.railcraft.api.fuel.FuelUtil;
import mods.railcraft.charge.ChargeCartStorageImpl;
import mods.railcraft.charge.ChargeProviderImpl;
import mods.railcraft.charge.ZapEffectProviderImpl;
import mods.railcraft.client.ClientManager;
import mods.railcraft.data.*;
import mods.railcraft.data.loot.RailcraftLootModifierProvider;
import mods.railcraft.data.models.RailcraftBlockModelProvider;
import mods.railcraft.data.models.RailcraftItemModelProvider;
import mods.railcraft.data.recipes.RailcraftRecipeProvider;
import mods.railcraft.data.recipes.builders.BrewingRecipe;
import mods.railcraft.fuel.FuelManagerImpl;
import mods.railcraft.loot.RailcraftLootModifiers;
import mods.railcraft.network.NetworkChannel;
import mods.railcraft.network.RailcraftDataSerializers;
import mods.railcraft.network.play.LinkedCartsMessage;
import mods.railcraft.particle.RailcraftParticleTypes;
import mods.railcraft.sounds.RailcraftSoundEvents;
import mods.railcraft.tags.RailcraftTags;
import mods.railcraft.util.EntitySearcher;
import mods.railcraft.util.capability.CapabilityUtil;
import mods.railcraft.util.capability.FluidBottleWrapper;
import mods.railcraft.world.effect.RailcraftMobEffects;
import mods.railcraft.world.entity.RailcraftEntityTypes;
import mods.railcraft.world.entity.ai.village.poi.RailcraftPoiTypes;
import mods.railcraft.world.entity.npc.RailcraftVillagerProfession;
import mods.railcraft.world.entity.npc.RailcraftVillagerTrades;
import mods.railcraft.world.entity.vehicle.MinecartHandler;
import mods.railcraft.world.entity.vehicle.RollingStockImpl;
import mods.railcraft.world.inventory.RailcraftMenuTypes;
import mods.railcraft.world.item.ChargeMeterItem;
import mods.railcraft.world.item.CrowbarHandler;
import mods.railcraft.world.item.RailcraftItems;
import mods.railcraft.world.item.alchemy.RailcraftPotions;
import mods.railcraft.world.item.crafting.RailcraftRecipeSerializers;
import mods.railcraft.world.item.crafting.RailcraftRecipeTypes;
import mods.railcraft.world.item.enchantment.RailcraftEnchantments;
import mods.railcraft.world.level.block.RailcraftBlocks;
import mods.railcraft.world.level.block.entity.RailcraftBlockEntityTypes;
import mods.railcraft.world.level.block.track.TrackTypes;
import mods.railcraft.world.level.material.RailcraftFluidTypes;
import mods.railcraft.world.level.material.RailcraftFluids;
import mods.railcraft.world.signal.TokenRingManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

import java.io.IOException;

@Mod(RailcraftConstants.ID)
public class Railcraft {
    static {
        FuelUtil._setFuelManager(new FuelManagerImpl());
        Charge._setZapEffectProvider(new ZapEffectProviderImpl());
        for (var value : ChargeProviderImpl.values()) {
            value.getCharge()._setProvider(value);
        }
    }

    public static ResourceLocation rl(String path) {
        return RailcraftConstants.rl(path);
    }

    private final CrowbarHandler crowbarHandler = new CrowbarHandler();
    private final MinecartHandler minecartHandler = new MinecartHandler();

    public Railcraft() {
        MinecraftForge.EVENT_BUS.register(this);

        RailcraftConfig.registerConfig(ModLoadingContext.get());

        var modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::handleCommonSetup);
//    modEventBus.addListener(this::buildContents);
        modEventBus.addListener(this::handleGatherData);

        if (FMLEnvironment.dist.isClient()) {
            ClientManager.init(modEventBus);
        }

        RailcraftEntityTypes.register(modEventBus);
        RailcraftBlocks.register(modEventBus);
        RailcraftItems.register(modEventBus);
        RailcraftPotions.register(modEventBus);
        RailcraftMobEffects.register(modEventBus);
        RailcraftBlockEntityTypes.register(modEventBus);
        TrackTypes.register(modEventBus);
        RailcraftFluids.register(modEventBus);
        RailcraftFluidTypes.register(modEventBus);
        RailcraftMenuTypes.register(modEventBus);
        RailcraftSoundEvents.register(modEventBus);
        RailcraftEnchantments.register(modEventBus);
        RailcraftParticleTypes.register(modEventBus);
        RailcraftRecipeSerializers.register(modEventBus);
        RailcraftRecipeTypes.register(modEventBus);
//        RailcraftGameEvents.register(modEventBus);
        RailcraftDataSerializers.register(modEventBus);
        RailcraftPoiTypes.register(modEventBus);
        RailcraftVillagerProfession.register(modEventBus);
        RailcraftLootModifiers.register(modEventBus);
//        RailcraftStructureTypes.register(modEventBus);
//        RailcraftStructurePieces.register(modEventBus);
    }

    // Mod Events
    private void handleCommonSetup(FMLCommonSetupEvent event) {
        NetworkChannel.registerAll();

        event.enqueueWork(() -> {
            RailcraftCriteriaTriggers.register();
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Potions.AWKWARD,
                    RailcraftItems.CREOSOTE_BOTTLE.get(), RailcraftPotions.CREOSOTE.get()));
        });
        FuelUtil.fuelManager().addFuel(RailcraftTags.Fluids.CREOSOTE, 4800);
    }

//  public void buildContents(BuildCreativeModeTabContentsEvent event) {
//    if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
//      RailcraftCreativeModeTabs.addToolsAndUtilities(event.getEntries());
//    } else if (event.getTabKey() == CreativeModeTabs.COMBAT) {
//      RailcraftCreativeModeTabs.addCombat(event.getEntries());
//    }
//  }

    private void handleGatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var fileHelper = event.getExistingFileHelper();

        var blockTags = new RailcraftBlockTagsProvider(generator, fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(),
                new RailcraftItemTagsProvider(generator, blockTags, fileHelper));
        generator.addProvider(event.includeServer(),
                new RailcraftFluidTagsProvider(generator, fileHelper));
//        generator.addProvider(event.includeServer(), new RailcraftLootTableProvider(generator));
        generator.addProvider(event.includeServer(), new RailcraftRecipeProvider(generator));
        generator.addProvider(event.includeServer(),
                new RailcraftPoiTypeTagsProvider(generator, fileHelper));
        generator.addProvider(event.includeServer(), new RailcraftLootModifierProvider(generator));
        generator.addProvider(event.includeClient(),
                new RailcraftItemModelProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(),
                new RailcraftBlockModelProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new RailcraftLanguageProvider(generator));
        generator.addProvider(event.includeClient(),
                new RailcraftSoundsProvider(generator, fileHelper));
//        generator.addProvider(event.includeClient(),
//                new RailcraftSpriteSourceProvider(generator, fileHelper));
    }

    // Forge Events
    @SubscribeEvent
    public void handleServerAboutToStart(ServerAboutToStartEvent event) {
//        ComponentWorkshop.addVillageStructures(event.getServer().registryAccess());
    }

    @SubscribeEvent
    public void handleServerStarted(ServerStartedEvent event) {
        if (RailcraftConfig.SERVER.solidCarts.get()) {
            AbstractMinecart.registerCollisionHandler(this.minecartHandler);
        }
    }

    @SubscribeEvent
    public void handleAttachEntityCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof AbstractMinecart minecart) {
            event.addCapability(RollingStockImpl.KEY,
                    CapabilityUtil.serializableProvider(
                            CompoundTag::new, () -> new RollingStockImpl(minecart), RollingStock.CAPABILITY));
        }
    }

    @SubscribeEvent
    public void handleAttachItemStackCapabilities(AttachCapabilitiesEvent<ItemStack> event) {
        var stack = event.getObject();
        if (stack.is(Items.GLASS_BOTTLE)) {
            event.addCapability(Railcraft.rl("bottle_container"), new FluidBottleWrapper(stack));
        }
    }

    @SubscribeEvent
    public void handleLevelTick(TickEvent.LevelTickEvent event) {
        if (event.level instanceof ServerLevel level && event.phase == TickEvent.Phase.END) {
            for (var provider : ChargeProviderImpl.values()) {
                provider.network(level).tick();
            }
            TokenRingManager.get(level).tick(level);
        }
    }

    @SubscribeEvent
    public void handlePlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.player instanceof ServerPlayer player && player.tickCount % 20 == 0) {
            var linkedCarts = EntitySearcher.findMinecarts()
                    .around(player)
                    .inflate(32F)
                    .stream(player.getLevel())
                    .map(RollingStock::getOrThrow)
                    .map(LinkedCartsMessage.LinkedCart::new)
                    .toList();
            NetworkChannel.GAME.sendTo(new LinkedCartsMessage(linkedCarts), player);
        }
    }

    @SubscribeEvent
    public void handleEntityInteract(PlayerInteractEvent.EntityInteract event) {
        if (event.getTarget() instanceof AbstractMinecart cart) {
            var player = event.getEntity();
            var hand = event.getHand();
            var stack = event.getItemStack();

            if (!stack.isEmpty() && stack.is(RailcraftItems.CHARGE_METER.get())) {
                player.swing(hand);
                if (!player.getLevel().isClientSide()) {
                    cart.getCapability(ForgeCapabilities.ENERGY)
                            .filter(ChargeCartStorageImpl.class::isInstance)
                            .map(ChargeCartStorageImpl.class::cast)
                            .ifPresent(battery -> {
                                ChargeMeterItem.sendChat(player, Translations.ChargeMeter.CART,
                                        battery.getEnergyStored(), battery.getDraw(), battery.getLosses());
                                event.setCanceled(true);
                                event.setCancellationResult(InteractionResult.SUCCESS);
                            });
                }
            } else {
                event.setCanceled(this.minecartHandler.handleInteract(cart, player));
                var crowbarActionResult = this.crowbarHandler.handleInteract(cart, player, hand);
                if (crowbarActionResult.consumesAction()) {
                    event.setCanceled(true);
                    event.setCancellationResult(crowbarActionResult);
                }
            }
        }
    }

    @SubscribeEvent
    public void handleEntityLeaveWorld(EntityLeaveLevelEvent event) {
        if (event.getEntity() instanceof AbstractMinecart cart
                && !cart.getLevel().isClientSide() && cart.isRemoved()) {
            RollingStock.getOrThrow(cart).removed(cart.getRemovalReason());
        }
    }

    @SubscribeEvent
    public void modifyDrops(LivingDropsEvent event) {
        var level = event.getEntity().getLevel();
        var registryAccess = level.registryAccess();
//        if (event.getSource().equals(RailcraftDamageSources.steam(registryAccess))) {
//            var recipeManager = level.getRecipeManager();
//            for (var entityItem : event.getDrops()) {
//                var drop = entityItem.getItem();
//                var cooked = recipeManager
//                        .getRecipeFor(RecipeType.SMELTING, new SimpleContainer(drop), level)
//                        .map(AbstractCookingRecipe::getResultItem)
//                        .orElse(ItemStack.EMPTY);
//                if (!cooked.isEmpty() && level.getRandom().nextBoolean()) {
//                    entityItem.setItem(new ItemStack(cooked.getItem(), drop.getCount()));
//                }
//            }
//        }
    }

    @SubscribeEvent
    public void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == RailcraftVillagerProfession.TRACKMAN.get()) {
            RailcraftVillagerTrades.addTradeForTrackman(event.getTrades());
        } else if (event.getType() == RailcraftVillagerProfession.CARTMAN.get()) {
            RailcraftVillagerTrades.addTradeForCartman(event.getTrades());
        } else if (event.getType() == VillagerProfession.ARMORER) {
            RailcraftVillagerTrades.addTradeForArmorer(event.getTrades());
        } else if (event.getType() == VillagerProfession.TOOLSMITH) {
            RailcraftVillagerTrades.addTradeForToolSmith(event.getTrades());
        }
    }

    @SubscribeEvent
    public void handleNeighborNotify(BlockEvent.NeighborNotifyEvent event) {
//        event.getLevel().gameEvent(null, RailcraftGameEvents.NEIGHBOR_NOTIFY.get(), event.getPos());
    }
}
