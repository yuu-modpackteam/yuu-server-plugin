package yuu

import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.logging.Level

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin

class CustomConfig
/**
 * 指定したファイル名で設定を読み書きするカスタムコンフィグクラスをインスタンス化します。
 *
 * @param plugin
 * ロード対象のプラグイン
 * @param fileName
 * 読み込みファイル名
 */

/**
 * config.ymlを設定として読み書きするカスタムコンフィグクラスをインスタンス化します。
 *
 * @param plugin
 * ロード対象のプラグイン
 */
@JvmOverloads constructor(private val plugin: Plugin, private val fileName: String = "config.yml") {


    private var config: FileConfiguration? = null
    private val configFile: File = File(plugin.dataFolder, fileName)

    /**
     * デフォルト設定を保存します。
     */
    fun saveDefaultConfig() {
        if (!configFile.exists()) {
            plugin.saveResource(fileName, false)
        }
    }

    /**
     * 読み込んだ [org.bukkit.configuration.file.FileConfiguration]を提供します。
     *
     * @return 読み込んだ設定
     */
    fun getConfig(): FileConfiguration? {
        if (config == null) {
            reloadConfig()
        }
        return config
    }

    /**
     * 設定を保存します。
     */
    fun saveConfig() {
        if (config == null) {
            return
        }
        try {
            getConfig()!!.save(configFile)
        } catch (ex: IOException) {
            plugin.logger.log(Level.SEVERE, "Could not save config to $configFile", ex)
        }

    }

    /**
     * 設定をリロードします。
     */
    fun reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile)

        val defConfigStream = plugin.getResource(fileName) ?: return

        config!!.defaults = YamlConfiguration.loadConfiguration(InputStreamReader(defConfigStream, StandardCharsets.UTF_8))
    }
}

