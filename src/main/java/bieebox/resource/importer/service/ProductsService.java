package bieebox.resource.importer.service;

import bieebox.resource.importer.service.dto.ProductsDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Products.
 */
public interface ProductsService {

    /**
     * Save a products.
     *
     * @param productsDTO the entity to save
     * @return the persisted entity
     */
    ProductsDTO save(ProductsDTO productsDTO);

    /**
     * Get all the products.
     *
     * @return the list of entities
     */
    List<ProductsDTO> findAll();
    /**
     * Get all the ProductsDTO where StockItem is null.
     *
     * @return the list of entities
     */
    List<ProductsDTO> findAllWhereStockItemIsNull();


    /**
     * Get the "id" products.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ProductsDTO> findOne(Long id);

    /**
     * Delete the "id" products.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
