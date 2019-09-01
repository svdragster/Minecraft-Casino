package minecraftCasino.player;

import org.bukkit.entity.Player;
import minecraftCasino.util.CasinoInventory;

import java.util.Stack;
import java.util.Timer;

public class CasinoPlayer {

    private int coinsBeforePlay;
    private int coins;
    private int useCoins = 10;
    private Player player;
    private boolean isCasinoPlayer;
    private CasinoInventory casinoInventory;
    private Stack<Integer> winPerSpin = new Stack<>();
    private int win = 0;
    private int timeStamp = 7;

    public CasinoPlayer(Player player) {
        this.player = player;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setCasinoPlayer(boolean casinoPlayer) {
        isCasinoPlayer = casinoPlayer;
    }

    public CasinoInventory getCasinoInventory() {
        return casinoInventory;
    }

    public void setCasinoInventory(CasinoInventory casinoInventory) {
        this.casinoInventory = casinoInventory;
    }

    public int getUseCoins() {
        return useCoins;
    }

    public void setUseCoins(int useCoins) {
        this.useCoins = useCoins;
    }

    public Stack<Integer> getWinPerSpin() {
        return winPerSpin;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getCoinsBeforePlay() {
        return coinsBeforePlay;
    }

    public void setCoinsBeforePlay(int coinsBeforePlay) {
        this.coinsBeforePlay = coinsBeforePlay;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }
}
