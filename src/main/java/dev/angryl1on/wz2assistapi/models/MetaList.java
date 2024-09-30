package dev.angryl1on.wz2assistapi.models;

import dev.angryl1on.wz2assistapi.models.enumeration.MetaCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

/**
 * Represents a meta list entity in the application.
 */
@Entity
public class MetaList extends Base {

    private List<LoadoutGun> loadoutGuns;

    private MetaCategory category;

    /**
     * Protected constructor for JPA.
     */
    protected MetaList() { /* do nothing */ }

    public MetaCategory getCategory() {
        return category;
    }

    public void setCategory(MetaCategory category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "metaList")
    public List<LoadoutGun> getLoadoutGuns() {
        return loadoutGuns;
    }

    public void setLoadoutGuns(List<LoadoutGun> loadoutGuns) {
        this.loadoutGuns = loadoutGuns;
    }
}
