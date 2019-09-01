package minecraftCasino.commands;

import minecraftCasino.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoinsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            if (s.equalsIgnoreCase("coins")) {
                if (Main.getInstance().getCasinoPlayerList().getList().containsKey(((Player) sender).getUniqueId())) {
                    if (args.length == 0) {

                        sender.sendMessage(Main.getInstance().getUtils().prefix() + ChatColor.BLUE + "COINS: " + Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).getCoins());

                    } else if (args[0].equalsIgnoreCase("add")) {
                        if (args.length == 1) {
                            return false;

                        } else {
                            try {
                                int amount = Integer.parseInt(args[1]);
                                Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).setCoins(Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).getCoins() + amount);
                                Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).setCoinsBeforePlay(Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).getCoins());
                            } catch (NumberFormatException e) {
                                return false;
                            }

                            sender.sendMessage(Main.getInstance().getUtils().prefix() + ChatColor.BLUE + "COINS: " + Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).getCoins());
                        }


                    } else if (args[0].equalsIgnoreCase("remove")) {
                        if (args.length == 1) {
                            return false;

                        } else {
                            try {
                                int amount = Integer.parseInt(args[1]);
                                Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).setCoins(Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).getCoins() - amount);
                                Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).setCoinsBeforePlay(Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).getCoins());
                            } catch (NumberFormatException e) {
                                return false;
                            }

                            sender.sendMessage(Main.getInstance().getUtils().prefix() + ChatColor.BLUE + "COINS: " + Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).getCoins());
                        }
                    } else if (args[0].equalsIgnoreCase("set")) {
                        if (args.length == 1) {

                        } else {
                            try {
                                int amount = Integer.parseInt(args[1]);
                                Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).setCoins(amount);
                                Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).setCoinsBeforePlay(Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).getCoins());
                            } catch (NumberFormatException e) {
                                return false;
                            }
                            sender.sendMessage(Main.getInstance().getUtils().prefix() + ChatColor.BLUE + "COINS: " + Main.getInstance().getCasinoPlayerList().getList().get(((Player) sender).getUniqueId()).getCoins());

                        }


                    } else
                        return false;
                } else
                    sender.sendMessage(Main.getInstance().getUtils().prefix() + ChatColor.RED + "Start the Casino first with /casino");
            }
        } else {
            sender.sendMessage(Main.getInstance().getUtils().prefix() + "You are not a player");
        }


        return true;
    }
}
