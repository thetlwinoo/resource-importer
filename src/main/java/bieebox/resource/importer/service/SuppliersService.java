package bieebox.resource.importer.service;

import bieebox.resource.importer.service.dto.SuppliersDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Suppliers.
 */
public interface SuppliersService {

    /**
     * Save a suppliers.
     *
     * @param suppliersDTO the entity to save
     * @return the persisted entity
     */
    SuppliersDTO save(SuppliersDTO suppliersDTO);

    /**
     * Get all the suppliers.
     *
     * @return the list of entities
     */
    List<SuppliersDTO> findAll();


    /**
     * Get the "id" suppliers.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<SuppliersDTO> findOne(Long id);

    /**
     * Delete the "id" suppliers.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
