# Melicia Performance Mod

A full performance optimization mod for Minecraft 1.20.1 (Forge).

Disables all non-essential game features by default to maximize FPS on low-end hardware. Every option is configurable **in-game** via the Mods menu config screen.

## Features

### General
- **Disable Tutorial** — silence tutorial hints
- **Disable Advancement Toasts** — remove popup notifications
- **Disable Statistics** — stop tracking stats
- **Disable Recipe Book** — remove recipe book GUI
- **Disable Death Screen** — skip death overlay

### Graphics (biggest FPS impact)
- **Disable All Particles** — suppress every particle effect
- **Disable Block Break Particles**
- **Disable Enchantment Glint** — remove shimmer effect
- **Disable Block / Item Animations**
- **Disable Rain / Snow**
- **Disable Fog** — push fog far away
- **Disable Boss Bar / Scoreboard**
- **Disable Overlays** — fire, pumpkin, portal vignette
- **Disable Render** — armor stands, item frames, paintings, dropped items, XP orbs

### Sound
- **Mute All Sounds** — or selectively: weather, blocks, entities, ambient

### Entities
- **Disable Entity AI** — makes mobs stand still (server-friendly)

### World
- **Fast Leaf Decay** — leaves vanish instantly when you chop a tree
- **Disable Random Ticks** — stop crop growth, grass spread, etc.

## Build

```bash
./gradlew build
```

JAR will be at `build/libs/melicia-1.0.0.jar`. Copy it into your Minecraft `mods/` folder.

## Requirements

- Minecraft 1.20.1
- Forge 47.3.0+
- Java 17
