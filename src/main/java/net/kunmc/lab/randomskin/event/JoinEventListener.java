package net.kunmc.lab.randomskin.event;

import net.kunmc.lab.randomskin.RandomSkin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEventListener implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(RandomSkin.rm)
    }
}
