package minato.kitpvp.main.eventos;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import minato.kitpvp.main.kitmain.KitMain;

public class Jump extends KitMain implements Listener {
	
	@EventHandler
	public void EsponjaEsmeralda(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(hasKit(p) && p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE) {
			p.setVelocity(new Vector(0.5, 0.5, 05));
		}
	}

}
