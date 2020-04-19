package worldbiomusic.controller.util;

public class Setting {
	public static final boolean DEBUG = true;

	// common
	public String controllerMenuTitle;
	public String staticItemDisplayName;
	public String dynamicItemDisplayName;
	
	// static
	
	
	// dynamic
	
	
	public Setting()
	{
		initValues();
	}
	
	public void initValues()
	{
		this.controllerMenuTitle = "Controller Menu";
		this.staticItemDisplayName = "Static";
		this.dynamicItemDisplayName = "Dynamic";
	}
	
}
