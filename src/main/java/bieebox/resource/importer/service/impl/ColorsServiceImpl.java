package bieebox.resource.importer.service.impl;

import bieebox.resource.importer.service.ColorsService;
import bieebox.resource.importer.domain.Colors;
import bieebox.resource.importer.repository.ColorsRepository;
import bieebox.resource.importer.service.dto.ColorsDTO;
import bieebox.resource.importer.service.mapper.ColorsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Colors.
 */
@Service
@Transactional
public class ColorsServiceImpl implements ColorsService {

    private final Logger log = LoggerFactory.getLogger(ColorsServiceImpl.class);

    private final ColorsRepository colorsRepository;

    private final ColorsMapper colorsMapper;

    public ColorsServiceImpl(ColorsRepository colorsRepository, ColorsMapper colorsMapper) {
        this.colorsRepository = colorsRepository;
        this.colorsMapper = colorsMapper;
    }

    /**
     * Save a colors.
     *
     * @param colorsDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ColorsDTO save(ColorsDTO colorsDTO) {
        log.debug("Request to save Colors : {}", colorsDTO);
        Colors colors = colorsMapper.toEntity(colorsDTO);
        colors = colorsRepository.save(colors);
        return colorsMapper.toDto(colors);
    }

    /**
     * Get all the colors.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ColorsDTO> findAll() {
        log.debug("Request to get all Colors");
        return colorsRepository.findAll().stream()
            .map(colorsMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one colors by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ColorsDTO> findOne(Long id) {
        log.debug("Request to get Colors : {}", id);
        return colorsRepository.findById(id)
            .map(colorsMapper::toDto);
    }

    /**
     * Delete the colors by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Colors : {}", id);        colorsRepository.deleteById(id);
    }
}
