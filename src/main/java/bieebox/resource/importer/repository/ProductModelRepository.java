package bieebox.resource.importer.repository;

import bieebox.resource.importer.domain.ProductModel;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ProductModel entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductModelRepository extends JpaRepository<ProductModel, Long> {

}
