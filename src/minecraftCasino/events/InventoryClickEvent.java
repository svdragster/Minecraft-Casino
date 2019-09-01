package minecraftCasino.events;

import minecraftCasino.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import minecraftCasino.player.CasinoPlayer;

public class InventoryClickEvent implements Listener {

    ItemStack spinStone;

    @EventHandler
    public void onClick(org.bukkit.event.inventory.InventoryClickEvent e) {
        e.setCancelled(true);

        HumanEntity player = e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "CASINO")) {


            try {

                if (e.getCurrentItem().equals(Main.getInstance().getStartStone())) {

                    if (Main.getInstance().getCasinoPlayer(player).getCoins() < Main.getInstance().getCasinoPlayer(player).getUseCoins()) {
                        player.closeInventory();
                        player.sendMessage(Main.getInstance().getUtils().prefix() + ChatColor.RED + "You do not have enough Coins\nYour Coin Value: " + Main.getInstance().getCasinoPlayer(player).getCoins());

                    } else {
                        for (int i = 36; i <= 38; i++) {
                            Main.getInstance().getCasinoPlayer(player).getCasinoInventory().getCasinoInventory().setItem(i, Main.getInstance().getCasinoPlayer(player).getCasinoInventory().createItem(Material.REDSTONE_BLOCK, ChatColor.RED + "EXIT"));
                        }

                        for (int i = 42; i <= 44; i++) {
                            Main.getInstance().getCasinoPlayer(player).getCasinoInventory().getCasinoInventory().setItem(i, Main.getInstance().getCasinoPlayer(player).getCasinoInventory().createItem(Material.DIAMOND_BLOCK, ChatColor.GREEN + "SPIN"));
                        }

                        spinStone = Main.getInstance().getCasinoPlayer(player).getCasinoInventory().createItem(Material.DIAMOND_BLOCK, ChatColor.GREEN + "SPIN");
                        Main.getInstance().getUtils().spin(player);
                        Main.getInstance().getCasinoPlayer(player).setCoinsBeforePlay(Main.getInstance().getCasinoPlayer(player).getCoins());


                    }
                } else if (e.getCurrentItem().equals(Main.getInstance().getExitStone())) {
                    player.closeInventory();

                } else if (e.getCurrentItem().equals(Main.getInstance().getUseUpStone())) {

                    Main.getInstance().getCasinoPlayer(player).setUseCoins(Main.getInstance().getCasinoPlayer(player).getUseCoins() + 5);
                    Main.getInstance().getCasinoPlayer(player).getCasinoInventory().getCasinoInventory().setItem(22, new ItemStack(Main.getInstance().getCasinoPlayer(player).getCasinoInventory().createItem(Material.BLAZE_ROD, ChatColor.BLUE + "IN USE: " + Main.getInstance().getCasinoPlayer(player).getUseCoins() + " COINS")));

                } else if (e.getCurrentItem().equals(Main.getInstance().getUseDownStone())) {

                    if (Main.getInstance().getCasinoPlayer(player).getUseCoins() > 5) {

                        Main.getInstance().getCasinoPlayer(player).setUseCoins(Main.getInstance().getCasinoPlayer(player).getUseCoins() - 5);
                        Main.getInstance().getCasinoPlayer(player).getCasinoInventory().getCasinoInventory().setItem(22, new ItemStack(Main.getInstance().getCasinoPlayer(player).getCasinoInventory().createItem(Material.BLAZE_ROD, ChatColor.BLUE + "IN USE: " + Main.getInstance().getCasinoPlayer(player).getUseCoins() + " COINS")));

                    }

                } else if (e.getCurrentItem().equals(spinStone)) {
                    if (Main.getInstance().getCasinoPlayer(player).getCoins() >= Main.getInstance().getCasinoPlayer(player).getUseCoins()) {
                        Main.getInstance().getCasinoPlayer(player).setCoins(Main.getInstance().getCasinoPlayer(player).getCoins() - Main.getInstance().getCasinoPlayer(player).getUseCoins());
                        Main.getInstance().getCasinoPlayer(player).getWinPerSpin().add(0);
                        Main.getInstance().getUtils().spin(player);

                        player.sendMessage("\n\n");
                        for (int i = 1; i <= 3; i++) {
                            if (i == 1) {
                                Main.getInstance().getUtils().checkWin((Player) player, i, 0, 1, 2, 11);
                            } else if (i == 2) {
                                Main.getInstance().getUtils().checkWin((Player) player, i, 3, 4, 5, 20);
                            } else if (i == 3) {
                                Main.getInstance().getUtils().checkWin((Player) player, i, 6, 7, 8, 29);
                            }


                        }
                        Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem(41, Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.EMERALD_BLOCK, ChatColor.RED + "WIN: " + Main.getInstance().getCasinoPlayer(player).getWinPerSpin().peek()));
                        if (Main.getInstance().getCasinoPlayer(player).getWinPerSpin().peek() > 0) {
                            player.sendMessage(Main.getInstance().getUtils().prefix() + ChatColor.GOLD + "WIN: " + ChatColor.BOLD + Main.getInstance().getCasinoPlayer(player).getWinPerSpin().peek() + " COINS");
                        }


                        Main.getInstance().getCasinoPlayer(player).setCoins(Main.getInstance().getCasinoPlayer(player).getCoins() + Main.getInstance().getCasinoPlayer(player).getWinPerSpin().peek());
                    } else {
                        player.sendMessage(Main.getInstance().getUtils().prefix() + ChatColor.RED + "You do not have enough Coins\nYour Coin Value: " + Main.getInstance().getCasinoPlayer(player).getCoins());
                    }


                } else if (e.getCurrentItem().equals(Main.getInstance().getInUseStone())) {
                    Main.getInstance().getUtils().menu((Player) player);


                } else {

                }

            } catch (NullPointerException exception) {

            }
        }
    }

}
