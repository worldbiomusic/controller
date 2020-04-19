package worldbiomusic.controller.main;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import worldbiomusic.controller.setting.Setting;

/*
 * object oriented 
 */

public class Main extends JavaPlugin{
	
	Server server;
	Setting setting;
	
	@Override
	public void onEnable() 
	{
		setupOnEnable();
	}
	
	
	@Override
	public void onDisable() 
	{
		setupOnDisable();
	}
	
	void setupOnEnable()
	{
		this.server = getServer();
		setting = new Setting();
		
		// notify on
		server.getConsoleSender().sendMessage(ChatColor.GREEN + "Controller ON");
	}
	
	void setupOnDisable()
	{
		// notify on
		server.getConsoleSender().sendMessage(ChatColor.GREEN + "Controller OFF");
	}
}
