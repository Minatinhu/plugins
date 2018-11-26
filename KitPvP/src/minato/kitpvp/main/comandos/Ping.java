package minato.kitpvp.main.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// /ping
		if(cmd.getName().equalsIgnoreCase("ping")) {
			Player p = (Player) sender;
			if(args.length == 0) {
				int ping = ((CraftPlayer)p).getHandle().ping;
				p.sendMessage(ChatColor.BLACK + "[" + ChatColor.GREEN + "RedeGet" + ChatColor.BLACK + "]" + ChatColor.RESET + " Sua ping é" + ping);
				return false;
			}
		}
		return false;
	}

}
