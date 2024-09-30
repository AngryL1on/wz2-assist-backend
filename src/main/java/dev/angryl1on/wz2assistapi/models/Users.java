package dev.angryl1on.wz2assistapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

/**
 * Represents a user entity in the application.
 */
@Entity
public class Users extends Base {
    private List<Loadout> loadouts;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String description;
    private String avatar;

    /**
     * Protected constructor for JPA.
     */
    protected Users() { /* do nothing */ }

    @OneToMany(mappedBy = "user")
    public List<Loadout> getLoadouts() {
        return loadouts;
    }

    public void setLoadouts(List<Loadout> loadOuts) {
        this.loadouts = loadOuts;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(unique = true)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
