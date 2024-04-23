package dev.angryl1on.wz2assistapi.services.impl;

import dev.angryl1on.wz2assistapi.dtos.GunDTO;
import dev.angryl1on.wz2assistapi.models.Gun;
import dev.angryl1on.wz2assistapi.models.enumeration.GunCategory;
import dev.angryl1on.wz2assistapi.models.enumeration.RepresentsGame;
import dev.angryl1on.wz2assistapi.repositories.GunRepository;
import dev.angryl1on.wz2assistapi.services.GunService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GunServiceImpl implements GunService {
    GunRepository gunRepository;
    ModelMapper modelMapper;

    @Autowired
    public GunServiceImpl(GunRepository gunRepository, ModelMapper modelMapper) {
        this.gunRepository = gunRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public GunDTO add(GunDTO gun) {
        if (gun == null || modelMapper == null || gunRepository == null) {
            throw new IllegalArgumentException("Input parameters cannot be null");
        }

        Gun gunNew = modelMapper.map(gun, Gun.class);

        try {
            if (gunNew.getId() == null || !gunRepository.existsById(gunNew.getId())) {
                // The object is new, save it
                return modelMapper.map(gunRepository.save(gunNew), GunDTO.class);
            } else return null;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Data validation error", e);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Gun with name '" + gunNew.getName() + "' already exists", e);
        }
    }

    @Override
    public List<GunDTO> getAll() {
        return gunRepository.findAll().stream().map((s) -> modelMapper.map(s, GunDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<GunDTO> getById(UUID id) {
        return gunRepository.findById(id).map((s) -> modelMapper.map(s, GunDTO.class));
    }

    @Override
    public Optional<GunDTO> findByName(String name) {
        return gunRepository.findByName(name).map((s) -> modelMapper.map(s, GunDTO.class));
    }

    @Override
    public List<GunDTO> findByCategory(GunCategory category) {
        return gunRepository.findByType(category).stream().map((s) -> modelMapper.map(s, GunDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<GunDTO> findByGameRepresent(RepresentsGame gameRepresents) {
        return gunRepository.findByGameRepresents(gameRepresents).stream().map((s) -> modelMapper.map(s, GunDTO.class)).collect(Collectors.toList());
    }

    @Override
    public GunDTO editByName(String name, GunDTO updatedGun) {
        if (gunRepository.findByName(updatedGun.getName()).isPresent()) {
            return modelMapper.map(gunRepository.save(modelMapper.map(updatedGun, Gun.class)), GunDTO.class);
        } else {
            throw new NoSuchElementException("This object does not exist");
        }
    }

    @Override
    public void delete(UUID id) {
        if (gunRepository.findById(id).isPresent()) {
            gunRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("This object does not exist");
        }
    }
}
