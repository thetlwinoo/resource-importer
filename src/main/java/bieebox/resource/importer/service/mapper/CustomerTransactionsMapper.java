package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.CustomerTransactionsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity CustomerTransactions and its DTO CustomerTransactionsDTO.
 */
@Mapper(componentModel = "spring", uses = {CustomersMapper.class, PaymentMethodsMapper.class, TransactionTypesMapper.class, InvoicesMapper.class})
public interface CustomerTransactionsMapper extends EntityMapper<CustomerTransactionsDTO, CustomerTransactions> {

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "customer.customerName", target = "customerCustomerName")
    @Mapping(source = "paymentMethod.id", target = "paymentMethodId")
    @Mapping(source = "paymentMethod.paymentMethodName", target = "paymentMethodPaymentMethodName")
    @Mapping(source = "transactionType.id", target = "transactionTypeId")
    @Mapping(source = "invoice.id", target = "invoiceId")
    CustomerTransactionsDTO toDto(CustomerTransactions customerTransactions);

    @Mapping(source = "customerId", target = "customer")
    @Mapping(source = "paymentMethodId", target = "paymentMethod")
    @Mapping(source = "transactionTypeId", target = "transactionType")
    @Mapping(source = "invoiceId", target = "invoice")
    CustomerTransactions toEntity(CustomerTransactionsDTO customerTransactionsDTO);

    default CustomerTransactions fromId(Long id) {
        if (id == null) {
            return null;
        }
        CustomerTransactions customerTransactions = new CustomerTransactions();
        customerTransactions.setId(id);
        return customerTransactions;
    }
}
