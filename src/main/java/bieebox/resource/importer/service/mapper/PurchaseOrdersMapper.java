package bieebox.resource.importer.service.mapper;

import bieebox.resource.importer.domain.*;
import bieebox.resource.importer.service.dto.PurchaseOrdersDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PurchaseOrders and its DTO PurchaseOrdersDTO.
 */
@Mapper(componentModel = "spring", uses = {PeopleMapper.class, SuppliersMapper.class, DeliveryMethodsMapper.class})
public interface PurchaseOrdersMapper extends EntityMapper<PurchaseOrdersDTO, PurchaseOrders> {

    @Mapping(source = "contactPerson.id", target = "contactPersonId")
    @Mapping(source = "contactPerson.fullName", target = "contactPersonFullName")
    @Mapping(source = "supplier.id", target = "supplierId")
    @Mapping(source = "supplier.supplierName", target = "supplierSupplierName")
    @Mapping(source = "deliveryMethod.id", target = "deliveryMethodId")
    @Mapping(source = "deliveryMethod.deliveryMethodName", target = "deliveryMethodDeliveryMethodName")
    PurchaseOrdersDTO toDto(PurchaseOrders purchaseOrders);

    @Mapping(source = "contactPersonId", target = "contactPerson")
    @Mapping(source = "supplierId", target = "supplier")
    @Mapping(source = "deliveryMethodId", target = "deliveryMethod")
    PurchaseOrders toEntity(PurchaseOrdersDTO purchaseOrdersDTO);

    default PurchaseOrders fromId(Long id) {
        if (id == null) {
            return null;
        }
        PurchaseOrders purchaseOrders = new PurchaseOrders();
        purchaseOrders.setId(id);
        return purchaseOrders;
    }
}
