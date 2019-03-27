package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.InvoicesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Invoices and its DTO InvoicesDTO.
 */
@Mapper(componentModel = "spring", uses = {PeopleMapper.class, CustomersMapper.class, DeliveryMethodsMapper.class, OrdersMapper.class})
public interface InvoicesMapper extends EntityMapper<InvoicesDTO, Invoices> {

    @Mapping(source = "contactPerson.id", target = "contactPersonId")
    @Mapping(source = "contactPerson.fullName", target = "contactPersonFullName")
    @Mapping(source = "salespersonPerson.id", target = "salespersonPersonId")
    @Mapping(source = "salespersonPerson.fullName", target = "salespersonPersonFullName")
    @Mapping(source = "packedByPerson.id", target = "packedByPersonId")
    @Mapping(source = "packedByPerson.fullName", target = "packedByPersonFullName")
    @Mapping(source = "accountsPerson.id", target = "accountsPersonId")
    @Mapping(source = "accountsPerson.fullName", target = "accountsPersonFullName")
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "customer.customerName", target = "customerCustomerName")
    @Mapping(source = "billToCustomer.id", target = "billToCustomerId")
    @Mapping(source = "billToCustomer.customerName", target = "billToCustomerCustomerName")
    @Mapping(source = "deliveryMethod.id", target = "deliveryMethodId")
    @Mapping(source = "deliveryMethod.deliveryMethodName", target = "deliveryMethodDeliveryMethodName")
    @Mapping(source = "order.id", target = "orderId")
    InvoicesDTO toDto(Invoices invoices);

    @Mapping(source = "contactPersonId", target = "contactPerson")
    @Mapping(source = "salespersonPersonId", target = "salespersonPerson")
    @Mapping(source = "packedByPersonId", target = "packedByPerson")
    @Mapping(source = "accountsPersonId", target = "accountsPerson")
    @Mapping(source = "customerId", target = "customer")
    @Mapping(source = "billToCustomerId", target = "billToCustomer")
    @Mapping(source = "deliveryMethodId", target = "deliveryMethod")
    @Mapping(source = "orderId", target = "order")
    Invoices toEntity(InvoicesDTO invoicesDTO);

    default Invoices fromId(Long id) {
        if (id == null) {
            return null;
        }
        Invoices invoices = new Invoices();
        invoices.setId(id);
        return invoices;
    }
}
