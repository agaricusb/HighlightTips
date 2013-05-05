package agaricus.mods.highlighttips;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.TickType;
import net.minecraft.client.settings.KeyBinding;

import java.util.EnumSet;

public class ToggleKeyHandler extends KeyBindingRegistry.KeyHandler {

    public boolean showInfo = true;

    public ToggleKeyHandler(int keyCode) {
        super(new KeyBinding[] { new KeyBinding("Highlight Tips", keyCode) }, new boolean[] { false });
    }

    @Override
    public String getLabel() {
        return "HighlightTips Toggle Key";
    }

    @Override
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
        if (!tickEnd) return;

        showInfo = !showInfo;
    }

    @Override
    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {

    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT);
    }
}
