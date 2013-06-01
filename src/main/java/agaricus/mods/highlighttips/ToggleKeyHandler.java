package agaricus.mods.highlighttips;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.TickType;
import net.minecraft.client.settings.KeyBinding;

import java.util.EnumSet;

public class ToggleKeyHandler extends KeyBindingRegistry.KeyHandler {

    enum DetailLevel {
        HIDDEN,
        MINIMAL,
        DETAILED,
    };

    private DetailLevel detailLevel = DetailLevel.MINIMAL;

    public ToggleKeyHandler(int keyCode) {
        super(new KeyBinding[] { new KeyBinding("Highlight Tips", keyCode) }, new boolean[] { false });
    }

    public boolean isVisible() {
        return detailLevel != DetailLevel.HIDDEN;
    }

    @Override
    public String getLabel() {
        return "HighlightTips Toggle Key";
    }

    @Override
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
        if (!tickEnd) return;

        switch (detailLevel) {
            case HIDDEN:
                detailLevel = DetailLevel.MINIMAL;
                break;
            default:
            case MINIMAL:
                detailLevel = DetailLevel.DETAILED;
                break;
            case DETAILED:
                detailLevel = DetailLevel.HIDDEN;
                break;
        }
    }

    @Override
    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {

    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT);
    }
}
