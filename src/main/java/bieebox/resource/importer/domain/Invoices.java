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
 * A Invoices.
 */
@Entity
@Table(name = "invoices")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Invoices implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "invoice_date", nullable = false)
    private LocalDate invoiceDate;

    @Column(name = "customer_purchase_order_number")
    private String customerPurchaseOrderNumber;

    @NotNull
    @Column(name = "is_credit_note", nullable = false)
    private Boolean isCreditNote;

    @Column(name = "credit_note_reason")
    private String creditNoteReason;

    @Column(name = "comments")
    private String comments;

    @Column(name = "delivery_instructions")
    private String deliveryInstructions;

    @Column(name = "internal_comments")
    private String internalComments;

    @NotNull
    @Column(name = "total_dry_items", nullable = false)
    private Integer totalDryItems;

    @NotNull
    @Column(name = "total_chiller_items", nullable = false)
    private Integer totalChillerItems;

    @Column(name = "delivery_run")
    private String deliveryRun;

    @Column(name = "run_position")
    private String runPosition;

    @Column(name = "returned_delivery_data")
    private String returnedDeliveryData;

    @Column(name = "confirmed_delivery_time")
    private Instant confirmedDeliveryTime;

    @Column(name = "confirmed_received_by")
    private String confirmedReceivedBy;

    @ManyToOne
    @JsonIgnoreProperties("invoices")
    private People contactPerson;

    @ManyToOne
    @JsonIgnoreProperties("invoices")
    private People salespersonPerson;

    @ManyToOne
    @JsonIgnoreProperties("invoices")
    private People packedByPerson;

    @ManyToOne
    @JsonIgnoreProperties("invoices")
    private People accountsPerson;

    @ManyToOne
    @JsonIgnoreProperties("invoices")
    private Customers customer;

    @ManyToOne
    @JsonIgnoreProperties("invoices")
    private Customers billToCustomer;

    @ManyToOne
    @JsonIgnoreProperties("invoices")
    private DeliveryMethods deliveryMethod;

    @ManyToOne
    @JsonIgnoreProperties("invoices")
    private Orders order;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public Invoices invoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
        return this;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerPurchaseOrderNumber() {
        return customerPurchaseOrderNumber;
    }

    public Invoices customerPurchaseOrderNumber(String customerPurchaseOrderNumber) {
        this.customerPurchaseOrderNumber = customerPurchaseOrderNumber;
        return this;
    }

    public void setCustomerPurchaseOrderNumber(String customerPurchaseOrderNumber) {
        this.customerPurchaseOrderNumber = customerPurchaseOrderNumber;
    }

    public Boolean isIsCreditNote() {
        return isCreditNote;
    }

    public Invoices isCreditNote(Boolean isCreditNote) {
        this.isCreditNote = isCreditNote;
        return this;
    }

    public void setIsCreditNote(Boolean isCreditNote) {
        this.isCreditNote = isCreditNote;
    }

    public String getCreditNoteReason() {
        return creditNoteReason;
    }

    public Invoices creditNoteReason(String creditNoteReason) {
        this.creditNoteReason = creditNoteReason;
        return this;
    }

    public void setCreditNoteReason(String creditNoteReason) {
        this.creditNoteReason = creditNoteReason;
    }

    public String getComments() {
        return comments;
    }

    public Invoices comments(String comments) {
        this.comments = comments;
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    public Invoices deliveryInstructions(String deliveryInstructions) {
        this.deliveryInstructions = deliveryInstructions;
        return this;
    }

    public void setDeliveryInstructions(String deliveryInstructions) {
        this.deliveryInstructions = deliveryInstructions;
    }

    public String getInternalComments() {
        return internalComments;
    }

    public Invoices internalComments(String internalComments) {
        this.internalComments = internalComments;
        return this;
    }

    public void setInternalComments(String internalComments) {
        this.internalComments = internalComments;
    }

    public Integer getTotalDryItems() {
        return totalDryItems;
    }

    public Invoices totalDryItems(Integer totalDryItems) {
        this.totalDryItems = totalDryItems;
        return this;
    }

    public void setTotalDryItems(Integer totalDryItems) {
        this.totalDryItems = totalDryItems;
    }

    public Integer getTotalChillerItems() {
        return totalChillerItems;
    }

    public Invoices totalChillerItems(Integer totalChillerItems) {
        this.totalChillerItems = totalChillerItems;
        return this;
    }

    public void setTotalChillerItems(Integer totalChillerItems) {
        this.totalChillerItems = totalChillerItems;
    }

    public String getDeliveryRun() {
        return deliveryRun;
    }

    public Invoices deliveryRun(String deliveryRun) {
        this.deliveryRun = deliveryRun;
        return this;
    }

    public void setDeliveryRun(String deliveryRun) {
        this.deliveryRun = deliveryRun;
    }

    public String getRunPosition() {
        return runPosition;
    }

    public Invoices runPosition(String runPosition) {
        this.runPosition = runPosition;
        return this;
    }

    public void setRunPosition(String runPosition) {
        this.runPosition = runPosition;
    }

    public String getReturnedDeliveryData() {
        return returnedDeliveryData;
    }

    public Invoices returnedDeliveryData(String returnedDeliveryData) {
        this.returnedDeliveryData = returnedDeliveryData;
        return this;
    }

    public void setReturnedDeliveryData(String returnedDeliveryData) {
        this.returnedDeliveryData = returnedDeliveryData;
    }

    public Instant getConfirmedDeliveryTime() {
        return confirmedDeliveryTime;
    }

    public Invoices confirmedDeliveryTime(Instant confirmedDeliveryTime) {
        this.confirmedDeliveryTime = confirmedDeliveryTime;
        return this;
    }

    public void setConfirmedDeliveryTime(Instant confirmedDeliveryTime) {
        this.confirmedDeliveryTime = confirmedDeliveryTime;
    }

    public String getConfirmedReceivedBy() {
        return confirmedReceivedBy;
    }

    public Invoices confirmedReceivedBy(String confirmedReceivedBy) {
        this.confirmedReceivedBy = confirmedReceivedBy;
        return this;
    }

    public void setConfirmedReceivedBy(String confirmedReceivedBy) {
        this.confirmedReceivedBy = confirmedReceivedBy;
    }

    public People getContactPerson() {
        return contactPerson;
    }

    public Invoices contactPerson(People people) {
        this.contactPerson = people;
        return this;
    }

    public void setContactPerson(People people) {
        this.contactPerson = people;
    }

    public People getSalespersonPerson() {
        return salespersonPerson;
    }

    public Invoices salespersonPerson(People people) {
        this.salespersonPerson = people;
        return this;
    }

    public void setSalespersonPerson(People people) {
        this.salespersonPerson = people;
    }

    public People getPackedByPerson() {
        return packedByPerson;
    }

    public Invoices packedByPerson(People people) {
        this.packedByPerson = people;
        return this;
    }

    public void setPackedByPerson(People people) {
        this.packedByPerson = people;
    }

    public People getAccountsPerson() {
        return accountsPerson;
    }

    public Invoices accountsPerson(People people) {
        this.accountsPerson = people;
        return this;
    }

    public void setAccountsPerson(People people) {
        this.accountsPerson = people;
    }

    public Customers getCustomer() {
        return customer;
    }

    public Invoices customer(Customers customers) {
        this.customer = customers;
        return this;
    }

    public void setCustomer(Customers customers) {
        this.customer = customers;
    }

    public Customers getBillToCustomer() {
        return billToCustomer;
    }

    public Invoices billToCustomer(Customers customers) {
        this.billToCustomer = customers;
        return this;
    }

    public void setBillToCustomer(Customers customers) {
        this.billToCustomer = customers;
    }

    public DeliveryMethods getDeliveryMethod() {
        return deliveryMethod;
    }

    public Invoices deliveryMethod(DeliveryMethods deliveryMethods) {
        this.deliveryMethod = deliveryMethods;
        return this;
    }

    public void setDeliveryMethod(DeliveryMethods deliveryMethods) {
        this.deliveryMethod = deliveryMethods;
    }

    public Orders getOrder() {
        return order;
    }

    public Invoices order(Orders orders) {
        this.order = orders;
        return this;
    }

    public void setOrder(Orders orders) {
        this.order = orders;
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
        Invoices invoices = (Invoices) o;
        if (invoices.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), invoices.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Invoices{" +
            "id=" + getId() +
            ", invoiceDate='" + getInvoiceDate() + "'" +
            ", customerPurchaseOrderNumber='" + getCustomerPurchaseOrderNumber() + "'" +
            ", isCreditNote='" + isIsCreditNote() + "'" +
            ", creditNoteReason='" + getCreditNoteReason() + "'" +
            ", comments='" + getComments() + "'" +
            ", deliveryInstructions='" + getDeliveryInstructions() + "'" +
            ", internalComments='" + getInternalComments() + "'" +
            ", totalDryItems=" + getTotalDryItems() +
            ", totalChillerItems=" + getTotalChillerItems() +
            ", deliveryRun='" + getDeliveryRun() + "'" +
            ", runPosition='" + getRunPosition() + "'" +
            ", returnedDeliveryData='" + getReturnedDeliveryData() + "'" +
            ", confirmedDeliveryTime='" + getConfirmedDeliveryTime() + "'" +
            ", confirmedReceivedBy='" + getConfirmedReceivedBy() + "'" +
            "}";
    }
}
