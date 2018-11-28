package com.nettyexception.hubcommand;

import com.nettyexception.hubcommand.command.HubCommand;
import jdk.nashorn.internal.objects.annotations.Getter;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

/**
 * Created on 28.11.2018 at 16:02 by NettyException | Sören!
 */

public class Launcher extends Plugin {

    private static Launcher instance;
    private String prefix = "§8[§3Lobby§8] §7";

    @Getter
    public static Launcher getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        this.initCommand();

        this.getLogger().info("Plugin successfully enable");
        this.getLogger().info("Coded by NettyException");
        this.getLogger().info(">> HubCommand");
    }

    private void initCommand() {
        PluginManager pluginManager = this.getProxy().getPluginManager();
        pluginManager.registerCommand(this, new HubCommand());
    }

    @Override
    public void onDisable() {
        instance = null;
        this.getLogger().info("Plugin successfully disable");
        this.getLogger().info("Coded by NettyException");
        this.getLogger().info(">> HubCommand");
    }

    @Getter
    public String getPrefix() {
        return prefix;
    }
}
