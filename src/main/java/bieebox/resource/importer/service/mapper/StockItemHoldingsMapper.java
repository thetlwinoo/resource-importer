package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.StockItemHoldingsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity StockItemHoldings and its DTO StockItemHoldingsDTO.
 */
@Mapper(componentModel = "spring", uses = {StockItemsMapper.class})
public interface StockItemHoldingsMapper extends EntityMapper<StockItemHoldingsDTO, StockItemHoldings> {

    @Mapping(source = "stockItem.id", target = "stockItemId")
    @Mapping(source = "stockItem.stockItemName", target = "stockItemStockItemName")
    StockItemHoldingsDTO toDto(StockItemHoldings stockItemHoldings);

    @Mapping(source = "stockItemId", target = "stockItem")
    StockItemHoldings toEntity(StockItemHoldingsDTO stockItemHoldingsDTO);

    default StockItemHoldings fromId(Long id) {
        if (id == null) {
            return null;
        }
        StockItemHoldings stockItemHoldings = new StockItemHoldings();
        stockItemHoldings.setId(id);
        return stockItemHoldings;
    }
}
