package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.TransactionTypesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity TransactionTypes and its DTO TransactionTypesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TransactionTypesMapper extends EntityMapper<TransactionTypesDTO, TransactionTypes> {



    default TransactionTypes fromId(Long id) {
        if (id == null) {
            return null;
        }
        TransactionTypes transactionTypes = new TransactionTypes();
        transactionTypes.setId(id);
        return transactionTypes;
    }
}
