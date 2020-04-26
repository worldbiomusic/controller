package worldbiomusic.controller.dynamics;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import worldbiomusic.controller.util.InventoryGUIHelper;
import worldbiomusic.controller.util.Setting;

public class DynamicGUIManager implements Listener {

	InventoryGUIHelper guiHelper; // 이거 멤버변수로 하면 비동기화 위험이 있기도하고, 따로 쓰는편이 좋을것 같음

	Setting setting;

	DynamicManager dm;

	public DynamicGUIManager(Setting setting, DynamicManager dm) {
		this.guiHelper = new InventoryGUIHelper();
		this.setting = setting;
		this.dm = dm;
	}

	@EventHandler
	public void onPlayerClickControllerMenu(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		Player p = (Player) e.getWhoClicked();

		// check inventory title
		if (!inv.getTitle().equals(setting.controllerMenuTitle)) {
			return;
		}

		// set event cancelled
		e.setCancelled(true);

		// open Dynamic menu
		ItemStack item = e.getCurrentItem();
		if (item == null) {
			return;
		}

		ItemMeta meta = item.getItemMeta();
		if (meta == null)
			return;

		String menu = meta.getDisplayName();
		if(menu == null)
			return;
		
		if (menu.equals(setting.dynamicItemDisplayName)) {
			p.sendMessage("you clicked dynamic");

			Inventory dynamicMenuInv = getDynamicMenu();
			p.openInventory(dynamicMenuInv);
		}
	}

	@EventHandler
	public void onPlayerClickDynamicMenu(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		Player p = (Player) e.getWhoClicked();

		// check inventory title
		if (!inv.getTitle().equals(setting.dynamicMenuTitle)) {
			return;
		}

		// set event cancelled
		e.setCancelled(true);

		// open selected menu (All Player & Each Player)
		ItemStack item = e.getCurrentItem();
		if (item == null) {
			return;
		}

		ItemMeta meta = item.getItemMeta();
		if (meta == null)
			return;

		String menu = meta.getDisplayName();

		if (menu.equals(setting.dynamicAllPlayerItemDisplayName)) {
			p.sendMessage("you clicked dynamic all player");
			Inventory AllPlayerMenu = getDynamicAllPlayerMenu();
			p.openInventory(AllPlayerMenu);

		} else if (menu.equals(setting.dynamicEachPlayerItemDisplayName)) {
			p.sendMessage("you clicked dynamic each player");
			Inventory EachPlayerMenu = getDynamicEachPlayerMenu();
			p.openInventory(EachPlayerMenu);
		} else if (menu.equals(setting.backItemDisplayName)) {
			p.openInventory(getControlMenu());
		}

	}

	@EventHandler
	public void onPlayerClickDynamicAllPlayerMenu(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		Player p = (Player) e.getWhoClicked();

		// check inventory title
		if (!inv.getTitle().equals(setting.dynamicAllPlayerMenuTitle)) {
			return;
		}

		// set event cancelled
		e.setCancelled(true);


		
		
		// open selected menu
		ItemStack item = e.getCurrentItem();
		if (item == null) {
			return;
		}

		ItemMeta meta = item.getItemMeta();
		if (meta == null)
			return;

		String menu = meta.getDisplayName();
		if(menu == null)
			return;
		
		// back
		if (menu.equals(setting.backItemDisplayName)) {
			p.openInventory(getDynamicMenu());
		}
		
		
		

		// change state of controlItem
		int slot = e.getSlot();

		ControlItem ctrlItem = dm.getControlItem(slot);
		if (ctrlItem == null) {
			return;
		}
		

		ctrlItem.changeState();

		// update viewing inventory
		inv.setItem(slot, ctrlItem);
	}

	@EventHandler
	public void onPlayerClickDynamicEachPlayerMenu(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		Player p = (Player) e.getWhoClicked();

		// check inventory title
		if (!inv.getTitle().equals(setting.dynamicEachPlayerMenuTitle)) {
			return;
		}

		// set event cancelled
		e.setCancelled(true);

		// open selected menu
		ItemStack item = e.getCurrentItem();
		if (item == null) {
			return;
		}

		ItemMeta meta = item.getItemMeta();
		if (meta == null)
			return;

		String menu = meta.getDisplayName();
		if(menu == null)
			return;
		
		// back
		if (menu.equals(setting.backItemDisplayName)) {
			p.openInventory(getDynamicMenu());
		}
	}

	Inventory getControlMenu() {
		// get Static / Dynamic choice inventory GUI
		guiHelper.createNewInventory(null, 9, setting.controllerMenuTitle);
		guiHelper.setEmptySpaceToItem(Material.THIN_GLASS, " ");

		guiHelper.setItem(3, new ItemStack(Material.ENDER_CHEST), setting.staticItemDisplayName);
		guiHelper.setItem(5, new ItemStack(Material.CHEST), setting.dynamicItemDisplayName);

		Inventory inv = guiHelper.getInventory();

		return inv;
	}

	Inventory getDynamicMenu() {
		Inventory inv;

		guiHelper.createNewInventory(null, 9, setting.dynamicMenuTitle);
		guiHelper.setEmptySpaceToItem(Material.THIN_GLASS, " ");

		guiHelper.setItem(3, new ItemStack(Material.ARMOR_STAND), setting.dynamicAllPlayerItemDisplayName);
		guiHelper.setItem(5, new ItemStack(Material.SKULL_ITEM, 1, (byte) 3), setting.dynamicEachPlayerItemDisplayName);
		guiHelper.setItem(0, new ItemStack(Material.BARRIER), setting.backItemDisplayName);

		inv = guiHelper.getInventory();

		return inv;
	}

	Inventory getDynamicAllPlayerMenu() {
		Inventory inv;

		guiHelper.createNewInventory(null, 54, setting.dynamicAllPlayerMenuTitle);
		guiHelper.setEmptySpaceToItem(Material.THIN_GLASS, " ");
		guiHelper.setItem(49, new ItemStack(Material.BARRIER), setting.backItemDisplayName);

		// TODO: capsulate dm
		for (int slot = 0; slot < setting.dynamicAllPlayerSize; slot++) {
			ControlItem item = dm.getControlItem(slot);
			guiHelper.setItem(slot, item);
		}

		
		
		inv = guiHelper.getInventory();

		return inv;
	}

	Inventory getDynamicEachPlayerMenu() {
		Inventory inv;

		guiHelper.createNewInventory(null, 54, setting.dynamicEachPlayerMenuTitle);
		guiHelper.setEmptySpaceToItem(Material.THIN_GLASS, " ");
		guiHelper.setItem(49, new ItemStack(Material.BARRIER), setting.backItemDisplayName);

		inv = guiHelper.getInventory();

		return inv;
	}
}
