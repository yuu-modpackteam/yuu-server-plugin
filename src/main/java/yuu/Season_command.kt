package yuu

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import sun.plugin2.main.server.Plugin

class Season_command : CommandExecutor {

    internal var season: CustomConfig
    private val plugin: Main? = null

    fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        season = CustomConfig(plugin!!, "season.yml")


        return false
    }
}
