package worldbiomusic.controller.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import worldbiomusic.controller.dynamics.DynamicManager;
import worldbiomusic.controller.statics.StaticManager;
import worldbiomusic.controller.util.Setting;
import worldbiomusic.controller.util.Util;

public class CommandHelper implements CommandExecutor{

	
	Setting setting;
	
	StaticManager sm;
	DynamicManager dm;
	
	public CommandHelper(Setting setting, StaticManager sm, DynamicManager dm)
	{
		this.setting = setting;
		this.sm = sm;
		this.dm = dm;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		// not console
		if( ! (sender instanceof Player))
		{
			sender.sendMessage("Only Player");
			return true;
		}
		
		Player p = (Player) sender;
		
		// only op
		if( ! p.isOp()) {
			p.sendMessage("Only OP");
			return true;
		}
		
		int length = args.length;
		
		if(length == 0)
		{
			Util.DebugMsg(p, "open controller GUI");
			
			// open inv
			p.openInventory(dm.getControlMenu());
			
			return true;
		}
		
		
		
		return false;
	}

}
