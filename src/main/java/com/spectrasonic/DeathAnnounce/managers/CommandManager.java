package com.spectrasonic.DeathAnnounce.managers;

import com.spectrasonic.DeathAnnounce.Main;
import com.spectrasonic.DeathAnnounce.commands.DeathAnnounceCommand;

public class CommandManager {

    private final Main plugin;

    public CommandManager(Main plugin) {
        this.plugin = plugin;
        registerCommands();
    }

    private void registerCommands() {
        new DeathAnnounceCommand(plugin).build().register();
    }
}
