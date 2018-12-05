package minato.kitpvp.main.eventos;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
		if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("�cHabilidades")) {
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				abrir(e.getPlayer());
			}
		}
	}

	private void abrir(Player player) {
		Inventory inv = Bukkit.createInventory(null, 4*9, "�7Habilidades");
		for(KitType kit : KitType.values()) {
			switch(kit) {
			case AJNIN:
				break;
			case ARCHER:
				break;
			case DEFAULT:
				ItemStack i = new ItemStack(Material.STONE_SWORD);
				ItemMeta meta = i.getItemMeta();
				meta.setDisplayName("�fCl�ssico");
				String[] lore = {"Uma habilidade simples para iniciantes"};
				meta.setLore(Arrays.asList(lore));
				i.setItemMeta(meta);
				inv.setItem(0, i);
				break;
			case DILMA:
				ItemStack i3 = new ItemStack(Material.BLAZE_ROD);
				ItemMeta meta3 = i3.getItemMeta();
				meta3.setDisplayName("�3Dilma");
				String[] lore3 = {"�cEssa habilidade estoca e solta vento, impurrando seu adiversario para longe"};
				i3.setItemMeta(meta3);
				inv.setItem(2, i3);
				break;
			case MELIODAS:
				break;
			case NINJA:
				ItemStack i4 = new ItemStack(Material.POTION);
				break;
			case STOMPER:
				ItemStack i2 = new ItemStack(Material.IRON_BOOTS);
				ItemMeta meta2 = i2.getItemMeta();
				meta2.setDisplayName("�2Stomper");
				String[] lore2 = {"�4 - Ao pular encima de um player ele ir� receber o dano de queda que voc� iria receber\n e voc� ir� levar apenas 2 cora��o de dano de queda."};
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
		Player p = (Player) e.getWhoClicked();
		if(e.getClickedInventory().getTitle().equalsIgnoreCase("�2Seus Kits")) {
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Default") ) {
				addKit(p, KitType.DEFAULT);
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Stomper")) {
				addKit(p, KitType.STOMPER);
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Dilma")) {
				addKit(p, KitType.DILMA);
			}
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage(ChatColor.YELLOW + "[Habilidade] Voce selecionou a habilidade " + kitsnome().get(p));
		}
	}

}
