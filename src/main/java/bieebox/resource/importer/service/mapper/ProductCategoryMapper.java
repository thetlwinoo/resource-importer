package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.ProductCategoryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ProductCategory and its DTO ProductCategoryDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProductCategoryMapper extends EntityMapper<ProductCategoryDTO, ProductCategory> {



    default ProductCategory fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(id);
        return productCategory;
    }
}
