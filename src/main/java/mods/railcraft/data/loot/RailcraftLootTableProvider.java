package mods.railcraft.data.loot;

import java.util.List;
import java.util.Map;

import mods.railcraft.data.loot.packs.RailcraftBlockLoot;
import mods.railcraft.data.loot.packs.RailcraftChestLoot;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class RailcraftLootTableProvider extends LootTableProvider {

    public RailcraftLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    public List<LootTableProvider.SubProviderEntry> getTables() {
        return List.of(
                new LootTableProvider.SubProviderEntry(RailcraftBlockLoot::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(RailcraftChestLoot::new, LootContextParamSets.CHEST));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map,
                            ValidationContext validationcontext) {
        map.forEach((location, lootTable) ->
                lootTable.validate(validationcontext
                        .setParams(lootTable.getParamSet())
                        .enterElement("{" + location + "}", new LootDataId<>(LootDataType.TABLE, location))));
    }
}
