package bieebox.resource.importer.service;

import bieebox.resource.importer.service.dto.CountriesDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Countries.
 */
public interface CountriesService {

    /**
     * Save a countries.
     *
     * @param countriesDTO the entity to save
     * @return the persisted entity
     */
    CountriesDTO save(CountriesDTO countriesDTO);

    /**
     * Get all the countries.
     *
     * @return the list of entities
     */
    List<CountriesDTO> findAll();


    /**
     * Get the "id" countries.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<CountriesDTO> findOne(Long id);

    /**
     * Delete the "id" countries.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
