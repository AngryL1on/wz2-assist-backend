package dev.angryl1on.wz2assistapi.models;

import dev.angryl1on.wz2assistapi.models.enumeration.AttachmentType;
import jakarta.persistence.*;

import java.util.List;

/**
 * Represents an attachment entity in the application.
 */
@Entity
public class Attachments extends Base {
    @ManyToOne
    @JoinColumn(name = "loadoutGun_id")
    private LoadoutGun loadoutGun;
    private String name;
    private AttachmentType type;
    @OneToOne
    private Gun gun;
    private Integer levelsToOpen;
    @ElementCollection
    private List<String> advantages;
    @ElementCollection
    private List<String> disadvantages;

    /**
     * Protected constructor for JPA.
     */
    public Attachments() { /* do nothing */ }

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

    public List<String> getAdvantages() {
        return advantages;
    }

    public void setAdvantages(List<String> advantages) {
        this.advantages = advantages;
    }

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

    public static Attachments createAttachment() {
        Attachments attachment = new Attachments();
        return attachment;
    }
}
