package benkralex.minecraftutilplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.block.ShulkerBox;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class InventoryInteractListener implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onItemClick(InventoryClickEvent e) {
        if (e.isRightClick()) {
            switch (e.getCurrentItem().getType()) {
                case CRAFTING_TABLE: {
                    e.getWhoClicked().openInventory(Bukkit.createInventory(null, InventoryType.CRAFTING));
                    break;
                }
                case ENDER_CHEST: {
                    e.getWhoClicked().openInventory(e.getWhoClicked().getEnderChest());
                    break;
                }
                case SHULKER_BOX: {
                    ItemStack item = e.getCurrentItem();
                    if(item.getItemMeta() instanceof BlockStateMeta){
                        BlockStateMeta im = (BlockStateMeta)item.getItemMeta();
                        if(im.getBlockState() instanceof ShulkerBox){
                            ShulkerBox shulker = (ShulkerBox) im.getBlockState();
                            Inventory inv = Bukkit.createInventory(null, InventoryType.SHULKER_BOX, shulker.getCustomName());
                            inv.setContents(shulker.getInventory().getContents());
                            e.getWhoClicked().openInventory(inv);
                        }
                    }
                    break;
                }
            }
        }
    }
}
