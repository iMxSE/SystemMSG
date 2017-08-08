package command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import us.imarco.msg.Main;

public class ReplyCommand implements CommandExecutor{
	Main main = Main.getPlugin(Main.class);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§c[Error] Only player can use this command!");
			return false;
		}
		if (!sender.hasPermission("message.send")) {
			sender.sendMessage("§cYou no have permissions!");
			return false;
		}
		if (cmd.getName().equalsIgnoreCase("r")) {
			if(args.length == 0) {
				sender.sendMessage("§cPorfavor specifica el mensaje");
				return false;
				
			}
			else {
				Player player = (Player) sender;
				Player target = main.lastmsg.get(player);
				if (target == null) {
					sender.sendMessage("§cEl jugador no esta conectado!");
					return false;
				}
				StringBuilder str = new StringBuilder();
				for (int i = 0; i < args.length; i++) {
					str.append(args[1] + " ");
				}
				sender.sendMessage("§eMe §6-) §e" + target.getName() + "§6: " + str.toString());
				target.sendMessage(ChatColor.YELLOW + player.getName() + "§6-) Me: " + str.toString());
				
			}
		}
		
		return false;
		
	}

		
}
