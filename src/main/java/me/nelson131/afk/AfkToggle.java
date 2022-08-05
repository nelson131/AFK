package me.nelson131.afk;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;


public class AfkToggle implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can use only player");
            return false;
        }
        Player player = (Player) sender;


        if (command.getName().equalsIgnoreCase("afk")) {
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
            Team team = scoreboard.getTeam("afk");
                if(team == null) {
                    team = scoreboard.registerNewTeam("afk");
                    team.setPrefix(ChatColor.RED + "[AFK]");
                }
                if (!(team.hasEntry(player.getDisplayName()))) {
                    team.addEntry(player.getName());
                    player.sendMessage(ChatColor.RED + "You are in afk status");
                    player.sendMessage(ChatColor.RED + "Move - to leave from afk status");
                }
                else {
                    player.sendMessage(ChatColor.RED + "You are in afk status yet");
                }
            }
        return true;
    }
}
