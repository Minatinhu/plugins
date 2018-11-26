package minato.kitpvp.main.eventos;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import minato.kitpvp.main.kitmain.KitMain;
import minato.kitpvp.main.kittype.KitType;

public class InteractOpen extends KitMain implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cKitSelector")) {
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				abrir(e.getPlayer());
			}
		}
	}

	private void abrir(Player player) {
		Inventory inv = Bukkit.createInventory(null, 4*9, "§2Seus Kits");
		for(KitType kit : KitType.values()) {
			switch(kit) {
			case AJNIN:
				break;
			case ARCHER:
				break;
			case DEFAULT:
				ItemStack i = new ItemStack(Material.STONE_SWORD);
				ItemMeta meta = i.getItemMeta();
				meta.setDisplayName("§3Default");
				String[] lore = {"Um kit simples para iniciantes"};
				meta.setLore(Arrays.asList(lore));
				i.setItemMeta(meta);
				inv.setItem(0, i);
				break;
			case DILMA:
				break;
			case MELIODAS:
				break;
			case NINJA:
				break;
			case STOMPER:
				ItemStack i2 = new ItemStack(Material.IRON_BOOTS);
				ItemMeta meta2 = i2.getItemMeta();
				meta2.setDisplayName("§2Stomper");
				String[] lore2 = {"§4 - Ao pular encima de um player ele irá receber o dano de queda que você iria receber\n e você irá levar apenas 2 coração de dano de queda."};
				i2.setItemMeta(meta2);
				inv.setItem(1, i2);
				break;
			default:
				break;
			
			}
		}
		player.openInventory(inv);
		
	}
	
	@EventHandler
	public void KitSelector(InventoryClickEvent e) {
		
	}

}
