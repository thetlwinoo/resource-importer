package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.CountriesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Countries and its DTO CountriesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CountriesMapper extends EntityMapper<CountriesDTO, Countries> {



    default Countries fromId(Long id) {
        if (id == null) {
            return null;
        }
        Countries countries = new Countries();
        countries.setId(id);
        return countries;
    }
}
