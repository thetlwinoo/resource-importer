package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.StateProvincesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity StateProvinces and its DTO StateProvincesDTO.
 */
@Mapper(componentModel = "spring", uses = {CountriesMapper.class})
public interface StateProvincesMapper extends EntityMapper<StateProvincesDTO, StateProvinces> {

    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "country.countryName", target = "countryCountryName")
    StateProvincesDTO toDto(StateProvinces stateProvinces);

    @Mapping(source = "countryId", target = "country")
    StateProvinces toEntity(StateProvincesDTO stateProvincesDTO);

    default StateProvinces fromId(Long id) {
        if (id == null) {
            return null;
        }
        StateProvinces stateProvinces = new StateProvinces();
        stateProvinces.setId(id);
        return stateProvinces;
    }
}
