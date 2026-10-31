package dev.nexus.gui;

import dev.nexus.module.Module;
import dev.nexus.module.ModuleCategory;
import dev.nexus.module.ModuleManager;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public final class ClickGuiScreen extends Screen {
    private static final int PURPLE = 0xFF9B5CFF;
    private static final int PANEL = 0xF0181720;
    private static final int CARD = 0xFF24212D;
    private ModuleCategory selectedCategory = ModuleCategory.VISUALS;

    public ClickGuiScreen() {
        super(Text.literal("NEXUS"));
    }

    @Override
    protected void init() {
        rebuildButtons();
    }

    private void rebuildButtons() {
        clearChildren();
        int left = this.width / 2 - 165;
        int top = this.height / 2 - 112;

        int tabY = top + 43;
        int index = 0;
        for (ModuleCategory category : ModuleCategory.values()) {
            final ModuleCategory chosen = category;
            this.addDrawableChild(ButtonWidget.builder(
                    Text.literal((category == selectedCategory ? "» " : "") + category.displayName()),
                    button -> {
                        selectedCategory = chosen;
                        rebuildButtons();
                    }).dimensions(left + 12, tabY + index * 29, 112, 23).build());
            index++;
        }

        int row = 0;
        for (Module module : ModuleManager.getModules(selectedCategory)) {
            final Module selected = module;
            String state = module.isEnabled() ? "ON" : "OFF";
            this.addDrawableChild(ButtonWidget.builder(
                    Text.literal(module.getName() + "  [" + state + "]"),
                    button -> {
                        selected.toggle();
                        rebuildButtons();
                    }).dimensions(left + 142, top + 44 + row * 30, 176, 24).build());
            row++;
        }

        this.addDrawableChild(ButtonWidget.builder(Text.literal("Close"), button -> this.close())
                .dimensions(left + 220, top + 181, 98, 22).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);

        int left = this.width / 2 - 165;
        int top = this.height / 2 - 112;

        context.fill(left, top, left + 330, top + 224, PANEL);
        context.fill(left, top, left + 330, top + 3, PURPLE);
        context.fill(left + 132, top + 38, left + 134, top + 174, 0xFF494253);

        context.drawText(this.textRenderer, "N E X U S", left + 14, top + 12, 0xFFFFFFFF, false);
        context.drawText(this.textRenderer, "CLIENT  /  MODULES", left + 14, top + 26, PURPLE, false);
        context.drawText(this.textRenderer, selectedCategory.displayName().toUpperCase(), left + 145, top + 27, 0xFFFFFFFF, false);

        int enabled = (int) ModuleManager.getModules().stream().filter(Module::isEnabled).count();
        context.drawText(this.textRenderer, "ENABLED: " + enabled, left + 145, top + 174, 0xFFB8B2C4, false);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
