package com.spectrasonic.DeathAnnounce.managers;

import com.spectrasonic.DeathAnnounce.Main;
import com.spectrasonic.DeathAnnounce.commands.DeathAnnounceCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandManager {
    private final Main plugin;

    {
        registerCommands();
    }

    private void registerCommands() {
        new DeathAnnounceCommand(plugin).build().register();
    }
}
