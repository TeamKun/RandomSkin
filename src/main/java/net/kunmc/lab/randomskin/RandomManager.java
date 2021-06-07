package net.kunmc.lab.randomskin;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import xyz.haoshoku.nick.api.NickAPI;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class RandomManager {

    private static class cc {
        private static org.bukkit.ChatColor red = org.bukkit.ChatColor.RED;
        private static org.bukkit.ChatColor black = org.bukkit.ChatColor.BLACK;
        private static org.bukkit.ChatColor blue = org.bukkit.ChatColor.BLUE;
        private static org.bukkit.ChatColor yellow = org.bukkit.ChatColor.YELLOW;
        private static org.bukkit.ChatColor pink = org.bukkit.ChatColor.LIGHT_PURPLE;
        private static org.bukkit.ChatColor purple = org.bukkit.ChatColor.DARK_PURPLE;
        private static org.bukkit.ChatColor lime = org.bukkit.ChatColor.GREEN;
        private static org.bukkit.ChatColor green = org.bukkit.ChatColor.DARK_GREEN;
        private static org.bukkit.ChatColor aqua = org.bukkit.ChatColor.AQUA;
        private static org.bukkit.ChatColor bold = org.bukkit.ChatColor.BOLD;
        private static org.bukkit.ChatColor graydark = org.bukkit.ChatColor.DARK_GRAY;
        private static org.bukkit.ChatColor gray = org.bukkit.ChatColor.GRAY;
        private static org.bukkit.ChatColor gold = org.bukkit.ChatColor.GOLD;
        private static org.bukkit.ChatColor white = org.bukkit.ChatColor.WHITE;
        private static org.bukkit.ChatColor italic = org.bukkit.ChatColor.ITALIC;
        private static org.bukkit.ChatColor strike = org.bukkit.ChatColor.STRIKETHROUGH;
        private static org.bukkit.ChatColor under = org.bukkit.ChatColor.UNDERLINE;
        private static org.bukkit.ChatColor bluedark = org.bukkit.ChatColor.DARK_BLUE;
        private static org.bukkit.ChatColor reddark = org.bukkit.ChatColor.DARK_RED;
        private static org.bukkit.ChatColor magic = org.bukkit.ChatColor.MAGIC;
    }

    private static class gm {
        private static org.bukkit.GameMode g0 = org.bukkit.GameMode.SURVIVAL;
        private static org.bukkit.GameMode g1 = org.bukkit.GameMode.CREATIVE;
        private static org.bukkit.GameMode g2 = org.bukkit.GameMode.ADVENTURE;
        private static org.bukkit.GameMode g3 = org.bukkit.GameMode.SPECTATOR;
        private static org.bukkit.GameMode survival = org.bukkit.GameMode.SURVIVAL;
        private static org.bukkit.GameMode creative = org.bukkit.GameMode.CREATIVE;
        private static org.bukkit.GameMode adventure = org.bukkit.GameMode.ADVENTURE;
        private static org.bukkit.GameMode spectator = org.bukkit.GameMode.SPECTATOR;
    }

    private static class dyecolor {
        private static org.bukkit.DyeColor red = org.bukkit.DyeColor.RED;
        private static org.bukkit.DyeColor black = org.bukkit.DyeColor.BLACK;
        private static org.bukkit.DyeColor blue = org.bukkit.DyeColor.BLUE;
        private static org.bukkit.DyeColor yellow = org.bukkit.DyeColor.YELLOW;
        private static org.bukkit.DyeColor brown = org.bukkit.DyeColor.BROWN;
        private static org.bukkit.DyeColor cyan = org.bukkit.DyeColor.CYAN;
        private static org.bukkit.DyeColor green = org.bukkit.DyeColor.GREEN;
        private static org.bukkit.DyeColor lime = org.bukkit.DyeColor.LIME;
        private static org.bukkit.DyeColor orange = org.bukkit.DyeColor.ORANGE;
        private static org.bukkit.DyeColor magenta = org.bukkit.DyeColor.MAGENTA;
        private static org.bukkit.DyeColor gray = org.bukkit.DyeColor.GRAY;
        private static org.bukkit.DyeColor bluelight = org.bukkit.DyeColor.LIGHT_BLUE;
        private static org.bukkit.DyeColor graylight = org.bukkit.DyeColor.LIGHT_GRAY;
        private static org.bukkit.DyeColor pink = org.bukkit.DyeColor.PINK;
        private static org.bukkit.DyeColor white = org.bukkit.DyeColor.WHITE;
        private static org.bukkit.DyeColor purple = org.bukkit.DyeColor.PURPLE;
    }

    private static class dyematerial {
        private static org.bukkit.Material black = org.bukkit.Material.INK_SAC;
        private static org.bukkit.Material red = org.bukkit.Material.RED_DYE;
        private static org.bukkit.Material blue = org.bukkit.Material.BLUE_DYE;
        private static org.bukkit.Material yellow = org.bukkit.Material.YELLOW_DYE;
        private static org.bukkit.Material brown = org.bukkit.Material.BROWN_DYE;
        private static org.bukkit.Material cyan = org.bukkit.Material.CYAN_DYE;
        private static org.bukkit.Material green = org.bukkit.Material.GREEN_DYE;
        private static org.bukkit.Material lime = org.bukkit.Material.LIME_DYE;
        private static org.bukkit.Material orange = org.bukkit.Material.ORANGE_DYE;
        private static org.bukkit.Material magenta = org.bukkit.Material.MAGENTA_DYE;
        private static org.bukkit.Material gray = org.bukkit.Material.GRAY_DYE;
        private static org.bukkit.Material bluelight = org.bukkit.Material.LIGHT_BLUE_DYE;
        private static org.bukkit.Material graylight = org.bukkit.Material.LIGHT_GRAY_DYE;
        private static org.bukkit.Material pink = org.bukkit.Material.PINK_DYE;
        private static org.bukkit.Material white = org.bukkit.Material.WHITE_DYE;
        private static org.bukkit.Material purple = org.bukkit.Material.PURPLE_DYE;
    }

    private static class sound {
        private void levelup(org.bukkit.entity.Player p, int vol) {
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, vol, 0f);
        }
    }

    public boolean enabled = false;

    public static Map<UUID, String> players;
    public static List<String> namelist;

    public static RandomSkin plugin;
    int c = 0;

    public RandomManager(RandomSkin rs) {
        plugin = rs;
        players = new HashMap<>();
        namelist = new ArrayList<>();
    }

    public void reloadName() {
        namelist = Kei.a(new File(plugin.getDataFolder() + File.separator + "name.txt"));
        Kei.out("loaded names: " + namelist.size());
    }

    public void setEnabled(boolean t) {
        if (t) {
            enabled = true;
            shuffle();
        } else {
            enabled = false;
            clearAll();
        }
    }

    public void shuffle() {
        reloadName();
        c = 0;
        Collections.shuffle(namelist);
        for (Player p : Bukkit.getOnlinePlayers()) {
            players.put(p.getUniqueId(), namelist.get(c));
            Kei.psm(p, "あなたは" + namelist.get(c) + "に変身しました。");
            setDummy(p, players.get(p.getUniqueId()));
            c += 1;
        }
    }

    public void clearAll() {
        Map<UUID, String> nickedPlayers = NickAPI.getNickedPlayers();
        for (Map.Entry<UUID, String> e : nickedPlayers.entrySet()) {
            OfflinePlayer player = Bukkit.getOfflinePlayer(e.getKey());
            if (player.isOnline()) {
                NickAPI.resetNick((Player) player);
                NickAPI.resetSkin((Player) player);
                NickAPI.resetUniqueId((Player) player);
                NickAPI.resetGameProfileName((Player) player);
                NickAPI.refreshPlayer((Player) player);
                Kei.psm((Player) player, "変身が解除されました。");
            }
        }
    }

    public void check(Player p) {
        if (!enabled) {
            NickAPI.resetNick(p);
            NickAPI.resetSkin(p);
            NickAPI.resetUniqueId(p);
            NickAPI.resetGameProfileName(p);
            NickAPI.resetGameProfileName(p);
            NickAPI.refreshPlayer(p);
            return;
        }
        if (!players.containsKey(p.getUniqueId())) {
            players.put(p.getUniqueId(), namelist.get(c));
            Kei.psm(p, "あなたは" + namelist.get(c) + "に変身しました。");
            setDummy(p, players.get(p.getUniqueId()));
            c += 1;
        } else {
            setDummy(p, players.get(p.getUniqueId()));
        }
    }

    public void setDummy(Player player, String name) {
        NickAPI.nick(player, name);
        NickAPI.setSkin(player, name);
        NickAPI.setUniqueId(player, name);
        NickAPI.setGameProfileName(player, name);
        NickAPI.refreshPlayer(player);
    }
}
