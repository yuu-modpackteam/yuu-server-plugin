package yuu

import org.bukkit.command.CommandExecutor
import org.bukkit.command.PluginCommand
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    internal var config: CustomConfig
    internal var season: CustomConfig

    init {
        config = CustomConfig(this)
        season = CustomConfig(this, "season.yml")
        instance = this
    }

    override fun onEnable() {
        config = CustomConfig(this)
        season = CustomConfig(this, "season.yml")
        config.saveDefaultConfig()
        season.saveDefaultConfig()
        setCommandExecutor("season", SeasonCommand)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    private fun setCommandExecutor(name: String, executor: CommandExecutor) {
        val command: PluginCommand? = getCommand(name)
        if (command == null) {
            logger.info("The command named `$command` not found.")
        } else {
            command.executor = executor
        }
    }

    companion object {
        lateinit var instance: Main
    }
}
