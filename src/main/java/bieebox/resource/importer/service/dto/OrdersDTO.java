package bieebox.resource.importer.service.dto;
import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Orders entity.
 */
public class OrdersDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate orderDate;

    @NotNull
    private LocalDate expectedDeliveryDate;

    private String customerPurchaseOrderNumber;

    @NotNull
    private Boolean isUndersupplyBackordered;

    private String comments;

    private String deliveryInstructions;

    private String internalComments;

    private Instant pickingCompletedWhen;


    private Long pickedByPersonId;

    private String pickedByPersonFullName;

    private Long contactPersonId;

    private String contactPersonFullName;

    private Long salespersonPersonId;

    private String salespersonPersonFullName;

    private Long customerId;

    private String customerCustomerName;

    private Long backorderOrderId;

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

    public String getCustomerPurchaseOrderNumber() {
        return customerPurchaseOrderNumber;
    }

    public void setCustomerPurchaseOrderNumber(String customerPurchaseOrderNumber) {
        this.customerPurchaseOrderNumber = customerPurchaseOrderNumber;
    }

    public Boolean isIsUndersupplyBackordered() {
        return isUndersupplyBackordered;
    }

    public void setIsUndersupplyBackordered(Boolean isUndersupplyBackordered) {
        this.isUndersupplyBackordered = isUndersupplyBackordered;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    public void setDeliveryInstructions(String deliveryInstructions) {
        this.deliveryInstructions = deliveryInstructions;
    }

    public String getInternalComments() {
        return internalComments;
    }

    public void setInternalComments(String internalComments) {
        this.internalComments = internalComments;
    }

    public Instant getPickingCompletedWhen() {
        return pickingCompletedWhen;
    }

    public void setPickingCompletedWhen(Instant pickingCompletedWhen) {
        this.pickingCompletedWhen = pickingCompletedWhen;
    }

    public Long getPickedByPersonId() {
        return pickedByPersonId;
    }

    public void setPickedByPersonId(Long peopleId) {
        this.pickedByPersonId = peopleId;
    }

    public String getPickedByPersonFullName() {
        return pickedByPersonFullName;
    }

    public void setPickedByPersonFullName(String peopleFullName) {
        this.pickedByPersonFullName = peopleFullName;
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

    public Long getSalespersonPersonId() {
        return salespersonPersonId;
    }

    public void setSalespersonPersonId(Long peopleId) {
        this.salespersonPersonId = peopleId;
    }

    public String getSalespersonPersonFullName() {
        return salespersonPersonFullName;
    }

    public void setSalespersonPersonFullName(String peopleFullName) {
        this.salespersonPersonFullName = peopleFullName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customersId) {
        this.customerId = customersId;
    }

    public String getCustomerCustomerName() {
        return customerCustomerName;
    }

    public void setCustomerCustomerName(String customersCustomerName) {
        this.customerCustomerName = customersCustomerName;
    }

    public Long getBackorderOrderId() {
        return backorderOrderId;
    }

    public void setBackorderOrderId(Long ordersId) {
        this.backorderOrderId = ordersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrdersDTO ordersDTO = (OrdersDTO) o;
        if (ordersDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ordersDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
            "id=" + getId() +
            ", orderDate='" + getOrderDate() + "'" +
            ", expectedDeliveryDate='" + getExpectedDeliveryDate() + "'" +
            ", customerPurchaseOrderNumber='" + getCustomerPurchaseOrderNumber() + "'" +
            ", isUndersupplyBackordered='" + isIsUndersupplyBackordered() + "'" +
            ", comments='" + getComments() + "'" +
            ", deliveryInstructions='" + getDeliveryInstructions() + "'" +
            ", internalComments='" + getInternalComments() + "'" +
            ", pickingCompletedWhen='" + getPickingCompletedWhen() + "'" +
            ", pickedByPerson=" + getPickedByPersonId() +
            ", pickedByPerson='" + getPickedByPersonFullName() + "'" +
            ", contactPerson=" + getContactPersonId() +
            ", contactPerson='" + getContactPersonFullName() + "'" +
            ", salespersonPerson=" + getSalespersonPersonId() +
            ", salespersonPerson='" + getSalespersonPersonFullName() + "'" +
            ", customer=" + getCustomerId() +
            ", customer='" + getCustomerCustomerName() + "'" +
            ", backorderOrder=" + getBackorderOrderId() +
            "}";
    }
}
