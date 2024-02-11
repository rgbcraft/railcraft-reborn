package mods.railcraft.data;

import mods.railcraft.api.core.RailcraftConstants;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RailcraftSpriteSourceProvider extends SpriteSourceProvider {
    public RailcraftSpriteSourceProvider(PackOutput output, ExistingFileHelper fileHelper) {
        super(output, fileHelper, RailcraftConstants.ID);
    }

    @Override
    protected void addSources() {
        atlas(SpriteSourceProvider.BLOCKS_ATLAS)
                .addSource(new DirectoryLister("entity/signal_aspect", "entity/signal_aspect/"))
                .addSource(new DirectoryLister("entity/signal_box_aspect", "entity/signal_box_aspect/"))
                .addSource(new DirectoryLister("entity/signal_box", "entity/signal_box/"))
                .addSource(new DirectoryLister("entity/fluid_manipulator", "entity/fluid_manipulator/"))
                .addSource(new DirectoryLister("entity/fluid_loader", "entity/fluid_loader/"));
    }
}
