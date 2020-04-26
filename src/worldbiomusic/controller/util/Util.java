package worldbiomusic.controller.util;

import org.bukkit.entity.Player;

public class Util {
	public static void DebugMsg(Player p, String msg) {
		if (Setting.DEBUG) {
			p.sendMessage(msg);
		}
	}
}
