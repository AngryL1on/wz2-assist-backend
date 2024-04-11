package dev.angryl1on.wz2assistapi.models.enumeration;

/**
 * A list representing different versions of the game.
 */
public enum RepresentsGame {
    MW2(0, "MW2"),
    MW3(1, "MW3");

    private final int index;
    private final String gameName;

    /**
     * Creates a new RepresentsGame with the specified index and game name.
     *
     * @param index the unique index of the game.
     * @param gameName the name of the game.
     */
    RepresentsGame(int index, String gameName) {
        this.index = index;
        this.gameName = gameName;
    }

    /**
     * Returns the unique index of the game.
     *
     * @return the index of the game.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns the name of the game.
     *
     * @return the name of the game.
     */
    public String getCategory() {
        return gameName;
    }
}
