package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.InvoiceLinesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity InvoiceLines and its DTO InvoiceLinesDTO.
 */
@Mapper(componentModel = "spring", uses = {PackageTypesMapper.class, InvoicesMapper.class, StockItemsMapper.class})
public interface InvoiceLinesMapper extends EntityMapper<InvoiceLinesDTO, InvoiceLines> {

    @Mapping(source = "packageType.id", target = "packageTypeId")
    @Mapping(source = "packageType.packageTypeName", target = "packageTypePackageTypeName")
    @Mapping(source = "invoice.id", target = "invoiceId")
    @Mapping(source = "stockItem.id", target = "stockItemId")
    InvoiceLinesDTO toDto(InvoiceLines invoiceLines);

    @Mapping(source = "packageTypeId", target = "packageType")
    @Mapping(source = "invoiceId", target = "invoice")
    @Mapping(source = "stockItemId", target = "stockItem")
    InvoiceLines toEntity(InvoiceLinesDTO invoiceLinesDTO);

    default InvoiceLines fromId(Long id) {
        if (id == null) {
            return null;
        }
        InvoiceLines invoiceLines = new InvoiceLines();
        invoiceLines.setId(id);
        return invoiceLines;
    }
}
