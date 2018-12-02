package minato.kitpvp.main.scoreboard;

import org.bukkit.ChatColor;

public class BlinkEffect {

	private static int i = 0;
	private static String s = "§2Kit§cPvP";

	public static void next() {
		if (i == 0) {
			s = ChatColor.AQUA + "Kit" + ChatColor.WHITE + "PvP";
		}
		if (i == 1) {
			s = ChatColor.GREEN + "Kit" + ChatColor.RED + "PvP";
		}
		if (i == 2) {
			s = ChatColor.LIGHT_PURPLE + "Kit" + ChatColor.DARK_PURPLE + "PvP";
		}
		if (i == 3) {
			s = "§6§lK" + ChatColor.RESET + "§lit PvP";
		}
		if (i == 4) {
			s = "§lK§6§li" + ChatColor.RESET + "§lt PvP";
		}
		if (i == 5) {
			s = "§lKi§6§lt" + ChatColor.RESET + " §lPvP";
		}
		if (i == 6) {
			s = "§lKit§6§lP" + ChatColor.RESET + "§lvP";
		}
		if (i == 7) {
			s = "§lKitP§6§lv" + ChatColor.RESET + "§lP";
		}
		if (i == 8) {
			s = "§lKitPv§6§lP";
		}
		if (i == 9) {
			s = "§lKitPvP";
			i = 0;
		}
		i++;
	}
	
	public static String getS() {
		return s;
	}

}
