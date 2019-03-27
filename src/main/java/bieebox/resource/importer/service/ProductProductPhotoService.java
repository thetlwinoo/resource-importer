package bieebox.resource.importer.service;

import bieebox.resource.importer.service.dto.ProductProductPhotoDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing ProductProductPhoto.
 */
public interface ProductProductPhotoService {

    /**
     * Save a productProductPhoto.
     *
     * @param productProductPhotoDTO the entity to save
     * @return the persisted entity
     */
    ProductProductPhotoDTO save(ProductProductPhotoDTO productProductPhotoDTO);

    /**
     * Get all the productProductPhotos.
     *
     * @return the list of entities
     */
    List<ProductProductPhotoDTO> findAll();


    /**
     * Get the "id" productProductPhoto.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ProductProductPhotoDTO> findOne(Long id);

    /**
     * Delete the "id" productProductPhoto.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
