package net.kunmc.lab.randomskin;

import net.kunmc.lab.randomskin.event.JoinEventListener;
import org.bukkit.Sound;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomSkin extends JavaPlugin {

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
        private void levelup(org.bukkit.entity.Player p, int vol){p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, vol, 0f);}
    }

    public static RandomManager rm;

    @Override
    public void onEnable() {
        Kei.z(this);
        Kei.a(new JoinEventListener(), this);
        rm = new RandomManager(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
