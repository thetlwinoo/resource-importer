package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.VehicleTemperaturesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity VehicleTemperatures and its DTO VehicleTemperaturesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VehicleTemperaturesMapper extends EntityMapper<VehicleTemperaturesDTO, VehicleTemperatures> {



    default VehicleTemperatures fromId(Long id) {
        if (id == null) {
            return null;
        }
        VehicleTemperatures vehicleTemperatures = new VehicleTemperatures();
        vehicleTemperatures.setId(id);
        return vehicleTemperatures;
    }
}
