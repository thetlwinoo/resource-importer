package bieebox.resource.importer.service;

import bieebox.resource.importer.service.dto.InvoiceLinesDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing InvoiceLines.
 */
public interface InvoiceLinesService {

    /**
     * Save a invoiceLines.
     *
     * @param invoiceLinesDTO the entity to save
     * @return the persisted entity
     */
    InvoiceLinesDTO save(InvoiceLinesDTO invoiceLinesDTO);

    /**
     * Get all the invoiceLines.
     *
     * @return the list of entities
     */
    List<InvoiceLinesDTO> findAll();


    /**
     * Get the "id" invoiceLines.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<InvoiceLinesDTO> findOne(Long id);

    /**
     * Delete the "id" invoiceLines.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
