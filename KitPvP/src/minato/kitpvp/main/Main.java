package minato.kitpvp.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import minato.kitpvp.main.automessage.AutoMessage;
import minato.kitpvp.main.comandos.Ping;
import minato.kitpvp.main.eventos.InteractOpen;
import minato.kitpvp.main.eventos.JoinLeave;
import minato.kitpvp.main.eventos.Jump;
import minato.kitpvp.main.eventos.SoupEvent;
import minato.kitpvp.main.habilidades.Dilma;
import minato.kitpvp.main.habilidades.Stomper;
import minato.kitpvp.main.scoreboard.Score;

public class Main extends JavaPlugin {

	private static Main instance;
	public static FileConfiguration cf;
	public static File autof = new File(getInstance().getDataFolder(), "automessage.yml");
	public static FileConfiguration auto = YamlConfiguration.loadConfiguration(autof);
	public Score s = new Score();

	public void onEnable() {
		cf = getConfig();
		setInstance(this);
		newMessage("&2[&cKitPvP] &2Plugin ligado com sucesso!");
		if (!autof.exists()) {
			auto.addDefault("Auto.Name", "&9[&bRede&cGet]");
			auto.addDefault("Auto.Boolean", true);
			auto.addDefault("Auto.Temp", 1);
			ArrayList<String> a = new ArrayList<>();
			a.add("&bBem Vindo a o " + auto.getString("Auto.Name"));
			auto.addDefault("Auto.List", a);
			auto.options().copyDefaults(true);
			try {
				auto.save(autof);
				newMessage("&2[&cKitPvP] Arquivo " + autof.getName() + " criado com sucesso!");
			} catch (IOException e) {
				newMessage("&c[&cKitPvP] &c Não Foi possivel criar o arquivo" + autof.getName());
				e.printStackTrace();
			}
		}
		if(autof.exists() == true) {
			if(auto.getBoolean("Auto.Boolean") == true) {
				new AutoMessage();
			}
		}
		// Events
		getServer().getPluginManager().registerEvents(new JoinLeave(), this);
		getServer().getPluginManager().registerEvents(new InteractOpen(), this);
		getServer().getPluginManager().registerEvents(new SoupEvent(), this);
		getServer().getPluginManager().registerEvents(new Jump(), this);

		// Kits
		getServer().getPluginManager().registerEvents(new Stomper(), this);
		getServer().getPluginManager().registerEvents(new Dilma(), this);

		// Commands
		getCommand("ping").setExecutor(new Ping());
		
		//Scoreboard
		s.run();

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
