package minato.kitpvp.main.automessage;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import minato.kitpvp.main.Main;

public class AutoMessage {
	
	public AutoMessage() {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					Random r = new Random();
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.auto.getStringList("Auto.List").get(r.nextInt())));
				}
				
			}
		}.runTaskTimer(Main.getInstance(), Main.auto.getInt("Auto.Temp"), Main.auto.getInt("Auto.Temp"));
	}

}
