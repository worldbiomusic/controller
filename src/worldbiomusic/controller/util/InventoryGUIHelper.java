package worldbiomusic.controller.util;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryGUIHelper{
	
	Inventory inv;
	
	public void setInventory(Inventory inv)
	{
		this.inv = inv;
	}
	
	public Inventory getInventory()
	{
		return this.inv;
	}
	
	public void createNewInventory(InventoryHolder owner, int size, String title)
	{
		this.inv = Bukkit.createInventory(owner, size, title);
	}
	
	public void setEmptySpaceToItem(Material material, String displayName)
	{
		// dummy item
		ItemStack dummy = new ItemStack(material);
		ItemMeta meta = dummy.getItemMeta();
		meta.setDisplayName(displayName);
		dummy.setItemMeta(meta);
		
		
		// set dummy into inv
		ItemStack[] allItems = inv.getStorageContents();
		
		for(int i = 0; i < inv.getSize(); i++)
		{
			if(allItems[i] == null)
			{
				allItems[i] = dummy;
			}
		}
		
		inv.setStorageContents(allItems);
	}
	
	public void setItem(int slot, ItemStack item)
	{
		setItem(slot, item, null, null);
	}
	
	public void setItem(int slot, ItemStack item, String displayName)
	{
		setItem(slot, item, displayName, null);
	}
	
	
	public void setItem(int slot, ItemStack item, String displayName, String[] lores)
	{
		// set meta
		ItemMeta meta = item.getItemMeta();
		
		// set display name
		meta.setDisplayName(displayName);
		
		// set lore
		if(lores != null)
		{
			ArrayList<String> loreList = new ArrayList<String>();
			for(String lore : lores)
			{
				loreList.add(lore);
			}
			meta.setLore(loreList);
		}
		
		item.setItemMeta(meta);

		// set item to inv
		inv.setItem(slot, item);
	}
}
