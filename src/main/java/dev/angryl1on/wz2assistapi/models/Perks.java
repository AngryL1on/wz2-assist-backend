package dev.angryl1on.wz2assistapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Represents a perks entity in the application.
 */
@Entity
public class Perks extends Base {
    private Loadout loadout;
    private String name;
    private String description;
    private String slot;    // TODO: REFACTOR ON ENUM!!!

    /**
     * Protected constructor for JPA.
     */
    protected Perks() { /* do nothing */ }

    @ManyToOne
    @JoinColumn(name = "loadout_id")
    public Loadout getLoadout() {
        return loadout;
    }

    public void setLoadout(Loadout loadout) {
        this.loadout = loadout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}
