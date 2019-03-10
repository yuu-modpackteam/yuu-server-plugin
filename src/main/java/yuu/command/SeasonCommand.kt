package yuu.command

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import yuu.CustomConfig
import yuu.Main

object SeasonCommand : CommandExecutor {
    private val plugin: Main = Main.instance
    val season: CustomConfig = CustomConfig(plugin, "season.yml")
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        return false
    }
}
