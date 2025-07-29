package com.spectrasonic.DeathAnnounce.commands;

import com.spectrasonic.DeathAnnounce.Main;
import com.spectrasonic.Utils.MessageUtils;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.command.CommandSender;

@CommandAlias("deathannounce|da")
@CommandPermission("deathannounce.admin")
public class DeathAnnounceCommand extends BaseCommand {

    private final Main plugin;

    public DeathAnnounceCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Subcommand("reload")
    public void onReload(CommandSender sender) {
        plugin.getConfigManager().reloadConfig();
        MessageUtils.sendMessage(sender, "<green>DeathAnnounce config reloaded successfully!</green>");
    }

    @Subcommand("toggle")
    @CommandCompletion("onoff")
    public void onToggle(CommandSender sender, String state) {
        boolean enabled = state.equalsIgnoreCase("on");
        plugin.getConfigManager().setDeathMessagesEnabled(enabled);
        MessageUtils.sendMessage(sender, "<green>Death messages " + (enabled ? "enabled" : "disabled") + "!</green>");
    }
}
