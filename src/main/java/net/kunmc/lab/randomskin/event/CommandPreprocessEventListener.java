package net.kunmc.lab.randomskin.event;

import net.kunmc.lab.randomskin.RandomSkin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CommandPreprocessEventListener implements Listener {

    @EventHandler
    public void on(org.bukkit.event.player.PlayerCommandPreprocessEvent e){
        if(RandomSkin.rm.enabled){
            // 返り値置き換えようと思ったけどむりそ＾＾；
        }
    }
}
