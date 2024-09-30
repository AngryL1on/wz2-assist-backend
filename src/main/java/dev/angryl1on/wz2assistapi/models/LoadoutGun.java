package dev.angryl1on.wz2assistapi.models;

import jakarta.persistence.*;

import java.util.List;

/**
 * Represents a loadout gun entity in the application.
 */
@Entity
public class LoadoutGun extends Base {

    private MetaList metaList;
    private Gun gun;
    private List<Attachments> attachments;
    private Loadout loadout;
    private String name;
    private String range;

    /**
     * Protected constructor for JPA.
     */
    protected LoadoutGun() { /* do nothing */ }


    @OneToOne
    @JoinColumn(name = "gun_id")
    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    @OneToMany(mappedBy = "loadoutGun")
    public List<Attachments> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachments> attachments) {
        this.attachments = attachments;
    }
    @ManyToOne
    @JoinColumn(name = "metalist_id")
    public MetaList getMetaList() {
        return metaList;
    }

    public void setMetaList(MetaList metaList) {
        this.metaList = metaList;
    }

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

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
