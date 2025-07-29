// EventManager.java
package com.spectrasonic.DeathAnnounce.managers;

import com.spectrasonic.DeathAnnounce.Main;
import com.spectrasonic.Utils.MessageUtils;
import com.spectrasonic.Utils.SoundUtils;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EventManager implements Listener {
    
    private final Main plugin;

    public EventManager(Main plugin) {
        this.plugin = plugin;
        registerEvents();
    }

    private void registerEvents() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (!plugin.getConfigManager().isDeathMessagesEnabled()) {
            event.setDeathMessage(null);
            return;
        }

        String playerName = event.getPlayer().getName();
        String message = plugin.getConfigManager().formatDeathMessage(playerName);
        
        event.setDeathMessage(null);
        
        MessageUtils.broadcastActionBar(message);
        SoundUtils.broadcastPlayerSound(Sound.BLOCK_BEACON_DEACTIVATE, 1.0f, 1.0f);
    }
}
