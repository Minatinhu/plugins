package minato.kitpvp.main.eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import minato.kitpvp.main.kitmain.KitMain;

public class SoupEvent extends KitMain implements Listener {
	
	@EventHandler
	public void a(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getItem().getType() == Material.MUSHROOM_SOUP && kitspvp().containsKey(p)) {
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				if(p.getHealth() != p.getMaxHealth()) {
					p.setHealth(7.0d + p.getHealth() > p.getMaxHealth() ? p.getMaxHealth() : 7.0d + p.getHealth());
				    e.getItem().setType(Material.BOWL);
				}
			}
		}
	}
	
	@EventHandler
	public void b(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

}
