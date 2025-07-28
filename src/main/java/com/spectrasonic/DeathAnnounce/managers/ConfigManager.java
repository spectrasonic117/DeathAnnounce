// ConfigManager.java (updated with setter)
package com.spectrasonic.DeathAnnounce.managers;

import com.spectrasonic.DeathAnnounce.Main;
import lombok.Getter;
import lombok.Setter;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


import java.io.File;
import java.io.IOException;

public class ConfigManager {
    private final Main plugin;
    private File configFile;
    private FileConfiguration config;
    
    @Getter
    private String deathMessage;
    
    @Getter
    @Setter
    private boolean deathMessagesEnabled;

    public ConfigManager(Main plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void saveDefaultConfig() {
        if (configFile == null) {
            configFile = new File(plugin.getDataFolder(), "config.yml");
        }
        if (!configFile.exists()) {
            plugin.saveResource("config.yml", false);
        }
    }

    public void loadConfig() {
        saveDefaultConfig();
        config = YamlConfiguration.loadConfiguration(configFile);
        
        deathMessage = config.getString("death-message", "<red><b>{player}</b></red> ha muerto");
        deathMessagesEnabled = config.getBoolean("death-messages-enabled", true);
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
        deathMessage = config.getString("death-message", "<red><b>{player}</b></red> ha muerto");
        deathMessagesEnabled = config.getBoolean("death-messages-enabled", true);
    }

    public void saveConfig() {
        config.set("death-messages-enabled", deathMessagesEnabled);
        try {
            config.save(configFile);
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save config.yml: " + e.getMessage());
        }
    }

    public String formatDeathMessage(String playerName) {
        return MiniMessage.miniMessage().serialize(
            MiniMessage.miniMessage().deserialize(deathMessage, 
                Placeholder.unparsed("player", playerName))
        );
    }
}
