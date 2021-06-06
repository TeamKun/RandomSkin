package net.kunmc.lab.randomskin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.inventivetalent.nicknamer.api.NickNamerAPI;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RandomManager {

    Map<UUID, String> players;
    List<String> namelist;

    RandomSkin plugin;
    int c = 0;

    public RandomManager(RandomSkin rs){
        plugin = rs;
        players = new HashMap<>();
        namelist = new ArrayList<>();
    }

    public void reloadName(){
        namelist = Kei.a(new File(plugin.getDataFolder() + File.separator + "name.txt"));
        Kei.out("loaded names: " + namelist.size());
    }

    public void shuffle(){
        reloadName();
        c = 0;
        Collections.shuffle(namelist);
        for(Player p : Bukkit.getOnlinePlayers()){
            players.put(p.getUniqueId(), namelist.get(c));
            setDummy(p, players.get(p.getUniqueId()));
            c+=1;
        }
    }

    public void setDummy(Player p, String target){
        NickNamerAPI.getNickManager().setNick(p.getUniqueId(), target);
        NickNamerAPI.getNickManager().setSkin(p.getUniqueId(), target);
    }
}
