package worldbiomusic.controller;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import worldbiomusic.controller.cmd.CommandHelper;
import worldbiomusic.controller.util.Setting;

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
		
		addCommands();
		addEvents();
		
		// notify on
		server.getConsoleSender().sendMessage(ChatColor.GREEN + "Controller ON");
	}
	
	void setupOnDisable()
	{
		// notify on
		server.getConsoleSender().sendMessage(ChatColor.GREEN + "Controller OFF");
	}
	
	void addCommands()
	{
		getCommand("c").setExecutor(new CommandHelper(setting));
	}
	
	void addEvents()
	{
		
	}
}
