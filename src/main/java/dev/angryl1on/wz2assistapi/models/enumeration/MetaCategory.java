package dev.angryl1on.wz2assistapi.models.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * An enumeration representing meta categories.
 */
public enum MetaCategory {
    ABSOLUTE_META(0, "Absolute Meta"),
    META(0, "Meta"),
    META_CONTENDER(1, "Meta Contender"),
    GOOD(1, "Good"),
    VIABLE(1, "Viable"),;

    private final int index;
    private final String categoryName;

    /**
     * Constructs a new MetaCategory instance.
     * This constructor initializes a new MetaCategory object with the specified index and category name.
     *
     * @param index the unique index of the meta category.
     * @param categoryName the name of the meta category.
     */
    MetaCategory(int index, String categoryName) {
        this.index = index;
        this.categoryName = categoryName;
    }

    /**
     * Returns the unique index of the meta category.
     *
     * @return the index of the meta category.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns the name of the meta category.
     *
     * @return the name of the meta category.
     */
    @JsonValue
    public String getName() {
        return categoryName;
    }
}
