package bieebox.resource.importer.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Orders.
 */
@Entity
@Table(name = "orders")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @NotNull
    @Column(name = "expected_delivery_date", nullable = false)
    private LocalDate expectedDeliveryDate;

    @Column(name = "customer_purchase_order_number")
    private String customerPurchaseOrderNumber;

    @NotNull
    @Column(name = "is_undersupply_backordered", nullable = false)
    private Boolean isUndersupplyBackordered;

    @Column(name = "comments")
    private String comments;

    @Column(name = "delivery_instructions")
    private String deliveryInstructions;

    @Column(name = "internal_comments")
    private String internalComments;

    @Column(name = "picking_completed_when")
    private Instant pickingCompletedWhen;

    @ManyToOne
    @JsonIgnoreProperties("orders")
    private People pickedByPerson;

    @ManyToOne
    @JsonIgnoreProperties("orders")
    private People contactPerson;

    @ManyToOne
    @JsonIgnoreProperties("orders")
    private People salespersonPerson;

    @ManyToOne
    @JsonIgnoreProperties("orders")
    private Customers customer;

    @ManyToOne
    @JsonIgnoreProperties("orders")
    private Orders backorderOrder;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Orders orderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public Orders expectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
        return this;
    }

    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getCustomerPurchaseOrderNumber() {
        return customerPurchaseOrderNumber;
    }

    public Orders customerPurchaseOrderNumber(String customerPurchaseOrderNumber) {
        this.customerPurchaseOrderNumber = customerPurchaseOrderNumber;
        return this;
    }

    public void setCustomerPurchaseOrderNumber(String customerPurchaseOrderNumber) {
        this.customerPurchaseOrderNumber = customerPurchaseOrderNumber;
    }

    public Boolean isIsUndersupplyBackordered() {
        return isUndersupplyBackordered;
    }

    public Orders isUndersupplyBackordered(Boolean isUndersupplyBackordered) {
        this.isUndersupplyBackordered = isUndersupplyBackordered;
        return this;
    }

    public void setIsUndersupplyBackordered(Boolean isUndersupplyBackordered) {
        this.isUndersupplyBackordered = isUndersupplyBackordered;
    }

    public String getComments() {
        return comments;
    }

    public Orders comments(String comments) {
        this.comments = comments;
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    public Orders deliveryInstructions(String deliveryInstructions) {
        this.deliveryInstructions = deliveryInstructions;
        return this;
    }

    public void setDeliveryInstructions(String deliveryInstructions) {
        this.deliveryInstructions = deliveryInstructions;
    }

    public String getInternalComments() {
        return internalComments;
    }

    public Orders internalComments(String internalComments) {
        this.internalComments = internalComments;
        return this;
    }

    public void setInternalComments(String internalComments) {
        this.internalComments = internalComments;
    }

    public Instant getPickingCompletedWhen() {
        return pickingCompletedWhen;
    }

    public Orders pickingCompletedWhen(Instant pickingCompletedWhen) {
        this.pickingCompletedWhen = pickingCompletedWhen;
        return this;
    }

    public void setPickingCompletedWhen(Instant pickingCompletedWhen) {
        this.pickingCompletedWhen = pickingCompletedWhen;
    }

    public People getPickedByPerson() {
        return pickedByPerson;
    }

    public Orders pickedByPerson(People people) {
        this.pickedByPerson = people;
        return this;
    }

    public void setPickedByPerson(People people) {
        this.pickedByPerson = people;
    }

    public People getContactPerson() {
        return contactPerson;
    }

    public Orders contactPerson(People people) {
        this.contactPerson = people;
        return this;
    }

    public void setContactPerson(People people) {
        this.contactPerson = people;
    }

    public People getSalespersonPerson() {
        return salespersonPerson;
    }

    public Orders salespersonPerson(People people) {
        this.salespersonPerson = people;
        return this;
    }

    public void setSalespersonPerson(People people) {
        this.salespersonPerson = people;
    }

    public Customers getCustomer() {
        return customer;
    }

    public Orders customer(Customers customers) {
        this.customer = customers;
        return this;
    }

    public void setCustomer(Customers customers) {
        this.customer = customers;
    }

    public Orders getBackorderOrder() {
        return backorderOrder;
    }

    public Orders backorderOrder(Orders orders) {
        this.backorderOrder = orders;
        return this;
    }

    public void setBackorderOrder(Orders orders) {
        this.backorderOrder = orders;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Orders orders = (Orders) o;
        if (orders.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), orders.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Orders{" +
            "id=" + getId() +
            ", orderDate='" + getOrderDate() + "'" +
            ", expectedDeliveryDate='" + getExpectedDeliveryDate() + "'" +
            ", customerPurchaseOrderNumber='" + getCustomerPurchaseOrderNumber() + "'" +
            ", isUndersupplyBackordered='" + isIsUndersupplyBackordered() + "'" +
            ", comments='" + getComments() + "'" +
            ", deliveryInstructions='" + getDeliveryInstructions() + "'" +
            ", internalComments='" + getInternalComments() + "'" +
            ", pickingCompletedWhen='" + getPickingCompletedWhen() + "'" +
            "}";
    }
}
