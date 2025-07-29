package com.spectrasonic.DeathAnnounce;

import com.spectrasonic.DeathAnnounce.managers.CommandManager;
import com.spectrasonic.DeathAnnounce.managers.ConfigManager;
import com.spectrasonic.DeathAnnounce.managers.EventManager;
import com.spectrasonic.Utils.MessageUtils;
import com.spectrasonic.Utils.CommandUtils;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Main extends JavaPlugin {

    private ConfigManager configManager;
    private CommandManager commandManager;
    private EventManager eventManager;

    @Override
    public void onEnable() {

        this.commandManager = new CommandManager(this);
        this.configManager = new ConfigManager(this);
        this.eventManager = new EventManager(this);
        
        
        CommandUtils.setPlugin(this);
        MessageUtils.sendStartupMessage(this);
    }

    @Override
    public void onDisable() {
        this.commandManager.unregisterCommands();
        MessageUtils.sendShutdownMessage(this);
    }

}
