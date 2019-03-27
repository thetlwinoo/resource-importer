package bieebox.resource.importer.repository;

import bieebox.resource.importer.domain.CustomerCategories;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the CustomerCategories entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CustomerCategoriesRepository extends JpaRepository<CustomerCategories, Long> {

}
