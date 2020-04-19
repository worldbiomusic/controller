package controller.src.main;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import controller.src.setting.Setting;

/*
 * 목표: object oriented 지켜가며 코드 짜기
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
		
		// MARK: notify on
		if(setting.DEBUG)
			server.getConsoleSender().sendMessage("#####controller ON#####");
	}
	
	void setupOnDisable()
	{
		// MARK: notify on
		if(setting.DEBUG)
			server.getConsoleSender().sendMessage("#####controller OFF#####");
	}
}
