package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.PurchaseOrderLinesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PurchaseOrderLines and its DTO PurchaseOrderLinesDTO.
 */
@Mapper(componentModel = "spring", uses = {StockItemsMapper.class, PackageTypesMapper.class, PurchaseOrdersMapper.class})
public interface PurchaseOrderLinesMapper extends EntityMapper<PurchaseOrderLinesDTO, PurchaseOrderLines> {

    @Mapping(source = "stockItem.id", target = "stockItemId")
    @Mapping(source = "stockItem.stockItemName", target = "stockItemStockItemName")
    @Mapping(source = "packageType.id", target = "packageTypeId")
    @Mapping(source = "packageType.packageTypeName", target = "packageTypePackageTypeName")
    @Mapping(source = "purchaseOrder.id", target = "purchaseOrderId")
    PurchaseOrderLinesDTO toDto(PurchaseOrderLines purchaseOrderLines);

    @Mapping(source = "stockItemId", target = "stockItem")
    @Mapping(source = "packageTypeId", target = "packageType")
    @Mapping(source = "purchaseOrderId", target = "purchaseOrder")
    PurchaseOrderLines toEntity(PurchaseOrderLinesDTO purchaseOrderLinesDTO);

    default PurchaseOrderLines fromId(Long id) {
        if (id == null) {
            return null;
        }
        PurchaseOrderLines purchaseOrderLines = new PurchaseOrderLines();
        purchaseOrderLines.setId(id);
        return purchaseOrderLines;
    }
}
