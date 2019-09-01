package minecraftCasino.main;

import minecraftCasino.commands.CasinoCommand;
import minecraftCasino.commands.CoinsCommand;
import minecraftCasino.commands.ExitCasinoCommand;
import minecraftCasino.events.InventoryClickEvent;
import minecraftCasino.events.InventoryCloseEvent;
import minecraftCasino.events.PlayerCasinoRightClickEvent;
import minecraftCasino.events.PlayerJoinEvent;
import minecraftCasino.list.CasinoPlayerList;
import minecraftCasino.list.CharacterList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import minecraftCasino.player.CasinoPlayer;
import minecraftCasino.util.CasinoInventory;
import minecraftCasino.util.CheckRow;
import minecraftCasino.util.Utils;

public class Main extends JavaPlugin {

    private static Main instance;

    private CasinoPlayerList casinoPlayerList = new CasinoPlayerList();

    private ItemStack casinoStone;
    private ItemStack startStone;
    private ItemStack exitStone;
    private ItemStack UseUpStone;
    private ItemStack UseDownStone;
    private ItemStack inUseStone;

    private Utils utils = new Utils();

    private CharacterList characterList = new CharacterList();

    private CheckRow checkRow = new CheckRow();

    public Main() {
        instance = this;
    }


    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "ENABLED CASINO");

        this.getCommand("casino").setExecutor(new CasinoCommand());
        this.getCommand("coins").setExecutor(new CoinsCommand());
        this.getCommand("exit").setExecutor(new ExitCasinoCommand());
        getServer().getPluginManager().registerEvents(new PlayerCasinoRightClickEvent(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new InventoryCloseEvent(), this);
        characterList.initializeCharacterList();



    }


    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "DISABLED CASINO");
    }





    public static Main getInstance() {
        return instance;
    }

    public CasinoPlayerList getCasinoPlayerList() {
        return casinoPlayerList;
    }

    public ItemStack getCasinoStone() {
        return casinoStone;
    }

    public void setCasinoStone(ItemStack casinoStone) {
        this.casinoStone = casinoStone;
    }

    public Utils getUtils() {
        return utils;
    }

    public ItemStack getStartStone() {
        return startStone;
    }

    public void setStartStone(ItemStack startStone) {
        this.startStone = startStone;
    }

    public ItemStack getExitStone() {
        return exitStone;
    }

    public void setExitStone(ItemStack exitStone) {
        this.exitStone = exitStone;
    }

    public ItemStack getUseUpStone() {
        return UseUpStone;
    }

    public void setUseUpStone(ItemStack useUpStone) {
        UseUpStone = useUpStone;
    }

    public ItemStack getUseDownStone() {
        return UseDownStone;
    }

    public void setUseDownStone(ItemStack useDownStone) {
        UseDownStone = useDownStone;
    }

    public CharacterList getCharacterList() {
        return characterList;
    }

    public ItemStack getInUseStone() {
        return inUseStone;
    }

    public void setInUseStone(ItemStack inUseStone) {
        this.inUseStone = inUseStone;
    }

    public CheckRow getCheckRow() {
        return checkRow;
    }

    public CasinoPlayer getCasinoPlayer(HumanEntity player){
        return getCasinoPlayerList().getList().get(player.getUniqueId());
    }

    public CasinoInventory getCasinoPlayerInventory(HumanEntity player) {
        return getCasinoPlayerList().getList().get(player.getUniqueId()).getCasinoInventory();
    }

    public Inventory getCasinoPlayerInventoryInventory(HumanEntity player) {
        return getCasinoPlayerList().getList().get(player.getUniqueId()).getCasinoInventory().getCasinoInventory();
    }
}



