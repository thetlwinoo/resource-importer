package bieebox.resource.importer.repository;

import bieebox.resource.importer.domain.SpecialDeals;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the SpecialDeals entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SpecialDealsRepository extends JpaRepository<SpecialDeals, Long> {

}
