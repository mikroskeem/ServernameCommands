/*
 * Copyright (c) 2018 Mark Vainomaa
 *
 * This source code is proprietary software and must not be distributed and/or copied without the express permission of Mark Vainomaa
 */

package eu.mikroskeem.servernamecommands;

import net.md_5.bungee.api.event.ProxyReloadEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public final class ServernameCommands extends Plugin implements Listener {
    @Override
    public void onEnable() {
        setupCommands();
    }

    @EventHandler
    public void on(ProxyReloadEvent event) {
        setupCommands();
    }

    private void setupCommands() {
        getProxy().getPluginManager().unregisterCommands(this);
        getProxy().getServers().forEach((name, server) -> {
            getProxy().getPluginManager().registerCommand(this, new ServerCommand(server));
        });
    }
}
