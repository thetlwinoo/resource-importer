package bieebox.resource.importer.service.dto;
import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Invoices entity.
 */
public class InvoicesDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate invoiceDate;

    private String customerPurchaseOrderNumber;

    @NotNull
    private Boolean isCreditNote;

    private String creditNoteReason;

    private String comments;

    private String deliveryInstructions;

    private String internalComments;

    @NotNull
    private Integer totalDryItems;

    @NotNull
    private Integer totalChillerItems;

    private String deliveryRun;

    private String runPosition;

    private String returnedDeliveryData;

    private Instant confirmedDeliveryTime;

    private String confirmedReceivedBy;


    private Long contactPersonId;

    private String contactPersonFullName;

    private Long salespersonPersonId;

    private String salespersonPersonFullName;

    private Long packedByPersonId;

    private String packedByPersonFullName;

    private Long accountsPersonId;

    private String accountsPersonFullName;

    private Long customerId;

    private String customerCustomerName;

    private Long billToCustomerId;

    private String billToCustomerCustomerName;

    private Long deliveryMethodId;

    private String deliveryMethodDeliveryMethodName;

    private Long orderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerPurchaseOrderNumber() {
        return customerPurchaseOrderNumber;
    }

    public void setCustomerPurchaseOrderNumber(String customerPurchaseOrderNumber) {
        this.customerPurchaseOrderNumber = customerPurchaseOrderNumber;
    }

    public Boolean isIsCreditNote() {
        return isCreditNote;
    }

    public void setIsCreditNote(Boolean isCreditNote) {
        this.isCreditNote = isCreditNote;
    }

    public String getCreditNoteReason() {
        return creditNoteReason;
    }

    public void setCreditNoteReason(String creditNoteReason) {
        this.creditNoteReason = creditNoteReason;
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

    public Integer getTotalDryItems() {
        return totalDryItems;
    }

    public void setTotalDryItems(Integer totalDryItems) {
        this.totalDryItems = totalDryItems;
    }

    public Integer getTotalChillerItems() {
        return totalChillerItems;
    }

    public void setTotalChillerItems(Integer totalChillerItems) {
        this.totalChillerItems = totalChillerItems;
    }

    public String getDeliveryRun() {
        return deliveryRun;
    }

    public void setDeliveryRun(String deliveryRun) {
        this.deliveryRun = deliveryRun;
    }

    public String getRunPosition() {
        return runPosition;
    }

    public void setRunPosition(String runPosition) {
        this.runPosition = runPosition;
    }

    public String getReturnedDeliveryData() {
        return returnedDeliveryData;
    }

    public void setReturnedDeliveryData(String returnedDeliveryData) {
        this.returnedDeliveryData = returnedDeliveryData;
    }

    public Instant getConfirmedDeliveryTime() {
        return confirmedDeliveryTime;
    }

    public void setConfirmedDeliveryTime(Instant confirmedDeliveryTime) {
        this.confirmedDeliveryTime = confirmedDeliveryTime;
    }

    public String getConfirmedReceivedBy() {
        return confirmedReceivedBy;
    }

    public void setConfirmedReceivedBy(String confirmedReceivedBy) {
        this.confirmedReceivedBy = confirmedReceivedBy;
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

    public Long getPackedByPersonId() {
        return packedByPersonId;
    }

    public void setPackedByPersonId(Long peopleId) {
        this.packedByPersonId = peopleId;
    }

    public String getPackedByPersonFullName() {
        return packedByPersonFullName;
    }

    public void setPackedByPersonFullName(String peopleFullName) {
        this.packedByPersonFullName = peopleFullName;
    }

    public Long getAccountsPersonId() {
        return accountsPersonId;
    }

    public void setAccountsPersonId(Long peopleId) {
        this.accountsPersonId = peopleId;
    }

    public String getAccountsPersonFullName() {
        return accountsPersonFullName;
    }

    public void setAccountsPersonFullName(String peopleFullName) {
        this.accountsPersonFullName = peopleFullName;
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

    public Long getBillToCustomerId() {
        return billToCustomerId;
    }

    public void setBillToCustomerId(Long customersId) {
        this.billToCustomerId = customersId;
    }

    public String getBillToCustomerCustomerName() {
        return billToCustomerCustomerName;
    }

    public void setBillToCustomerCustomerName(String customersCustomerName) {
        this.billToCustomerCustomerName = customersCustomerName;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long ordersId) {
        this.orderId = ordersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InvoicesDTO invoicesDTO = (InvoicesDTO) o;
        if (invoicesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), invoicesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "InvoicesDTO{" +
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
            ", contactPerson=" + getContactPersonId() +
            ", contactPerson='" + getContactPersonFullName() + "'" +
            ", salespersonPerson=" + getSalespersonPersonId() +
            ", salespersonPerson='" + getSalespersonPersonFullName() + "'" +
            ", packedByPerson=" + getPackedByPersonId() +
            ", packedByPerson='" + getPackedByPersonFullName() + "'" +
            ", accountsPerson=" + getAccountsPersonId() +
            ", accountsPerson='" + getAccountsPersonFullName() + "'" +
            ", customer=" + getCustomerId() +
            ", customer='" + getCustomerCustomerName() + "'" +
            ", billToCustomer=" + getBillToCustomerId() +
            ", billToCustomer='" + getBillToCustomerCustomerName() + "'" +
            ", deliveryMethod=" + getDeliveryMethodId() +
            ", deliveryMethod='" + getDeliveryMethodDeliveryMethodName() + "'" +
            ", order=" + getOrderId() +
            "}";
    }
}
