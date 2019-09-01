package minecraftCasino.util;

import minecraftCasino.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CheckRow {

    private int[] winsPerLine = {0, 0, 0, 0, 0, 0, 0, 0, 0};


    public int[] checkRows(Player player, ItemStack item, int row) {

        switch (row) {
            case 1:
                if (Main.getInstance().getUtils().checkEqualItems(player, 12, item) && Main.getInstance().getUtils().checkEqualItems(player, 13, item)) {
                    winsPerLine[0] = 3;
                    if (Main.getInstance().getUtils().checkEqualItems(player, 14, item)) {
                        winsPerLine[0] = 4;
                        if (Main.getInstance().getUtils().checkEqualItems(player, 15, item)) {
                            winsPerLine[0] = 5;
                        }
                    }
                } else {
                    winsPerLine[0] = 0;
                }
                if (Main.getInstance().getUtils().checkEqualItems(player, 21, item)) {
                    if (Main.getInstance().getUtils().checkEqualItems(player, 13, item)) {
                        winsPerLine[1] = 3;
                        if (Main.getInstance().getUtils().checkEqualItems(player, 23, item)) {
                            winsPerLine[1] = 4;
                            if (Main.getInstance().getUtils().checkEqualItems(player, 15, item)) {
                                winsPerLine[1] = 5;
                            }
                        }
                    } else {
                        winsPerLine[1] = 0;
                    }
                    if (Main.getInstance().getUtils().checkEqualItems(player, 31, item)) {
                        winsPerLine[2] = 3;
                        if (Main.getInstance().getUtils().checkEqualItems(player, 23, item)) {
                            winsPerLine[2] = 4;
                            if (Main.getInstance().getUtils().checkEqualItems(player, 15, item)) {
                                winsPerLine[2] = 5;
                            }
                        }
                    } else {
                        winsPerLine[2] = 0;
                    }
                } else {
                    winsPerLine[1] = 0;
                    winsPerLine[2] = 0;
                }

                return winsPerLine;



            case 2:
                if (Main.getInstance().getUtils().checkEqualItems(player, 12, item) && Main.getInstance().getUtils().checkEqualItems(player, 22, item)) {
                    winsPerLine[3] = 3;
                    if (Main.getInstance().getUtils().checkEqualItems(player, 14, item)) {
                        winsPerLine[3] = 4;
                        if (Main.getInstance().getUtils().checkEqualItems(player, 24, item)) {
                            winsPerLine[3] = 5;
                        }
                    }

                } else {
                    winsPerLine[3] = 0;
                }

                if (Main.getInstance().getUtils().checkEqualItems(player, 21, item) && Main.getInstance().getUtils().checkEqualItems(player, 22, item)) {
                    winsPerLine[4] = 3;
                    if (Main.getInstance().getUtils().checkEqualItems(player, 23, item)) {
                        winsPerLine[4] = 4;
                        if (Main.getInstance().getUtils().checkEqualItems(player, 24, item)) {
                            winsPerLine[4] = 5;
                        }
                    }
                } else {
                    winsPerLine[4] = 0;
                }
                if (Main.getInstance().getUtils().checkEqualItems(player, 30, item) && Main.getInstance().getUtils().checkEqualItems(player, 22, item)) {
                    winsPerLine[5] = 3;
                    if (Main.getInstance().getUtils().checkEqualItems(player, 32, item)) {
                        winsPerLine[5] = 4;
                        if (Main.getInstance().getUtils().checkEqualItems(player, 24, item)) {
                            winsPerLine[5] = 5;
                        }
                    }
                } else {
                    winsPerLine[5] = 0;
                }

                return winsPerLine;


            case 3:
                if (Main.getInstance().getUtils().checkEqualItems(player, 30, item) && Main.getInstance().getUtils().checkEqualItems(player, 31, item)) {
                    winsPerLine[6] = 3;
                    if (Main.getInstance().getUtils().checkEqualItems(player, 32, item)) {
                        winsPerLine[6] = 4;
                        if (Main.getInstance().getUtils().checkEqualItems(player, 33, item)) {
                            winsPerLine[6] = 5;
                        }
                    }
                } else {
                    winsPerLine[6] = 0;
                }

                if (Main.getInstance().getUtils().checkEqualItems(player, 21, item)) {
                    if (Main.getInstance().getUtils().checkEqualItems(player, 31, item)) {
                        winsPerLine[7] = 3;
                        if (Main.getInstance().getUtils().checkEqualItems(player, 23, item)) {
                            winsPerLine[7] = 4;
                            if (Main.getInstance().getUtils().checkEqualItems(player, 33, item)) {
                                winsPerLine[7] = 5;
                            }
                        }
                    } else {
                        winsPerLine[7] = 0;
                    }
                    if (Main.getInstance().getUtils().checkEqualItems(player, 13, item)) {
                        winsPerLine[8] = 3;
                        if (Main.getInstance().getUtils().checkEqualItems(player, 23, item)) {
                            winsPerLine[8] = 4;
                            if (Main.getInstance().getUtils().checkEqualItems(player, 33, item)) {
                                winsPerLine[8] = 5;
                            }
                        }
                    } else {
                        winsPerLine[8] = 0;
                    }
                } else {
                    winsPerLine[7] = 0;
                    winsPerLine[8] = 0;
                }

                return winsPerLine;

            default: return winsPerLine;
        }
    }
}
