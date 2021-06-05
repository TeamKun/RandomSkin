package net.kunmc.lab.randomskin

import net.kunmc.lab.randomskin.cmd.MainCommandExecutor
import net.kunmc.lab.randomskin.event.JoinEventListener
import net.kunmc.lab.randomskin.event.QuitEventListener
import org.bukkit.plugin.java.JavaPlugin

infix fun org.bukkit.event.Listener.register(plugin: org.bukkit.plugin.java.JavaPlugin): Unit{
    plugin.server.pluginManager.registerEvents(this, plugin);
}

fun org.bukkit.command.CommandExecutor.register(plugin: org.bukkit.plugin.java.JavaPlugin, str: String): Unit{
    plugin.getCommand(str)?.setExecutor(this);
}

class RandomSkin : JavaPlugin() {

    override fun onEnable() {
        JoinEventListener().register(this);
        QuitEventListener().register(this);
        MainCommandExecutor().register(this, "rs");
    }
}