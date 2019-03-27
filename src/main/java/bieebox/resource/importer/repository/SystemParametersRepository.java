package bieebox.resource.importer.repository;

import bieebox.resource.importer.domain.SystemParameters;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the SystemParameters entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SystemParametersRepository extends JpaRepository<SystemParameters, Long> {

}
