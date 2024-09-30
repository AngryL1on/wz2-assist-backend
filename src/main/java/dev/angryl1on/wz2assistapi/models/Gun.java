package dev.angryl1on.wz2assistapi.models;

import dev.angryl1on.wz2assistapi.models.enumeration.GunCategory;
import dev.angryl1on.wz2assistapi.models.enumeration.RepresentsGame;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * Represents a gun entity in the application.
 */
@Entity
@Table(name = "gun")
public class Gun extends Base {
    private String name;
    private GunCategory type;
    private RepresentsGame gameRepresents;

    /**
     * Protected constructor for JPA.
     */
    protected Gun() { /* do nothing */ }

    /**
     * Creates a new Gun with the specified name, type, and game representation.
     *
     * @param name the name of the gun.
     * @param type the category of the gun.
     * @param gameRepresents the game that the gun represents.
     */
    public Gun(String name, GunCategory type, RepresentsGame gameRepresents) {
        this.name = name;
        this.type = type;
        this.gameRepresents = gameRepresents;
    }
    @Column(unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GunCategory getType() {
        return type;
    }

    public void setType(GunCategory type) {
        this.type = type;
    }

    public RepresentsGame getGameRepresents() {
        return gameRepresents;
    }

    public void setGameRepresents(RepresentsGame gameRepresents) {
        this.gameRepresents = gameRepresents;
    }
}
