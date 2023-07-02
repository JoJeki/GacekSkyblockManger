package me.gacekmpl2.gacekskyblockmanger.listeners;

import me.gacekmpl2.gacekskyblockmanger.CropHandler;
import me.gacekmpl2.gacekskyblockmanger.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import java.util.Arrays;
import java.util.List;

public class BreakEvent implements Listener {

    private final List<Material> cropList = Arrays.asList(Material.WHEAT, Material.POTATOES, Material.CARROTS, Material.BEETROOTS);

    @EventHandler
    public void breakEvent(BlockBreakEvent event) {
        Player player = event.getPlayer();

        Block block = event.getBlock();
        PlayerInventory inventory = player.getInventory();
        Material cropBlockType;

        if (cropList.contains(block.getType())) {
            cropBlockType = block.getType();
        } else {
            return;
        }

        if (!hasPermissionsToReplantCrop(player, cropBlockType)) {
            return;
        }

        if (isFullyGrown(block)) {
            replantCrop(block.getLocation(), cropBlockType, false);
            event.setDropItems(false);
        } else {
            event.setCancelled(true);
        }
    }

    public boolean isFullyGrown(Block block) {
        Ageable ageable = (Ageable) block.getBlockData();
        int maximumAge = ageable.getMaximumAge();

        return ageable.getAge() == maximumAge;
    }

    public boolean hasPermissionsToReplantCrop(Player player, Material cropBlockType) {
        String cropPermission = CropHandler.getPermissionStringForCrop(cropBlockType);
        return player.hasPermission("skyblockmanager.replant.all") || player.hasPermission(cropPermission);
    }

    public void replantCrop(Location location, Material cropBlockType, boolean dropSeeds) {
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            Block block = location.getBlock();
            block.setType(cropBlockType);

            if (!dropSeeds) {
                BlockData blockData = block.getBlockData();
                if (blockData instanceof Ageable) {
                    Ageable ageable = (Ageable) blockData;
                    ageable.setAge(0);
                    block.setBlockData(ageable);
                }
            }

            if (!dropSeeds) {
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(cropBlockType, 1));
            }
        }, 20L);
    }
}