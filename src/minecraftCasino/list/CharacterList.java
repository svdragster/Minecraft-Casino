package minecraftCasino.list;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CharacterList {

    ArrayList<ItemStack> characterList = new ArrayList<>();

    public ArrayList<ItemStack> getList() {
        return characterList;
    }


    public void initializeCharacterList() {

        for (int i = 0; i <= 1; i++) {
            characterList.add(new ItemStack(Material.DIAMOND));
        }

        for (int i = 0; i <= 3; i++) {
            characterList.add(new ItemStack(Material.IRON_INGOT));
        }

        for (int i = 0; i <= 5; i++) {
            characterList.add(new ItemStack(Material.GOLD_INGOT));
        }

        for (int i = 0; i <= 7; i++) {
            characterList.add(new ItemStack(Material.BRICK));
        }

        for (int i = 0; i <= 9; i++) {
            characterList.add(new ItemStack(Material.WHEAT));
        }

        for (int i = 0; i <= 11; i++) {
            characterList.add(new ItemStack(Material.LEATHER));
        }

        for (int i = 0; i <= 13; i++) {
            characterList.add(new ItemStack(Material.GUNPOWDER));
        }

    }
}
