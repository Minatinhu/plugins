package minato.ban.main.eventos;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import minato.ban.main.Main;

public class BanEvent implements Listener {
	
	@EventHandler
	public void ban(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if(Main.cf.contains(p.getName().toLowerCase()) || Main.cf.contains(p.getName().toLowerCase() + ".IP")) {
			e.setResult(Result.KICK_BANNED);
		}
		if(e.getResult() == Result.KICK_BANNED) {
			e.setKickMessage(ChatColor.RED + "RedeGet\n§cBanimento\n" + "\nVocê foi banido pelo motivo: " + Main.cf.getString(p.getName().toLowerCase() + ".Motivo") + "\n§cPelo Staff: " + Main.cf.getString(p.getName().toLowerCase() + ".Staff"));
		}
	}

}
