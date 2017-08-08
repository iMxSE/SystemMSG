package command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import us.imarco.msg.Main;

public class MessageCommand implements CommandExecutor{
	Main main = Main.getPlugin(Main.class);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("[ERROR] Only player can use the command!");
			return false;
		}
		if (!sender.hasPermission("message.send")) {
			sender.sendMessage("§cNo tienes permisos!");
			return false;
		}
		
		if (cmd.getName().equalsIgnoreCase("msg")) {
			if (args.length == 0) {
				sender.sendMessage("§cUsa: /msg (player) (message)");
				return false;
			}
			else if (args.length ==1) {
				sender.sendMessage("§cPorfavor specifica el mensaje");
				return false;
			}
		}
		else {
			Player target = Bukkit.getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage("§Jugador no encontrado");
				return false;
			}
			StringBuilder str = new StringBuilder();
			for (int i = 1; i < args.length; i++) {
				str.append(args[1] + " ");
			}
			Player player = (Player) sender;
			
			sender.sendMessage("§eMe §6-) §e" + target.getName() + "§6: " + str.toString());
			target.sendMessage(ChatColor.YELLOW + player.getName() + "§6-) Me: " + str.toString());
			main.lastmsg.put(player, target);
		}
		return false;
	}

}
