package bieebox.resource.importer.service;

import bieebox.resource.importer.service.dto.ColorsDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Colors.
 */
public interface ColorsService {

    /**
     * Save a colors.
     *
     * @param colorsDTO the entity to save
     * @return the persisted entity
     */
    ColorsDTO save(ColorsDTO colorsDTO);

    /**
     * Get all the colors.
     *
     * @return the list of entities
     */
    List<ColorsDTO> findAll();


    /**
     * Get the "id" colors.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ColorsDTO> findOne(Long id);

    /**
     * Delete the "id" colors.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
