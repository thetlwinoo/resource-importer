package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.OrdersDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Orders and its DTO OrdersDTO.
 */
@Mapper(componentModel = "spring", uses = {PeopleMapper.class, CustomersMapper.class})
public interface OrdersMapper extends EntityMapper<OrdersDTO, Orders> {

    @Mapping(source = "pickedByPerson.id", target = "pickedByPersonId")
    @Mapping(source = "pickedByPerson.fullName", target = "pickedByPersonFullName")
    @Mapping(source = "contactPerson.id", target = "contactPersonId")
    @Mapping(source = "contactPerson.fullName", target = "contactPersonFullName")
    @Mapping(source = "salespersonPerson.id", target = "salespersonPersonId")
    @Mapping(source = "salespersonPerson.fullName", target = "salespersonPersonFullName")
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "customer.customerName", target = "customerCustomerName")
    @Mapping(source = "backorderOrder.id", target = "backorderOrderId")
    OrdersDTO toDto(Orders orders);

    @Mapping(source = "pickedByPersonId", target = "pickedByPerson")
    @Mapping(source = "contactPersonId", target = "contactPerson")
    @Mapping(source = "salespersonPersonId", target = "salespersonPerson")
    @Mapping(source = "customerId", target = "customer")
    @Mapping(source = "backorderOrderId", target = "backorderOrder")
    Orders toEntity(OrdersDTO ordersDTO);

    default Orders fromId(Long id) {
        if (id == null) {
            return null;
        }
        Orders orders = new Orders();
        orders.setId(id);
        return orders;
    }
}
