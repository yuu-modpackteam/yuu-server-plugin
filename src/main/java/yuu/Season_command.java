package yuu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import sun.plugin2.main.server.Plugin;

public class Season_command implements CommandExecutor {

    CustomConfig season;
    private Main plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        season = new CustomConfig(plugin, "season.yml");


        return false;
    }
}
