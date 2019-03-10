package yuu

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import sun.plugin2.main.server.Plugin

class Season_command internal constructor(private val plugin: Main) : CommandExecutor {

    private val season: CustomConfig = CustomConfig(plugin, "season.yml")

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {


        return false
    }
}
