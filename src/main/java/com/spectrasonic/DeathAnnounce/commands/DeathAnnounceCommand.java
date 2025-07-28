package com.spectrasonic.DeathAnnounce.commands;

import com.spectrasonic.DeathAnnounce.Main;
import com.spectrasonic.Utils.MessageUtils;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.MultiLiteralArgument;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeathAnnounceCommand {
    private final Main plugin;

    public CommandAPICommand build() {
        return new CommandAPICommand("deathannounce")
            .withAliases("da")
            .withPermission("deathannounce.admin")
            .withSubcommand(
                new CommandAPICommand("reload")
                    .executes((sender, args) -> {
                        plugin.getConfigManager().reloadConfig();
                        MessageUtils.sendMessage(sender, "<green>DeathAnnounce config reloaded successfully!</green>");
                    })
            )
            .withSubcommand(
                new CommandAPICommand("toggle")
                    .withArguments(new MultiLiteralArgument("state", "on", "off"))
                    .executes((sender, args) -> {
                        String state = (String) args.get(0);
                                    boolean enabled = state.equalsIgnoreCase("on");
                        
                        plugin.getConfigManager().setDeathMessagesEnabled(enabled);
                        MessageUtils.sendMessage(sender, "<green>Death messages " + (enabled ? "enabled" : "disabled") + "!</green>");
                    })
            );
    }
}
