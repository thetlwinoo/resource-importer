package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.OrderLinesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity OrderLines and its DTO OrderLinesDTO.
 */
@Mapper(componentModel = "spring", uses = {OrdersMapper.class, PackageTypesMapper.class, StockItemsMapper.class})
public interface OrderLinesMapper extends EntityMapper<OrderLinesDTO, OrderLines> {

    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "packageType.id", target = "packageTypeId")
    @Mapping(source = "stockItem.id", target = "stockItemId")
    @Mapping(source = "stockItem.stockItemName", target = "stockItemStockItemName")
    OrderLinesDTO toDto(OrderLines orderLines);

    @Mapping(source = "orderId", target = "order")
    @Mapping(source = "packageTypeId", target = "packageType")
    @Mapping(source = "stockItemId", target = "stockItem")
    OrderLines toEntity(OrderLinesDTO orderLinesDTO);

    default OrderLines fromId(Long id) {
        if (id == null) {
            return null;
        }
        OrderLines orderLines = new OrderLines();
        orderLines.setId(id);
        return orderLines;
    }
}
