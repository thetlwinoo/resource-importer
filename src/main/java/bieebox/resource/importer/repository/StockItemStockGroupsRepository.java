package bieebox.resource.importer.repository;

import bieebox.resource.importer.domain.StockItemStockGroups;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the StockItemStockGroups entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StockItemStockGroupsRepository extends JpaRepository<StockItemStockGroups, Long> {

}
