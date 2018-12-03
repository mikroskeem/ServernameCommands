/*
 * Copyright (c) 2018 Mark Vainomaa
 *
 * This source code is proprietary software and must not be distributed and/or copied without the express permission of Mark Vainomaa
 */

package eu.mikroskeem.servernamecommands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * @author mark
 */
public final class ServerCommand extends Command {
    private final ServerInfo serverInfo;

    public ServerCommand(ServerInfo serverInfo) {
        super(serverInfo.getName(), "bungeecord.server." + serverInfo.getName());
        this.serverInfo = serverInfo;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ((ProxiedPlayer) sender).connect(serverInfo);
        } else {
            sender.sendMessage(TextComponent.fromLegacyText("This command can be only executed by player", ChatColor.RED));
        }
    }
}
