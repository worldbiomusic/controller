package worldbiomusic.controller.util;

public class Setting {
	public static final boolean DEBUG = true;

	// common
	public String controllerMenuTitle;
	public String staticItemDisplayName;
	public String dynamicItemDisplayName;
	
	// static
	
	
	// dynamic
	public String dynamicMenuTitle;
	
	public String dynamicAllPlayerItemDisplayName;
	public String dynamicEachPlayerItemDisplayName;
	
	public String dynamicAllPlayerMenuTitle;
	public String dynamicEachPlayerMenuTitle;
	
	
	
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
		
		
		// static
		
		
		//dynamic
		this.dynamicMenuTitle = "Dynamic Menu";
		
		this.dynamicAllPlayerItemDisplayName = "All Player";
		this.dynamicEachPlayerItemDisplayName = "Each Player";
		
		this.dynamicAllPlayerMenuTitle = "All Player Menu";
		this.dynamicEachPlayerMenuTitle = "Each Player Menu";
	}
	
}
