package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.CustomersDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Customers and its DTO CustomersDTO.
 */
@Mapper(componentModel = "spring", uses = {PeopleMapper.class, CustomerCategoriesMapper.class, BuyingGroupsMapper.class, CitiesMapper.class, DeliveryMethodsMapper.class})
public interface CustomersMapper extends EntityMapper<CustomersDTO, Customers> {

    @Mapping(source = "primaryContactPerson.id", target = "primaryContactPersonId")
    @Mapping(source = "primaryContactPerson.fullName", target = "primaryContactPersonFullName")
    @Mapping(source = "alternateContactPerson.id", target = "alternateContactPersonId")
    @Mapping(source = "alternateContactPerson.fullName", target = "alternateContactPersonFullName")
    @Mapping(source = "customerCategory.id", target = "customerCategoryId")
    @Mapping(source = "customerCategory.customerCategoryName", target = "customerCategoryCustomerCategoryName")
    @Mapping(source = "buyingGroup.id", target = "buyingGroupId")
    @Mapping(source = "buyingGroup.buyingGroupName", target = "buyingGroupBuyingGroupName")
    @Mapping(source = "billToCustomer.id", target = "billToCustomerId")
    @Mapping(source = "billToCustomer.customerName", target = "billToCustomerCustomerName")
    @Mapping(source = "deliveryCity.id", target = "deliveryCityId")
    @Mapping(source = "deliveryCity.cityName", target = "deliveryCityCityName")
    @Mapping(source = "postalCity.id", target = "postalCityId")
    @Mapping(source = "postalCity.cityName", target = "postalCityCityName")
    @Mapping(source = "deliveryMethod.id", target = "deliveryMethodId")
    @Mapping(source = "deliveryMethod.deliveryMethodName", target = "deliveryMethodDeliveryMethodName")
    CustomersDTO toDto(Customers customers);

    @Mapping(source = "primaryContactPersonId", target = "primaryContactPerson")
    @Mapping(source = "alternateContactPersonId", target = "alternateContactPerson")
    @Mapping(source = "customerCategoryId", target = "customerCategory")
    @Mapping(source = "buyingGroupId", target = "buyingGroup")
    @Mapping(source = "billToCustomerId", target = "billToCustomer")
    @Mapping(source = "deliveryCityId", target = "deliveryCity")
    @Mapping(source = "postalCityId", target = "postalCity")
    @Mapping(source = "deliveryMethodId", target = "deliveryMethod")
    Customers toEntity(CustomersDTO customersDTO);

    default Customers fromId(Long id) {
        if (id == null) {
            return null;
        }
        Customers customers = new Customers();
        customers.setId(id);
        return customers;
    }
}
