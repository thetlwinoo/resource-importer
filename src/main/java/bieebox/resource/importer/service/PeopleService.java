package bieebox.resource.importer.service;

import bieebox.resource.importer.service.dto.PeopleDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing People.
 */
public interface PeopleService {

    /**
     * Save a people.
     *
     * @param peopleDTO the entity to save
     * @return the persisted entity
     */
    PeopleDTO save(PeopleDTO peopleDTO);

    /**
     * Get all the people.
     *
     * @return the list of entities
     */
    List<PeopleDTO> findAll();


    /**
     * Get the "id" people.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<PeopleDTO> findOne(Long id);

    /**
     * Delete the "id" people.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
