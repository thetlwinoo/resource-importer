package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.ProductModelDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ProductModel and its DTO ProductModelDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProductModelMapper extends EntityMapper<ProductModelDTO, ProductModel> {



    default ProductModel fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProductModel productModel = new ProductModel();
        productModel.setId(id);
        return productModel;
    }
}
