package worldbiomusic.controller.dynamics;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ControlItem extends ItemStack {
	boolean state;

	public ControlItem(Material material, String displayName, boolean state) {
		super(material);

		setDisplayName(displayName);
		setState(state);
	}

	public void setState(boolean state) {
		this.state = state;
		
		// set lore with state
		ChatColor color = (state) ? ChatColor.GREEN : ChatColor.RED;
		String onoff = (state) ? "ON" : "OFF";
		setLore(new String[] { color + onoff});
	}

	public boolean getState() {
		return this.state;
	}
	
	public void changeState() {
		setState(!state);
	}

	public void setDisplayName(String displayName) {
		ItemMeta meta = getItemMeta();
		meta.setDisplayName(displayName);
		setItemMeta(meta);
	}

	public void setLore(String[] lores) {
		ItemMeta meta = getItemMeta();

		ArrayList<String> loreList = new ArrayList<String>();
		for (String lore : lores) {
			loreList.add(lore);
		}

		meta.setLore(loreList);

		setItemMeta(meta);
	}
}
