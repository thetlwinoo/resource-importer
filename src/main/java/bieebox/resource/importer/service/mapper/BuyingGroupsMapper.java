package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.BuyingGroupsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity BuyingGroups and its DTO BuyingGroupsDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BuyingGroupsMapper extends EntityMapper<BuyingGroupsDTO, BuyingGroups> {



    default BuyingGroups fromId(Long id) {
        if (id == null) {
            return null;
        }
        BuyingGroups buyingGroups = new BuyingGroups();
        buyingGroups.setId(id);
        return buyingGroups;
    }
}
