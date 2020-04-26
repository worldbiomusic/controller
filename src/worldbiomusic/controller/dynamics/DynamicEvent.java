package worldbiomusic.controller.dynamics;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import worldbiomusic.controller.Main;
import worldbiomusic.controller.PlayerControlType;
import worldbiomusic.controller.util.Setting;

public class DynamicEvent implements Listener{

	Setting setting;
	DynamicManager dm;
	
	public DynamicEvent(Setting setting, DynamicManager dm) {
		this.setting = setting;
		this.dm = dm;
		
		onChangedTime();
	}
	
	void sendMsg(Player p, String msg) {
		if(Setting.DEBUG)
			p.sendMessage(msg);
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		sendMsg(p, "chat");
		if( ! dm.getControlItem(PlayerControlType.CHAT).getState()) {
			e.setCancelled(true);
			sendMsg(p, "blocked");
		}
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		sendMsg(p, "move");
		if( ! dm.getControlItem(PlayerControlType.MOVE).getState()) {
			e.setCancelled(true);
			sendMsg(p, "blocked");
		}
	}
	
	@EventHandler
	public void onPlayerPVP(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			Player p = (Player) e.getDamager();
			
			sendMsg(p, "pvp");
			if( ! dm.getControlItem(PlayerControlType.PVP).getState()) {
				e.setCancelled(true);
				sendMsg(p, "blocked");
			}
		}
		
	}
	
	@EventHandler
	public void onPlayerBreakBlock(BlockBreakEvent e) {
		Player p = e.getPlayer();
		sendMsg(p, "break block");
		if( ! dm.getControlItem(PlayerControlType.BLOCK_BREAK).getState()) {
			e.setCancelled(true);
			sendMsg(p, "blocked");
		}
	}
	
	@EventHandler
	public void onPlayerPlaceBlock(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		sendMsg(p, "place block");
		if( ! dm.getControlItem(PlayerControlType.BLOCK_PLACE).getState()) {
			e.setCancelled(true);
			sendMsg(p, "blocked");
		}
	}
	
	@EventHandler
	public void onMobHit(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player && e.getEntity() instanceof Monster) {
			Player p = (Player) e.getDamager();
			
			sendMsg(p, "mob hit");
			if( ! dm.getControlItem(PlayerControlType.MOB_HIT).getState()) {
				e.setCancelled(true);
				sendMsg(p, "blocked");
			}
		}
	}
	
	@EventHandler
	public void onCrafting(CraftItemEvent e) {
		Player p = (Player) e.getWhoClicked();
		sendMsg(p, "craft");
		if( ! dm.getControlItem(PlayerControlType.CRAFTING).getState()) {
			e.setCancelled(true);
			sendMsg(p, "blocked");
		}
	}
	
	public void onChangedTime() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				if( ! dm.getControlItem(PlayerControlType.TIME).getState()) {
					List<World> worlds = (ArrayList<World>) Main.getInstance().getServer().getWorlds();
					for(World w : worlds) {
						w.setTime(w.getTime() - 20L);
					}
					Bukkit.broadcastMessage("blocked");
				}
			}
			
		}, 0L, 20L);
		
	}
	
	@EventHandler
	public void onWeatherChanged(WeatherChangeEvent e) {
		if( ! dm.getControlItem(PlayerControlType.WEATHER).getState()) {
			e.setCancelled(true);
			Bukkit.broadcastMessage("blocked");
		}
	}
	
	@EventHandler
	public void onPlayerPickUpItem(EntityPickupItemEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			sendMsg(p, "pickup item");
			if( ! dm.getControlItem(PlayerControlType.ITEM_PICKUP).getState()) {
				e.setCancelled(true);
				sendMsg(p, "blocked");
			}
			
		}
	}
	
	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		sendMsg(p, "drop item");
		if( ! dm.getControlItem(PlayerControlType.ITEM_DROP).getState()) {
			e.setCancelled(true);
			sendMsg(p, "blocked");
		}
	}
	
	@EventHandler
	public void onPlayerLevelChanged(PlayerLevelChangeEvent e) {
		Player p = e.getPlayer();
		sendMsg(p, "level change");
		if( ! dm.getControlItem(PlayerControlType.LEVEL).getState()) {
			p.setLevel(e.getOldLevel());
			sendMsg(p, "blocked");
		}
	}
	
	
	
	
	
	
}








































