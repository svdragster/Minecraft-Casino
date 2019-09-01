package minecraftCasino.list;

import minecraftCasino.player.CasinoPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CasinoPlayerList {

    Map<UUID, CasinoPlayer> casinoPlayerList = new HashMap<>();

    public Map<UUID, CasinoPlayer> getList() {
        return casinoPlayerList;
    }
}
