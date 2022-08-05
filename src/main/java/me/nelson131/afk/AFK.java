package me.nelson131.afk;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class AFK extends JavaPlugin {
    Logger log = getLogger();

    @Override
    public void onEnable() {
        log.info("Enabled AFK");
        getCommand("afk").setExecutor(new AfkToggle());
        getServer().getPluginManager().registerEvents(new MoveEvent(), this);
        getServer().getPluginManager().registerEvents(new QuitEvent(), this);
    }

    @Override
    public void onDisable() {

    }
}
