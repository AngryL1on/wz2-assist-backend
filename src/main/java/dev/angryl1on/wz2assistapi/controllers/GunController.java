package dev.angryl1on.wz2assistapi.controllers;

import dev.angryl1on.wz2assistapi.dtos.GunDTO;
import dev.angryl1on.wz2assistapi.dtos.ResponseApi;
import dev.angryl1on.wz2assistapi.models.enumeration.GunCategory;
import dev.angryl1on.wz2assistapi.models.enumeration.RepresentsGame;
import dev.angryl1on.wz2assistapi.services.GunService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/gunservice")
public class GunController {
    private final GunService gunservice;

    @Autowired
    public GunController(GunService gunservice) {
        this.gunservice = gunservice;
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseApi<GunDTO>> createGun(@RequestBody GunDTO gunDto) {
        try {
            GunDTO createdGun = gunservice.add(gunDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi<>(List.of(createdGun), Collections.emptyList()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ResponseApi<>(Collections.emptyList(), List.of("Bad Request" + e.getMessage())));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseApi<>(Collections.emptyList(), List.of("Database Error")));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseApi<>(Collections.emptyList(), List.of("Internal Server Error")));
        }
    }

    @GetMapping("/find")
    public ResponseEntity<ResponseApi<GunDTO>> findGuns(@RequestParam(required = false) String name,
                                                        @RequestParam(required = false) GunCategory category,
                                                        @RequestParam(required = false) RepresentsGame gameRepresents) {
        try {
            List<GunDTO> guns;
            if (name != null) {
                guns = gunservice.findByName(name).stream().toList();
            } else if (category != null) {
                guns = gunservice.findByCategory(category);
            } else if (gameRepresents != null) {
                guns = gunservice.findByGameRepresent(gameRepresents);
            } else {
                guns = gunservice.getAll();
            }
            if (guns.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseApi<>(Collections.emptyList(), List.of("No items found")));
            else return ResponseEntity.ok(new ResponseApi<>(guns, Collections.emptyList()));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ResponseApi<>(Collections.emptyList(), List.of(e.getMessage())));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseApi<>(Collections.emptyList(), List.of(e.getMessage())));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseApi<>(Collections.emptyList(), List.of("Internal Server Error")));
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseApi<GunDTO>> editGun(@RequestParam String name, @RequestBody GunDTO updatedGun) {
        try {
            GunDTO editedGun = gunservice.editByName(name, updatedGun);
            return ResponseEntity.ok(new ResponseApi<>(List.of(editedGun), Collections.emptyList()));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(new ResponseApi<>(Collections.emptyList(), List.of(e.getMessage())));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ResponseApi<>(Collections.emptyList(), List.of("An error occurred while updating the gun")));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseApi<GunDTO>> deleteGun(@RequestParam UUID id) {
        try {
            gunservice.delete(id);
            return ResponseEntity.ok(new ResponseApi<>(Collections.emptyList(), Collections.emptyList()));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(new ResponseApi<>(Collections.emptyList(), List.of(e.getMessage())));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ResponseApi<>(Collections.emptyList(), List.of("An error occurred while deleting the gun")));
        }
    }
}
