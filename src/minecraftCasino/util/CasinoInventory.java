package minecraftCasino.util;

import com.sun.istack.internal.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CasinoInventory implements InventoryHolder, Listener {

    private Inventory casinoInventory;

    private boolean initializeCasinostate = false;

    private int counter;

    public CasinoInventory() {
        casinoInventory = Bukkit.createInventory(this, 45, ChatColor.GOLD + "CASINO");
    }

    public void openCasinoInventory(HumanEntity player, Inventory inventory) {
        player.openInventory(inventory);
    }

    public void initializeCasinoState(Inventory inventory, int startValue) {

        while (startValue <= 44) {
            inventory.setItem(startValue, createCasinoLoadingItems());
            startValue += 2;
        }
    }


    public ItemStack createCasinoLoadingItems() {
        ItemStack loadingDiamond = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta m = loadingDiamond.getItemMeta();
        m.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
        m.setDisplayName(ChatColor.GOLD + "LOADING...");
        loadingDiamond.setItemMeta(m);
        return loadingDiamond;
    }

    public ItemStack createItem(Material material, String name, Enchantment enchantment) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta m = itemStack.getItemMeta();
        m.setDisplayName(name);
        m.addEnchant(enchantment, 10, true);
        itemStack.setItemMeta(m);
        return itemStack;
    }

    public ItemStack createItem(Material material, String name) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta m = itemStack.getItemMeta();
        m.setDisplayName(name);
        itemStack.setItemMeta(m);
        return itemStack;
    }


    @NotNull
    @Override
    public Inventory getInventory() {
        return casinoInventory;
    }


    public Inventory getCasinoInventory() {
        return casinoInventory;
    }


    public boolean isInitializeCasinostate() {
        return initializeCasinostate;
    }

    public void setInitializeCasinostate(boolean initializeCasinostate) {
        this.initializeCasinostate = initializeCasinostate;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int addOneToCounter() {
        return counter++;
    }
}
