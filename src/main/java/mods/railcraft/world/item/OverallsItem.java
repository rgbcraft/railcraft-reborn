package mods.railcraft.world.item;

import java.util.List;

import net.minecraft.world.entity.EquipmentSlot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import mods.railcraft.Translations.Tips;
import mods.railcraft.api.charge.ChargeProtectionItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class OverallsItem extends ArmorItem implements ChargeProtectionItem {

    public OverallsItem(Properties properties) {
        super(RailcraftArmorMaterial.OVERALLS, EquipmentSlot.LEGS, properties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level,
                                @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        tooltipComponents.add(Component.translatable(Tips.OVERALLS).withStyle(ChatFormatting.GRAY));
    }
}
