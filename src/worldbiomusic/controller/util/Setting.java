package worldbiomusic.controller.util;

import worldbiomusic.controller.PlayerControlType;

public class Setting {
	public static final boolean DEBUG = true;

	// common
	public String controllerMenuTitle;
	public String staticItemDisplayName;
	public String dynamicItemDisplayName;
	public String backItemDisplayName;
	
	// static
	
	
	// dynamic
	public String dynamicMenuTitle;
	
	public String dynamicAllPlayerItemDisplayName;
	public String dynamicEachPlayerItemDisplayName;
	
	public String dynamicAllPlayerMenuTitle;
	public String dynamicEachPlayerMenuTitle;
	
	public int dynamicAllPlayerSize;
	
	
	public Setting()
	{
		initValues();
	}
	
	public void initValues()
	{
		// common
		this.controllerMenuTitle = "Controller Menu";
		this.staticItemDisplayName = "Static";
		this.dynamicItemDisplayName = "Dynamic";
		this.backItemDisplayName = "BACK";
		
		// static
		
		
		//dynamic
		this.dynamicMenuTitle = "Dynamic Menu";
		
		this.dynamicAllPlayerItemDisplayName = "All Player";
		this.dynamicEachPlayerItemDisplayName = "Each Player";
		
		this.dynamicAllPlayerMenuTitle = "All Player Menu";
		this.dynamicEachPlayerMenuTitle = "Each Player Menu";
		
		this.dynamicAllPlayerSize = PlayerControlType.values().length;
	}
	
}
