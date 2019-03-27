package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.UnitMeasureDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity UnitMeasure and its DTO UnitMeasureDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UnitMeasureMapper extends EntityMapper<UnitMeasureDTO, UnitMeasure> {



    default UnitMeasure fromId(Long id) {
        if (id == null) {
            return null;
        }
        UnitMeasure unitMeasure = new UnitMeasure();
        unitMeasure.setId(id);
        return unitMeasure;
    }
}
