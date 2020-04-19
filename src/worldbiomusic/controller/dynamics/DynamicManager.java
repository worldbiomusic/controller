package worldbiomusic.controller.dynamics;

import java.util.HashMap;

import org.bukkit.Material;

public class DynamicManager {

	HashMap<Integer, ControlItem> allPlayer;
	// Integer, ControllItem
	// String(title), Boolean
	// 출력할 때, 선택할 때
	
	public DynamicManager()
	{
		allPlayer = new HashMap<Integer, ControlItem>();
		
		ControlItem chatItem = new ControlItem(Material.BOOK_AND_QUILL, "Chat", false);
		allPlayer.put(0, chatItem);
	}
	
	public ControlItem getControlItem(int slot)
	{
		return allPlayer.get(slot);
	}
}
