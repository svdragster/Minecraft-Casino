package minecraftCasino.commands;

import minecraftCasino.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExitCasinoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("casino")) {
                    Player player = (Player) sender;


                    if (Main.getInstance().getCasinoPlayerList().getList().containsKey(player.getUniqueId())) {
                        Main.getInstance().getCasinoPlayerList().getList().remove(player.getUniqueId());
                        player.getInventory().clear();
                        player.sendMessage(Main.getInstance().getUtils().prefix() + ChatColor.GREEN + "You were removed from the casino");
                        return true;
                    } else {
                        player.sendMessage(Main.getInstance().getUtils().prefix() + ChatColor.RED + "You are not registered in to the casino");
                        return true;
                    }
                } else return false;
            } else return false;
        } else {
            sender.sendMessage(Main.getInstance().getUtils().prefix() + "You are not a player");
        }

        return true;
    }
}