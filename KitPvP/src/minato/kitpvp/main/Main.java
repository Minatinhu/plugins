package minato.kitpvp.main;

import org.bukkit.plugin.java.JavaPlugin;

import minato.kitpvp.main.eventos.InteractOpen;
import minato.kitpvp.main.eventos.JoinLeave;

public class Main extends JavaPlugin {
	
	private static Main instance;
	
	public void onEnable() {
		setInstance(this);
		getServer().getPluginManager().registerEvents(new JoinLeave(), this);
		getServer().getPluginManager().registerEvents(new InteractOpen(), this);
	}

	public static Main getInstance() {
		return instance;
	}

	public static void setInstance(Main instance) {
		Main.instance = instance;
	}

}
