package minato.kitpvp.main.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import minato.kitpvp.main.Main;
import minato.kitpvp.main.kitmain.KitMain;

public class Respown extends KitMain implements Listener {
	
	@EventHandler
	public void respawnEvent(PlayerRespawnEvent e) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			public void run() {
				Player p = e.getPlayer();
				p.getInventory().clear();
				//Kit Selector
				ItemStack i = new ItemStack(Material.ENDER_CHEST);
				String nameKitSelector = "§cKitSelector";
				ItemMeta meta = i.getItemMeta();
				meta.setDisplayName(nameKitSelector);
				i.setItemMeta(meta);
				p.getInventory().setItem(1, i);
				kitsnome().put(p, "Nenhum");
			}
		}, 10);
	}

}
