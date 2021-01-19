package com.MrEngMan.OpenAnvil;

import com.MrEngMan.OpenAnvil.commands.AnvilCommandHandler;
import com.MrEngMan.OpenAnvil.commands.ReloadCommandHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

import java.io.File;

public class OpenAnvil extends JavaPlugin implements Listener {

    private static OpenAnvil plugin;

    private boolean debug;

    // When plugin is first enabled
    @SuppressWarnings("static-access")
    @Override
    public void onEnable() {
        this.plugin = this;
        reloadTheConfig();

        // Register stuff
        getCommand("oareload").setExecutor(new ReloadCommandHandler());
        getCommand("openanvil").setExecutor(new AnvilCommandHandler());
        //Bukkit.getPluginManager().registerEvents(new Listeners(), this);

    }

    public void reloadTheConfig() {

        // Generate the config file if it was deleted
        if (!(new File(this.getDataFolder(), "config.yml").exists())) {
            this.saveDefaultConfig();
        }

        // Load new config values
        reloadConfig();
        debug = getConfig().getBoolean("debug", false);

    }

    // Getters
    public static OpenAnvil getPlugin() {
        return plugin;
    }
    public boolean isDebugEnabled() {
        return debug;
    }

}