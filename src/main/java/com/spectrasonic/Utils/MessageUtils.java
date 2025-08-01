package com.spectrasonic.Utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import net.kyori.adventure.title.Title.Times;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.time.Duration;

public final class MessageUtils {

    private static final JavaPlugin plugin = JavaPlugin.getProvidingPlugin(MessageUtils.class);
    public static final String DIVIDER = "<gray>----------------------------------------</gray>";
    public static final String PREFIX = "<gray>[<gold>"+ plugin.getPluginMeta().getName()+"</gold>]</gray> <gold>»</gold> ";

    private static final MiniMessage miniMessage = MiniMessage.miniMessage();

    private MessageUtils() {
        // Private constructor to prevent instantiation
    }

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(miniMessage.deserialize(PREFIX + message));
    }

    public static void sendConsoleMessage(String message) {
        Bukkit.getConsoleSender().sendMessage(miniMessage.deserialize(PREFIX + message));
    }

    public static void sendPermissionMessage(CommandSender sender) {
        sender.sendMessage(miniMessage.deserialize(PREFIX + "<red>You do not have permission to use this command!</red>"));
    }

    public static void sendStartupMessage(JavaPlugin plugin) {
        String[] messages = {
                DIVIDER,
                PREFIX + "<white>" + plugin.getPluginMeta().getName() + "</white> <green>Plugin Enabled!</green>",
                PREFIX + "<light_purple>Version: </light_purple>" + plugin.getPluginMeta().getVersion(),
                PREFIX + "<white>Developed by: </white><red>" + plugin.getPluginMeta().getAuthors() + "</red>",
                DIVIDER
        };

        for (String message : messages) {
            Bukkit.getConsoleSender().sendMessage(miniMessage.deserialize(message));
        }
    }

    public static void sendVeiMessage(JavaPlugin plugin) {
        String[] messages = {
                PREFIX + "⣇⣿⠘⣿⣿⣿⡿⡿⣟⣟⢟⢟⢝⠵⡝⣿⡿⢂⣼⣿⣷⣌⠩⡫⡻⣝⠹⢿⣿⣷",
                PREFIX + "⡆⣿⣆⠱⣝⡵⣝⢅⠙⣿⢕⢕⢕⢕⢝⣥⢒⠅⣿⣿⣿⡿⣳⣌⠪⡪⣡⢑⢝⣇",
                PREFIX + "⡆⣿⣿⣦⠹⣳⣳⣕⢅⠈⢗⢕⢕⢕⢕⢕⢈⢆⠟⠋⠉⠁⠉⠉⠁⠈⠼⢐⢕⢽",
                PREFIX + "⡗⢰⣶⣶⣦⣝⢝⢕⢕⠅⡆⢕⢕⢕⢕⢕⣴⠏⣠⡶⠛⡉⡉⡛⢶⣦⡀⠐⣕⢕",
                PREFIX + "⡝⡄⢻⢟⣿⣿⣷⣕⣕⣅⣿⣔⣕⣵⣵⣿⣿⢠⣿⢠⣮⡈⣌⠨⠅⠹⣷⡀⢱⢕",
                PREFIX + "⡝⡵⠟⠈⢀⣀⣀⡀⠉⢿⣿⣿⣿⣿⣿⣿⣿⣼⣿⢈⡋⠴⢿⡟⣡⡇⣿⡇⡀⢕",
                PREFIX + "⡝⠁⣠⣾⠟⡉⡉⡉⠻⣦⣻⣿⣿⣿⣿⣿⣿⣿⣿⣧⠸⣿⣦⣥⣿⡇⡿⣰⢗⢄",
                PREFIX + "⠁⢰⣿⡏⣴⣌⠈⣌⠡⠈⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣬⣉⣉⣁⣄⢖⢕⢕⢕",
                PREFIX + "⡀⢻⣿⡇⢙⠁⠴⢿⡟⣡⡆⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣵⣵⣿",
                PREFIX + "⡻⣄⣻⣿⣌⠘⢿⣷⣥⣿⠇⣿⣿⣿⣿⣿⣿⠛⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿",
                PREFIX + "⣷⢄⠻⣿⣟⠿⠦⠍⠉⣡⣾⣿⣿⣿⣿⣿⣿⢸⣿⣦⠙⣿⣿⣿⣿⣿⣿⣿⣿⠟",
                PREFIX + "⡕⡑⣑⣈⣻⢗⢟⢞⢝⣻⣿⣿⣿⣿⣿⣿⣿⠸⣿⠿⠃⣿⣿⣿⣿⣿⣿⡿⠁⣠",
                PREFIX + "⡝⡵⡈⢟⢕⢕⢕⢕⣵⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣿⣿⣿⣿⣿⠿⠋⣀⣈⠙",
                PREFIX + "⡝⡵⡕⡀⠑⠳⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⢉⡠⡲⡫⡪⡪⡣",
        };

        for (String message : messages) {
            Bukkit.getConsoleSender().sendMessage(miniMessage.deserialize(message));
        }
    }

    public static void sendBroadcastMessage(String message) {
        Bukkit.getOnlinePlayers().forEach(player -> 
            player.sendMessage(miniMessage.deserialize(message))
        );
    }

    public static void sendShutdownMessage(JavaPlugin plugin) {
        String[] messages = {
                DIVIDER,
                PREFIX + "<red>" + plugin.getPluginMeta().getName() + " plugin Disabled!</red>",
                DIVIDER
        };

        for (String message : messages) {
            Bukkit.getConsoleSender().sendMessage(miniMessage.deserialize(message));
        }
    }

    public static void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        final Component titleComponent = miniMessage.deserialize(title);
        final Component subtitleComponent = miniMessage.deserialize(subtitle);
        player.showTitle(Title.title(titleComponent, subtitleComponent, Times.times(
            Duration.ofSeconds(fadeIn),
            Duration.ofSeconds(stay),
            Duration.ofSeconds(fadeOut)
        )));
    }

    public static void sendActionBar(Player player, String message) {
        player.sendActionBar(miniMessage.deserialize(message));
    }

    public static void broadcastTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        final Component titleComponent = miniMessage.deserialize(title);
        final Component subtitleComponent = miniMessage.deserialize(subtitle);
        final Title formattedTitle = Title.title(titleComponent, subtitleComponent, Times.times(
            Duration.ofSeconds(fadeIn),
            Duration.ofSeconds(stay),
            Duration.ofSeconds(fadeOut)
        ));

        Bukkit.getOnlinePlayers().forEach(player -> player.showTitle(formattedTitle));
    }

        // Uso - Send Title to players
        // MiniMessageUtils.sendTitle(player, 
        //     "<gold>¡Alerta!</gold>", 
        //     "<red>Mensaje importante</red>", 
        //     2, 40, 2
        // );

    public static void broadcastActionBar(Component message) {
        Bukkit.getOnlinePlayers().forEach(player -> player.sendActionBar(message));
    }

    // Uso Broadcast ActionBAR
    // MiniMessageUtils.broadcastActionBar("<yellow>¡Evento e…special activado!</yellow>");

}
