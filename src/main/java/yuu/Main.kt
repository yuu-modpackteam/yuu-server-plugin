package yuu

import org.bukkit.command.CommandExecutor
import org.bukkit.command.PluginCommand
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    internal var config: CustomConfig = CustomConfig(this)
    internal var season: CustomConfig = CustomConfig(this, "season.yml")

    init {
        instance = this
    }

    override fun onEnable() {
        reloadConfigurations()
        setCommandExecutor("season", SeasonCommand)
    }

    override fun onDisable() {
        saveConfigurations()
    }

    private fun setCommandExecutor(name: String, executor: CommandExecutor) {
        val command: PluginCommand? = getCommand(name)
        if (command == null) {
            logger.info("The command named `$command` not found.")
        } else {
            command.executor = executor
        }
    }

    private fun reloadConfigurations() {
        config.reloadConfig()
        season.reloadConfig()
        config.saveDefaultConfig()
        season.saveDefaultConfig()
    }

    private fun saveConfigurations() {
        config.saveConfig()
        season.saveConfig()
        config.saveDefaultConfig()
        season.saveDefaultConfig()
    }

    companion object {
        lateinit var instance: Main
    }
}
