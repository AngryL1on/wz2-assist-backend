package dev.angryl1on.wz2assistapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

/**
 * Represents a loadout entity in the application.
 */
@Entity
public class Loadout extends Base {
    private List<LoadoutGun> loadoutGuns;
    private List<Perks> perks;
    private Users user;
    private String description;
    private String date;
    private String updatedAt;

    /**
     * Protected constructor for JPA.
     */
    protected Loadout() { /* do nothing */ }

    @OneToMany(mappedBy = "loadout")
    public List<LoadoutGun> getLoadoutGuns() {
        return loadoutGuns;
    }

    public void setLoadoutGuns(List<LoadoutGun> loadoutGuns) {
        this.loadoutGuns = loadoutGuns;
    }

    @OneToMany(mappedBy = "loadout")
    public List<Perks> getPerks() {
        return perks;
    }

    public void setPerks(List<Perks> perks) {
        this.perks = perks;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
