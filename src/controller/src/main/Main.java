package controller.src.main;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import controller.src.setting.Setting;

/*
 * ��ǥ: object oriented ���Ѱ��� �ڵ� ¥��
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
