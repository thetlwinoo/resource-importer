package bieebox.resource.importer.repository;

import bieebox.resource.importer.domain.TransactionTypes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TransactionTypes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TransactionTypesRepository extends JpaRepository<TransactionTypes, Long> {

}
