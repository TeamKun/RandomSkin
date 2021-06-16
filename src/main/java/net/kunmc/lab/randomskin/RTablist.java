package net.kunmc.lab.randomskin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.haoshoku.nick.api.NickAPI;

import java.util.*;

public class RTablist {

    static Map<String, PlayerList> listcache;

    RTablist() {
        listcache = new HashMap<>();
    }

    public static void update() {
        List<String> cache = new ArrayList<>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            cache.add(NickAPI.getGameProfileName(p));
        }
        Collections.sort(cache);
        for(PlayerList ls : listcache.values()){
            ls.clearAll();
            ls = null;
        }
        listcache.clear();
        for (Player p : Bukkit.getOnlinePlayers()) {
            PlayerList list;
            if (cache.size() < 21) {
                list = new PlayerList(p, PlayerList.SIZE_DEFAULT);
            } else if (cache.size() < 41) {
                list = new PlayerList(p, PlayerList.SIZE_TWO);
            } else if (cache.size() < 61) {
                list = new PlayerList(p, PlayerList.SIZE_THREE);
            } else {
                list = new PlayerList(p, PlayerList.SIZE_FOUR);
            }
            listcache.put(NickAPI.getOriginalGameProfileName(p), list);
            list.initTable();
            list.clearPlayers();
            for (int i = 0; i < cache.size(); i++) {
                if (i >= 80) break;
                list.updateSlot(i, cache.get(i), true);
            }
        }

    }
}
