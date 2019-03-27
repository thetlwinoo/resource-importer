package bieebox.resource.importer.service.impl;

import bieebox.resource.importer.service.ProductProductPhotoService;
import bieebox.resource.importer.domain.ProductProductPhoto;
import bieebox.resource.importer.repository.ProductProductPhotoRepository;
import bieebox.resource.importer.service.dto.ProductProductPhotoDTO;
import bieebox.resource.importer.service.mapper.ProductProductPhotoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing ProductProductPhoto.
 */
@Service
@Transactional
public class ProductProductPhotoServiceImpl implements ProductProductPhotoService {

    private final Logger log = LoggerFactory.getLogger(ProductProductPhotoServiceImpl.class);

    private final ProductProductPhotoRepository productProductPhotoRepository;

    private final ProductProductPhotoMapper productProductPhotoMapper;

    public ProductProductPhotoServiceImpl(ProductProductPhotoRepository productProductPhotoRepository, ProductProductPhotoMapper productProductPhotoMapper) {
        this.productProductPhotoRepository = productProductPhotoRepository;
        this.productProductPhotoMapper = productProductPhotoMapper;
    }

    /**
     * Save a productProductPhoto.
     *
     * @param productProductPhotoDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProductProductPhotoDTO save(ProductProductPhotoDTO productProductPhotoDTO) {
        log.debug("Request to save ProductProductPhoto : {}", productProductPhotoDTO);
        ProductProductPhoto productProductPhoto = productProductPhotoMapper.toEntity(productProductPhotoDTO);
        productProductPhoto = productProductPhotoRepository.save(productProductPhoto);
        return productProductPhotoMapper.toDto(productProductPhoto);
    }

    /**
     * Get all the productProductPhotos.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductProductPhotoDTO> findAll() {
        log.debug("Request to get all ProductProductPhotos");
        return productProductPhotoRepository.findAll().stream()
            .map(productProductPhotoMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one productProductPhoto by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProductProductPhotoDTO> findOne(Long id) {
        log.debug("Request to get ProductProductPhoto : {}", id);
        return productProductPhotoRepository.findById(id)
            .map(productProductPhotoMapper::toDto);
    }

    /**
     * Delete the productProductPhoto by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProductProductPhoto : {}", id);        productProductPhotoRepository.deleteById(id);
    }
}
