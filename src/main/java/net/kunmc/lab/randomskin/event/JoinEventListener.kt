package net.kunmc.lab.randomskin.event

import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class JoinEventListener: Listener {

    @EventHandler
    fun on(e: PlayerJoinEvent){
        if(e.player.gameMode == GameMode.CREATIVE){
            return
        }
    }

}
