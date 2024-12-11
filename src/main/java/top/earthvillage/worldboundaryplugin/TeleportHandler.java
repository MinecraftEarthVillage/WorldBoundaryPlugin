package top.earthvillage.worldboundaryplugin;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TeleportHandler implements Listener {

    private ConfigHandler configHandler;

    public TeleportHandler(ConfigHandler configHandler) {
        this.configHandler = configHandler;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        String worldName = player.getWorld().getName();

        // 获取世界的配置
        int x1 = configHandler.getX1(worldName);
        int x2 = configHandler.getX2(worldName);
        int z1 = configHandler.getZ1(worldName);
        int z2 = configHandler.getZ2(worldName);

        boolean isXWrapping = configHandler.isXWrappingEnabled(worldName);
        boolean isZWrapping = configHandler.isZWrappingEnabled(worldName);
        double changeX = configHandler.getChangeX(worldName);
        double changeZ = configHandler.getChangeZ(worldName);

// 检查X坐标是否越界
        double newX = player.getLocation().getX();
        if (newX >= x2) {
            newX = x1 + (newX - x2) * changeX;  // 优化调整方式
        } else if (newX <= x1) {
            newX = x2 - (x1 - newX) * changeX;  // 优化调整方式
        }

// 检查Z坐标是否越界
        double newZ = player.getLocation().getZ();
        if (newZ >= z2) {
            newZ = z1 + (newZ - z2) * changeZ;  // 优化调整方式
        } else if (newZ <= z1) {
            newZ = z2 - (z1 - newZ) * changeZ;  // 优化调整方式
        }

// 如果坐标发生变化，进行传送
        if (newX != player.getLocation().getX() || newZ != player.getLocation().getZ()) {
            Location location = player.getLocation(); // 获取玩家当前的位置
            location.setX(newX); // 设置新的X坐标
            location.setZ(newZ); // 设置新的Z坐标
            player.teleport(location); // 将玩家传送到新的位置
        }

    }
}
