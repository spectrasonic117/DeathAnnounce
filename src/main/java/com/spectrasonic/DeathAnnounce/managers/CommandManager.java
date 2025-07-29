package com.spectrasonic.DeathAnnounce.managers;

import co.aikar.commands.PaperCommandManager;
import com.spectrasonic.DeathAnnounce.Main;
import com.spectrasonic.DeathAnnounce.commands.DeathAnnounceCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandManager {
    private final Main plugin;
    private PaperCommandManager commandManager;

    public void registerCommands() {
        commandManager = new PaperCommandManager(plugin);
        commandManager.registerCommand(new DeathAnnounceCommand(plugin));
    }

    public void unregisterCommands() {
        if (commandManager != null) {
            commandManager.unregisterCommands();
        }
    }
}
