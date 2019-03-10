package yuu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    CustomConfig config;
    CustomConfig season;

    @Override
    public void onEnable() {
        config = new CustomConfig(this);
        season = new CustomConfig(this, "season.yml");
        config.saveDefaultConfig();
        season.saveDefaultConfig();
        getCommand("season").setExecutor(new Season_command());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
