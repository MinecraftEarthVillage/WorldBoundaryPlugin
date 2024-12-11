package top.earthvillage.worldboundaryplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigHandler {
    public Plugin getPlugin() {
        // 返回插件实例
        return plugin;
    }
    private JavaPlugin plugin;
    private FileConfiguration config;

    public ConfigHandler(JavaPlugin plugin) {
        this.plugin = plugin;
        this.plugin.saveDefaultConfig(); // 加载默认的config.yml
        this.config = plugin.getConfig();
    }

    public FileConfiguration getConfig() {
        return config;
    }
    // 添加一个保存配置文件的方法
    public void saveConfig() {
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        plugin.saveConfig(); // 保存配置
    }

    // 获取各个配置项的方法
    // 可以根据需要添加方法来访问不同世界的配置
    public double getChangeX(String worldName) {
        return config.getDouble(worldName + ".changeX", 1.0);
    }

    public double getChangeZ(String worldName) {
        return config.getDouble(worldName + ".changeZ", 1.0);
    }

    public int getX1(String worldName) {
        return config.getInt(worldName + ".x1", 0);
    }

    public int getX2(String worldName) {
        return config.getInt(worldName + ".x2", 0);
    }

    public int getZ1(String worldName) {
        return config.getInt(worldName + ".z1", 0);
    }

    public int getZ2(String worldName) {
        return config.getInt(worldName + ".z2", 0);
    }

    public boolean isXWrappingEnabled(String worldName) {
        return config.getBoolean(worldName + ".x-wrapping", false);
    }

    public boolean isZWrappingEnabled(String worldName) {
        return config.getBoolean(worldName + ".z-wrapping", false);
    }
}
