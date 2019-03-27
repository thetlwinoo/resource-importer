package bieebox.resource.importer.service.dto;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the PurchaseOrders entity.
 */
public class PurchaseOrdersDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate orderDate;

    private LocalDate expectedDeliveryDate;

    private String supplierReference;

    @NotNull
    private Integer isOrderFinalized;

    private String comments;

    private String internalComments;


    private Long contactPersonId;

    private String contactPersonFullName;

    private Long supplierId;

    private String supplierSupplierName;

    private Long deliveryMethodId;

    private String deliveryMethodDeliveryMethodName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(String supplierReference) {
        this.supplierReference = supplierReference;
    }

    public Integer getIsOrderFinalized() {
        return isOrderFinalized;
    }

    public void setIsOrderFinalized(Integer isOrderFinalized) {
        this.isOrderFinalized = isOrderFinalized;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getInternalComments() {
        return internalComments;
    }

    public void setInternalComments(String internalComments) {
        this.internalComments = internalComments;
    }

    public Long getContactPersonId() {
        return contactPersonId;
    }

    public void setContactPersonId(Long peopleId) {
        this.contactPersonId = peopleId;
    }

    public String getContactPersonFullName() {
        return contactPersonFullName;
    }

    public void setContactPersonFullName(String peopleFullName) {
        this.contactPersonFullName = peopleFullName;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long suppliersId) {
        this.supplierId = suppliersId;
    }

    public String getSupplierSupplierName() {
        return supplierSupplierName;
    }

    public void setSupplierSupplierName(String suppliersSupplierName) {
        this.supplierSupplierName = suppliersSupplierName;
    }

    public Long getDeliveryMethodId() {
        return deliveryMethodId;
    }

    public void setDeliveryMethodId(Long deliveryMethodsId) {
        this.deliveryMethodId = deliveryMethodsId;
    }

    public String getDeliveryMethodDeliveryMethodName() {
        return deliveryMethodDeliveryMethodName;
    }

    public void setDeliveryMethodDeliveryMethodName(String deliveryMethodsDeliveryMethodName) {
        this.deliveryMethodDeliveryMethodName = deliveryMethodsDeliveryMethodName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PurchaseOrdersDTO purchaseOrdersDTO = (PurchaseOrdersDTO) o;
        if (purchaseOrdersDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), purchaseOrdersDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PurchaseOrdersDTO{" +
            "id=" + getId() +
            ", orderDate='" + getOrderDate() + "'" +
            ", expectedDeliveryDate='" + getExpectedDeliveryDate() + "'" +
            ", supplierReference='" + getSupplierReference() + "'" +
            ", isOrderFinalized=" + getIsOrderFinalized() +
            ", comments='" + getComments() + "'" +
            ", internalComments='" + getInternalComments() + "'" +
            ", contactPerson=" + getContactPersonId() +
            ", contactPerson='" + getContactPersonFullName() + "'" +
            ", supplier=" + getSupplierId() +
            ", supplier='" + getSupplierSupplierName() + "'" +
            ", deliveryMethod=" + getDeliveryMethodId() +
            ", deliveryMethod='" + getDeliveryMethodDeliveryMethodName() + "'" +
            "}";
    }
}
