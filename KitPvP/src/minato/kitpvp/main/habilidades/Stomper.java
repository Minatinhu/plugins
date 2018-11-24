package minato.kitpvp.main.habilidades;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import minato.kitpvp.main.kitmain.KitMain;
import minato.kitpvp.main.kittype.KitType;

public class Stomper extends KitMain implements Listener {
	
	
	@EventHandler
	public void StomperEvent(EntityDamageEvent e) {
		Player p = (Player) e.getEntity();
		if(e.getEntityType() == EntityType.PLAYER) {
			if(kitspvp().get(p) == KitType.STOMPER) {
				for(Entity p2 : p.getNearbyEntities(3, 3, 3)) {
					Player p21 = (Player) p2;
					if(p21 instanceof Player) {
						p21.damage(e.getDamage());
						p21.playSound(p21.getLocation(), Sound.ANVIL_LAND, 1f, 1f);
					}
				}
				p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1f, 1f);
			}
		}
	}

}
