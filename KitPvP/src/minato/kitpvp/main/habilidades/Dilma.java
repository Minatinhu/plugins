package minato.kitpvp.main.habilidades;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import minato.kitpvp.main.kitmain.KitMain;
import minato.kitpvp.main.kittype.KitType;

public class Dilma extends KitMain implements Listener {
	
	@EventHandler
	public void dilma(EntityDamageByEntityEvent e) {
		Player p = (Player) e.getDamager();
		if(e.getDamager() instanceof Player && hasKit(p, KitType.DILMA)) {
			if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§4Habilidade Dilma")) {
				//x lados, y altura, z frente e tras
				Player p2 = (Player) e.getEntity();
				if(e.getEntity() instanceof Player && hasKit(p2)) {
					p2.setVelocity(new Vector(0, 0.2, 0.4));
					p2.sendMessage("§4Voce caiu no estoque de vento da Dilma");
				}
			}
		}
	}

}
