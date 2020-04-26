package worldbiomusic.controller;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import worldbiomusic.controller.cmd.CommandHelper;
import worldbiomusic.controller.dynamics.DynamicGUIManager;
import worldbiomusic.controller.dynamics.DynamicManager;
import worldbiomusic.controller.dynamics.DynamicEvent;
import worldbiomusic.controller.statics.StaticManager;
import worldbiomusic.controller.util.Setting;

/*
 * object oriented 
 */

public class Main extends JavaPlugin{
	
	Server server;
	Setting setting;
	
	StaticManager sm;
	DynamicManager dm;
	
	DynamicGUIManager dGUIM;
	
	static Main main;
	
	public static Main getInstance() {
		return main;
	}
	
	@Override
	public void onEnable() 
	{
		main = this;
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
		
		sm = new StaticManager();
		dm = new DynamicManager(setting); 
		
		dGUIM = new DynamicGUIManager(setting, dm);
		dm.attachGUIManager(dGUIM);
		
		
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
		getCommand("c").setExecutor(new CommandHelper(setting, sm, dm));
	}
	
	void addEvents()
	{
		server.getPluginManager().registerEvents(dGUIM, this);
		server.getPluginManager().registerEvents(new DynamicEvent(setting, dm), this);
	}
}
