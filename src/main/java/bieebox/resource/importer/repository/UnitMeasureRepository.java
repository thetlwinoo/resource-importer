package bieebox.resource.importer.repository;

import bieebox.resource.importer.domain.UnitMeasure;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the UnitMeasure entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UnitMeasureRepository extends JpaRepository<UnitMeasure, Long> {

}
