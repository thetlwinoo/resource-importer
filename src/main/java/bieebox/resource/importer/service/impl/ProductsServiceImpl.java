package bieebox.resource.importer.service.impl;

import bieebox.resource.importer.service.ProductsService;
import bieebox.resource.importer.domain.Products;
import bieebox.resource.importer.repository.ProductsRepository;
import bieebox.resource.importer.service.dto.ProductsDTO;
import bieebox.resource.importer.service.mapper.ProductsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service Implementation for managing Products.
 */
@Service
@Transactional
public class ProductsServiceImpl implements ProductsService {

    private final Logger log = LoggerFactory.getLogger(ProductsServiceImpl.class);

    private final ProductsRepository productsRepository;

    private final ProductsMapper productsMapper;

    public ProductsServiceImpl(ProductsRepository productsRepository, ProductsMapper productsMapper) {
        this.productsRepository = productsRepository;
        this.productsMapper = productsMapper;
    }

    /**
     * Save a products.
     *
     * @param productsDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProductsDTO save(ProductsDTO productsDTO) {
        log.debug("Request to save Products : {}", productsDTO);
        Products products = productsMapper.toEntity(productsDTO);
        products = productsRepository.save(products);
        return productsMapper.toDto(products);
    }

    /**
     * Get all the products.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductsDTO> findAll() {
        log.debug("Request to get all Products");
        return productsRepository.findAll().stream()
            .map(productsMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }



    /**
     *  get all the products where StockItem is null.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<ProductsDTO> findAllWhereStockItemIsNull() {
        log.debug("Request to get all products where StockItem is null");
        return StreamSupport
            .stream(productsRepository.findAll().spliterator(), false)
            .filter(products -> products.getStockItem() == null)
            .map(productsMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one products by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProductsDTO> findOne(Long id) {
        log.debug("Request to get Products : {}", id);
        return productsRepository.findById(id)
            .map(productsMapper::toDto);
    }

    /**
     * Delete the products by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Products : {}", id);        productsRepository.deleteById(id);
    }
}
