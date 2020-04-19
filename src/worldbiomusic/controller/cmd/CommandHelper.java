package worldbiomusic.controller.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHelper implements CommandExecutor{

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
			p.sendMessage("open controller GUI");
			
			
			
			return true;
		}
		
		
		
		return false;
	}

}
