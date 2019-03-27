package bieebox.resource.importer.service.impl;

import bieebox.resource.importer.service.PeopleService;
import bieebox.resource.importer.domain.People;
import bieebox.resource.importer.repository.PeopleRepository;
import bieebox.resource.importer.service.dto.PeopleDTO;
import bieebox.resource.importer.service.mapper.PeopleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing People.
 */
@Service
@Transactional
public class PeopleServiceImpl implements PeopleService {

    private final Logger log = LoggerFactory.getLogger(PeopleServiceImpl.class);

    private final PeopleRepository peopleRepository;

    private final PeopleMapper peopleMapper;

    public PeopleServiceImpl(PeopleRepository peopleRepository, PeopleMapper peopleMapper) {
        this.peopleRepository = peopleRepository;
        this.peopleMapper = peopleMapper;
    }

    /**
     * Save a people.
     *
     * @param peopleDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PeopleDTO save(PeopleDTO peopleDTO) {
        log.debug("Request to save People : {}", peopleDTO);
        People people = peopleMapper.toEntity(peopleDTO);
        people = peopleRepository.save(people);
        return peopleMapper.toDto(people);
    }

    /**
     * Get all the people.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<PeopleDTO> findAll() {
        log.debug("Request to get all People");
        return peopleRepository.findAll().stream()
            .map(peopleMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one people by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PeopleDTO> findOne(Long id) {
        log.debug("Request to get People : {}", id);
        return peopleRepository.findById(id)
            .map(peopleMapper::toDto);
    }

    /**
     * Delete the people by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete People : {}", id);        peopleRepository.deleteById(id);
    }
}
