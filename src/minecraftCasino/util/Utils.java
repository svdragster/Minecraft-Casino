package minecraftCasino.util;

import minecraftCasino.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Utils {


    public void spin(HumanEntity player) {
        Random random = new Random();
        int b = 10;
        int v = 16;

        for (int i = 1; i <= 3; i++) {
            Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem((b), new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem((v), new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            b += 9;
            v += 9;

            for (int x = 11; x <= 15; x++) {
                int randomInt = random.nextInt(56);

                if (i == 1) {
                    Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem((x), Main.getInstance().getCharacterList().getList().get(randomInt));

                } else if (i == 2) {
                    Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem(x + 9, Main.getInstance().getCharacterList().getList().get(randomInt));

                } else if (i == 3) {
                    Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem(x + 18, Main.getInstance().getCharacterList().getList().get(randomInt));

                }
                Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem(39, Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.GOLD_BLOCK, ChatColor.GOLD + "YOUR COINS: " + Main.getInstance().getCasinoPlayer(player).getCoins()));
                Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem(41, Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.EMERALD_BLOCK, ChatColor.RED + "WIN: " + Main.getInstance().getCasinoPlayer(player).getWinPerSpin().peek()));
                Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem(40, Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.BLAZE_ROD, ChatColor.BLUE + "IN USE: " + Main.getInstance().getCasinoPlayer(player).getUseCoins()));
                Main.getInstance().setInUseStone(Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.BLAZE_ROD, ChatColor.BLUE + "IN USE: " + Main.getInstance().getCasinoPlayerList().getList().get(player.getUniqueId()).getUseCoins()));

            }
        }
    }


    public void menu(Player player) {

        Main.getInstance().getCasinoPlayerInventoryInventory(player).clear();

        for (int i = 0; i <= 8; i++) {
            menuGlassPane(player, i);
        }


        int i = 9;
        while (i <= 27) {
            menuGlassPane(player, i);
            i++;
            menuStartBlock(player, i);
            i++;
            menuStartBlock(player, i);
            i++;
            menuStartBlock(player, i);
            i++;
            menuGlassPane(player, i);
            i++;
            menuExitBlock(player, i);
            i++;
            menuExitBlock(player, i);
            i++;
            menuExitBlock(player, i);
            i++;
            menuGlassPane(player, i);
            i++;
        }

        for (int x = 36; x <= 44; x++) {
            menuGlassPane(player, x);
        }

        Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem(13, Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.DIAMOND, ChatColor.GREEN + "UP"));
        Main.getInstance().setUseUpStone(Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.DIAMOND, ChatColor.GREEN + "UP"));
        Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem(22, Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.BLAZE_ROD, ChatColor.GOLD + "IN USE: " + Main.getInstance().getCasinoPlayerList().getList().get(player.getUniqueId()).getUseCoins()));
        Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem(31, Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.REDSTONE, ChatColor.RED + "DOWN"));
        Main.getInstance().setUseDownStone(Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.REDSTONE, ChatColor.RED + "DOWN"));
        Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem(40, Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.GOLD_BLOCK, ChatColor.GOLD + "YOUR COINS: " + Main.getInstance().getCasinoPlayerList().getList().get(player.getUniqueId()).getCoins()));
        Main.getInstance().setInUseStone(Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.BLAZE_ROD, ChatColor.GOLD + "IN USE: " + Main.getInstance().getCasinoPlayerList().getList().get(player.getUniqueId()).getUseCoins()));
        Main.getInstance().setStartStone(Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.EMERALD_BLOCK, ChatColor.GREEN + "START", Enchantment.LOOT_BONUS_BLOCKS));
        Main.getInstance().setExitStone(Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.REDSTONE_BLOCK, ChatColor.RED + "EXIT"));
    }


    /**public void loadingScreen(Player player) {

        if (!Main.getInstance().getCasinoPlayerInventory(player).isInitializeCasinostate()) {
            Main.getInstance().getCasinoPlayerInventoryInventory(player).clear();
            Main.getInstance().getCasinoPlayerInventory(player).initializeCasinoState(Main.getInstance().getCasinoPlayerInventoryInventory(player), 0);
            Main.getInstance().getCasinoPlayerInventory(player).setInitializeCasinostate(true);
            Main.getInstance().getCasinoPlayerInventory(player).addOneToCounter();
        } else {
            Main.getInstance().getCasinoPlayerInventoryInventory(player).clear();
            Main.getInstance().getCasinoPlayerInventory(player).initializeCasinoState(Main.getInstance().getCasinoPlayerInventoryInventory(player), 1);
            Main.getInstance().getCasinoPlayerInventory(player).setInitializeCasinostate(false);
            Main.getInstance().getCasinoPlayerInventory(player).addOneToCounter();
        }
    }**/


    public void checkWin(Player player, int row, int line1, int line2, int line3, int itemSlot) {


        ItemStack diamondCharacter = new ItemStack(Material.DIAMOND);
        ItemStack ironCharacter = new ItemStack(Material.IRON_INGOT);
        ItemStack goldCharacter = new ItemStack(Material.GOLD_INGOT);
        ItemStack brickCharacter = new ItemStack(Material.BRICK);
        ItemStack wheatCharacter = new ItemStack(Material.WHEAT);
        ItemStack leatherCharacter = new ItemStack(Material.LEATHER);
        ItemStack gunpowderCharacter = new ItemStack(Material.GUNPOWDER);

        ItemStack item = Main.getInstance().getCasinoPlayerInventoryInventory(player).getItem(itemSlot);

        if (item.equals(diamondCharacter)) {
            setWinPerRow(Main.getInstance().getCheckRow(), player, item, 100, 1000, 10000, line1, line2, line3, row);

        } else if (item.equals(ironCharacter)) {
            setWinPerRow(Main.getInstance().getCheckRow(), player, item, 50, 500, 5000, line1, line2, line3, row);

        } else if (item.equals(goldCharacter)) {
            setWinPerRow(Main.getInstance().getCheckRow(), player, item, 30, 300, 3000, line1, line2, line3, row);

        } else if (item.equals(brickCharacter)) {
            setWinPerRow(Main.getInstance().getCheckRow(), player, item, 10, 100, 1000, line1, line2, line3, row);

        } else if (item.equals(wheatCharacter)) {
            setWinPerRow(Main.getInstance().getCheckRow(), player, item, 5, 50, 500, line1, line2, line3, row);

        } else if (item.equals(leatherCharacter)) {
            setWinPerRow(Main.getInstance().getCheckRow(), player, item, 3, 30, 300, line1, line2, line3, row);

        } else if (item.equals(gunpowderCharacter)) {
            setWinPerRow(Main.getInstance().getCheckRow(), player, item, 1, 10, 100, line1, line2, line3, row);
        }

    }


    private void setWinPerRow(CheckRow checkRow, Player player, ItemStack item, int win3, int win4, int win5, int line1, int line2, int line3, int row) {


        if (checkRow.checkRows(player, item, row)[line1] == 3 || checkRow.checkRows(player, item, row)[line2] == 3 || checkRow.checkRows(player, item, row)[line3] == 3) {
            Main.getInstance().getCasinoPlayer(player).getWinPerSpin().push((Main.getInstance().getCasinoPlayer(player).getUseCoins() * win3) + Main.getInstance().getCasinoPlayer(player).getWinPerSpin().peek());
            if ((checkRow.checkRows(player, item, row)[line1] == 3 && checkRow.checkRows(player, item, row)[line2] == 3) || (checkRow.checkRows(player, item, row)[line1] == 3 && checkRow.checkRows(player, item, row)[line3] == 3 || (checkRow.checkRows(player, item, row)[line2] == 3 && checkRow.checkRows(player, item, row)[line3] == 3))) {
                int win = Main.getInstance().getCasinoPlayer(player).getWinPerSpin().pop();
                Main.getInstance().getCasinoPlayer(player).getWinPerSpin().push((Main.getInstance().getCasinoPlayer(player).getUseCoins() * win3) + win);
                if (checkRow.checkRows(player, item, row)[line1] == 3 && checkRow.checkRows(player, item, row)[line2] == 3 && checkRow.checkRows(player, item, row)[line3] == 3) {
                    win = Main.getInstance().getCasinoPlayer(player).getWinPerSpin().pop();
                    Main.getInstance().getCasinoPlayer(player).getWinPerSpin().push((Main.getInstance().getCasinoPlayer(player).getUseCoins() * win3) + win);
                }

            }
            player.sendMessage(prefix() + ChatColor.GOLD + "From the " + row + " row with 3 " + item.getType().name());

        }


        if (checkRow.checkRows(player, item, row)[line1] == 4 || checkRow.checkRows(player, item, row)[line2] == 4 || checkRow.checkRows(player, item, row)[line3] == 4) {
            Main.getInstance().getCasinoPlayer(player).getWinPerSpin().push((Main.getInstance().getCasinoPlayer(player).getUseCoins() * win4) + Main.getInstance().getCasinoPlayer(player).getWinPerSpin().peek());
            if ((checkRow.checkRows(player, item, row)[line1] == 4 && checkRow.checkRows(player, item, row)[line2] == 4) || (checkRow.checkRows(player, item, row)[line1] == 4 && checkRow.checkRows(player, item, row)[line3] == 4 || (checkRow.checkRows(player, item, row)[line2] == 4 && checkRow.checkRows(player, item, row)[line3] == 4))) {
                int win = Main.getInstance().getCasinoPlayer(player).getWinPerSpin().pop();
                Main.getInstance().getCasinoPlayer(player).getWinPerSpin().push((Main.getInstance().getCasinoPlayer(player).getUseCoins() * win4) + win);
                if (checkRow.checkRows(player, item, row)[line1] == 4 && checkRow.checkRows(player, item, row)[line2] == 4 && checkRow.checkRows(player, item, row)[line3] == 4) {
                    win = Main.getInstance().getCasinoPlayer(player).getWinPerSpin().pop();
                    Main.getInstance().getCasinoPlayer(player).getWinPerSpin().push((Main.getInstance().getCasinoPlayer(player).getUseCoins() * win4) + win);
                }

            }
            player.sendMessage(prefix() + ChatColor.GOLD + "From the " + row + " row with 4 " + item.getType().name());


        }
        if (checkRow.checkRows(player, item, row)[line1] == 5 || checkRow.checkRows(player, item, row)[line2] == 5 || checkRow.checkRows(player, item, row)[line3] == 5) {
            Main.getInstance().getCasinoPlayer(player).getWinPerSpin().push((Main.getInstance().getCasinoPlayer(player).getUseCoins() * win5) + Main.getInstance().getCasinoPlayer(player).getWinPerSpin().peek());
            if ((checkRow.checkRows(player, item, row)[line1] == 5 && checkRow.checkRows(player, item, row)[line2] == 5) || (checkRow.checkRows(player, item, row)[line1] == 5 && checkRow.checkRows(player, item, row)[line3] == 5 || (checkRow.checkRows(player, item, row)[line2] == 5 && checkRow.checkRows(player, item, row)[line3] == 5))) {
                int win = Main.getInstance().getCasinoPlayer(player).getWinPerSpin().pop();
                Main.getInstance().getCasinoPlayer(player).getWinPerSpin().push((Main.getInstance().getCasinoPlayer(player).getUseCoins() * win5) + win);
                if (checkRow.checkRows(player, item, row)[line1] == 5 && checkRow.checkRows(player, item, row)[line2] == 5 && checkRow.checkRows(player, item, row)[line3] == 5) {
                    win = Main.getInstance().getCasinoPlayer(player).getWinPerSpin().pop();
                    Main.getInstance().getCasinoPlayer(player).getWinPerSpin().push((Main.getInstance().getCasinoPlayer(player).getUseCoins() * win5) + win);
                }

            }
            player.sendMessage(prefix() + ChatColor.GOLD + "From the " + row + " row with 5 " + item.getType().name());
        }
    }


    public boolean checkEqualItems(Player player, int itemSlot, ItemStack equalItem) {

        if (Main.getInstance().getCasinoPlayerInventoryInventory(player).getItem(itemSlot).equals(equalItem)) {
            return true;
        } else {
            return false;
        }
    }


    public String prefix() {
        return ChatColor.GOLD + "" + ChatColor.BOLD + "CASINO" + ChatColor.DARK_RED + ">> ";
    }

    private void menuGlassPane(Player player, int slot) {
        Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem(slot, Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.GRAY_STAINED_GLASS_PANE, ""));
    }

    private void menuStartBlock(Player player, int slot) {
        Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem(slot, Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.EMERALD_BLOCK, ChatColor.GREEN + "START", Enchantment.LOOT_BONUS_BLOCKS));

    }

    private void menuExitBlock(Player player, int slot) {
        Main.getInstance().getCasinoPlayerInventoryInventory(player).setItem(slot, Main.getInstance().getCasinoPlayerInventory(player).createItem(Material.REDSTONE_BLOCK, ChatColor.RED + "EXIT"));

    }


}

