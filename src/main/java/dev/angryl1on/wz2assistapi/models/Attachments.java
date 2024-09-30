package dev.angryl1on.wz2assistapi.models;

import dev.angryl1on.wz2assistapi.models.enumeration.AttachmentType;
import jakarta.persistence.*;

import java.util.List;

/**
 * Represents an attachment entity in the application.
 */
@Entity
public class Attachments extends Base {

    private String name;
    private AttachmentType type;
    private Gun gun;
    private Integer levelsToOpen;
    private List<String> advantages;
    private List<String> disadvantages;
    private LoadoutGun loadoutGun;

    /**
     * Protected constructor for JPA.
     */
    public Attachments() { /* do nothing */ }

    /**
     *
     *
     * @param name
     * @param type
     * @param gun
     * @param levelsToOpen
     * @param advantages
     * @param disadvantages
     * @param loadoutGun
     */
    public Attachments(String name, AttachmentType type, Gun gun, Integer levelsToOpen, List<String> advantages, List<String> disadvantages, LoadoutGun loadoutGun) {
        this.name = name;
        this.type = type;
        this.gun = gun;
        this.levelsToOpen = levelsToOpen;
        this.advantages = advantages;
        this.disadvantages = disadvantages;
        this.loadoutGun = loadoutGun;
    }

    @ManyToOne
    @JoinColumn(name = "loadoutGun_id")
    public LoadoutGun getLoadoutGun() {
        return loadoutGun;
    }

    public void setLoadoutGun(LoadoutGun loadoutGun) {
        this.loadoutGun = loadoutGun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public Integer getLevelsToOpen() {
        return levelsToOpen;
    }

    public void setLevelsToOpen(Integer levelsToOpen) {
        this.levelsToOpen = levelsToOpen;
    }

    @ElementCollection
    public List<String> getAdvantages() {
        return advantages;
    }

    public void setAdvantages(List<String> advantages) {
        this.advantages = advantages;
    }

    @ElementCollection
    public List<String> getDisadvantages() {
        return disadvantages;
    }

    public void setDisadvantages(List<String> disadvantages) {
        this.disadvantages = disadvantages;
    }

    public AttachmentType getType() {
        return type;
    }

    public void setType(AttachmentType type) {
        this.type = type;
    }
}
