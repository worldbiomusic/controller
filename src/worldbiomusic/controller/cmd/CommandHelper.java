package worldbiomusic.controller.cmd;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import worldbiomusic.controller.util.InventoryGUIHelper;
import worldbiomusic.controller.util.Setting;

public class CommandHelper implements CommandExecutor{

	InventoryGUIHelper guiHelper;
	
	Setting setting;
	
	public CommandHelper(Setting setting)
	{
		this.guiHelper = new InventoryGUIHelper();
		this.setting = setting;
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
			p.sendMessage("open controller GUI");
			
			// get Static / Dynamic choice inventory GUI
			guiHelper.createNewInventory(null, 9, setting.controllerMenuTitle);
			guiHelper.setEmptySpaceToItem(Material.THIN_GLASS, " ");
			
			
			guiHelper.setItem(3, new ItemStack(Material.ENDER_CHEST), setting.staticItemDisplayName);
			guiHelper.setItem(5, new ItemStack(Material.CHEST), setting.dynamicItemDisplayName);
			
			Inventory inv = guiHelper.getInventory();
			
			// open inv
			p.openInventory(inv);
			
			return true;
		}
		
		
		
		return false;
	}

}
