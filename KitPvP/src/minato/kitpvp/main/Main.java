package minato.kitpvp.main;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import minato.kitpvp.main.eventos.InteractOpen;
import minato.kitpvp.main.eventos.JoinLeave;
import minato.kitpvp.main.eventos.SoupEvent;
import minato.kitpvp.main.habilidades.Stomper;

public class Main extends JavaPlugin {
	
	private static Main instance;
	public static FileConfiguration cf;
	
	public void onEnable() {
		cf = getConfig();
		setInstance(this);
		newMessage("&2[&cKitPvP] &2Plugin ligado com sucesso!");
		//Events
		getServer().getPluginManager().registerEvents(new JoinLeave(), this);
		getServer().getPluginManager().registerEvents(new InteractOpen(), this);
		getServer().getPluginManager().registerEvents(new SoupEvent(), this);
		
		//Kits
		getServer().getPluginManager().registerEvents(new Stomper(), this);
	}

	public static Main getInstance() {
		return instance;
	}

	public static void setInstance(Main instance) {
		Main.instance = instance;
	}
	
	void newMessage(String Message) {
		getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', Message));
	}

}
