package dev.nexus.module;

public enum ModuleCategory {
    VISUALS("Visuals"),
    HUD("HUD"),
    RENDER("Render"),
    SETTINGS("Settings");

    private final String displayName;

    ModuleCategory(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }
}
