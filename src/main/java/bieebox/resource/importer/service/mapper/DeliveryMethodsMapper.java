package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.DeliveryMethodsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity DeliveryMethods and its DTO DeliveryMethodsDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DeliveryMethodsMapper extends EntityMapper<DeliveryMethodsDTO, DeliveryMethods> {



    default DeliveryMethods fromId(Long id) {
        if (id == null) {
            return null;
        }
        DeliveryMethods deliveryMethods = new DeliveryMethods();
        deliveryMethods.setId(id);
        return deliveryMethods;
    }
}
