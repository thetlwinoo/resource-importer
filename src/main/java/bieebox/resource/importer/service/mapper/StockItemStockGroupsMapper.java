package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.StockItemStockGroupsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity StockItemStockGroups and its DTO StockItemStockGroupsDTO.
 */
@Mapper(componentModel = "spring", uses = {StockGroupsMapper.class, StockItemsMapper.class})
public interface StockItemStockGroupsMapper extends EntityMapper<StockItemStockGroupsDTO, StockItemStockGroups> {

    @Mapping(source = "stockGroup.id", target = "stockGroupId")
    @Mapping(source = "stockGroup.stockGroupName", target = "stockGroupStockGroupName")
    @Mapping(source = "stockItem.id", target = "stockItemId")
    @Mapping(source = "stockItem.stockItemName", target = "stockItemStockItemName")
    StockItemStockGroupsDTO toDto(StockItemStockGroups stockItemStockGroups);

    @Mapping(source = "stockGroupId", target = "stockGroup")
    @Mapping(source = "stockItemId", target = "stockItem")
    StockItemStockGroups toEntity(StockItemStockGroupsDTO stockItemStockGroupsDTO);

    default StockItemStockGroups fromId(Long id) {
        if (id == null) {
            return null;
        }
        StockItemStockGroups stockItemStockGroups = new StockItemStockGroups();
        stockItemStockGroups.setId(id);
        return stockItemStockGroups;
    }
}
