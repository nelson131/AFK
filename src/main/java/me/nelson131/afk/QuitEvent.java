package me.nelson131.afk;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class QuitEvent implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam("afk");
        if(team.hasEntry(player.getDisplayName())){
            team.removeEntry(player.getName());
        }
        if(team == null){
            team = scoreboard.registerNewTeam("afk");
            team.setPrefix(ChatColor.RED + "[AFK]");
        }
    }
}
