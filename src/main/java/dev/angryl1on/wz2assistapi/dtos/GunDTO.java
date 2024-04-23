package dev.angryl1on.wz2assistapi.dtos;

import dev.angryl1on.wz2assistapi.models.enumeration.GunCategory;
import dev.angryl1on.wz2assistapi.models.enumeration.RepresentsGame;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class GunDTO{
    private UUID id;
    private String name;
    private GunCategory type;
    private RepresentsGame gameRepresents;

    public GunDTO(UUID id, String name, GunCategory type, RepresentsGame gameRepresents) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.gameRepresents = gameRepresents;
    }

    public GunDTO() {
    }

    @NotNull(message = "ID cannot be empty")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @NotNull(message = "Name cannot be empty")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Type cannot be empty")
    public GunCategory getType() {
        return type;
    }

    public void setType(GunCategory type) {
        this.type = type;
    }

    @NotNull(message = "Game Represent cannot be empty")
    public RepresentsGame getGameRepresents() {
        return gameRepresents;
    }

    public void setGameRepresents(RepresentsGame gameRepresents) {
        this.gameRepresents = gameRepresents;
    }

    @Override
    public String toString() {
        return "GunDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", gameRepresents=" + gameRepresents +
                '}';
    }
}
