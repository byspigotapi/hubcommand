package com.nettyexception.hubcommand.command;

import com.nettyexception.hubcommand.Launcher;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created on 28.11.2018 at 16:07 by NettyException | Sören!
 */

public class HubCommand extends Command {

    public HubCommand() {
        super("hub", null, "leave", "quit", "l", "lobby");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer proxiedPlayer = (ProxiedPlayer)commandSender;

            String premiumLobby = "Premium-Lobby-1";
            String normalLobby = "Lobby-1";

            if (proxiedPlayer.hasPermission("system.premium")) {
                proxiedPlayer.sendMessage(new ComponentBuilder(Launcher.getInstance().getPrefix()).append("Da du einen besonderen Rang besitzt, wirst du auf die ").color(ChatColor.GRAY).append("Premium-Lobby").color(ChatColor.GOLD).append(" verschoben.").color(ChatColor.GRAY).create());
                proxiedPlayer.connect(Launcher.getInstance().getProxy().getServerInfo(premiumLobby));
            }

            proxiedPlayer.sendMessage(new ComponentBuilder(Launcher.getInstance().getPrefix()).append("Du wirst auf die ").color(ChatColor.GRAY).append("Lobby").color(ChatColor.YELLOW).append(" verschoben").color(ChatColor.GRAY).create());
            proxiedPlayer.connect(Launcher.getInstance().getProxy().getServerInfo(normalLobby));

        }
    }
}
