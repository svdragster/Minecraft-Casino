package minecraftCasino.events;

import minecraftCasino.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import minecraftCasino.util.CasinoInventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;


public class PlayerCasinoRightClickEvent implements Listener {


    @EventHandler
    public void onClick(PlayerInteractEvent e) {


        Player player = e.getPlayer();
        Action action = e.getAction();


        HashMap<Player, Integer> time = new HashMap<>();

        if (Main.getInstance().getCasinoPlayerList().getList().containsKey(player.getUniqueId())) {
            if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
                if (player.getInventory().getItemInMainHand().equals(Main.getInstance().getCasinoStone())) {
                    CasinoInventory casinoInventory = new CasinoInventory();
                    Main.getInstance().getCasinoPlayerList().getList().get(player.getUniqueId()).setCasinoInventory(casinoInventory);
                    Main.getInstance().getCasinoPlayerInventory(player).openCasinoInventory(player, Main.getInstance().getCasinoPlayerInventory(player).getCasinoInventory());

                    Main.getInstance().getUtils().menu(player);

                    /**
                     *
                     * Kann je nach Geschmack eingefügt werden
                     *
                     * Dann auch die Methode loadingScreen in minecraftCasino.util.Utils einfügen
                     *
                     */



                     /**Main.getInstance().getCasinoPlayerInventory(player).setCounter(0);


                    new BukkitRunnable() {
                        @Override
                        public void run() {

                            time.put(player, Main.getInstance().getCasinoPlayer(player).getTimeStamp());
                            for (Player p : time.keySet()) {
                                Main.getInstance().getCasinoPlayer(player).setTimeStamp(Main.getInstance().getCasinoPlayer(player).getTimeStamp() - 1);
                                time.remove(p);
                                time.put(p, Main.getInstance().getCasinoPlayer(player).getTimeStamp());

                                if (Main.getInstance().getCasinoPlayer(player).getTimeStamp() == 0) {
                                    time.remove(p);
                                    Main.getInstance().getUtils().menu(player);
                                    Main.getInstance().getCasinoPlayer(player).setTimeStamp(7);
                                    cancel();

                                } else {
                                    Main.getInstance().getUtils().loadingScreen(player);
                                }
                            }

                        }
                    }.runTaskTimer(Main.getInstance(), 0L, Main.getInstance().getCasinoPlayer(player).getTimeStamp());
**/

                }
            }
        }
    }


}
