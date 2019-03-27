package bieebox.resource.importer.repository;

import bieebox.resource.importer.domain.ProductProductPhoto;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ProductProductPhoto entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductProductPhotoRepository extends JpaRepository<ProductProductPhoto, Long> {

}
