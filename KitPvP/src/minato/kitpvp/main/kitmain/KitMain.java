package minato.kitpvp.main.kitmain;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import minato.kitpvp.main.kittype.KitType;

public class KitMain {
	
	private Map<Player, KitType> kitpvp = new HashMap<>();
	
	public Map<Player, KitType> kitspvp() {
		return kitpvp;
	}
	
	public void addKit(Player p, KitType kit) {
		p.getInventory().clear();
		switch(kit) {
		case AJNIN:
			break;
		case ARCHER:
			break;
		case DEFAULT:
			p.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
			kitpvp.put(p, KitType.DEFAULT);
			break;
		case DILMA:
			break;
		case MELIODAS:
			break;
		case NINJA:
			break;
		case STOMPER:
			break;
		default:
			break;
		
		}
		for(ItemStack i : p.getInventory().getContents()) {
			if(i != null) {
				p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			}
		}
	}
	
	public boolean hasKit(Player p, KitType kit) {
		return kitpvp.get(p) == kit;
	}
	
	public boolean hasKit(Player p) {
		return kitpvp.containsKey(p);
	}

}
