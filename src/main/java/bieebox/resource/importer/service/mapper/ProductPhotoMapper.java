package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.ProductPhotoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ProductPhoto and its DTO ProductPhotoDTO.
 */
@Mapper(componentModel = "spring", uses = {ProductsMapper.class})
public interface ProductPhotoMapper extends EntityMapper<ProductPhotoDTO, ProductPhoto> {

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.productName", target = "productProductName")
    ProductPhotoDTO toDto(ProductPhoto productPhoto);

    @Mapping(source = "productId", target = "product")
    ProductPhoto toEntity(ProductPhotoDTO productPhotoDTO);

    default ProductPhoto fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProductPhoto productPhoto = new ProductPhoto();
        productPhoto.setId(id);
        return productPhoto;
    }
}
