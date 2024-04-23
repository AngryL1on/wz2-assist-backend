package dev.angryl1on.wz2assistapi.models.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * An enumeration representing different categories of firearms.
 */
public enum GunCategory {
    ASSAULT_RIFLES(0, "Assault Rifles"),
    BATTLE_RIFLES(1, "Battle Rifles"),
    LAUNCHER(2, "Launcher"),
    LMG(3, "LMG"),
    MARKSMAN_RIFLES(4, "Marksman Rifles"),
    MELEE_WEAPON(5, "Melee Weapon"),
    PISTOL(6, "Pistol"),
    SHOTGUN(7, "Shotgun"),
    SMG(8, "SMG"),
    SNIPER_RIFLES(9, "Sniper Rifles");

    private final int index;
    private final String category;

    /**
     * Creates a new GunCategory with the specified index and category name.
     *
     * @param index the unique index of the gun category.
     * @param category the name of the gun category.
     */
    GunCategory(int index, String category) {
        this.index = index;
        this.category = category;
    }

    /**
     * Returns the unique index of the gun category.
     *
     * @return the index of the gun category.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns the name of the gun category.
     *
     * @return the name of the gun category.
     */
    @JsonValue
    public String getCategory() {
        return category;
    }
}
