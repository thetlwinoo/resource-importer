package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.ProductsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Products and its DTO ProductsDTO.
 */
@Mapper(componentModel = "spring", uses = {ProductSubCategoryMapper.class, UnitMeasureMapper.class, ProductModelMapper.class})
public interface ProductsMapper extends EntityMapper<ProductsDTO, Products> {

    @Mapping(source = "productSubCategory.id", target = "productSubCategoryId")
    @Mapping(source = "sizeUnitMeasureCode.id", target = "sizeUnitMeasureCodeId")
    @Mapping(source = "sizeUnitMeasureCode.unitMeasureCode", target = "sizeUnitMeasureCodeUnitMeasureCode")
    @Mapping(source = "weightUnitMeasureCode.id", target = "weightUnitMeasureCodeId")
    @Mapping(source = "weightUnitMeasureCode.unitMeasureCode", target = "weightUnitMeasureCodeUnitMeasureCode")
    @Mapping(source = "productModel.id", target = "productModelId")
    @Mapping(source = "productModel.productModelName", target = "productModelProductModelName")
    ProductsDTO toDto(Products products);

    @Mapping(source = "productSubCategoryId", target = "productSubCategory")
    @Mapping(source = "sizeUnitMeasureCodeId", target = "sizeUnitMeasureCode")
    @Mapping(source = "weightUnitMeasureCodeId", target = "weightUnitMeasureCode")
    @Mapping(source = "productModelId", target = "productModel")
    @Mapping(target = "stockItem", ignore = true)
    Products toEntity(ProductsDTO productsDTO);

    default Products fromId(Long id) {
        if (id == null) {
            return null;
        }
        Products products = new Products();
        products.setId(id);
        return products;
    }
}
