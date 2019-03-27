package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.PackageTypesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PackageTypes and its DTO PackageTypesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PackageTypesMapper extends EntityMapper<PackageTypesDTO, PackageTypes> {



    default PackageTypes fromId(Long id) {
        if (id == null) {
            return null;
        }
        PackageTypes packageTypes = new PackageTypes();
        packageTypes.setId(id);
        return packageTypes;
    }
}
