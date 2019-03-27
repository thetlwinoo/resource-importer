package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.CitiesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Cities and its DTO CitiesDTO.
 */
@Mapper(componentModel = "spring", uses = {StateProvincesMapper.class})
public interface CitiesMapper extends EntityMapper<CitiesDTO, Cities> {

    @Mapping(source = "stateProvince.id", target = "stateProvinceId")
    @Mapping(source = "stateProvince.stateProvinceName", target = "stateProvinceStateProvinceName")
    CitiesDTO toDto(Cities cities);

    @Mapping(source = "stateProvinceId", target = "stateProvince")
    Cities toEntity(CitiesDTO citiesDTO);

    default Cities fromId(Long id) {
        if (id == null) {
            return null;
        }
        Cities cities = new Cities();
        cities.setId(id);
        return cities;
    }
}
