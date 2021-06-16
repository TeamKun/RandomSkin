package net.kunmc.lab.randomskin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.haoshoku.nick.api.NickAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class SetCommandExecutor implements org.bukkit.command.CommandExecutor, TabCompleter {
    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (Kei.pexc(sender)) return true;
        if (Kei.agc(args, 1)) {
            sender.sendMessage("切り替えをするプレイヤーを選択してください。");
            sender.sendMessage("e.g. /rset <@a|@r|@e|@p|@s / name> <on / off>");
            sender.sendMessage("e.g. /rset list 現在の状態を表示する");
            return true;
        } else if (Kei.agc(args, 2)) {
            if ("list".equals(args[0])) {
                Kei.sm(sender,
                        "--- 現在の状態 ---",
                        "全体のスキン変更： " + (RandomSkin.rm.enabled ? "有効" : "無効"),
                        "読み込み済みプレイヤー数： " + RandomSkin.rm.namelist.size(),
                        "無効されているプレイヤー数： " + RandomSkin.rm.without.size(),
                        "詳しくは/rset disablelist");
                return true;
            } else if ("disablelist".equals(args[0])) {
                Kei.sm(sender, "無効化されているプレイヤー: ");
                for (UUID uid : RandomSkin.rm.without) {
                    Kei.sm(sender, Bukkit.getOfflinePlayer(uid).getName());
                }
                return true;
            }
            String selector = args[0];
            List<Entity> entityList;
            boolean nicked = false;
            boolean at = false;
            if (selector.startsWith("@") && !selector.equals("@")) {
                entityList = Bukkit.selectEntities(sender, args[0]);
                at = true;
            } else {
                if (NickAPI.isNickedName(selector)) {
                    entityList = Collections.singletonList(NickAPI.getPlayerOfNickedName(selector));
                    nicked = true;
                } else {
                    entityList = new ArrayList<>();
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (p.getName().equals(selector)) {
                            entityList.add(p);
                            break;
                        }
                    }
                }
            }
            if (entityList == null || entityList.isEmpty() || entityList.size() < 1) {
                Kei.sm(sender, "対象のエンティティがみつかりませんでした。");
                return true;
            }
            int count = 0;
            if (at) {
                for (Entity entity : entityList) {
                    if (entity instanceof Player) {
                        count += 1;
                        boolean bool = !RandomSkin.rm.toggleWithout((Player) entity);
                        String status = bool ? "有効" : "無効";
                        Kei.psm((Player) entity, "あなたのスキン変更は" + status + "化されました。");
                    }
                }
                Kei.sm(sender, count + "人のスキンの変更状態を切り替えました。");
                RTablist.update();
                return true;
            } else {
                if (nicked) {
                    boolean bool = !RandomSkin.rm.toggleWithout((Player) entityList.get(0));
                    String status = bool ? "有効" : "無効";
                    Kei.psm((Player) entityList.get(0), "あなたのスキン変更は" + status + "化されました。");
                    Kei.sm(sender, "1人のスキンの変更状態を切り替えました。");
                    RTablist.update();
                    return true;
                } else {
                    boolean bool = !RandomSkin.rm.toggleWithout((Player) entityList.get(0));
                    String status = bool ? "有効" : "無効";
                    Kei.psm((Player) entityList.get(0), "あなたのスキン変更は" + status + "化されました。");
                    Kei.sm(sender, "1人のスキンの変更状態を切り替えました。");
                    RTablist.update();
                    return true;
                }
            }
        } else if (Kei.agc(args, 3)) {
            String selector = args[0];
            if (!("on".equals(args[1]) || "off".equals(args[1]))) {
                sender.sendMessage("on 又は off で選択してください。");
                sender.sendMessage("e.g. /rset <@a|@r|@e|@p|@s / name> <on / off>");
                sender.sendMessage("e.g. /rset list 現在の状態を表示する");
                return true;
            }
            boolean enable = "on".equals(args[1]);
            String status = enable ? "有効" : "無効";
            List<Entity> entityList;
            boolean nicked = false;
            boolean at = false;
            if (selector.startsWith("@") && !selector.equals("@")) {
                entityList = Bukkit.selectEntities(sender, args[0]);
                at = true;
            } else {
                if (NickAPI.isNickedName(selector)) {
                    entityList = Collections.singletonList(NickAPI.getPlayerOfNickedName(selector));
                    nicked = true;
                } else {
                    entityList = new ArrayList<>();
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (p.getName().equals(selector)) {
                            entityList.add(p);
                            break;
                        }
                    }
                }
            }
            if (entityList == null || entityList.isEmpty() || entityList.size() < 1) {
                Kei.sm(sender, "対象のエンティティがみつかりませんでした。");
                return true;
            }
            int count = 0;
            if (at) {
                for (Entity entity : entityList) {
                    if (entity instanceof Player) {
                        count += 1;
                        RandomSkin.rm.setWithout((Player) entity, enable);
                        Kei.psm((Player) entity, "あなたのスキン変更は" + status + "化されました。");
                    }
                }
                Kei.sm(sender, count + "人のスキンの変更状態を切り替えました。");
                RTablist.update();
                return true;
            } else {
                if (nicked) {
                    RandomSkin.rm.setWithout((Player) entityList.get(0), enable);
                    Kei.psm((Player) entityList.get(0), "あなたのスキン変更は" + status + "化されました。");
                    Kei.sm(sender, "1人のスキンの変更状態を切り替えました。");
                    RTablist.update();
                    return true;
                } else {
                    RandomSkin.rm.setWithout((Player) entityList.get(0), enable);
                    Kei.psm((Player) entityList.get(0), "あなたのスキン変更は" + status + "化されました。");
                    Kei.sm(sender, "1人のスキンの変更状態を切り替えました。");
                    RTablist.update();
                    return true;
                }
            }
        } else {
            sender.sendMessage("切り替えをするプレイヤーを選択してください。");
            sender.sendMessage("e.g. /rset <@a|@r|@e|@p|@s / name> <on / off>");
            sender.sendMessage("e.g. /rset list 現在の状態を表示する");
            return true;
        }
    }

    /**
     * Requests a list of possible completions for a command argument.
     *
     * @param sender  Source of the command.  For players tab-completing a
     *                command inside of a command block, this will be the player, not
     *                the command block.
     * @param command Command which was executed
     * @param alias   The alias used
     * @param args    The arguments passed to the command, including final
     *                partial argument to be completed and command label
     * @return A List of possible completions for the final argument, or null
     * to default to the command executor
     */
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (Kei.agc(args, 1)) {
            List<String> dummy = new ArrayList<>();
            dummy.add("@a");
            dummy.add("@p");
            dummy.add("@e");
            dummy.add("@r");
            dummy.add("@s");
            dummy.add("list");
            dummy.add("disablelist");
            for (Player p : Bukkit.getOnlinePlayers()) {
                dummy.add(NickAPI.getName(p));
            }
            return dummy;
        } else if (Kei.agc(args, 2)) {
            List<String> r = new ArrayList<>();
            List<String> dummy = new ArrayList<>();
            dummy.add("@a");
            dummy.add("@p");
            dummy.add("@e");
            dummy.add("@r");
            dummy.add("@s");
            dummy.add("list");
            dummy.add("disablelist");
            for (Player p : Bukkit.getOnlinePlayers()) {
                dummy.add(NickAPI.getName(p));
            }
            for (String s : dummy) {
                if (s.startsWith(args[0])) r.add(s);
            }
            return r;
        } else if (Kei.agc(args, 3)) {
            List<String> r = new ArrayList<>();
            if (args[1] == null) {
                return Arrays.asList("on", "off");
            }
            for (String s : Arrays.asList("on", "off")) {
                if (s.startsWith(args[1])) r.add(s);
            }
            return r;
        }
        return Collections.singletonList("");
    }
}
