package dev.angryl1on.wz2assistapi.models.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * An enumeration representing different types of attachments.
 */
public enum AttachmentType {
    AMMUNITION_TYPE(1, "Amunition type"),
    BARREL(2, "Barrel"),
    BOLT(3, "Bolt"),
    COMB(4, "Comb"),
    GUARD(5, "Guard"),
    LAZER(6, "Lazer"),
    MAGAZINE(7, "Magazine"),
    MUZZLE(8, "Muzzle"),
    OPTICS(9, "Optics"),
    REAR_GRIP(10, "Rear Grip"),
    STOCK(11, "Stock"),
    Trigger(12, "Trigger"),
    UNDERBARREL(13, "Underbarrel");

    private final int index;
    private final String name;

    /**
     * Creates a new AttachmentType with the specified index and category name.
     *
     * @param index the unique index of the attachment category.
     * @param name the name of the attachment category.
     */
    AttachmentType(int index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * Returns the unique index of the AttachmentType.
     *
     * @return the index of the AttachmentType.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns the name of the AttachmentType.
     *
     * @return the name of the AttachmentType.
     */
    @JsonValue
    public String getName() {
        return name;
    }
}
