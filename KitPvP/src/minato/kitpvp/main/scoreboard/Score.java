package minato.kitpvp.main.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import minato.kitpvp.main.Main;
import minato.kitpvp.main.kitmain.KitMain;

public class Score extends KitMain implements Listener {

	public static void run() {
		new BukkitRunnable() {

			@Override
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					update(p.getScoreboard(), p);
				}

			}
		}.runTaskTimer(Main.getInstance(), 0, 3);
	}

	@SuppressWarnings("deprecation")
	public static void build(Player p) {
		Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = score.registerNewObjective("scoreboard", "dummy");
		obj.setDisplayName("§b§lKIT PVP");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		// Line 15
		obj.getScore(Bukkit.getOfflinePlayer("§7 @GetServidores")).setScore(15);
		// Line 14
		obj.getScore(Bukkit.getOfflinePlayer("§2")).setScore(14);
		// Line 13
		obj.getScore(Bukkit.getOfflinePlayer("§fNick:§b ")).setScore(13);
		Team t1 = score.registerNewTeam("nick");
		t1.addPlayer(Bukkit.getOfflinePlayer("§fNick:§b "));
		// Line 12
		obj.getScore(Bukkit.getOfflinePlayer("§fGrupo:§b ")).setScore(12);
		Team t2 = score.registerNewTeam("grupo");
		t2.addPlayer(Bukkit.getOfflinePlayer("§fGrupo:§b "));
		// Line 11
		obj.getScore(Bukkit.getOfflinePlayer("§fGetCoins:§c Manutenção"));
		// Line 10
		obj.getScore(Bukkit.getOfflinePlayer("§f")).setScore(10);
		// Line 9
		obj.getScore(Bukkit.getOfflinePlayer("§fOnline:§b ")).setScore(9);
		Team t3 = score.registerNewTeam("online");
		t3.addPlayer(Bukkit.getOfflinePlayer("§fOnline:§b "));
		// Line 8
		obj.getScore(Bukkit.getOfflinePlayer("§fHabilidade:§b ")).setScore(8);
		Team t4 = score.registerNewTeam("habilidade");
		t4.addPlayer(Bukkit.getOfflinePlayer("§fHabilidade:§b "));
		// Line 7
		obj.getScore(Bukkit.getOfflinePlayer("§fMatou:§b ")).setScore(7);
		Team t5 = score.registerNewTeam("matou");
		t5.addPlayer(Bukkit.getOfflinePlayer("§fMatou:§b "));
		// Line 6
		obj.getScore(Bukkit.getOfflinePlayer("§4")).setScore(6);
		// Line 5
		obj.getScore(Bukkit.getOfflinePlayer("§7jogar-redeget.tk")).setScore(5);
		// Set Scoreboard
		p.setScoreboard(score);
	}

	public static void update(final Scoreboard score, Player p) {
		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				Team t1 = score.getTeam("nick");
				String nick = p.getName().length() > 16 ? p.getName().substring(0, 16) : p.getName();
				t1.setSuffix(nick);
				Team t2 = score.getTeam("online");
				t2.setSuffix("" + Bukkit.getOnlinePlayers().size() + " jogadores");
				Team t3 = score.getTeam("habilidade");
				t3.setSuffix("" + kitsnome().get(p));
				Team t4 = score.getTeam("matou");
				t4.setSuffix("" + p.getStatistic(Statistic.PLAYER_KILLS));
			}
		});
		th.start();
	}

}