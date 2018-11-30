package minato.kitpvp.main.scoreboard;

import org.bukkit.Bukkit;
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
	
	
	String t = "§2Kit§cPvP";
	
	public void run() {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					update(p.getScoreboard(), p);
				}
				
			}
		}.runTaskTimer(Main.getInstance(), 0, 3);
	}
	
	@SuppressWarnings("deprecation")
	public void build(Player p) {
		Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = score.registerNewObjective("scoreboard", "dummy");
		obj.setDisplayName(t);
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
	    
		//Line 15
		obj.getScore(Bukkit.getOfflinePlayer("§4")).setScore(15);
		//Line 14
		obj.getScore(Bukkit.getOfflinePlayer("§6Estatisticas:")).setScore(14);
		//Line 13
		obj.getScore(Bukkit.getOfflinePlayer("§aKills: §c")).setScore(13);
		Team t1 = score.registerNewTeam("kills");
		t1.addPlayer(Bukkit.getOfflinePlayer("§aKills: §c"));
		//Line 12
		obj.getScore(Bukkit.getOfflinePlayer("§aMortes: §c")).setScore(12);
		Team t2 = score.registerNewTeam("mortes");
		t2.addPlayer(Bukkit.getOfflinePlayer("§aMortes: §c"));
		//Line 11
		obj.getScore(Bukkit.getOfflinePlayer("§4")).setScore(11);
		//Line 10
		obj.getScore(Bukkit.getOfflinePlayer("§aSeu Nick: §b")).setScore(10);
		Team t3 = score.registerNewTeam("nick");
		t3.addPlayer(Bukkit.getOfflinePlayer("§aSeu Nick: §b"));
		//Line 9
		obj.getScore(Bukkit.getOfflinePlayer("§aSeu Kit: ")).setScore(9);
		Team t4 = score.registerNewTeam("kit");
		t4.addPlayer(Bukkit.getOfflinePlayer("§aSeu Kit: "));
		//Set Scoreboard
		p.setScoreboard(score);
	}
	
	
	public void update(final Scoreboard score, final Player p) {
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Team t1 = score.getTeam("kills");
				t1.setSuffix("" + p.getStatistic(Statistic.PLAYER_KILLS));
				Team t2 = score.getTeam("mortes");
				t2.setSuffix("" + p.getStatistic(Statistic.DEATHS));
				Team t3 = score.getTeam("nick");
				t3.setSuffix(p.getName());
				Team t4 = score.getTeam("kit");
				t4.setSuffix(kitsnome().get(p));
			}
		});
		th.start();
	}
	
	
	

}
