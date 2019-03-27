package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.StockItemsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity StockItems and its DTO StockItemsDTO.
 */
@Mapper(componentModel = "spring", uses = {ProductsMapper.class, PackageTypesMapper.class, SuppliersMapper.class, ColorsMapper.class})
public interface StockItemsMapper extends EntityMapper<StockItemsDTO, StockItems> {

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "unitPackage.id", target = "unitPackageId")
    @Mapping(source = "unitPackage.packageTypeName", target = "unitPackagePackageTypeName")
    @Mapping(source = "outerPackage.id", target = "outerPackageId")
    @Mapping(source = "outerPackage.packageTypeName", target = "outerPackagePackageTypeName")
    @Mapping(source = "supplier.id", target = "supplierId")
    @Mapping(source = "supplier.supplierName", target = "supplierSupplierName")
    @Mapping(source = "color.id", target = "colorId")
    @Mapping(source = "color.colorName", target = "colorColorName")
    StockItemsDTO toDto(StockItems stockItems);

    @Mapping(source = "productId", target = "product")
    @Mapping(source = "unitPackageId", target = "unitPackage")
    @Mapping(source = "outerPackageId", target = "outerPackage")
    @Mapping(source = "supplierId", target = "supplier")
    @Mapping(source = "colorId", target = "color")
    StockItems toEntity(StockItemsDTO stockItemsDTO);

    default StockItems fromId(Long id) {
        if (id == null) {
            return null;
        }
        StockItems stockItems = new StockItems();
        stockItems.setId(id);
        return stockItems;
    }
}
