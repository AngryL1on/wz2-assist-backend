package dev.angryl1on.wz2assistapi.repositories;

import dev.angryl1on.wz2assistapi.models.Gun;
import dev.angryl1on.wz2assistapi.models.enumeration.GunCategory;
import dev.angryl1on.wz2assistapi.models.enumeration.RepresentsGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GunRepository extends JpaRepository<Gun, UUID> {
    /**
     * Finds a gun by name.
     *
     * @param name the name of the gun to find.
     * @return an optional containing the gun if found, empty optional otherwise.
     */
    Optional<Gun> findByName(String name);

    /**
     * Finds weapons by type.
     *
     * @param type type of weapon (for example: Assault Rifle, Pistol, etc.).
     * @return list of weapons of this type.
     */
    List<Gun> findByType(GunCategory type);

    /**
     * Find guns by the game they represent.
     *
     * @param gameRepresents the game being represented.
     * @return a list of guns representing the game.
     */
    List<Gun> findByGameRepresents(RepresentsGame gameRepresents);
}
