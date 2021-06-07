package net.kunmc.lab.randomskin.event;

import net.kunmc.lab.randomskin.Kei;
import net.kunmc.lab.randomskin.RandomSkin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.haoshoku.nick.api.NickAPI;

public class AsyncChatEventListener implements Listener {

    @EventHandler
    public void on(AsyncPlayerChatEvent e){
        if(RandomSkin.rm.enabled){
            if(NickAPI.isNicked(e.getPlayer())){
                String s = NickAPI.getName(e.getPlayer());
                e.setCancelled(true);
                Kei.bc("<" + s + "> " + e.getMessage());
            }
        }
    }
}
