package minato.kitpvp.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import minato.kitpvp.main.eventos.InteractOpen;
import minato.kitpvp.main.eventos.JoinLeave;

public class Main extends JavaPlugin {
	
	private static Main instance;
	
	public void onEnable() {
		setInstance(this);
		newMessage("&2[&cKitPvP] &2Plugin ligado com sucesso!");
		getServer().getPluginManager().registerEvents(new JoinLeave(), this);
		getServer().getPluginManager().registerEvents(new InteractOpen(), this);
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
