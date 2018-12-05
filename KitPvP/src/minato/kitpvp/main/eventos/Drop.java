package minato.kitpvp.main.eventos;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import minato.kitpvp.main.kitmain.KitMain;

public class Drop extends KitMain implements Listener {
	
	@EventHandler
	public void DropEvent(PlayerDropItemEvent e) {
		if(!(e.getItemDrop().getItemStack().getType() == Material.BOWL)) {
			e.setCancelled(true);
		} else {
			e.setCancelled(false);
		}
	}

}
