package minato.kitpvp.main.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import minato.kitpvp.main.Main;
import minato.kitpvp.main.kitmain.KitMain;
import minato.kitpvp.main.scoreboard.Score;

public class JoinLeave extends KitMain implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
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
		getSeguencia().put(p, 0);
		Score.build(p);
	}
		
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if(hasKit(p)) {
			kitspvp().remove(p);
		}
		p.getInventory().clear();
	}

}
