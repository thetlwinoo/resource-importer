package bieebox.resource.importer.repository;

import bieebox.resource.importer.domain.BuyingGroups;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the BuyingGroups entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BuyingGroupsRepository extends JpaRepository<BuyingGroups, Long> {

}
