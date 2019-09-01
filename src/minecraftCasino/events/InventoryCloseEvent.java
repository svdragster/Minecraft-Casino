package minecraftCasino.events;

import minecraftCasino.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import minecraftCasino.player.CasinoPlayer;

public class InventoryCloseEvent implements Listener {

    @EventHandler
    public void onClose(org.bukkit.event.inventory.InventoryCloseEvent e) {
        HumanEntity player = e.getPlayer();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "CASINO")) {
            while (!Main.getInstance().getCasinoPlayer(player).getWinPerSpin().empty()) {
                Main.getInstance().getCasinoPlayer(player).setWin(Main.getInstance().getCasinoPlayer(player).getWinPerSpin().pop() + Main.getInstance().getCasinoPlayer(player).getWin());
            }
            Main.getInstance().getCasinoPlayer(player).getWinPerSpin().push(0);
            if (Main.getInstance().getCasinoPlayer(player).getCoinsBeforePlay() > Main.getInstance().getCasinoPlayer(player).getCoins()) {
                player.sendMessage(Main.getInstance().getUtils().prefix() + ChatColor.GOLD + "You have lost: " + ChatColor.BOLD + ChatColor.RED + "" + (Main.getInstance().getCasinoPlayer(player).getCoinsBeforePlay() - Main.getInstance().getCasinoPlayer(player).getCoins()) + " COINS");
                Main.getInstance().getCasinoPlayer(player).setCoinsBeforePlay(Main.getInstance().getCasinoPlayer(player).getCoins());
            } else if (Main.getInstance().getCasinoPlayer(player).getCoinsBeforePlay() < Main.getInstance().getCasinoPlayer(player).getCoins()) {
                player.sendMessage(Main.getInstance().getUtils().prefix() + ChatColor.GOLD + "You have won: " + ChatColor.BOLD + "" + (Main.getInstance().getCasinoPlayer(player).getCoins() - Main.getInstance().getCasinoPlayer(player).getCoinsBeforePlay()) + " COINS");
                Main.getInstance().getCasinoPlayer(player).setCoinsBeforePlay(Main.getInstance().getCasinoPlayer(player).getCoins());
            } else player.sendMessage(Main.getInstance().getUtils().prefix() + ChatColor.GOLD + "You have neither won or lost");
            Main.getInstance().getCasinoPlayer(player).setCoinsBeforePlay(Main.getInstance().getCasinoPlayer(player).getCoins());
        }

    }

}
