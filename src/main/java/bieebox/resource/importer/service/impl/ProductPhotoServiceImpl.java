package bieebox.resource.importer.service.impl;

import bieebox.resource.importer.service.ProductPhotoService;
import bieebox.resource.importer.domain.ProductPhoto;
import bieebox.resource.importer.repository.ProductPhotoRepository;
import bieebox.resource.importer.service.dto.ProductPhotoDTO;
import bieebox.resource.importer.service.mapper.ProductPhotoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing ProductPhoto.
 */
@Service
@Transactional
public class ProductPhotoServiceImpl implements ProductPhotoService {

    private final Logger log = LoggerFactory.getLogger(ProductPhotoServiceImpl.class);

    private final ProductPhotoRepository productPhotoRepository;

    private final ProductPhotoMapper productPhotoMapper;

    public ProductPhotoServiceImpl(ProductPhotoRepository productPhotoRepository, ProductPhotoMapper productPhotoMapper) {
        this.productPhotoRepository = productPhotoRepository;
        this.productPhotoMapper = productPhotoMapper;
    }

    /**
     * Save a productPhoto.
     *
     * @param productPhotoDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProductPhotoDTO save(ProductPhotoDTO productPhotoDTO) {
        log.debug("Request to save ProductPhoto : {}", productPhotoDTO);
        ProductPhoto productPhoto = productPhotoMapper.toEntity(productPhotoDTO);
        productPhoto = productPhotoRepository.save(productPhoto);
        return productPhotoMapper.toDto(productPhoto);
    }

    /**
     * Get all the productPhotos.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductPhotoDTO> findAll() {
        log.debug("Request to get all ProductPhotos");
        return productPhotoRepository.findAll().stream()
            .map(productPhotoMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one productPhoto by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProductPhotoDTO> findOne(Long id) {
        log.debug("Request to get ProductPhoto : {}", id);
        return productPhotoRepository.findById(id)
            .map(productPhotoMapper::toDto);
    }

    /**
     * Delete the productPhoto by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProductPhoto : {}", id);        productPhotoRepository.deleteById(id);
    }
}
