package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.ProductProductPhotoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ProductProductPhoto and its DTO ProductProductPhotoDTO.
 */
@Mapper(componentModel = "spring", uses = {ProductPhotoMapper.class, ProductsMapper.class})
public interface ProductProductPhotoMapper extends EntityMapper<ProductProductPhotoDTO, ProductProductPhoto> {

    @Mapping(source = "productPhoto.id", target = "productPhotoId")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.productName", target = "productProductName")
    ProductProductPhotoDTO toDto(ProductProductPhoto productProductPhoto);

    @Mapping(source = "productPhotoId", target = "productPhoto")
    @Mapping(source = "productId", target = "product")
    ProductProductPhoto toEntity(ProductProductPhotoDTO productProductPhotoDTO);

    default ProductProductPhoto fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProductProductPhoto productProductPhoto = new ProductProductPhoto();
        productProductPhoto.setId(id);
        return productProductPhoto;
    }
}
