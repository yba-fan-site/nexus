package dev.nexus.module.impl;

import dev.nexus.module.Module;
import dev.nexus.module.ModuleCategory;

public final class KeystrokesModule extends Module {
    public KeystrokesModule() {
        super("Keystrokes", "Displays movement keys and mouse clicks.", ModuleCategory.HUD);
    }
}
