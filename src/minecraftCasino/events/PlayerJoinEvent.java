package minecraftCasino.events;

import minecraftCasino.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        if (Main.getInstance().getCasinoPlayerList().getList().containsKey(e.getPlayer().getUniqueId())) {
            e.getPlayer().getInventory().setItem(4, Main.getInstance().getCasinoStone());
        } else
            e.getPlayer().getInventory().clear();
    }

}
