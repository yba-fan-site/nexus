# NEXUS Client — v0.2 starter

Client-side Fabric mod scaffold for Minecraft **1.21.11**.

## Requirements
- JDK 21
- IntelliJ IDEA (recommended)
- Fabric Loader and Fabric API for Minecraft 1.21.11
- Internet access on the first Gradle sync/build

## Open and build
1. Extract this archive.
2. Open the `NEXUS` folder in IntelliJ IDEA as a Gradle project.
3. Set the Gradle JVM to JDK 21.
4. Wait for Gradle sync.
5. Run the Gradle task `build`.
6. The mod JAR will be in `build/libs/`.

## Controls
- Right Shift: open the NEXUS menu
- Click category tabs to switch categories
- Click a module row to toggle it
- Close button or Escape: close the menu

## Current modules
- Target ESP — registered toggle placeholder; render implementation is next.
- Keystrokes — registered toggle placeholder; HUD implementation is next.
- CPS Counter — registered toggle placeholder; click tracking/HUD implementation is next.

The module framework and GUI toggles are implemented. ESP rendering, HUD rendering,
settings persistence, draggable HUD editor, and animation polish are still planned.
