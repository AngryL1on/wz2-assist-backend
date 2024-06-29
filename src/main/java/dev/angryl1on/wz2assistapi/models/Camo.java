package dev.angryl1on.wz2assistapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Represents a camo entity in the application.
 */
@Entity
public class Camo extends Base {
    @ManyToOne
    @JoinColumn(name = "gun_id")
    private Gun gun;
    private String title;
    private String description;
    private String image;
    private boolean status;

    /**
     * Protected constructor for JPA.
     */
    protected Camo() { /* do nothing */ }

    /**
     * Creates a new Camo with the specified gun, title, description, image, and status.
     *
     * @param gun
     * @param title
     * @param description
     * @param image
     * @param status
     */
    public Camo(Gun gun, String title, String description, String image, boolean status) {
        this.gun = gun;
        this.title = title;
        this.description = description;
        this.image = image;
        this.status = status;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
