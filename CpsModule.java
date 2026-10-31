package dev.nexus.module.impl;

import dev.nexus.module.Module;
import dev.nexus.module.ModuleCategory;

public final class CpsModule extends Module {
    public CpsModule() {
        super("CPS Counter", "Displays left and right clicks per second.", ModuleCategory.HUD);
    }
}
