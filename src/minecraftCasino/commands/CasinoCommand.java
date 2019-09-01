package minecraftCasino.commands;

import minecraftCasino.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import minecraftCasino.player.CasinoPlayer;

public class CasinoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {


        if (sender instanceof Player) {
            if (!Main.getInstance().getCasinoPlayerList().getList().containsKey(((Player) sender).getUniqueId())) {

                Player player = (Player) sender;
                CasinoPlayer casinoPlayer = new CasinoPlayer(player);
                casinoPlayer.getWinPerSpin().push(0);
                Main.getInstance().getCasinoPlayerList().getList().put(player.getUniqueId(), casinoPlayer);
                Main.getInstance().getCasinoPlayerList().getList().get(player.getUniqueId()).setCasinoPlayer(true);
                Main.getInstance().setCasinoStone(new ItemStack(Material.EMERALD));
                ItemMeta m = Main.getInstance().getCasinoStone().getItemMeta();
                m.setDisplayName(ChatColor.GOLD + "CASINO");
                m.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
                Main.getInstance().getCasinoStone().setItemMeta(m);

                player.getInventory().setItem(4, Main.getInstance().getCasinoStone());
                player.sendMessage(Main.getInstance().getUtils().prefix() + ChatColor.GOLD + "" + ChatColor.MAGIC + "XXX" + ChatColor.RESET + "" + ChatColor.GOLD + " GOOD LUCK " + ChatColor.MAGIC + "XXX");

                return true;
            } else {
                sender.sendMessage(Main.getInstance().getUtils().prefix() + "You are already registered in the casino");
            }


        } else {
            sender.sendMessage(Main.getInstance().getUtils().prefix() + "You are not a player");
        }
        return true;

    }


}
