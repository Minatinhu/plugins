package minato.kitpvp.main.eventos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import minato.kitpvp.main.kitmain.KitMain;

public class PlacaDeSopa extends KitMain implements Listener {

	@EventHandler
	public void soupSign(SignChangeEvent e) {
		if (e.getBlock() instanceof Sign) {
			Sign s = (Sign) e.getBlock();
			if (e.getPlayer().hasPermission("kitpvp.placadesopa")) {
				if (s.getLine(0) == "Sopa" || s.getLine(0) == "sopa") {
					s.setLine(0, ChatColor.AQUA + "[KitPvP]");
					s.setLine(1, ChatColor.GREEN + "Sopas");
					s.update();
				}
			}
		}
	}
	@EventHandler
	public void InteractSign(PlayerInteractEvent e) {
		if(e.getClickedBlock().getType() == Material.SIGN || e.getClickedBlock().getType() == Material.SIGN_POST) {
			Sign s = (Sign) e.getClickedBlock();
			if(s.getLine(0) == ChatColor.AQUA + "[KitPvP]" && s.getLine(1) == ChatColor.GREEN + "Sopas") {
				Inventory inv = Bukkit.createInventory(null, 4*9, ChatColor.GOLD + "Sopa");
				for(ItemStack i : inv.getContents()) {
					if(i == null) {
						inv.addItem(new ItemStack(Material.MUSHROOM_SOUP));
					}
				}
				e.getPlayer().openInventory(inv);
			}
		}
	}
}