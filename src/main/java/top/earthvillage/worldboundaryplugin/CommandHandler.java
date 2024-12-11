package top.earthvillage.worldboundaryplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;

import java.io.File;
import java.io.IOException;

public class CommandHandler implements CommandExecutor {

    private ConfigHandler configHandler;

    public CommandHandler(ConfigHandler configHandler) {
        this.configHandler = configHandler;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            try {
                // 重新加载配置文件
                configHandler.getConfig().load(new File(configHandler.getPlugin().getDataFolder(), "config.yml"));
                sender.sendMessage("Config.yml has been reloaded.");
            } catch (IOException | InvalidConfigurationException e) {
                sender.sendMessage("Failed to reload config.yml.");
                e.printStackTrace();
            }
            return true;
        }

        sender.sendMessage("Usage: /setconfig reload");
        return false;
    }
}
