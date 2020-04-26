package worldbiomusic.controller.dynamics;

import java.util.HashMap;

import org.bukkit.inventory.Inventory;

import worldbiomusic.controller.PlayerControlType;
import worldbiomusic.controller.util.Setting;

public class DynamicManager {

	HashMap<Integer, ControlItem> allPlayerControlItem;
	// Integer, ControllItem
	// String(title), Boolean
	// 출력할 때, 선택할 때

	DynamicGUIManager gui;

	Setting setting;

	public DynamicManager(Setting setting) {
		allPlayerControlItem = new HashMap<Integer, ControlItem>();
		this.setting = setting;

		initAllPlayerControlItem();

	}

	void initAllPlayerControlItem() {
		PlayerControlType[] types = PlayerControlType.values();

		// put items
		for (int i = 0; i < setting.dynamicAllPlayerSize; i++) {
			allPlayerControlItem.put(i, types[i].getItem());
		}
	}

	public Inventory getControlMenu() {
		return gui.getControlMenu();
	}

	public ControlItem getControlItem(int slot) {
		return allPlayerControlItem.get(slot);
	}
	
	public ControlItem getControlItem(PlayerControlType type) {
		for(ControlItem item : allPlayerControlItem.values()) {
			if(item.equals(type.getItem())) {
				return item;
			}
		}
		return null;
	}

	public void attachGUIManager(DynamicGUIManager gui) {
		this.gui = gui;
	}

}







































