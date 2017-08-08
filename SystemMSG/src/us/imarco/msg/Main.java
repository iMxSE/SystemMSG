package us.imarco.msg;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import command.MessageCommand;
import command.ReplyCommand;

public class Main extends JavaPlugin{
	
	public HashMap<Player, Player> lastmsg = new HashMap<Player, Player>();
	
	public void onEnable() {
		Bukkit.getServer().getLogger().info("SystemMSG enable v 0.0.1");
		
		this.getCommand("msg").setExecutor(new MessageCommand());
		this.getCommand("r").setExecutor(new ReplyCommand());
	}
	
	public void onDisable() {
		Bukkit.getServer().getLogger().info("SystemMSG Disable");
	}

}
