package top.earthvillage.worldboundaryplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class WorldBoundaryPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("WorldBoundaryPlugin has been enabled.");
        // 初始化配置，并传递 plugin 实例
        ConfigHandler configHandler = new ConfigHandler(this);

        // 注册事件处理器
        getServer().getPluginManager().registerEvents(new TeleportHandler(configHandler), this);

        // 注册命令
        getCommand("setconfig").setExecutor(new CommandHandler(configHandler));
    }

    @Override
    public void onDisable() {
        getLogger().info("WorldBoundaryPlugin has been disabled.");
    }
}
