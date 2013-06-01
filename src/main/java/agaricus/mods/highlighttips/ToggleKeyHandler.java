package agaricus.mods.highlighttips;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.TickType;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

import java.util.EnumSet;

public class ToggleKeyHandler extends KeyBindingRegistry.KeyHandler {

    private boolean visible = true;
    private boolean detailed = false;

    public ToggleKeyHandler(int keyCode) {
        super(new KeyBinding[] { new KeyBinding("Highlight Tips", keyCode) }, new boolean[] { false });
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isDetailed() {
        return detailed;
    }

    @Override
    public String getLabel() {
        return "HighlightTips Toggle Key";
    }

    @Override
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
        if (!tickEnd) return;

        // shift: toggle detail
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            detailed = !detailed;
            return;
        }

        // ctrl or menu: toggle visibility
        if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL) ||
                Keyboard.isKeyDown(Keyboard.KEY_LMENU) || Keyboard.isKeyDown(Keyboard.KEY_RMENU)) {
            visible = !visible;
            return;
        }

        // normal: cycle through hidden/minimal/detailed
        if (!visible) {
            visible = true;
            detailed = false;
        } else if (!detailed) {
            detailed = true;
        } else {
            visible = false;
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
