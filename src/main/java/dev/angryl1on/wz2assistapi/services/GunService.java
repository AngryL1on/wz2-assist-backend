package dev.angryl1on.wz2assistapi.services;

import dev.angryl1on.wz2assistapi.dtos.GunDTO;
import dev.angryl1on.wz2assistapi.models.enumeration.GunCategory;
import dev.angryl1on.wz2assistapi.models.enumeration.RepresentsGame;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service interface for managing Gun entities.
 */
public interface GunService {
    /**
     * Adds a new gun.
     *
     * @param gun the GunDto object representing the gun to be added
     * @return the GunDto object representing the added gun
     */
    GunDTO add(GunDTO gun);

    /**
     * Retrieves a list of all guns.
     *
     * @return a list of GunDto objects representing all guns.
     */
    List<GunDTO> getAll();

    /**
     * Retrieves a gun by its unique identifier.
     *
     * @param id the unique identifier of the gun.
     * @return an Optional containing the GunDto object representing the gun, or an empty Optional if not found.
     */
    Optional<GunDTO> getById(UUID id);

    /**
     * Finds a gun by its name.
     *
     * @param name the name of the gun.
     * @return an Optional containing the GunDto object representing the gun, or an empty Optional if not found.
     */
    Optional<GunDTO> findByName(String name);

    /**
     * Finds guns by their category.
     *
     * @param category the GunCategory representing the category of guns.
     * @return a list of GunDto objects representing the guns in the specified category.
     */
    List<GunDTO> findByCategory(GunCategory category);

    /**
     * Finds guns by the game they represent.
     *
     * @param gameRepresents the RepresentsGame representing the game the guns represent.
     * @return a list of GunDto objects representing the guns for the specified game.
     */
    List<GunDTO> findByGameRepresent(RepresentsGame gameRepresents);

    /**
     * Updates a gun by its name.
     *
     * @param name the name of the gun to be updated.
     * @param updatedGun the GunDto object containing the updated data for the gun.
     * @return the GunDto object representing the updated gun.
     */
    GunDTO editByName(String name, GunDTO updatedGun);

    /**
     * Deletes a gun by its unique identifier.
     *
     * @param id the unique identifier of the gun to be deleted.
     */
    void delete(UUID id);
}
