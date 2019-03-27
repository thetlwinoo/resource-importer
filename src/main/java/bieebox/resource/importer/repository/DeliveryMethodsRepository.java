package bieebox.resource.importer.repository;

import bieebox.resource.importer.domain.DeliveryMethods;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the DeliveryMethods entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DeliveryMethodsRepository extends JpaRepository<DeliveryMethods, Long> {

}
