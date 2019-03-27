package bieebox.resource.importer.repository;

import bieebox.resource.importer.domain.ProductSubCategory;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ProductSubCategory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory, Long> {

}
