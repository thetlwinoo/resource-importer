package bieebox.resource.importer.service;

import bieebox.resource.importer.service.dto.PaymentMethodsDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing PaymentMethods.
 */
public interface PaymentMethodsService {

    /**
     * Save a paymentMethods.
     *
     * @param paymentMethodsDTO the entity to save
     * @return the persisted entity
     */
    PaymentMethodsDTO save(PaymentMethodsDTO paymentMethodsDTO);

    /**
     * Get all the paymentMethods.
     *
     * @return the list of entities
     */
    List<PaymentMethodsDTO> findAll();


    /**
     * Get the "id" paymentMethods.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<PaymentMethodsDTO> findOne(Long id);

    /**
     * Delete the "id" paymentMethods.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
