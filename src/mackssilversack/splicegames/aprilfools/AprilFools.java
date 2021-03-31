package mackssilversack.splicegames.aprilfools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AprilFools extends JavaPlugin {

	@Override
	public void onEnable() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				if (Bukkit.getOnlinePlayers().size() != 0) {
					if (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 1
							&& Calendar.getInstance().get(Calendar.MONTH) + 1 == 4) {
						ArrayList<Player> allPlayers = new ArrayList<Player>();
						for (Player players : Bukkit.getOnlinePlayers()) {
							allPlayers.add(players);
						}
						int random = new Random().nextInt(allPlayers.size());
						Player bannedPlayer = allPlayers.get(random);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"litebans:ban {player} 1s April Fools: Banned by the Hourly Ban System"
										.replace("{player}", bannedPlayer.getName()));
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pa &6{player} &fwas banned by the Hourly Ban System".replace("{player}",
										bannedPlayer.getName()));
					}
				}
			}
		}, 0, 20 * 60 * 60L);
		return;
	}
}
