package minato.kitpvp.main.kitmain;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import minato.kitpvp.main.kittype.KitType;

public class KitMain {
	
	private static Map<Player, KitType> kitpvp = new HashMap<>();
	private static Map<Player, String> kitnome =  new HashMap<>();
	private static Map<Player, Integer> seguencia = new HashMap<>();
	
	public static Map<Player, Integer> getSeguencia() {
		return seguencia;
	}
	
	public static Map<Player, String> kitsnome() {
		return kitnome;
	}
	
	public static Map<Player, KitType> kitspvp() {
		return kitpvp;
	}
	
	public void addKit(Player p, KitType kit) {
		p.getInventory().setArmorContents(null);
		p.getInventory().clear();
		switch(kit) {
		case AJNIN:
			break;
		case ARCHER:
			break;
		case DEFAULT:
			p.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
			kitpvp.put(p, KitType.DEFAULT);
			kitnome.put(p, "Default");
			break;
		case DILMA:
			p.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
			ItemStack i = new ItemStack(Material.BLAZE_ROD);
			ItemMeta meta = i.getItemMeta();
			meta.setDisplayName("§4Habilidade Dilma");
			i.setItemMeta(meta);
			p.getInventory().setItem(1, i);
			kitpvp.put(p, KitType.DILMA);
			kitnome.put(p, "Dilma");
			break;
		case MELIODAS:
			break;
		case NINJA:
			break;
		case STOMPER:
			p.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			kitpvp.put(p, KitType.STOMPER);
			kitnome.put(p, "Stomper");
			break;
		default:
			break;
		
		}
		for(ItemStack i : p.getInventory().getContents()) {
			if(i == null) {
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
