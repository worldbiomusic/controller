package worldbiomusic.controller;

import org.bukkit.Material;

import worldbiomusic.controller.dynamics.ControlItem;

public enum PlayerControlType {
	CHAT(new ControlItem(Material.GRASS, "Chat", true)),
	MOVE(new ControlItem(Material.DIRT, "Move", true) ),
	PVP(new ControlItem(Material.WOOD_SWORD, "PVP", true)),
	BLOCK_BREAK(new ControlItem(Material.COBBLESTONE, "Block_Break", true)),
	BLOCK_PLACE(new ControlItem(Material.STONE, "Block_Place", true)),
	MOB_HIT(new ControlItem(Material.SKULL_ITEM, "Mob_Hit", true)),
	CRAFTING(new ControlItem(Material.WORKBENCH, "Crafting", true)),
	PORTAL(new ControlItem(Material.WOOD_DOOR, "Portal", true)),
	TIME(new ControlItem(Material.WATCH, "Time", true)),
	WEATHER(new ControlItem(Material.GLASS, "Weather", true)),
	ITEM_PICKUP(new ControlItem(Material.ITEM_FRAME, "Item_PickUp", true)),
	ITEM_DROP(new ControlItem(Material.FLOWER_POT_ITEM, "Item_PickUp", true)),
	LEVEL(new ControlItem(Material.EXP_BOTTLE, "Level", true)),
	
	
	
	
	
	;
	
	ControlItem item;
	
	PlayerControlType(ControlItem item) {
		this.item = item;
//		Material.EXP_BOTTLE
	}
	
	public ControlItem getItem() {
		return this.item;
	}
}
